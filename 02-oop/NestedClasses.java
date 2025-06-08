public class NestedClasses {
    // Static nested class
    // what is static nested class?
    // 1. static nested class is a class that is nested in another class and is static
    // 2. static nested class can access static members of the outer class
    // 3. static nested class can be instantiated without an instance of the outer class
    // 4. static nested class can be used to implement static methods
    // 5. static nested class can be used to implement static variables
    // 6. static nested class can be used to implement static blocks
    static class StaticNested {
        private String message;
        
        public StaticNested(String message) {
            this.message = message;
        }
        
        public void display() {
            System.out.println("Static Nested: " + message);
        }
    }
    
    // Inner class (non-static)
    // what is inner class?
    // 1. inner class is a class that is nested in another class and is not static
    // 2. inner class can access non-static members of the outer class
    // 3. inner class can be instantiated with an instance of the outer class
    // 4. inner class can be used to implement non-static methods
    // 5. inner class can be used to implement non-static variables
    // 6. inner class can be used to implement non-static blocks
    class Inner {
        private String message;
        
        public Inner(String message) {
            this.message = message;
        }
        
        public void display() {
            System.out.println("Inner: " + message);
            System.out.println("Outer field: " + outerField);  // Can access outer class fields
        }
    }
    
    private String outerField = "Outer field value";
    
    public void demonstrateLocalClass() {
        // Local class
        // what is local class?
        // 1. local class is a class that is nested in a method
        // 2. local class can access local variables of the method
        // 3. local class can be instantiated with an instance of the outer class
        // 4. local class can be used to implement local methods
        // 5. local class can be used to implement local variables
        class Local {
            private String message;
            
            public Local(String message) {
                this.message = message;
            }
            
            public void display() {
                System.out.println("Local: " + message);
            }
        }
        
        Local local = new Local("Local class message");
        local.display();
    }
    
    public void demonstrateAnonymousClass() {
        // Anonymous class implementing Runnable
        Runnable anonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class running");
            }
        };
        
        anonymous.run();
    }
    
    public static void main(String[] args) {
        NestedClasses outer = new NestedClasses();
        
        // Using static nested class
        StaticNested staticNested = new StaticNested("Static nested message");
        staticNested.display();
        
        // Using inner class
        Inner inner = outer.new Inner("Inner class message");
        inner.display();
        
        // Using local class
        outer.demonstrateLocalClass();
        
        // Using anonymous class
        outer.demonstrateAnonymousClass();
    }
} 