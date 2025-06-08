public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("=== Case 1: No Exception ===");
        noException();

        System.out.println("\n=== Case 2: Single Catch ===");
        singleCatch();

        System.out.println("\n=== Case 3: Multiple Catch ===");
        multipleCatch();

        System.out.println("\n=== Case 4: finally always runs ===");
        finallyAlwaysRuns();

        System.out.println("\n=== Case 5: return in try ===");
        int result1 = returnInTry();
        System.out.println("Returned value: " + result1);

        System.out.println("\n=== Case 6: return in finally overrides ===");
        int result2 = returnInFinally();
        System.out.println("Returned value: " + result2);
    }

    // Case 1: try runs fine, no exception
    public static void noException() {
        try {
            System.out.println("try: no exception");
        } catch (Exception e) {
            System.out.println("catch: should not be seen");
        } finally {
            System.out.println("finally: always runs");
        }
    }

    // Case 2: single catch
    public static void singleCatch() {
        try {
            int x = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("catch: ArithmeticException caught: " + e.getMessage());
        } finally {
            System.out.println("finally: always runs");
        }
    }

    // Case 3: multiple catch
    public static void multipleCatch() {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("catch: NullPointerException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("catch: Exception caught: " + e.getMessage());
        } finally {
            System.out.println("finally: always runs");
        }
    }

    // Case 4: finally block runs even after exception
    public static void finallyAlwaysRuns() {
        try {
            int[] arr = new int[2];
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("catch: ArrayIndexOutOfBoundsException caught");
        } finally {
            System.out.println("finally: always runs");
        }
    }

    // Case 5: return in try, finally still runs
    public static int returnInTry() {
        try {
            System.out.println("try: returning 1");
            return 1;
        } catch (Exception e) {
            System.out.println("catch: returning 2");
            return 2;
        } finally {
            System.out.println("finally: runs before return");
        }
    }

    // Case 6: return in finally overrides try/catch
    public static int returnInFinally() {
        try {
            System.out.println("try: returning 1");
            return 1;
        } catch (Exception e) {
            System.out.println("catch: returning 2");
            return 2;
        } finally {
            System.out.println("finally: overrides return, returns 3");
            return 3;
        }
    }
}
