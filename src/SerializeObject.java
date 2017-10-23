import java.io.*;
import java.io.ObjectOutputStream;

/**
 * Class provides static methods for serializing/deserializing objects
 */
public class SerializeObject {
    /**
     * Serializing object
     *
     * @param object object is being serialized
     * @param fileTo file to which object is being serialized
     */
    public static void serialize(Object object, File fileTo) {
        try (ObjectOutputStream objectWriter =
                     new ObjectOutputStream(new FileOutputStream(fileTo))) {
            objectWriter.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserialize object
     *
     * @param fileFrom file from which object is being deserialized
     * @return Object object
     */
    public static Object deSerialize(File fileFrom) {
        Object object = null;
        try (ObjectInputStream objectReader =
                     new ObjectInputStream(new FileInputStream(fileFrom))) {
            object = objectReader.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
