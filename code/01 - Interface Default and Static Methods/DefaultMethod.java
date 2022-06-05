public interface DefaultMethod {

    void methodA();

    /**
     * Default methods are declared using the new default keyword.
     * These are accessible through the INSTANCE of the implementing
     * class and can be overridden.
     */
    default String methodB(){
        return "Hi";
    }
}

class DefaultMethodImpl implements DefaultMethod {
    @java.lang.Override
    public void methodA() {}
}

class Demo {
    // methodB Accessible through the INSTANCE
    String a = new DefaultMethodImpl().methodB();
}