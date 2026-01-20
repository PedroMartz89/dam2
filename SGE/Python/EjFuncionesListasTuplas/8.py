import math
import random

def pedir_nombres_persona():
    personas = []
    continuar = True
    while continuar:
        persona = input("Introduce el nombre de una persona o pulsa Enter: ")
        if not persona:
            continuar = False

        personas.append(persona)
    return personas

def generar_matriz_cuadrada():
    personas = ["Pedro", "Claudia", "Paloma", "Jorge", "Roberto", "Alberto"]
    # La raiz cuadrada de N nos da el lado de la matriz
    N = math.ceil(math.sqrt(len(personas)))

    #Rellenamos los espacios vacios con None
    while len(personas) < N * N:
        personas.append(None)

    #Aleatorizamos la lista
    random.shuffle(personas)

    #Generamos la matriz
    M = []
    for i in range(0, len(personas), N):
        fila = personas[i : i + N]
        M.append(fila)

    return M

def mostrar_matriz(m):
    for fila in m:
        print(fila)

def diccionario_personas_posiciones(m):
    D = {}

    for i in range(0, len(m)):
        for j in range(0, len(m[i])):
            nombre = str(m[i][j])
            if nombre not in D and nombre != "None":
                D[nombre] = [(i, j)] # Añadir la tupla como lista de tuplas
            elif nombre in D and nombre is not None:
                coordenadas = (i, j)
                D[nombre].append(coordenadas)

    return D

def mostrar_diccionario(d):
    for clave, valor in d.items():  # usar D.items() para recorrer por clave y valor
        print(f"Persona: {clave}, Coordenadas: {valor}")

def persona_no_en_diccionario(p, d):
    if p not in d:
        return False
    return True

def menu_diccionario_opciones(d, tpersonas):
    indice = 0

    while indice < tpersonas:
        for p in d:
            print(f"{indice} - {str(p)}")
            indice+=1

    correcto = False
    opcion = int(input("Introduce el número de la persona: "))
    while correcto:
        if opcion < int(tpersonas):
            correcto = True
        opcion = int(input("Introduce el número de la persona: "))

    tamano_matriz = math.ceil(math.sqrt(tpersonas))
    personas = []
    for persona in d:
        personas.append(persona)

    persona_elegida = personas[int(opcion)]

    coordenadas = d.get(persona_elegida, [])

    for i in range(tamano_matriz):
        fila = []
        for j in range(tamano_matriz):
            fila.append(None)

    for i in range(0, tamano_matriz):
        for j in range(0,tamano_matriz - i):
            actual = (i, j)
            if actual in coordenadas:
                print(persona_elegida)
            else:
                print("---")
        print()

def Comer(matriz):

    Cambio = True
    L = len(matriz)
    while Cambio:
        for i in range(0, L):
            for j in range(0, L):
                Vecinos = []
                if i > 0:
                    Vecinos.append(matriz[i-1][j])
                if j < L-1:
                    if matriz[i][j+1] in Vecinos:
                        Cambio = True
                        matriz[i][j] = matriz[i][j+1]
                else:
                    Vecinos.append(matriz[i][j+1])
matriz = [
    ["Pepe", "Maria", "Juan"],
    ["Pepe", "Pepe", "Juan"],
    ["Maria", "Maria", "Pepe"]
]
D = diccionario_personas_posiciones(generar_matriz_cuadrada())
personas = ["Pedro", "Claudia", "Paloma", "Jorge", "Roberto", "Alberto"]
# pedir_nombres_persona()
# mostrar_matriz(generar_matriz_cuadrada())
# mostrar_diccionario(diccionario_personas_posiciones(generar_matriz_cuadrada()))
# print(persona_no_en_diccionario("Juan", diccionario_personas_posiciones(matriz)))
menu_diccionario_opciones(D, len(personas))