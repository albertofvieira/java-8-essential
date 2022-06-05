public class Reference2InstanceMethodOfAnObjectOfAParticularType {

    // This reference method takes the syntax ContainingType::methodName.

    long count = list.stream().filter(String::isEmpty).count();
}