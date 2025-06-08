// Custom exception class
class InsufficientFundsException extends Exception {
    private double amount;
    
    public InsufficientFundsException(double amount) {
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
    
    @Override
    public String getMessage() {
        return "Insufficient funds. Required: " + amount;
    }
    // what else can be overridden?
    // 1. toString()
    // 2. getCause()
    // 3. getLocalizedMessage()
    // 4. initCause()
    // 5. printStackTrace()
    // 6. printStackTrace(PrintStream)
}

class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
    }
    
    public double getBalance() {
        return balance;
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        
        // Try-catch-finally demonstration
        try {
            System.out.println("Initial balance: " + account.getBalance());
            
            // Valid deposit
            account.deposit(500.0);
            System.out.println("After deposit: " + account.getBalance());
            
            // Invalid deposit
            try {
                account.deposit(-100.0);
            } catch (IllegalArgumentException e) {
                System.out.println("Deposit error: " + e.getMessage());
            }
            
            // Valid withdrawal
            account.withdraw(200.0);
            System.out.println("After withdrawal: " + account.getBalance());
            
            // Invalid withdrawal
            try {
                account.withdraw(2000.0);
            } catch (InsufficientFundsException e) {
                System.out.println("Withdrawal error: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            System.out.println("Final balance: " + account.getBalance());
        }
        
        // Multiple catch blocks
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);  // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        }
        
        // Try-with-resources (simulated)
        try (AutoCloseable resource = new AutoCloseable() {
            @Override
            public void close() {
                System.out.println("Resource closed");
            }
        }) {
            System.out.println("Using resource");
        } catch (Exception e) {
            System.out.println("Resource error: " + e.getMessage());
        }
    }
} 