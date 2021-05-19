## numb2word 1.0.1 :1234: :arrow_right: :bust_in_silhouette::speech_balloon:

#### 1. What is it?

A simple JAVA library to translate whole numbers to their written form. The library is capable of translating whole numbers up to 19 digits (more precisely `9.21x10^18`) due to its `Long` type limitations. Check out the [table](#available-languages) below to see what languages are available.

#### 2. How to use? 

Download the [jar file](lib/) into your project's folder and import it into your project's path.
Once you've done that, that's how you use in your code:

```java
import org.krauss.main.NumberTranslator;
```

Then using the `NumberTranslator` class static method `getInstance` you can get an instance of the object.

```java
NumberTranslator translator = NumberTranslator.getInstance();
translator.translate(32145698l, ELanguage.ENGLISH);

//Output:

"thirty two million one hundred forty five thousand six hundred ninety eight" 
```

The method `translate()` receives a `long` argument and an `enum ELanguage`, then returns a `String` with the number already translated. 

##### Available languages

| Language | Enum | Available |
| -------- | -----| --------- |
| :gb: **English** | `ELanguage.ENGLISH` | :heavy_check_mark: | 
| :es: **Spanish** | `ELanguage.SPANISH` | :heavy_check_mark: |
| :brazil: **Portuguese** | `ELanguage.PORTUGUESE` | :heavy_check_mark: |
| :it: **Italian** | `ELanguage.ITALIAN` | :x: Loading... |
| :fr: **French** | `ELanguage.FRENCH` | :x: Loading... |

#### 3. Docker Usage :whale:

If you just want to see how this library works, download our image available on Docker Hub following the instructions below:

##### Download the image :cd:

Once you have [Docker CE](https://docs.docker.com/) installed an running, from your Linux terminal or Windows cmd, type:  

```shell
$ docker pull jrkrauss/nutowor:latest
```

##### Create the container and run/ship it :ship:

```shell
$ docker run -it jrkrauss/nutowor:latest
```



