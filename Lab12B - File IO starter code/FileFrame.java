/**
 * DO NOT EDIT THIS CODE.  Edit the FileHandler class instead.
 */
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FileFrame extends JFrame
    implements WindowListener, ActionListener {
    private JButton inputButton;
    private JTextField inputFileField;
    private JTextField callField;
    private JButton outputButton;
    private JTextField outputFileField;
    private JTextArea messageArea;
    private JTextField stringField;
    private JButton countBytesButton;
    private JButton copyFileButton;
    private JButton copyFileInvertButton;
    private JButton createFileButton;
    private JButton listContentsButton;
    private JButton deleteFileButton;
    private JButton appendStringButton;
    private FileHandler fh;

    private static Color LIGHT_GREEN = new Color(180,255,180);
    private static Color LIGHT_BLUE = new Color(200,200,255);

    public static void main(String[] args) {
        FileFrame ff = new FileFrame();
        ff.setSize(1000,450);
        ff.setVisible(true);
        ff.setTitle("CS273 File I/O Lab");
    }

    public FileFrame() {
        this.setSize(600,400);
        this.addWindowListener(this);
        
        fh = new FileHandler();

        JPanel p = createPanel();

        JPanel p1 = createPanel("Input file: ");

        inputFileField = createTextField(50, false);
        p1.add(inputFileField);

        inputButton = createButton("Browse...");
        p1.add(inputButton);
        p.add(p1);

        JPanel p2 = createPanel("Output file: ");

        outputFileField = createTextField("     ", 50, false);
        p2.add(outputFileField);

        outputButton = createButton("Browse...");
        p2.add(outputButton);
        p.add(p2);
        
        JPanel p5 = createPanel("String to append: ");

        stringField = createTextField(50, true);
        p5.add(stringField);
        p.add(p5);
        
        JPanel p4 = createPanel();
        
        createFileButton = createButton("Create empty file");
        p4.add(createFileButton);
        
        deleteFileButton = createButton("Delete file");
        p4.add(deleteFileButton);
        
        listContentsButton = createButton("List contents");
        p4.add(listContentsButton);
        
        countBytesButton = createButton("Count bytes");
        p4.add(countBytesButton);
        
        copyFileButton = createButton("Copy file");
        p4.add(copyFileButton);
        
        copyFileInvertButton = createButton("Copy/invert file");
        p4.add(copyFileInvertButton);
        
        appendStringButton = createButton("Append string");
        p4.add(appendStringButton);
        
        p.add(p4);

        messageArea = new JTextArea("", 10, 80);
        messageArea.setBackground(Color.WHITE);
        messageArea.setEditable(false);

        JScrollPane scroller = new JScrollPane(messageArea);
        p.add(scroller);
        
        JPanel p6 = createPanel("Call:");

        callField = createTextField(70, false);
        p6.add(callField);

        p.add(p6);

        this.getContentPane().add(p);
    }

    private JTextField createTextField(int columns, boolean editable) {
        return createTextField("", columns, editable);
    }

    private JTextField createTextField(String text, int columns, boolean editable) {
        JTextField textField = new JTextField(text);
        textField.setColumns(columns);
        textField.setEditable(editable);
        textField.setBackground(Color.WHITE);
        return textField;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(LIGHT_BLUE);
        button.addActionListener(this);
        return button;
    }

    private JPanel createPanel() {
        return createPanel("");
    }

    private JPanel createPanel(String label) {
        JPanel panel = new JPanel();
        panel.setBackground(LIGHT_GREEN);

        if (!label.trim().isEmpty()) {
            panel.add(new JLabel(label));
        }
        return panel;
    }

    public void windowClosing(WindowEvent we) {}
    public void windowClosed(WindowEvent we) { }
    public void windowOpened(WindowEvent we) { }
    public void windowIconified(WindowEvent we) { }
    public void windowDeiconified(WindowEvent we) { }
    public void windowActivated(WindowEvent we) { }
    public void windowDeactivated(WindowEvent we) { }

    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == inputButton) {
            JFileChooser fileChooser = createFileChooser();

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                inputFileField.setText("" + selectedFile.getAbsolutePath());
            }
        }
        else if (obj == outputButton) {
            JFileChooser fileChooser = createFileChooser();

            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String fileName = "" + selectedFile.getAbsolutePath();
                if (fileName.toLowerCase().endsWith(".java")) {
                    messageArea.setText("Output file may not end with '.java'");
                    return;
                }
                outputFileField.setText(fileName);
            }
        }
        else if (obj == countBytesButton) {
            String filename = inputFileField.getText();
            if (isTextFieldInvalid(filename, true)) {
                return;
            }
            
            callField.setText("fh.countBytes(\""+filename+"\")");
            int numBytes = fh.countBytes(filename);
            if (numBytes >= 0) {
                messageArea.setText(numBytes+" bytes found");
                return;
            }
            
        }
        else if (obj == createFileButton) {
            String filename = outputFileField.getText();
            if (isTextFieldInvalid(filename, false)) {
                return;
            }
            
            callField.setText("fh.createEmptyFile(\"" + filename + "\")");
            fh.createEmptyFile(filename);
        }
        else if (obj == deleteFileButton) {
            String filename = outputFileField.getText();
            if (isTextFieldInvalid(filename, false)) {
                return;
            }
            
            callField.setText("fh.deleteFile(\"" + filename + "\")");
            fh.deleteFile(filename);
        }
        else if (obj == copyFileButton) {
            String srcFile = inputFileField.getText();
            if (isTextFieldInvalid(srcFile, true)) {
                return;
            }
            
            String dstFile = outputFileField.getText();
            if (isTextFieldInvalid(dstFile, false)) {
                return;
            }
            
            callField.setText("fh.copyFile(\"" + srcFile + "\",\"" + dstFile + "\")");
            fh.copyFile(srcFile,  dstFile);
        }
        else if (obj == copyFileInvertButton) {
            String srcFile = inputFileField.getText();
            if (isTextFieldInvalid(srcFile, true)) {
                return;
            }
            
            String dstFile = outputFileField.getText();
            if (isTextFieldInvalid(dstFile, false)) {
                return;
            }
            
            callField.setText("fh.copyFileInvertButton(\"" + srcFile + "\",\"" + dstFile + "\")");
            fh.copyFileInvertCase(srcFile,  dstFile);
        }
        else if (obj == listContentsButton) {
            String filename = inputFileField.getText();
            if (isTextFieldInvalid(filename, true)) {
                return;
            }
            
            callField.setText("fh.listContents(\"" + filename + "\")");
            fh.listContents(filename);
        }
        else if (obj == appendStringButton) {
            String filename = outputFileField.getText();
            if (isTextFieldInvalid(filename, false)) {
                return;
            }
            
            callField.setText("fh.appendStringFile(\"" + stringField.getText() + "\",\"" + filename + "\")");
            fh.appendString(stringField.getText(), filename);
        }
        messageArea.setText(fh.getMessage());
        
    }

    private JFileChooser createFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        File currentDir = new File(Dir.cur);
        fileChooser.setCurrentDirectory(currentDir);
        return fileChooser;
    }

    private boolean isTextFieldInvalid(String file, boolean forInput) {
        if (file.trim().length() == 0) {
            messageArea.setText("No " +
                    (forInput ? "input" : "output") +
                    " file specified.");
            return true;
        }
        return false;
    }
}
