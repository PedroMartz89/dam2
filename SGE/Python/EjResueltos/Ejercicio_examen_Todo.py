import random

# Función Se piden los nombres 
# de personas hasta pulsar enter y devuelve lista

def Generar_Lista_Nombre():
    L = []
    nombre = input("Nombre: ")
    while nombre != "":
        L.append(nombre)
        nombre = input("Nombre: ")
    return L

# Función que genera una matriz cuadrada según el 
# número de personas y coloca aleatoriamente los 
# nombres de las personas y la devuelve la matriz
def Matriz_Personas(L):
    M = list()
    for i in range(0, len(L)):
        M.append([])
        for j in range(0, len(L)):
#            M[i].append(L[random.randint(0, (len(L)-1))])
            M[i].append(random.choice(L))
    return M

# Función mostrar matriz

def MostrarMatriz(matriz):
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            print(matriz[i][j], end="\t")
        print()


def ObtenerCoordenadas(nombres, matriz):
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

def ObtenerCoordenadas(nombres, matriz):
    diccionario = {}
    for nombre in nombres:
        diccionario[nombre] = []
    for fila in range(0, len(matriz)):
        for columna in range(0, len(matriz)):
            coordenada = (fila, columna)
            diccionario[matriz[fila][columna]].append(coordenada)
    return diccionario

########

print("0.- Salir")
print("1.- Generar Lista Nombres")
print("2.- Cuadrada")
print("3.- Mostrar Matriz")
print("4.- ObtenerCoordenadas")

opcion = int(input("Opcion: "))
LNombre = list()
while opcion != 0:
    if opcion == 1:
        #LNombre = Generar_Lista_Nombre()
        #print(LNombre)
        LNombre = ['Pepe', 'María', 'Juan']
    elif opcion == 2:
        M = Matriz_Personas(LNombre)
        print(M)
    elif opcion == 3:
        MostrarMatriz(M)
    elif opcion == 4:
        DC = ObtenerCoordenadas(LNombre, M)
        
    opcion = int(input("Opcion: "))
