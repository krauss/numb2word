## NuToWor 1.0.0

#### What is it?

A simple JAVA library to translate whole numbers to their written form.

#### How to use

Download the [jar file](lib/) into your project's folder and import it into your project's path.
Once you've done that, that's how you use in your code:

```java
import org.krauss.main.NumberTranslator;
```

Then using the `NumberTranslator` class static method `getInstance` you can get an instance of the object.

```java
NumberTranslator translator = NumberTranslator.getInstance();
translator.translate(32145698l);

Output:

"thirty two million one hundred forty five thousand six hundred ninety eight" 
```

The method `translate()` receives a `long` argument and returns a `String` with the number already translated. 