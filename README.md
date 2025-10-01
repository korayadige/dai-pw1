# DAI: Practical Work 1 - Command Line Application


## Overview
This project is a small Java command-line application built using [Picocli](https://picocli.info/) . 
It has two main features:
- **Count**: count the number of lines, words, and characters in a text file.
- **Locate**: search for a given word in a text file and output the positions into another file.



## Authors
Koray Akgül
Nathan Stampfli

## Getting started
### 1. Clone the repository
```bash
git clone https://github.com/korayadige/dai-pw1.git
cd <folder>
```
### 2. Build with Maven
Use the Maven wrapper (./mvnw) to build the project:
```sh
./mvnw clean package
```
This will produce a runnable JAR file with all dependencies in the target/ folder:
```sh
target/pw1-1.0-SNAPSHOT.jar
```
### Usage
Run the application with:
```sh
java -jar target/pw1-1.0-SNAPSHOT.jar <command> [options]
```
## Available Commands
- `count <file>` - Count lines, words, and characters in the given file.
- `locate <file> <word> <outputFile>`- Search for a word in `<file>`and save the results in `<outputFile>`.

## Examples
### Count

### Locate

## Notes


