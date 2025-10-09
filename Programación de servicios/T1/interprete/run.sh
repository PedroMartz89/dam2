#!/bin/bash

# Ruta al proyecto desde WSL
cd /mnt/c/Users/pedni/Desktop/dam2/Acceso\ a\ datos/Tema\ 1/interprete

# Compilar todos los .java dentro de src
javac -d out src/Main/*.java src/Proceso/*.java

# Ejecutar la clase principal
java -cp out Main.Interpretetest