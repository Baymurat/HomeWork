package test.HW8;

/**
 * Class containing fields of products
 */
public class SomeSubject {
    private static int countOfAllSubjects = 0;
    private static double priceOfAllSubjects = 0;
    private static int countOfTypes = 0;
    private String typeOfEntity;
    private String nameOfSubject;
    private int countOfSubject;
    private double priceOfSubject;

    /**
     * Constructor for TYPE of product.
     * Summarizes the number of calls.
     *
     * @param name Name of type
     */
    SomeSubject(String name) {
        typeOfEntity = name;
        countOfTypes++;
    }

    /**
     * Constructor for product.
     * Summarizes the number of calls and price all products.
     *
     * @param name  Name of product
     * @param count Count of product
     * @param price Price of product
     */
    SomeSubject(String name, int count, int price) {
        nameOfSubject = name;
        countOfSubject = count;
        priceOfSubject = price;
        countOfAllSubjects++;
        priceOfAllSubjects += priceOfSubject;
    }

    public String getTypeOfEntity() {
        return typeOfEntity;
    }

    public int getCountOfTypes() {
        return countOfTypes;
    }

    public double getPriceOfSubject() {
        return priceOfSubject;
    }

    public int getCountOfAllSubjects() {
        return countOfAllSubjects;
    }

    public double getPriceOfAllSubjects() {
        return priceOfAllSubjects;
    }
}
