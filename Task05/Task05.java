package Task05;

/**
 * Created by Admin on 20.10.2016.
 */
public class Task05 {
    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        double a = initializer.initVariable();
        double b = initializer.initVariable();
        double c = initializer.initVariable();

        TriangleType triangleType = new TriangleType(a, b, c);
        triangleType.type();
    }
}
