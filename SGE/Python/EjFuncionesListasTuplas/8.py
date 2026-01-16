from sympy import true

matriz = [
    ["Pepe", "Maria", "Juan"],
    ["Pepe", "Pepe", "Juan"],
    ["Maria", "Maria", "Pepe"]
]

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