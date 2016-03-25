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

At it's heart, left-pad is easy to use and simple to grasp.
However, its interface is built on decades of programming language research.

The simplest usage looks like `new LeftPad(length, character).apply(string)`.

It also supports an advanced functional style whereby you define a new `LeftPad`
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


LeftPad also supports TDD practices since you always create a LeftPad
object instance before calling the function. This makes it easy to mock.

You can even use your favorite dependency injection framework to efficiently pass
a configured LeftPad object throughout your code without impacting testability.

## Adding to Your Project

Clone this repository, run `mvn install`, and this project as a dependency.

maven:
```
<dependency>
    <groupId>net.raboof</groupId>
    <artifactId>left-pad</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

gradle:
```
compile 'net.raboof:left-pad:1.0-SNAPSHOT'
```

sbt:

```
libraryDependencies += "net.raboof" % "left-pad" % "1.0-SNAPSHOT"
```