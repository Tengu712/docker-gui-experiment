FROM ubuntu:22.04

RUN apt-get update \
 && apt-get install --no-install-recommends -y openjdk-17-jdk \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/*

COPY src /usr/local/tmp/src/
COPY META-INF /usr/local/tmp/META-INF/

RUN cd /usr/local/tmp/ \
 && javac -sourcepath src -d bin src/**/*.java  \
 && jar cvfm App.jar META-INF/MANIFEST.MF -C bin . \
 && mv ./App.jar /usr/local/App.jar \
 && rm -rf /usr/local/tmp/

CMD java -jar /usr/local/App.jar
