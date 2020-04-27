FROM openjdk:14-jdk
RUN mkdir -p /home/nutowor/src
COPY ./src /home/nutowor/src 
WORKDIR /home/nutowor
RUN javac -d bin -cp src src/org/krauss/main/MainConsole.java
RUN chmod +x -R bin/
CMD ["java", "-cp", "bin", "org.krauss.main.MainConsole"] 
