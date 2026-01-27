import random


def generar_matriz_cruz(filas, columnas):
    rango_random = filas * columnas

    matriz = []
    num_aparecidos = []
    for i in range(filas):
        fila = []
        for j in range(columnas):
            contenido = random.randint(1, rango_random)
            while contenido in num_aparecidos:
                contenido = random.randint(1, rango_random)
            num_aparecidos.append(contenido)
            fila.append(contenido)
        matriz.append(fila)

    return matriz

def sumar_en_cruz(matriz, coord):
    filaCoord = coord["fila"]
    colCoord = coord["colum"]
    fila = len(matriz)
    col = len(matriz[0])
    print(f"{filaCoord} {colCoord} {fila} {col}")
    suma = 0

    for i in range(0, fila):
        for j in range(0, col):
            if i == filaCoord and j == colCoord:
                actual = matriz[i][j]
                print(f"actual: {actual}")
                suma+= actual
                # arriba abajo
                if 0 <= i - 1 < fila and 0 <= j < col:
                    arriba = matriz[i-1][j]
                    print(f"arriba: {arriba}")
                    suma += arriba
                if 0 <= i + 1 < fila and 0 <= j < col:
                    abajo = matriz[i+1][j]
                    print(f"abajo: {abajo}")
                    suma += abajo
                # izquierda derecha
                if 0 <= i < fila and 0 <= j-1 < col:
                    izquierda = matriz[i][j-1]
                    print(f"izquierda: {izquierda}")
                    suma += izquierda
                if 0 <= i < fila and 0 <= j+1 < col:
                    derecha = matriz[i][j+1]
                    print(f"derecha: {derecha}")
                    suma += derecha
    return suma

def mostrar_matriz(matriz):
    for fila in matriz:
        print(fila)

matriz = generar_matriz_cruz(3, 3)
mostrar_matriz(matriz)
coord = {"fila":1, "colum":2}
suma = sumar_en_cruz(matriz, coord)
print(f"Total de la suma: {suma}")
