public interface StaticMethod {

    void methodA();

    /**
     * The static methodB() method is available only through
     * and inside of an interface. It can't be overridden by
     * an implementing class.
     */
    static String methodB(){
        return "Hi";
    }
}

class Demo {
    // Calling the static method from interface
    String x = StaticMethod.methodB();
}