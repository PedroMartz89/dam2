import random
def generar_temperaturas(filas, columnas):
    matriz = []
    for i in range(filas):
        fila = []
        for j in range(columnas):
            fila.append(round(random.uniform(-10.0,40.0), 1))
        matriz.append(fila)
        
    return matriz


def mostrar_matriz(m):
    for fila in m:
        print(fila)

def media_vecinos(m, coord):
    fila = coord["fila"]
    colum = coord["colum"]
    total_vecinos = 0
    suma = 0
    for df in [-1, 0, 1]:
        for dc in [-1, 0, 1]:

            if df == 0 and dc == 0:
                suma+= m[fila][colum]
                total_vecinos += 1
            
            nueva_fila = df + fila
            nueva_colum = dc + fila

            if 0 <= nueva_fila < fila and 0 <= nueva_colum < colum:
                suma += m[nueva_fila] [nueva_colum]
                total_vecinos += 1
    print(suma," ", total_vecinos)
    media = suma / total_vecinos
    return round(media, 1)
            
m = generar_temperaturas(3, 3)
d = {"fila": 1, "colum":1}
mostrar_matriz(m)
print(f"Media vecinos: {media_vecinos(m, d)}")

