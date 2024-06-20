#!/bin/bash

if [ -z $(docker image ls -q Tengu712/docker-gui-experiment/opengl) ]; then
    docker build -t Tengu712/docker-gui-experiment/opengl .
fi

docker run \
    --gpus all \
    --user $DOCKER_USER \
    --env DISPLAY=$DISPLAY \
    --env NVIDIA_VISIBLE_DEVICES=all \
    --env NVIDIA_DRIVER_CAPABILITIES=all \
    --mount type=bind,source=/tmp/.X11-unix,target=/tmp/.X11-unix \
    Tengu712/docker-gui-experiment/opengl
