import random

def generar_tablero(n, porcentaje):
    matriz = []
    aparecidos = []
    rango_max_random = n*n
    for i in range(n):
        fila = []
        for j in range(n):
            if random.random() < porcentaje:
                fila.append(0)
            else:
                num = random.randint(1, rango_max_random)
                while num in aparecidos:
                    num = random.randint(1, rango_max_random)
                aparecidos.append(num)
                fila.append(num)
        matriz.append(fila)
    return matriz

def mostrar_matriz(m):
    for fila in m:
        print(fila)

def contar_vecinos_pares(tablero, coord):
    coorI = coord["fila"]
    coorJ = coord["colum"]
    conteo = 0
    fila = len(tablero)
    colum = len(tablero[0])

    for df in [-1, 0, 1]:
        for dc in [-1, 0, 1]:
            if df == 0 and dc == 0:
                if tablero[coorI][coorJ] % 2 == 0:
                    conteo+=1
                    continue
            nueva_fila = df + coorI
            nueva_colum = dc + coorJ

            if 0 <= nueva_fila < fila and 0 <= nueva_colum < colum:
                if tablero[nueva_fila][nueva_colum] % 2 == 0:
                    conteo += 1
    return conteo


m = generar_tablero(3, 0.2)
d = {"fila": 1, "colum":1}
mostrar_matriz(m)
print(f"Vecinos pares: {contar_vecinos_pares(m, d)}")