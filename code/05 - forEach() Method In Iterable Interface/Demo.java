import java.util.ArrayList;
import java.util.List;

public class Demo {

    // In Java 8, the Java.lang interface now supports a “forEach” function.
    // Iterable that can iterate over the collection’s items.
    // The Iterable interface has a default method called “forEach.” Collection
    // classes use it to iterate items, which extends the Iterable interface.
    // You may send Lambda Expression as an argument to the “forEach” method,
    // which accepts the Functional Interface as a single parameter.

    public static void main(String[] args) {
        List<String> subList = new ArrayList<String>();

        subList.add("Carrot");
        subList.add("Potato");
        subList.add("Cauliflower");
        subList.add("LadyFinger");
        subList.add("Tomato");

        System.out.println("------------Vegetable List--------------");
        subList.forEach(sub -> System.out.println(sub));

        // OR

        System.out.println("------------Vegetable List--------------");
        subList.forEach(System.out::println);
    }
}