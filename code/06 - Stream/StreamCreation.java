
// Another significant feature in Java 8 is the Stream API.
// The Stream API is used to handle a collection of items and allows many iterations.
// A Stream is a collection of items (elements) that enables you to combine multiple
// techniques to achieve your goals.

// The java.util.stream package in Java 8 introduces a new Streams API that enables
// you to process components of Java Collections in parallel.
// Because Java is inherently sequential, and there is no direct way to implement
// parallel processing at the library level, the stream API will fill that void.
// You may use Java’s Stream API to filter items of a collection based on
// a defined condition. If you have a list of orders, for example, you may
// combine purchase and sell orders, filter orders by amount and price,
// and so on.

// There are many ways to create a stream instance of different sources.
// Once created, the instance will not modify its source, therefore allowing
// the creation of multiple instances from a single source.

// We can instantiate a stream, and have an accessible reference to it, as long
// as only intermediate operations are called. Executing a terminal operation makes a stream inaccessible.

// ***********************************************************
// Empty Stream
// ***********************************************************
// We should use the empty() method in case of the creation of an empty stream:
Stream<String> streamEmpty = Stream.empty();

// We often use the empty() method upon creation to avoid returning null for streams with no element:
public Stream<String> streamOf(List<String> list) {
    return list == null || list.isEmpty() ? Stream.empty() : list.stream();
}

// ***********************************************************
// Stream of Collection
// ***********************************************************
// We can also create a stream of any type of Collection (Collection, List, Set):
Collection<String> collection = Arrays.asList("a", "b", "c");
Stream<String> streamOfCollection = collection.stream();

// ***********************************************************
// Stream of Array
// ***********************************************************
// An array can also be the source of a stream:
Stream<String> streamOfArray = Stream.of("a", "b", "c");

// We can also create a stream out of an existing array or of part of an array:
String[] arr = new String[]{"a", "b", "c"};
Stream<String> streamOfArrayFull = Arrays.stream(arr);
Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

// ***********************************************************
// Stream.builder()
// ***********************************************************
// When builder is used, the desired type should be additionally specified in
// the right part of the statement, otherwise the build() method will create
// an instance of the Stream<Object>:
Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();

// ***********************************************************
// Stream.generate()
// ***********************************************************
// The generate() method accepts a Supplier<T> for element generation.
// As the resulting stream is infinite, the developer should specify the
// desired size, or the generate() method will work until it reaches the
// memory limit:

// The code below creates a sequence of ten strings with the value “element.”
Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);

// ***********************************************************
// Stream.iterate()
// ***********************************************************
// Another way of creating an infinite stream is by using the iterate() method:
Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
streamIterated.forEach(System.out::println);

// The first element of the resulting stream is the first parameter of the
// iterate() method. When creating every following element, the specified
// function is applied to the previous element. In the example above the
// second element will be 42.

// ***********************************************************
// Stream of Primitives
// ***********************************************************
// Java 8 offers the possibility to create streams out of
// three primitive types: int, long and double.
// As Stream<T> is a generic interface, and there is no way to use primitives
// as a type parameter with generics, three new special interfaces were created:
// IntStream, LongStream, DoubleStream.

// Using the new interfaces alleviates unnecessary auto-boxing, which allows
// for increased productivity:
IntStream intStream = IntStream.range(1, 3);
LongStream longStream = LongStream.rangeClosed(1, 3);

// The range(int startInclusive, int endExclusive) method creates an ordered
// stream from the first parameter to the second parameter. It increments the
// value of subsequent elements with the step equal to 1. The result
// doesn't include the last parameter, it is just an upper bound of the sequence.

// The rangeClosed(int startInclusive, int endInclusive) method does the same
// thing with only one difference, the second element is included.
// We can use these two methods to generate any of the three types of
// streams of primitives.

// Since Java 8, the Random class provides a wide range of methods for
// generating streams of primitives. For example, the following code creates
// a DoubleStream, which has three elements:
Random random = new Random();
DoubleStream doubleStream = random.doubles(3);

// ***********************************************************
// Stream of String
// ***********************************************************
// We can also use String as a source for creating a stream with the help of
// the chars() method of the String class. Since there is no interface for
// CharStream in JDK, we use the IntStream to represent a stream of chars instead.
IntStream streamOfChars = "abc".chars();

// The following example breaks a String into sub-strings according to specified RegEx:
Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");

// ***********************************************************
// Stream of File
// ***********************************************************
// Furthermore, Java NIO class Files allows us to generate a Stream<String>
// of a text file through the lines() method. Every line of the text
// becomes an element of the stream:
Path path = Paths.get("C:\\file.txt");
Stream<String> streamOfStrings = Files.lines(path);
Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));


// ***********************************************************
// the source, intermediate operation(s) and a terminal operation
// ***********************************************************

// Intermediate Operations:
// 1) map: The map method is used to returns a stream consisting of the results of applying the given function to the elements of this stream.
List number = Arrays.asList(2,3,4,5);
List square = number.stream().map(x->x*x).collect(Collectors.toList());

// 2) filter: The filter method is used to select elements as per the Predicate passed as argument.
List names = Arrays.asList("Reflection","Collection","Stream");
List result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());

// 3) sorted: The sorted method is used to sort the stream.
List names = Arrays.asList("Reflection","Collection","Stream");
List result = names.stream().sorted().collect(Collectors.toList());

// Terminal Operations:
// 1) collect: The collect method is used to return the result of the intermediate operations performed on the stream.
List number = Arrays.asList(2,3,4,5,3);
Set square = number.stream().map(x->x*x).collect(Collectors.toSet());

// 2) forEach: The forEach method is used to iterate through every element of the stream.
List number = Arrays.asList(2,3,4,5);
number.stream().map(x->x*x).forEach(y->System.out.println(y));

// 3) reduce: The reduce method is used to reduce the elements of a stream to a single value.
// The reduce method takes a BinaryOperator as a parameter.
List number = Arrays.asList(2,3,4,5);
int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);