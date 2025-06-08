// Custom exception class

// what should we do if we want to create a custom exception?
// 1. extend the Exception class
// 2. create a constructor that takes a message
// 3. throw the exception

// example:
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        // why call super?
        
        super(message);  // Pass message to the parent Exception class
    }
}


public class CustomExceptions {
    public static void main(String[] args) {
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is less than 18");
        }
    }
}