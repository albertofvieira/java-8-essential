public Reference2Constructor {

    // A reference to a constructor takes the syntax ClassName::new.

    // As constructor in Java is a special method, method reference
    // could be applied to it too, with the help of new as a method name:
    Stream<User> stream = list.stream().map(User::new);
}