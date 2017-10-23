
import java.io.File;

/**
 * Class provides method for sorting files in given directory
 */

public class FileSorter {

    private String rootDirectory;

    public FileSorter(String directory) {
        rootDirectory = directory;
    }

    /**
     * Sort files in given directory
     */
    public void sortFiles() {
        createDirectories(rootDirectory);
        sortFiles(rootDirectory);
    }

    /**
     * Creates new directories for storing sorted files
     *
     * @param inDirectory root directory in which new directories will be created
     */
    private void createDirectories(String inDirectory) {
        File sortedFiles = new File(inDirectory + "/Sorted");
        sortedFiles.mkdir();
        File fileAK = new File(sortedFiles.getAbsolutePath() + "/A-K");
        File fileLQ = new File(sortedFiles.getAbsolutePath() + "/L-Q");
        File fileRZ = new File(sortedFiles.getAbsolutePath() + "/R-Z");
        File otherFiles = new File(sortedFiles.getAbsolutePath() + "/Other");
        fileAK.mkdir();
        fileLQ.mkdir();
        fileRZ.mkdir();
        otherFiles.mkdir();
    }

    /**
     * Sorts files in given directory by moving then into new directories
     * according to their name first symbol
     *
     * @param inDirectory root directory
     */
    private void sortFiles(String inDirectory) {
        File fileDir = new File(inDirectory);
        if (fileDir.isDirectory()) {
            for (File file : fileDir.listFiles()) {
                if (!file.isDirectory()) {
                    file.renameTo(nameSorter(file.getName()));
                } else {
                    sortFiles(file.getAbsolutePath());
                }
            }
        }
    }

    /**
     * Consruct file name of file being moved
     *
     * @param fileName
     * @return new file name of moved file
     */
    private File nameSorter(String fileName) {
        char fileStart = fileName.toLowerCase().charAt(0);
        File newFile = chooseFolder(fileStart);
        if (newFile == null) {
            newFile = new File("Files/Sorted/Other/" + fileName);
        } else {
            newFile = new File(newFile.getAbsolutePath() + "/" + fileName);
        }
        return newFile;
    }

    /**
     * Select directory to which file will be moved by its name first symbol
     *
     * @param firstLetter file name first symbol
     * @return directory to which file will be moved
     */
    private File chooseFolder(char firstLetter) {
        File fileDir = new File(rootDirectory + "/Sorted");
        File newDir = null;
        for (File file : fileDir.listFiles()) {
            if (file.isDirectory()) {
                char firstSymbol = file.getName().toLowerCase().charAt(0);
                char lastSymbol =
                        file.getName().toLowerCase().charAt(2);
                if (firstSymbol <= firstLetter &&
                        lastSymbol >= firstLetter) {
                    newDir = file;
                    break;
                }
            }
        }

        return newDir;
    }
}
