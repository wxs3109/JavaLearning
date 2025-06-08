// GenericMethods.java - Java Learning File


public class Utils {
    // explain the syntax of the generic method
    // <T> is a type parameter
    // T[] array is an array of type T
    // for (T element : array) is a for-each loop that iterates over the array
    // System.out.println(element) is a method call that prints the element

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    // give me two generic variables in one method
    public static <T, U> void printArray(T[] array, U[] array2) {
        for (T element : array) {
            System.out.println(element);
        }
        for (U element : array2) {
            System.out.println(element);
        }
    }
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Hello", "World", "Java"};
        printArray(intArray);
        printArray(stringArray);

        printArray(intArray, stringArray);
    }

}