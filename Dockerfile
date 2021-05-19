FROM openjdk:14-jdk
RUN mkdir -p /home/numb2word/src
COPY ./src /home/numb2word/src 
WORKDIR /home/numb2word
RUN javac -d bin -cp src src/org/krauss/main/MainConsole.java
RUN chmod +x -R bin/
CMD ["java", "-cp", "bin", "org.krauss.main.MainConsole"] 
