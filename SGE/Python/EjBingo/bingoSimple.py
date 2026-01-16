import random


def mostrar_bingo(L):
    print("---- BINGO ----")
    for i in range(1, len(L)):
        print(L[i], end="\t")
        if i % 10 == 0:
            print()

Bingo = "N"
L = ['-'] * 91
while Bingo == "N":
    N = random.randint(1, 90)
    while N in L:
        N = random.randint(1, 90)
    L[N] = str(N)
    mostrar_bingo(L)
    Bingo = input("Bingo?: ").upper()

