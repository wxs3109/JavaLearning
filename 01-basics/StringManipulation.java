// StringManipulation.java - Java Learning File

public class StringManipulation {
    public static void main(String[] args) {
        String str = "Hello, World!";
        System.out.println(str);
    }

    // stringbuilder
    public static void stringBuilder() {
        StringBuilder sb = new StringBuilder("Hello, World!");
        sb.append(" Java");
        String result = sb.toString();
        System.out.println(result);
    }
    // difference between stringbuilder and stringbuffer
    // stringbuilder is not thread safe and stringbuffer is thread safe
    // stringbuilder is faster than stringbuffer
    // stringbuffer is slower than stringbuilder
    // stringbuffer is synchronized and stringbuilder is not synchronized
    // stringbuffer is thread safe and stringbuilder is not thread safe
    // stringbuffer is slower than stringbuilder
    // stringbuffer is thread safe and stringbuilder is not thread safe
    // stringbuffer
    public static void stringBuffer() {
        StringBuffer sb = new StringBuffer("Hello, World!");
        sb.append(" Java");
        String result = sb.toString();
        System.out.println(result);
    }

    
}