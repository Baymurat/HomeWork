package Task05;

/**
 * Main class, consists main() method.
 */
public class Task05 {
    /**
     * Main method in which happens: Instance declaration of class Triangle.
     * Displays if triangle exists or it's type.
     *
     * @param args
     * @throws Exception - invokes if there is NaN or Infinity values.
     */
    public static void main(String[] args) throws Exception {
        Initializer initializer = new Initializer();
        double a = initializer.initVariable();
        double b = initializer.initVariable();
        double c = initializer.initVariable();

        Triangle triangle = new Triangle(a, b, c);
        System.out.println(triangle.type());
    }
}
