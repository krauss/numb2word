## NuToWor 1.0.0 :1234: :arrow_right: :bust_in_silhouette::speech_balloon:

#### What is it?

A simple JAVA library to translate whole numbers to their written form. Check out the [table](#available-languages) below to see what languages are available.

#### How to use 

Download the [jar file](lib/) into your project's folder and import it into your project's path.
Once you've done that, that's how you use in your code:

```java
import org.krauss.main.NumberTranslator;
```

Then using the `NumberTranslator` class static method `getInstance` you can get an instance of the object.

```java
NumberTranslator translator = NumberTranslator.getInstance();
translator.translate(32145698l, ELanguage.ENGLISH);

Output:

"thirty two million one hundred forty five thousand six hundred ninety eight" 
```

The method `translate()` receives a `long` argument and an `enum ELanguage`, then returns a `String` with the number already translated. 

#### Available languages

| Language | Enum | Available |
| -------- | -----| --------- |
| :gb: English | `ELanguage.ENGLISH` | :heavy_check_mark: | 
| :es: Spanish | `ELanguage.SPANISH` | :heavy_check_mark: |
| :interrobang: Portuguese | `ELanguage.PORTUGUESE` | :heavy_check_mark: |
| :it: Italian | `ELanguage.ITALIAN` | :x: |
| :fr: French | `ELanguage.FRENCH` | :x: |