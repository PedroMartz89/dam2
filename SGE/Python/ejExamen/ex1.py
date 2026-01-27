import random

def generar_matriz(num_filas, num_columnas):
    matriz = []
    num_casillas = num_filas * num_columnas
    numeros_aparecidos = []
    for i in range(0, num_filas):
        fila = []
        for j in range(0, num_columnas):
            num = random.randint(0, num_casillas)
            while num in numeros_aparecidos:
                if num == 0:
                    break
                num = random.randint(0, num_casillas)
            numeros_aparecidos.append(num)
            fila.append(num)
        matriz.append(fila)
    return matriz


def sumar_vecinos(matriz, dicc):
    fila = len(matriz)
    col = len(matriz[0])
    corI = dicc.get("fila")
    corJ = dicc.get("col")
    suma = 0
    for df in [-1, 0, 1]:
        for dc in [-1, 0, 1]:
            if df == 0 and dc == 0:
                suma += matriz[corI][corJ]
                print(f"Sumando vecino en posicion ({corI}, {corJ}), valor: {matriz[corI][corJ]}")
                continue
            nueva_fila = df + corI
            nueva_col = dc + corJ

            if 0 <= nueva_fila < fila and 0 <= nueva_col < col:
                suma += matriz[nueva_fila][nueva_col]
                print(f"Sumando vecino en posicion ({nueva_fila}, {nueva_col}), valor: {matriz[nueva_fila][nueva_col]}")

    return suma

def pedir_coordenada(matriz):
    fila = int(len(matriz))
    col = int(len(matriz[0]))
    corI, corJ = 0, 0
    valida = False
    while not valida:
        corI = int(input("Ingrese la coordenada de la fila: "))
        corJ = int(input("Ingrese la coordenada de la columna: "))
        if 0 < corI < fila and 0 < corJ < col:
            valida = True
        print("Las coordenadas introducidas no son válidas")
    dicc = {"fila": corI, "col":corJ}
    return dicc

def mostrar_matriz(matriz):
    for fila in matriz:
        print(fila)


m = generar_matriz(3, 3)
diccionario = pedir_coordenada(m)
mostrar_matriz(m)
print()
print(sumar_vecinos(m, diccionario))
