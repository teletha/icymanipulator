<p align="center">
    <a href="https://docs.oracle.com/en/java/javase/21/"><img src="https://img.shields.io/badge/Java-Release%2021-green"/></a>
    <span>&nbsp;</span>
    <a href="https://jitpack.io/#Teletha/IcyManipulator"><img src="https://img.shields.io/jitpack/v/github/Teletha/IcyManipulator?label=Repository&color=green"></a>
    <span>&nbsp;</span>
    <a href="https://Teletha.github.io/IcyManipulator"><img src="https://img.shields.io/website.svg?down_color=red&down_message=CLOSE&label=Official%20Site&up_color=green&up_message=OPEN&url=https%3A%2F%2FTeletha.github.io%2FIcyManipulator"></a>
</p>

## Summary
Icy Manipulator is the annotation processor to generate the immutable model builder with the builder-less staging builder pattern.

## Immutable Object
An immutable object is an object whose state cannot be changed once it’s created. In Java, the `String` class is a well-known example of an immutable class. Immutable objects offer several benefits:

### 1. Improved Thread Safety
Since immutable objects cannot change state after creation, they are inherently thread-safe. This eliminates the need for locks or synchronization, reducing the chance of race conditions, and makes them safer for use in multi-threaded environments.

### 2. Improved Memory Efficiency
Immutable objects with the same values can be shared, allowing memory optimization. For example, the `String` pool allows multiple instances of identical strings to share the same reference, which can significantly save memory in applications with repeated values.

### 3. Simple and Readable Code
With immutable objects, code readability and predictability improve as there are no unintended state changes. This reduces the risk of bugs caused by side effects from state changes, making debugging easier.

### 4. Effective Caching and Hash Code Stability
Immutable objects have a fixed hash code, which can be cached for better performance in collections like `HashMap` and `HashSet`. There is no need to worry about object state changes, making them ideal for use as keys in hash-based collections.

### 5. Safe and Easy Copying
Immutable objects are easy to share since they don’t require cloning for safe usage. Passing immutable objects between parts of code is safer, as there’s no risk of unintended state changes, simplifying code maintenance.

### 6. Enhanced Security
Immutability prevents objects from being altered by unintended sources, leading to better security. For public APIs that expose data objects, immutability can be particularly critical in ensuring data consistency and security.

Overall, immutable objects help in designing thread-safe applications, improving memory efficiency, and building reliable systems.

## Builder Pattern
The Builder pattern is particularly useful for creating immutable objects with complex configurations. By allowing for step-by-step object construction, it provides a flexible yet concise approach to building objects without compromising immutability. Here are several reasons why the Builder pattern is beneficial for creating immutable objects:

### 1. Simplified Object Creation with Complex Configurations
When constructing objects with many fields, especially those where not all fields are required, the Builder pattern helps avoid constructors with a long list of parameters. Instead, each parameter can be set in a readable and manageable way, allowing complex objects to be built more intuitively.

### 2. Preservation of Immutability
The Builder pattern allows for the creation of fully-configured immutable objects. Once the object is constructed, it cannot be altered, ensuring immutability. The Builder itself is mutable during construction, but the final object it produces is immutable, providing the best of both flexibility and safety.

### 3. Improved Readability and Usability
With the Builder pattern, each field in the object can be set using descriptive method calls, making the code more readable. In cases where objects have multiple optional fields, constructors can quickly multiply to cover all possible combinations, leading to excessive boilerplate code. The Builder pattern allows you to specify only the fields needed, keeping the codebase cleaner and reducing potential errors associated with too many constructors.

### 4. Validation and Consistency
The Builder pattern enables validation before the object creation, allowing you to enforce consistency rules and constraints easily. Any required fields or constraints can be checked within the Builder before finalizing the object, preventing invalid objects from being created.

## Staging Builderless Builder
Normally, the Builder pattern used to create Immutable objects would look something like this.
```java
Order order = Order.builder()
    .setProduct("Laptop")
    .setQuantity(2)
    .setPrice(999.99)
    .build();
```

If we were to write similar code in the Builderless Builder pattern, it would look like this.
```java
Order order = Order.with
    .product("Laptop")
    .quantity(2)
    .price(999.99);
```
<p align="right"><a href="#top">back to top</a></p>






## Prerequisites
Icymanipulator runs on all major operating systems and requires only [Java version 21](https://docs.oracle.com/en/java/javase/21/) or later to run.
To check, please run `java -version` on your terminal.
<p align="right"><a href="#top">back to top</a></p>

## Install
For any code snippet below, please substitute the version given with the version of Icymanipulator you wish to use.
#### [Maven](https://maven.apache.org/)
Add JitPack repository at the end of repositories element in your build.xml:
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
Add it into in the dependencies element like so:
```xml
<dependency>
    <groupId>com.github.teletha</groupId>
    <artifactId>icymanipulator</artifactId>
    <version>1.6.0</version>
</dependency>
```
#### [Gradle](https://gradle.org/)
Add JitPack repository at the end of repositories in your build.gradle:
```gradle
repositories {
    maven { url "https://jitpack.io" }
}
```
Add it into the dependencies section like so:
```gradle
dependencies {
    implementation 'com.github.teletha:icymanipulator:1.6.0'
}
```
#### [SBT](https://www.scala-sbt.org/)
Add JitPack repository at the end of resolvers in your build.sbt:
```scala
resolvers += "jitpack" at "https://jitpack.io"
```
Add it into the libraryDependencies section like so:
```scala
libraryDependencies += "com.github.teletha" % "icymanipulator" % "1.6.0"
```
#### [Leiningen](https://leiningen.org/)
Add JitPack repository at the end of repositories in your project.clj:
```clj
:repositories [["jitpack" "https://jitpack.io"]]
```
Add it into the dependencies section like so:
```clj
:dependencies [[com.github.teletha/icymanipulator "1.6.0"]]
```
#### [Bee](https://teletha.github.io/bee)
Add it into your project definition class like so:
```java
require("com.github.teletha", "icymanipulator", "1.6.0");
```
<p align="right"><a href="#top">back to top</a></p>


## Contributing
Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.
If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

The overwhelming majority of changes to this project don't add new features at all. Optimizations, tests, documentation, refactorings -- these are all part of making this product meet the highest standards of code quality and usability.
Contributing improvements in these areas is much easier, and much less of a hassle, than contributing code for new features.

### Bug Reports
If you come across a bug, please file a bug report. Warning us of a bug is possibly the most valuable contribution you can make to Icymanipulator.
If you encounter a bug that hasn't already been filed, [please file a report](https://github.com/Teletha/IcyManipulator/issues/new) with an [SSCCE](http://sscce.org/) demonstrating the bug.
If you think something might be a bug, but you're not sure, ask on StackOverflow or on [icymanipulator-discuss](https://github.com/Teletha/IcyManipulator/discussions).
<p align="right"><a href="#top">back to top</a></p>


## Dependency
Icymanipulator depends on the following products on runtime.
* No Dependency
<p align="right"><a href="#top">back to top</a></p>


## License
Copyright (C) 2024 The ICYMANIPULATOR Development Team

MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
<p align="right"><a href="#top">back to top</a></p>