FROM ubuntu:22.04

RUN apt-get update \
 && apt-get install --no-install-recommends -y mesa-utils \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/*

CMD glxgears
