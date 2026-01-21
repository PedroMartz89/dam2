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
    p = list(d.keys())
    personas_menu = []
    for i in range(len(p)):
        if p[i] not in personas_menu:
            personas_menu.append(p[i])
            print(f"{i}.{p[i]}")


    correcto = False
    opcion = int(input("Introduce el número de la persona: "))
    while correcto:
        if opcion < int(tpersonas):
            correcto = True
        opcion = int(input("Introduce el número de la persona: "))


    personas = []
    for persona in d:
        personas.append(persona)

    persona_elegida = personas[int(opcion)]
    coordenadas = d.get(persona_elegida, [])
    tamano_matriz = math.ceil(math.sqrt(tpersonas))

    for i in range(0, tamano_matriz):
        for j in range(0,tamano_matriz):
            actual = (i, j)
            if actual in coordenadas:
                print(f"{persona_elegida[:3]:^5}", end="") # Uso [:3] para solo coger las 3 primeras letras
                                                           # por si en nombre es muy largo
            else:
                print(f"{'---':^5}", end="") # Uso ^5 para formatear el texto y que se vea correctamente
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
# menu_diccionario_opciones(D, len(personas))
Comer(matriz)