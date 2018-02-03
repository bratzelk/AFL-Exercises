# AFL Exercises
========

## Build

```mvn clean install```

or

```mvn clean install -Dmaven.test.skip=true```


## Run

```mvn exec:java -Dexec.args="Exercise arg1 arg2"```

or

```java -jar ./target/AFLExercise-1.0.0-SNAPSHOT-jar-with-dependencies.jar Exercise arg1 arg2```

Where Exercise is either ```children``` or ```number```

##Examples

### Children Game with n=2 and k=3
```mvn exec:java -Dexec.args="children 2 3"```

or

```java -jar ./target/AFLExercise-1.0.0-SNAPSHOT-jar-with-dependencies.jar children 2 3```


### Number Iterator with limit=7

```mvn exec:java -Dexec.args="number 7"```

or

```java -jar ./target/AFLExercise-1.0.0-SNAPSHOT-jar-with-dependencies.jar number 7```

