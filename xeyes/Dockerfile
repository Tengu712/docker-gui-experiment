FROM ubuntu:22.04

RUN apt-get update \
 && apt-get install --no-install-recommends -y x11-apps \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/*

CMD xeyes
