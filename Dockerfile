From  bellsoft/liberica-openjdk-alpine:17.0.15
#Workspace
WORKDIR /home/Selenium-Docker
#Install CURL and JA
RUN apk add curl jq
#ADD or copy file to working directory
ADD target/docker-resources ./
ADD runner.sh  runner.sh

# Fix for windows
RUN dos2unix runner.sh
#To run tests
#run the runner.sh
ENTRYPOINT sh runner.sh


