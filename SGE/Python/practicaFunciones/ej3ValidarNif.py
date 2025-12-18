from sympy.polys.densebasic import dmp_ground

Salir = 1
letrasDNI = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E']
def generar_letra_nif(nif):
    resto = int(float(nif) % 23)
    return str(nif + letrasDNI[resto])


len(letrasDNI)


def es_nif(nif):
    if len(str(nif)) == 9:
        num = nif[:-1]
        if num.isnumeric():
            if nif[-1] in letrasDNI:
                return True
        return False
    else:
        return False

print("0.- Salir")
print("1.- Validar NIF")
print("2.- Generar letra NIF")

while Salir != 0:
    option = int(input("Elige una opción: "))

    if option == 1:
        if es_nif(dniCliente):
            dniCliente = str(input("Introduce el DNI: "))
            print("NIF Correcto")
        else:
            print("NIF Incorrecto")
    elif option == 2:
        dniCliente = str(input("Introduce el DNI: "))
        dniCompleto = generar_letra_nif(dniCliente)
        print("NIF generado: ", dniCompleto)
    elif option == 0:
        Salir = 0
