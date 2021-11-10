import java.io.*;
import java.util.*;

/**
 * FileHandler - performs a number operations on file
 * 
 * A FileHandler object performs operations on files. After each operation
 * the FileHandler keeps track of the result of the operations, which the
 * caller may query by invoking the 'getMessage' operation on the object. The
 * 'getMessage' method returns a String.
 *
 * A FileHandler object performs the following operations:
 *   - createEmptyFile - creates an new (empty) file
 *   - deleteFile - deletes a file
 *   - listContents: reads all the bytes in the file. The result of a 'lastMessage'
 *     after this operation is the String containing the contents of the file, where
 *     each byte in the file is treated as a char.
 *   - countBytes - counts the number of bytes in the file. The result of the
 *     'lastMessage' will be a string that tells the number of bytes counted.
 *   - copyFile - copies the contents of one file to another. The 'lastMessage' string
 *     is an indication as to whether the copying was successfully done. *   
 *   - appendString - appends a string to a text file.
 *   - copyFileInvertCase - copies the contents of a source file to a second file, except upper
       and lowercase letters are swapped.
 */
public class FileHandler {

    /**
     * Instance Variables
     */

    // the message to give to the caller, if asked
    private String lastMessage;

    // machine-independent representation of newline character-sequence
    private static String EOL = System.getProperty("line.separator");

    /**
     * FileHandler constructor - creates a new FileHandler object
     */
    public FileHandler() {
        lastMessage = "";
    }

    /**
     * Gives the message that resulted from the most recent file operation
     * @return The object's message.
     */
    public String getMessage() { 
        return lastMessage; 
    }

    /**
     * Creates a file with no bytes in it.
     * 
     * The object's message is changed to reflect the method's
     * status. If a file by that name already exists, it is deleted.
     *     
     * @param fileName - the name of the file to be created.
     */
    public void createEmptyFile(String fileName) {
        lastMessage = "'createEmptyFile' is not yet implemented";
    }

    /**
     * Deletes a file.
     * 
     * The object's message is changed to reflect the method's
     * status.
     * 
     * @param fileName - the name of the file to be deleted.
     */
    public void deleteFile(String fileName) {
        lastMessage = "'deleteFile' is not yet implemented";
    }

    /**
     * Set's this object's message to contents of a file.
     * 
     * The object's message is changed.  If the file-read was successful,
     * then the message consists of the file's contents.  Otherwise it consists
     * of a message that the file was not successfully read.
     * 
     * @param fileName - The name of the file whose contents are to be examined
     */
    public void listContents(String fileName) {
        lastMessage = "'listContents' is not yet implemented";
    }

    /**
     * Counts the number of bytes in a file
     * 
     * The object's message is changed to reflect the method's
     * status.
     *      
     * @param fileName - The name of the file whose bytes are to be counted
     * @return the number of bytes in the file, or -1 if there was an error 
     *          in opening and/or reading the file.
     */
    public int countBytes(String fileName) {
        lastMessage = "Could not count bytes in file";
        return -1;
    }

    /**
     * Copies the contents of a source file to a second file.
     *
     * The file whose name is given by 'outFileName' is created; the contents
     * of the 'inFileName' file are copied into it.  The object's message-
     * string is changed to reflect the status of the operation.  If a file
     * already exists by that name, it is deleted.
     *
     * @param srcName - The name of the source file.
     * @param dstName - The name of the new file to create and copy the contents of the source file to.
     */
    public void copyFile(String srcName, String dstName) {
        lastMessage = "'copyFile' is not yet implemented";
    }    

    /**
     * Appends a string to a file.
     *
     * @param str - the string to append
     * @param fileName - the name of the file that the string should be appended to.
     */
    public void appendString(String str, String fileName) {
        lastMessage = "'appendString' is not yet implemented";
    }
    
    /**
     * Copies the contents of a source file to a second file, except upper
     * and lowercase letters are swapped.
     *
     * The file whose name is given by 'outFileName' is created; the contents
     *      * of the 'inFileName' file are copied into it.  The object's message-
     *      * string is changed to reflect the status of the operation.  If a file
     *      * already exists by that name, it is deleted.
     *
     * @param srcName - The name of the source file.
     * @param dstName - The name of the new file to create and copy the contents of the source file to.
     */
    public void copyFileInvertCase(String srcName, String dstName) {
        lastMessage = "'copyFileInvertCase' is not yet implemented";
    }
}//class FileHandler
