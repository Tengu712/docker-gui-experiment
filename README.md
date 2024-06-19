# Docker GUI Experiment

## What is this?

It's samples of running GUI apllications in Docker container.

What can be understood from this samples is:

- There is a slight delay in keyboard input.
- OpenGL programs executed via WSLg and Docker Desktop cannot synchronize with vertical sync.
- Distributing GUI applications as Docker containers may be useful for learning purposes related to libraries, but may not be practical for real-world applications.

## Run

### Windows

If you use WSLg:

1. Install WSL2 and make sure WSLg is enabled. Do all the following tasks on WSL2.
2. Install Docker.
3. Install NVIDIA Container Toolkit.
4. Run `docker compose up` or `docker compose -f docker-compose-wsl.yml up` at each directory.

If you use Docker Desktop:

1. Install WSL2.
2. Install VcXsrv and run it.
3. Install Docker Desktop and run it.
4. Run `docker compose -f docker-compose-desktop.yml up` at each directory.
