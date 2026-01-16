import random

lista_nombres = []
matriz = []
diccionario = {}

def pedir_nombres():
    while True:
        nombre = input("Introduce un nombre (o pulsa Enter para finalizar): ").strip()
        if nombre == "":
            break
        lista_nombres.append(nombre)

def generar_matriz(nombres):
    n = len(nombres)
    # Creamos matriz vacía
    matriz = [[None for _ in range(n)] for _ in range(n)]
    
    # Colocamos cada nombre en una posición aleatoria vacía
    for nombre in nombres:
        colocado = False
        while not colocado:
            f = random.randint(0, n - 1)
            c = random.randint(0, n - 1)
            if matriz[f][c] is None:
                matriz[f][c] = nombre
                colocado = True
    return matriz

def mostrar_matriz(matriz):
    for fila in matriz:
        # Formateamos para que las columnas queden alineadas
        print(" | ".join([str(elem).center(10) if elem else "---".center(10) for elem in fila]))
    print("-" * (13 * len(matriz)))

def generar_diccionario(matriz, nombres):
    diccionario = {}
    for nombre in nombres:
        diccionario[nombre] = []
    for f in range(len(matriz)):
        for c in range(len(matriz)):
            nombre = matriz[f][c]
            if nombre in diccionario:
                diccionario[nombre].append((f, c))
    return diccionario

def mostrar_diccionario(dicc):
    for nombre, posiciones in dicc.items():
        print(f"{nombre}: {posiciones}")

def verificar_ausencias(dicc):
    ausentes = [nombre for nombre, pos in dicc.items() if not pos]
    if ausentes:
        print(f"Personas que no están en la matriz: {', '.join(ausentes)}")
    else:
        print("Todas las personas están en la matriz.")

def mostrar_posiciones_persona(dicc, nombres):
    print("\n--- Selecciona una persona ---")
    for i, nombre in enumerate(nombres, 1):
        print(f"{i}. {nombre}")
    
    try:
        op = int(input("Introduce el número: ")) - 1
        if 0 <= op < len(nombres):
            nombre_sel = nombres[op]
            n = len(nombres)
            posiciones = dicc[nombre_sel]
            
            for f in range(n):
                fila = []
                for c in range(n):
                    fila.append(nombre_sel.center(10) if (f, c) in posiciones else "------".center(10))
                print(" | ".join(fila))
        else:
            print("Número fuera de rango.")
    except ValueError:
        print("Entrada no válida.")

def funcion_comer(matriz):
    n = len(matriz)
    cambio = True
    while cambio:
        cambio = False
        for f in range(n):
            for c in range(n):
                if matriz[f][c] is not None:
                    actual = matriz[f][c]
                    # Comprobar Horizontal (Izquierda y Derecha)
                    if 0 < c < n - 1:
                        if matriz[f][c-1] == matriz[f][c+1] and matriz[f][c-1] is not None and matriz[f][c-1] != actual:
                            matriz[f][c] = matriz[f][c-1]
                            cambio = True
                            continue
                    # Comprobar Vertical (Arriba y Abajo)
                    if 0 < f < n - 1:
                        if matriz[f-1][c] == matriz[f+1][c] and matriz[f-1][c] is not None and matriz[f-1][c] != actual:
                            matriz[f][c] = matriz[f-1][c]
                            cambio = True
        if cambio:
            print("Se ha producido una captura, actualizando matriz...")



def menu():

    while True:
        print("\n--- MENÚ PRINCIPAL ---")
        print("1. Pedir nombres")
        print("2. Generar matriz aleatoria")
        print("3. Mostrar matriz")
        print("4. Generar diccionario de posiciones")
        print("5. Mostrar diccionario")
        print("6. Verificar si alguien falta")
        print("7. Ver mapa individual")
        print("8. Ejecutar función comer")
        print("0. Salir")
        
        opcion = input("Elige una opción: ")

        if opcion == "1":
            print(pedir_nombres())
        elif opcion == "2":
            if lista_nombres:
                matriz = generar_matriz(lista_nombres)
                print("Matriz generada.")
            else: print("Primero debes introducir nombres.")
        elif opcion == "3":
            if matriz: mostrar_matriz(matriz)
            else: print("La matriz no existe.")
        elif opcion == "4":
            if matriz: diccionario = generar_diccionario(matriz, lista_nombres)
            else: print("Primero genera la matriz.")
        elif opcion == "5":
            if diccionario: mostrar_diccionario(diccionario)
            else: print("El diccionario está vacío.")
        elif opcion == "6":
            if diccionario: verificar_ausencias(diccionario)
            else: print("El diccionario no ha sido generado.")
        elif opcion == "7":
            if diccionario: mostrar_posiciones_persona(diccionario, lista_nombres)
            else: print("El diccionario no ha sido generado.")
        elif opcion == "8":
            if matriz: 
                funcion_comer(matriz)
                diccionario = generar_diccionario(matriz, lista_nombres) # Actualizar dicc
            else: print("La matriz no existe.")
        elif opcion == "0":
            break
        else:
            print("Opción no válida.")

if __name__ == "__main__":
    menu()