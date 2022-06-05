public Reference2InstanceMethod {

    // The reference to an instance method holds the syntax containingInstance::methodName.

    // The following code calls method isLegalName(String string) of type User,
    // which validates an input parameter:
    boolean isLegalName = list.stream().anyMatch(user::isLegalName);
}