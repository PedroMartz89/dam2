import random


def generar_minas(filas, columnas, minas):
    m = []
    d = {"mina": []}
    for i in range(filas):
        fila = []
        for j in range(columnas):
            fila.append(0)
        m.append(fila)
    for i in range(minas):
        coordenada = [random.randint(0, filas - 1), random.randint(0, columnas - 1)]
        while coordenada in d["mina"]:
            coordenada = [random.randint(0, filas - 1), random.randint(0, columnas - 1)]
        d["mina"].append(coordenada)
        fila = coordenada[0]
        columna = coordenada[1]
        m[fila][columna] = 1

    return m

def minas_alrededor(matriz, coord):
    coorI = coord["fila"]
    coorJ = coord["colum"]
    minas = 0
    for df in [-1, 0, 1]:
        for dc in [-1, 0, 1]:
            if df == 0 and dc == 0:
                continue

            nueva_fila = df + coorI
            nueva_colum = dc + coorJ
            if 0 <= nueva_fila < len(m) and 0 <= nueva_colum < len(m[0]):
                if matriz[nueva_fila][nueva_colum] == 1:
                    minas += 1

    return minas

def mostrar_matriz(m):
    for fila in m:
        print(fila)

m = generar_minas(5, 5, 9)
coord = {"fila":3, "colum":3}
mostrar_matriz(m)
minas = minas_alrededor(m, coord)
print(f"Minas alrededor: {minas}")