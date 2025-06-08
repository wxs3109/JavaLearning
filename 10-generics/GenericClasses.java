// GenericClasses.java - Java Learning File

class Container<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class GenericClasses {
    public static void main(String[] args) {
        Container<Integer> intContainer = new Container<>();
        intContainer.setValue(10);
        System.out.println(intContainer.getValue());

        Container<String> stringContainer = new Container<>();
        stringContainer.setValue("Hello");
        System.out.println(stringContainer.getValue());
    }
}