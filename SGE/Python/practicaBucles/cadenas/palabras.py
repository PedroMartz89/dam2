cadena = input("Escribe una frase: ")

while cadena != ' ':
    cambios = 0
    cadenaMod = cadena.split()
    for c in cadenaMod:
        cambios+=1

    print("Palabras totales: ", cambios)
    cadena = input("Escribe una frase: ")