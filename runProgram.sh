#!/bin/bash

javac -d bin src/Program/*.java src/Horoscope/*.java src/Quiz/*.java src/Welcome/*.java
java -cp bin Program.Program
