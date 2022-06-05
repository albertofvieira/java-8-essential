public class MyOptional {

    // Before Java 8, developers had to carefully validate values they referred
    // to because of the possibility of throwing the NullPointerException (NPE).
    // All these checks demanded a pretty annoying and error-prone boilerplate code.

    // Java 8 Optional<T> class can help to handle situations where there is a
    // possibility of getting the NPE. It works as a container for the
    // object of type T. It can return a value of this object if this value is not
    // a null. When the value inside this container is null, it allows doing some
    // predefined actions instead of throwing NPE.

    // Empty Optional:
    Optional<String> optional = Optional.empty();

    // An Optional that contains a non-null value:
    String str = "value";
    Optional<String> optional = Optional.of(str);

    // Return an Optional with a specific value or an empty Optional if the parameter is null:
    Optional<String> optional = Optional.ofNullable(getString());

    // **************************************************************
    // EXAMPLE 1
    // **************************************************************
    // With pre-Java 8's code, we need to do something like this:
    List<String> list = getList();
    List<String> listOpt = list != null ? list : new ArrayList<>();

    // With Java 8, the same functionality can be achieved with a much shorter code:
    List<String> listOpt = getList().orElseGet(() -> new ArrayList<>());

    // **************************************************************
    // EXAMPLE 2
    // **************************************************************
    // Assume we have an object of type User that has a field of type Address
    // with a field street of type String, and we need to return a value of
    // the street field if some exist or a default value if street is null:
    User user = getUser();
    if (user != null) {
        Address address = user.getAddress();
        if (address != null) {
            String street = address.getStreet();
            if (street != null) {
                return street;
            }
        }
    }
    return "not specified";

    // This can be simplified with Optional:
    Optional<User> user = Optional.ofNullable(getUser());
    String result = user
            .map(User::getAddress)
            .map(Address::getStreet)
            .orElse("not specified");

    // In this example, we used the map() method to convert results of
    // calling the getAdress() to the Optional<Address> and getStreet()
    // to Optional<String>. If any of these methods returned null,
    // the map() method would return an empty Optional.

    // **************************************************************
    // EXAMPLE 3
    // **************************************************************
    // Now imagine that our getters return Optional<T>.
    // In this case, we should use the flatMap() method instead of the map():
    Optional<OptionalUser> optionalUser = Optional.ofNullable(getOptionalUser());
    String result = optionalUser
            .flatMap(OptionalUser::getAddress)
            .flatMap(OptionalAddress::getStreet)
            .orElse("not specified");

    // **************************************************************
    // EXAMPLE 4
    // **************************************************************
    // Another use case of Optional is changing NPE with another exception.
    // So, as we did previously, let's try to do this in pre-Java 8's style:
    String value = null;
    String result = "";
    try {
        result = value.toUpperCase();
    } catch (NullPointerException exception) {
        throw new CustomException();
    }

    // And the answer is more readable and simpler if we use Optional<String>:
    String value = null;
    Optional<String> valueOpt = Optional.ofNullable(value);
    String result = valueOpt.orElseThrow(CustomException::new).toUpperCase();
}