public class Demo {

    // A Functional Interface is an interface that has exactly one abstract method.
    // To designate an interface as a Functional Interface,
    // we don’t need to use the @FunctionalInterface annotation.

    public static void main(String args[]) {
        // An anonymous function may be defined as a Lambda Expression (or function)
        // (a function with no name and an identifier).
        // Lambda Expressions are defined precisely where they are required,
        // often as a parameter to another function.
        MyInterface fobj = (int x, int y) -> System.out.println(x+y);

        System.out.print("The result = ");
        fobj.abstract_func(5,5);
        fobj.default_Fun();
    }
}

interface MyInterface {
    void abstract_func(int x,int y);

    default void default_Fun() {
        System.out.println("This is default method");
    }
}