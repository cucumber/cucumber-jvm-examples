Cucumber-JVM Examples
=====================

This is a collection of examples for Cucumber JVM using different test runners
and dependency injection frameworks. The projects are build with maven. You can run
each sample with `mvn test`.

For a minimal starter template repository see either:
* [Maven](https://github.com/cucumber/cucumber-jvm-starter-maven-java)
* [Gradle](https://github.com/cucumber/cucumber-jvm-starter-gradle-java)

## Test runner examples

Different examples showing how you can run Cucumber.

### CLI

The [calculator-java-cli](./calculator-java-cli) demonstrates running Cucumber through the CLI using the `maven-antrun-plugin`.

### JUnit 4

The [calculator-java-junit-4](./calculator-java-junit-4) demonstrates running Cucumber through JUnit 4.

### JUnit JUpiter

The [calculator-java-junit-jupiter](./calculator-java-junit-jupiter) demonstrates running Cucumber through JUnit JUpiter.

### TestNG

The [calculator-java-testng](./calculator-java-testng) demonstrates running Cucumber through TestNG.


## Language examples

Different examples showing how to use dependency injection.

### Java (Annotations)

The [calculator-java-cli](./calculator-java-cli) demonstrates running Cucumber with Java using annotation based step definitions.

### Java (Lambda)

The [calculator-java8-junit-jupiter](./calculator-java8-junit-jupiter) demonstrates running Cucumber with Java using lambda based step definitions.

### Kotlin (Annotations)

The [calculator-kotlin-junit-jupiter](./calculator-kotlin-junit-jupiter) demonstrates running Cucumber with Kotlin using lambda based step definitions.

## Dependency Injection examples

Different examples showing how to use dependency injection.

### Spring

The [spring-java-junit-jupiter](./spring-java-junit-jupiter) demonstrates the use of [cucumber-spring](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-picocontainer) for Spring for dependency injection.

### Pico Container

TODO: See [cucumber-picocontainer](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-picocontainer).

### Guice

TODO:

TODO: See [cucumber-guice](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-guice).