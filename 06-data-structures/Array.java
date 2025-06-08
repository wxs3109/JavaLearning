import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr);
    }

    public static void arrayInitialization() {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        System.out.println(arr);
    }

    public static void arrayCopy() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        System.out.println(arr2);
    }

    public static void arrayCopy2() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(arr2);
    }

    public static void arrayCopy3() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = Arrays.copyOfRange(arr, 0, 3);
        System.out.println(arr2);
}
