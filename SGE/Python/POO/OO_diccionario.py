class Diccionario:
    def __init__(self, nombre, editorial="XXX", nivel="FP"):
        self.nombre = nombre
        self.editorial = editorial
        self.nivel = nivel
        self.dic = dict()

    def introducir_palabras(self, palabra):
        if palabra in self.dic:
            result = "Ya existe"
        else:
            self.dic[palabra] = list()
            result = "Introducido"
        return result

    def introducir_acepcion(self, palabra, acepcion):
        if palabra in self.dic:
            self.dic[palabra].append(acepcion)
            return f"Añadida la palabra {palabra} con la acepción {acepcion}"
        else:
            return f"No existe la palabra {palabra} en el diccionario"

    def consultar_palabra_existente(self):
        pass

    def __str__(self):
        r = f"Nombre: {self.nombre}\nEditorial: {self.editorial}"
        lp = list(self.dic.keys())
        lp.sort()
        for k in lp:
            print(f"{k}: ")
            for a in self.dic[k]:
                r += f"\t - {a}\n"
        return r


print("0.- Salir")
print("1.- Crear diccionario")
print("2.- Añadir palabra")
print("3.- Introducir aceptaciones")
print("4.- Mostrar")
print("5.- Consultar palabra existente")

opcion = int(input("Opción: "))

while opcion != 0:
    if opcion == 1:
        nombre = input("Nombre del diccionario: ")
        dicc = Diccionario(nombre)
    elif opcion == 2:
        palabra = str(input("Introduce una palabra: "))
        print(dicc.introducir_palabras(palabra))
    elif opcion == 3:
        palabra = input("Palabra: ")
        acepcion = input("Acepción: ")
        print(dicc.introducir_acepcion(palabra, acepcion))
    elif opcion == 4:
        print(dicc)
    opcion = int(input("Opción: "))