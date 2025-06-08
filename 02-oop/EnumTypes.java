// Basic enum
enum Direction {
    NORTH, SOUTH, EAST, WEST  
}
// why use enum instead of class?
// 1. enum is a type-safe way to represent a set of constants

// Enum with fields and methods
enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27, 7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7);

    private final double mass;   // in kilograms
    private final double radius; // in meters

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    // Universal gravitational constant (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    public double surfaceGravity() {
        return G * mass / (radius * radius);
    }

    public double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
}

public class EnumTypes {
    public static void main(String[] args) {
        // Basic enum usage
        Direction dir = Direction.NORTH;
        System.out.println("Direction: " + dir);
        
        // Switch statement with enum
        switch (dir) {
            case NORTH:
                System.out.println("Going North");
                break;
            case SOUTH:
                System.out.println("Going South");
                break;
            case EAST:
                System.out.println("Going East");
                break;
            case WEST:
                System.out.println("Going West");
                break;
        }
        
        // Using enum with fields and methods
        double earthWeight = 175.0;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        
        System.out.println("\nWeight on different planets:");
        for (Planet p : Planet.values()) {
            System.out.printf("Your weight on %s is %f%n",
                    p, p.surfaceWeight(mass));
        }
        
        // Enum methods
        System.out.println("\nEnum methods demonstration:");
        Direction[] directions = Direction.values();
        for (Direction d : directions) {
            System.out.println(d.name() + " ordinal: " + d.ordinal());
        }
        
        // Comparing enums
        Direction dir1 = Direction.NORTH;
        Direction dir2 = Direction.SOUTH;
        System.out.println("\nComparing directions:");
        System.out.println("dir1 == dir2: " + (dir1 == dir2));
        System.out.println("dir1 == Direction.NORTH: " + (dir1 == Direction.NORTH));
    }
} 