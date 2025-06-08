// Base class demonstrating different access modifiers
// summary:
// private: only within the class
// protected: within the package and subclasses , what is package?  package is a directory that contains classes and interfaces
// public: everywhere
// default: within the package

// example:
class Base {
    private String privateField = "private";
    protected String protectedField = "protected";
    public String publicField = "public";
    String defaultField = "default";  // package-private
    
    private void privateMethod() {
        System.out.println("Private method");
    }
    
    protected void protectedMethod() {
        System.out.println("Protected method");
    }
    
    public void publicMethod() {
        System.out.println("Public method");
    }
    
    void defaultMethod() {
        System.out.println("Default method");
    }
}

// Derived class in the same package
// what is derived class?  derived class is a class that inherits from another class
class Derived extends Base {
    public void demonstrateAccess() {
        // Can access protected, public, and default members
        System.out.println("Protected field: " + protectedField);
        System.out.println("Public field: " + publicField);
        System.out.println("Default field: " + defaultField);
        
        // Can call protected, public, and default methods
        protectedMethod();
        publicMethod();
        defaultMethod();
        
        // Cannot access private members
        // System.out.println(privateField);  // Compilation error
        // privateMethod();  // Compilation error
    }
}

// Class in the same package
class SamePackage {
    public void demonstrateAccess() {
        Base base = new Base();
        
        // Can access protected, public, and default members
        System.out.println("Protected field: " + base.pjirotectedField);
        System.out.println("Public field: " + base.publicField);
        System.out.println("Default field: " + base.defaultField);
        
        // Can call protected, public, and default methods
        base.protectedMethod();
        base.publicMethod();
        base.defaultMethod();
        
        // Cannot access private members
        // System.out.println(base.privateField);  // Compilation error
        // base.privateMethod();  // Compilation error
    }
}

public class AccessModifiers {
    public static void main(String[] args) {
        System.out.println("Testing access modifiers in the same package:");
        
        // Testing Derived class
        Derived derived = new Derived();
        System.out.println("\nAccess from Derived class:");
        derived.demonstrateAccess();
        
        // Testing SamePackage class
        SamePackage samePackage = new SamePackage();
        System.out.println("\nAccess from SamePackage class:");
        samePackage.demonstrateAccess();
        
        // Testing direct access
        Base base = new Base();
        System.out.println("\nDirect access to Base class:");
        System.out.println("Public field: " + base.publicField);
        base.publicMethod();
        
        // Cannot access private, protected, or default members directly
        // System.out.println(base.privateField);  // Compilation error
        // System.out.println(base.protectedField);  // Compilation error
        // System.out.println(base.defaultField);  // Compilation error
    }
} 