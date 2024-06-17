FROM ubuntu:22.04

RUN apt-get update \
 && apt-get install --no-install-recommends -y wget xz-utils libc6-dev libgl1-mesa-dev libglfw3 libglfw3-dev \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/*

RUN mkdir /usr/local/tmp \
 && mkdir /usr/local/zig \
 && wget https://ziglang.org/download/0.13.0/zig-linux-x86_64-0.13.0.tar.xz -P /usr/local/tmp --no-check-certificate \
 && tar Jxvf /usr/local/tmp/zig-linux-x86_64-0.13.0.tar.xz -C /usr/local/zig --strip-components 1 \
 && rm -rf /usr/local/tmp

COPY main.zig /usr/local/tmp/

RUN cd /usr/local/tmp/ \
 && /usr/local/zig/zig build-exe /usr/local/tmp/main.zig -lGL -lglfw -lc \
 && mv ./main /usr/local/executable \
 && rm -rf /usr/local/tmp/

CMD /usr/local/executable
