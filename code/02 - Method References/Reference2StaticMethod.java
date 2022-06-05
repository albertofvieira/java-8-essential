public class Reference2StaticMethod {

    // The reference to a static method holds the syntax ContainingClass::methodName.

    // Let's take a closer look at lambda expression in the anyMatch() method.
    // It just makes a call to a static method isRealUser(User user) of the User class.
    boolean isReal = list.stream().anyMatch(u -> User.isRealUser(u));

    // So, it can be substituted with a reference to a static method:
    boolean isReal = list.stream().anyMatch(User::isRealUser);
}

class User {
    public static boolean isRealUser(User u) {
        return u != null ? true : false;
    }
}