#!/bin/bash

./gradlew bootJar
cat ./build/libs/demo-0.0.1-SNAPSHOT.jar |ssh root@120.78.187.115 'cat - > /root/realty.jar'
