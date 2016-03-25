# left-pad for Java 8

[![Build Status](https://travis-ci.org/absurdhero/left-pad-java.svg?branch=master)](https://travis-ci.org/absurdhero/left-pad-java)

This is an implementation of the left-pad library
with special support for Java 8's Functional paradigm.
It is lightweight and supports industrial usage thanks to its 100% test coverage
and continuous integration.

It works well with modern libraries like
[Spring Data](http://projects.spring.io/spring-data/)
and [jooq](http://jooq.org).

## Usage

left-pad supports an advanced functional style whereby you define a new `LeftPad`
[functor](https://en.wikipedia.org/wiki/Function_object)
and apply it as a unary function which accepts a `CharSequence`.

Example:

```java
LeftPad fourPadded = new LeftPad(4);
fourPadded.apply("foo"); // => " foo"
fourPadded.apply("x");   // => "   x"

// using Java 8 Streams
// this will yield [" x", " y", " z"]
asList("x", "y", "z").stream().map(new LeftPad(2)).collect(Collectors.toList())
```
