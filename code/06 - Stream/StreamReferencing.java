// We can instantiate a stream, and have an accessible reference to it,
// as long as only intermediate operations are called.
// Executing a terminal operation makes a stream inaccessible.

// To demonstrate this, we will forget for a while that the best practice is to chain
// the sequence of operation. Besides its unnecessary verbosity,
// technically the following code is valid:
Stream<String> stream = Stream.of("a", "b", "c").filter(element -> element.contains("b"));
Optional<String> anyElement = stream.findAny();

// However, an attempt to reuse the same reference after calling the terminal operation will trigger the IllegalStateException:
Optional<String> firstElement = stream.findFirst();

// As the IllegalStateException is a RuntimeException, a compiler will not signalize
// about a problem. So it is very important to remember that Java 8 streams can't
// be reused. This kind of behavior is logical. We designed streams to apply a
// finite sequence of operations to the source of elements in a functional style,
// not to store elements.

// So to make the previous code work properly, some changes should be made:
List<String> elements = Stream.of("a", "b", "c")
        .filter(element -> element.contains("b"))
        .collect(Collectors.toList());

Optional<String> anyElement = elements.stream().findAny();
Optional<String> firstElement = elements.stream().findFirst();