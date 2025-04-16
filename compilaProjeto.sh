#!/bin/bash

# Compila os arquivos Java
echo "Compilando os arquivos Java..."
javac -d bin $(find src -name "*.java")

