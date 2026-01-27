import random
import string

def generar_matriz_letras(filas, colum):
    aparecidas = []
    matriz = []
    for i in range(filas):
        fila = []
        for k in range(colum):
            if len(aparecidas) >= 26:
                aparecidas.clear()
            letra_random = random.choice(string.ascii_uppercase)
            while letra_random in aparecidas:
                letra_random = random.choice(string.ascii_uppercase)
            aparecidas.append(letra_random)
            fila.append(letra_random)

        matriz.append(fila)

    return matriz

def suma_valores_letra(matriz, coord):
    coorI = coord["fila"]
    coorJ = coord["colum"]
    fila = len(matriz)
    colum = len(matriz[0])
    puntuacion = 0

    for df in [-1, 0, 1]:
        for dc in [-1, 0, 1]:
            if df == 0 and dc == 0:
                continue
            nueva_fila = df + coorI
            nueva_colum = dc + coorJ

            if 0 <= nueva_fila < fila and 0 <= nueva_colum < colum:
                letra = matriz[nueva_fila][nueva_colum]
                puntuacion_letra = ord(letra) - 64
                puntuacion += puntuacion_letra
                print(f"Puntuación de {letra}: {puntuacion_letra}")

    return puntuacion


def mostrar_matriz(m):
    for fila in m:
        print(fila)


m = generar_matriz_letras(6, 6)
coord = {"fila": 4, "colum": 4}
mostrar_matriz(m)
print(f"Puntuación final: {suma_valores_letra(m, coord)}")