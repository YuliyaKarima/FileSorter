import java.io.Serializable;

/**
 * Class encapsulates two fields
 * Implements Serializable interface so that objects can be stored
 */
public class MyClass implements Serializable {
    private int number;
    private String line;

    public MyClass(int number, String line) {
        this.number = number;
        this.line = line;
    }

    public String toString() {
        return (number + " " + line);
    }
}
