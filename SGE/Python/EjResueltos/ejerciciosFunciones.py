import random


def pedirNombre():
    nombres = []
    nombre = str(input("Introduce un nombre: "))
    while nombre != "":
        nombres.append(nombre)
        nombre = str(input("Introduce un nombre: "))
    return nombres


def generarMatriz(nombres):
    random.shuffle(nombres)
    matriz = []
    for i in range(len(nombres)):
        columna = []
        for j in range(len(nombres)):
            columna.append(random.choice(nombres))
        matriz.append(columna)
    return matriz


def mostrarMatriz(matriz):
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            print(matriz[i][j], end=" ")
        print()


def obtenerCoordenadas(nombres, matriz):
    diccionario = {}
    for nombre in nombres:
        listaCoordenadas = []
        for fila in range(0, len(matriz)):
            for columna in range(0, len(matriz)):
                if matriz[fila][columna] == nombre:
                    coordenada = (fila, columna)
                    listaCoordenadas.append(coordenada)
        diccionario[nombre] = listaCoordenadas
    return diccionario


def mostrarDiccionario(diccionario):
    for clave, valor in diccionario.items():
        print(f"{clave}->{valor}")


def comprobarPersona(nombres, diccionario):
    for nombre in nombres:
        coordenadas = diccionario[nombre]
        if len(coordenadas)==0:
            print(f"{nombre} no está en el diccionario")


def mostrarMenuPersonas(diccionario, longitud):
    posicionesNombre = {}
    print("Menú-------------")
    posicion = 0
    for nombre in diccionario.keys():
        print(f"{posicion + 1}-{nombre}")
        posicionesNombre[posicion] = nombre
        posicion += 1
    numeroElegido = int(input("Selecciona una número: "))
    if 0 < numeroElegido <= longitud:
        nombreSeleccionado = posicionesNombre.pop(numeroElegido - 1)
        listaCoordenadas = list(diccionario[nombreSeleccionado])
        matriz = []
        for fila in range(longitud):
            columna = []
            for columnas in range(longitud):
                if (fila, columnas) in listaCoordenadas:
                    columna.append(f"({fila},{columnas})")
                else:
                    columna.append("-----")
            matriz.append(columna)
        return matriz
    return None


def comer(matrizComer):
    lenMatriz = len(matrizComer)
    haCambiado = True
    while (haCambiado):
        haCambiado = False
        for i in range(lenMatriz):
            for j in range(lenMatriz):
                if 0 <= i - 1 < lenMatriz and 0 <= i + 1 < lenMatriz:
                    arriba = matrizComer[i - 1][j]
                    abajo = matrizComer[i + 1][j]
                    centro = matrizComer[i][j]
                    if arriba == abajo and arriba != centro:
                        matrizComer[i][j] = arriba
                        haCambiado = True
                        continue

                if 0 <= j - 1 < lenMatriz and 0 <= j + 1 < lenMatriz:
                    izquierda = matrizComer[i][j - 1]
                    derecha = matrizComer[i][j + 1]
                    centro = matrizComer[i][j]

                    if izquierda == derecha and izquierda != centro:
                        matrizComer[i][j] = izquierda
                        haCambiado = True

    return matrizComer


# --------------------------------------------
nombreElegidos = pedirNombre()
matrizNombres = generarMatriz(nombreElegidos)
mostrarMatriz(matrizNombres)
diccionario = obtenerCoordenadas(nombreElegidos, matrizNombres)
mostrarDiccionario(diccionario)
comprobarPersona(nombreElegidos, diccionario)
mostrarMatriz(mostrarMenuPersonas(diccionario, len(nombreElegidos)))
mostrarMatriz(comer(matrizNombres))
