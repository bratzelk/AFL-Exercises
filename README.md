# AFL Exercises

## Requirements

* Java 1.8
* Maven

## Build

```mvn clean install``` to build the application and run the tests.

or

```mvn clean install -Dmaven.test.skip=true``` to build without the tests.


## Run

```mvn exec:java -Dexec.args="Exercise arg1 arg2"```

or

```java -jar ./target/AFLExercise-1.0.0-SNAPSHOT-jar-with-dependencies.jar Exercise arg1 arg2```

Where ```Exercise``` is either ```children``` or ```number``` to run either the Children Game or Number Iterator respectively.

## Examples

### Children Game with n=2 and k=3
```mvn exec:java -Dexec.args="children 2 3"```

or

```java -jar ./target/AFLExercise-1.0.0-SNAPSHOT-jar-with-dependencies.jar children 2 3```


### Number Iterator with limit=7

```mvn exec:java -Dexec.args="number 7"```

or

```java -jar ./target/AFLExercise-1.0.0-SNAPSHOT-jar-with-dependencies.jar number 7```


## Specification


### Exercise 1 – Children’s Game

Consider the following children’s game:

* n children stand around a circle.
* To play the game there needs to be more than 1 child.
* Starting with a given child and working clockwise, each child gets a sequential number, which we will refer to as it’s id.
* Then starting with the first child, they count out from 1 until k. The k’th child is now out and leaves the circle. The count starts again with the child immediately next to the eliminated one.
* k can be larger than or less than the number of children
* Children are so removed from the circle one by one. The winner is the child left standing last.

Write a program, which, when given n and k, returns the sequence of children as
they go out, and the id of the winning child. Create any additional classes you need
to support the design of your solution.

### Exercise 2 – Number Iterator

Write a program that will iterate though a sequence of integers starting from 0 up to
and including a number that can be passed in and the program will:

* output the number and “FOO” only when the integer is divisible by 3
* output the number and “BAR” only when the integer is divisible by 5
* but when the integer is divisible by both 3 and 5 then don’t write the above, output the number and “BAZ” instead

Take into consideration that we might want to add new rules in the future including different numbers, operators and iteration patterns. Create any additional classes you need to support the design of your solution.
