# Docker GUI Experiment

## What is this?

It's samples of running GUI apllications in Docker container.

I understood from this samples that:

- There is a slight delay in keyboard input.
- The flag `--gpus all` is required on Linux.
- OpenGL programs executed via WSLg and Docker Desktop cannot synchronize with vertical sync.
- Vulkan is unavailable in Docker containers.
- Distributing GUI applications as Docker containers may be useful for learning purposes related to libraries, but may not be practical for real-world applications.

## Run

### Linux

1. Install Docker.
2. Install NVIDIA Driver.
3. Install NVIDIA Container Toolkit.
4. Run `export DOCKER_USER=$(id -u):$(id -g)`.
4. Run `docker compose -f docker-compose-linux.yml up` or `./run.sh` at each directory.

### Windows

If you use WSLg:

1. Install WSL2 and make sure WSLg is enabled. Do all the following tasks on WSL2.
2. Install Docker.
3. Install NVIDIA Container Toolkit.
4. Run `docker compose -f docker-compose-wsl.yml up` at each directory.

If you use VcXsrv:

1. Install WSL2.
2. Install VcXsrv and run it.
3. Install Docker Desktop and run it.
4. Run `docker compose -f docker-compose-desktop.yml up` at each directory.
