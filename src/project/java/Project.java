/*
 * Copyright (C) 2021 icymanipulator Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */

public class Project extends bee.api.Project {

    {
        product("com.github.teletha", "icymanipulator", ref("version.txt"));

        describe("""
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
                With the Builder pattern, each field in the object can be set using descriptive method calls, making the code more readable. This pattern allows code to more clearly reflect the intent, and it also eliminates the ambiguity and errors that can arise from having multiple overloaded constructors.

                ### 4. Reduces the Need for Multiple Constructors
                In cases where objects have multiple optional fields, constructors can quickly multiply to cover all possible combinations, leading to excessive boilerplate code. The Builder pattern allows you to specify only the fields needed, keeping the codebase cleaner and reducing potential errors associated with too many constructors.

                ### 5. Validation and Consistency
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
                """);

        require("com.github.teletha", "antibug").atTest();
        require("com.github.teletha", "bee").atTest();
        require("com.google.guava", "guava").atTest();

        versionControlSystem("https://github.com/Teletha/IcyManipulator");
    }
}