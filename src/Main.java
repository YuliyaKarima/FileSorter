import java.io.File;

public class Main {
    public static void main(String[] args) {
        //sorting file in certain directory
        FileManager.sort("Files");
        //serialize object
        File fromFile = FileManager.getFirstFile("Files/Sorted/L-Q");
        File toFile = FileManager.getFirstFile("Files/Sorted/A-K");
        MyClass object = new MyClass(8, "line");
        SerializeObject.serialize(object, fromFile);
        FileManager.copyWithDelete(fromFile, toFile);
        //deserialize object
        MyClass object2 = (MyClass) SerializeObject.deSerialize(toFile);
        System.out.println(object2);
    }
}
