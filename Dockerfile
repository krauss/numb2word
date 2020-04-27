FROM openjdk:latest
RUN mkdir -p /home/nutowor/src
COPY ./src /home/blackjack/src 
WORKDIR /home/nutowor
RUN javac -d bin -cp src/org/krauss/main/MainConsole.java
RUN chmod +x -R bin/
CMD ["java", "-cp", "bin", "org.krauss.main.MainConsole"] 
