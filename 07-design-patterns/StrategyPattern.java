// StrategyPattern.java - Java Learning File

// what is strategy pattern?
// 1. strategy pattern is a design pattern that allows an object to choose a behavior at runtime
// 2. strategy pattern is a design pattern that allows an object to choose a behavior at runtime
// 3. strategy pattern is a design pattern that allows an object to choose a behavior at runtime
// 4. strategy pattern is a design pattern that allows an object to choose a behavior at runtime
// 5. strategy pattern is a design pattern that allows an object to choose a behavior at runtime
// 6. strategy pattern is a design pattern that allows an object to choose a behavior at runtime
interface PaymentStrategy {
    public void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using credit card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment()); // here must be a concrete class that implements the interface? yes
        cart.checkout(100);
    }
}
