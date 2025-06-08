class Animal {
    public String publicField = "public field";
    protected String protectedField = "protected field";
    private String privateField = "private field";
    public static String staticField = "static field";
    public final String finalField = "final field";

    public Animal() {
        System.out.println("Animal constructor");
    }

    public void eat() {
        System.out.println("Animal: Eating...");
    }

    protected void sleep() {
        System.out.println("Animal: Sleeping...");
    }

    private void breath() {
        System.out.println("Animal: Breathing...");
    }

    public static void staticMethod() {
        System.out.println("Animal: static method");
    }
    
    public final void finalMethod() {
        System.out.println("Animal: final method");
    }
}

class Dog extends Animal {
    public Dog() {
        // super() is called implicitly
        System.out.println("Dog constructor");
    }

    // override public method
    @Override
    public void eat() {
        System.out.println("Dog: Eating dog food...");
    }

    // override protected method
    @Override
    protected void sleep() {
        System.out.println("Dog: Sleeping in dog house...");
    }

    // hide static method
    public static void staticMethod() {
        System.out.println("Dog: static method");
    }

    public void showFields() {
        System.out.println(publicField);         // ✅
        System.out.println(protectedField);      // ✅
        // System.out.println(privateField);     // ❌ Compile error
        System.out.println(staticField);         // ✅
        System.out.println(finalField);          // ✅
    }

    public void callMethods() {
        eat();              // ✅ override
        sleep();            // ✅ override
        // breath();        // ❌ private method not accessible
        staticMethod();     // ✅ calls Dog's own staticMethod
        finalMethod();      // ✅ inherited but not overrideable
    }
}

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("=== Constructor Call ===");
        Dog dog = new Dog();
        // 输出:
        // Animal constructor
        // Dog constructor

        System.out.println("\n=== Dog.showFields() ===");
        dog.showFields();
        // 输出:
        // Dog -> publicField: public field
        // Dog -> protectedField: protected field
        // Dog -> staticField: static field
        // Dog -> finalField: final field

        System.out.println("\n=== Dog.callMethods() ===");
        dog.callMethods();
        // 输出:
        // Dog -> eat(): Dog: Eating dog food...
        // Dog -> sleep(): Dog: Sleeping in dog house...
        // Dog -> staticMethod(): Dog: static method
        // Dog -> finalMethod(): Animal: final method

        System.out.println("\n=== Static Method Test ===");
        Animal.staticMethod(); // 输出: Animal: static method
        Dog.staticMethod();    // 输出: Dog: static method

        System.out.println("\n=== Upcasting Test ===");
        Animal a = new Dog();
        // 输出:
        // Animal constructor
        // Dog constructor

        a.eat();             // 输出: Dog: Eating dog food...
        a.sleep();           // 输出: Dog: Sleeping in dog house...
        a.finalMethod();     // 输出: Animal: final method
        Animal.staticMethod(); // 输出: Animal: static method（静态方法不发生多态）
    }
}
