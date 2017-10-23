import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Class provides static methods to get file in directory by ordinal index,
 * copy file contents
 */
public class FileManager {
    private static FileSorter sorter;

    /**
     * Return file by index in directory
     *
     * @param inDirectory directory path
     * @param index       ordinal index in sorted list of files in directory
     * @return File object
     */


    public static File getFile(String inDirectory, int index) {
        File directory = new File(inDirectory);
        File[] filesFrom = directory.listFiles();
        Arrays.sort(filesFrom);
        return filesFrom[index];
    }

    /**
     * Return first file in sorted list of files in directory
     *
     * @param inDirectory directory path
     * @return File object
     */
    public static File getFirstFile(String inDirectory) {
        return getFile(inDirectory, 0);
    }

    /**
     * Copies content of one file to another
     *
     * @param copyFrom file whose contents are being copied
     * @param copyTo   file to which contents are copied
     */

    public static void copy(File copyFrom, File copyTo) {
        try (FileInputStream fin = new FileInputStream(copyFrom);
             FileOutputStream fout = new FileOutputStream(copyTo)) {
            int c = 0;
            while ((c = fin.read()) != -1) {
                fout.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Copy firts file contents to second file and delete first one
     *
     * @param copyFrom
     * @param copyTo
     */
    public static void copyWithDelete(File copyFrom, File copyTo) {
        copy(copyFrom, copyTo);
        copyFrom.delete();
    }

    /**
     * Sort files in certain directory
     *
     * @param directory directory name
     */
    public static void sort(String directory) {
        sorter = new FileSorter(directory);
        sorter.sortFiles();
    }
}
