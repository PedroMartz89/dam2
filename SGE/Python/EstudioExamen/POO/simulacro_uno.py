
import random


class Examen:
    def __init__(self, modulo):
        self.modulo = modulo
        self.preguntas = {} #clave: "Python" valor: [(Pregunta, respuesta, puntuacion), (), ()]

    def insertar_pregunta(self, pregunta, respuesta, puntuacion, tema="python"):
        if float(puntuacion) < 0:
            puntuacion = 0
        elif float(puntuacion) > 10:
            puntuacion = 10

        if tema not in self.preguntas.keys():
            self.preguntas[tema] = []
        self.preguntas[tema].append((pregunta, respuesta, puntuacion))

    def generar_examen(self, tema, num_preguntas):
        if tema not in self.preguntas:
            print("El tema no existe.")
            return

        if len(self.preguntas[tema]) < int(num_preguntas):
            print("No hay preguntas suficientes.")
            return

        preguntas_seleccionadas = random.sample(self.preguntas[tema], int(num_preguntas))
        puntuacion_maxima = 0.0
        puntuacion_total = 0.0
        for pregunta, respuesta, puntuacion in preguntas_seleccionadas:
            puntuacion_maxima += float(puntuacion)
            print(f"Pregunta: {pregunta}: ")
            respuesta_usuario = str(input(f"Respuesta: "))

            if respuesta_usuario.lower() == str(respuesta).lower():
                print("Respuesta correcta.")
                puntuacion_total += float(puntuacion)
            else:
                print("Respuesta incorrecta.")

        print(f"Total preguntas: {num_preguntas}")
        print(f"Puntuación máxima posible: {puntuacion_maxima}")
        print(f"Puntuación obtenida: {puntuacion_total}")

    def __str__(self):
        result = ""
        for clave, valor in self.preguntas.items():
            result = result + f"Tema: {clave}"
            for p, r, punt in valor:
                result = result + f"\nPregunta: {p}"
                result = result + f"\nRespuesta: {r}"
                result = result + f"\nPuntuación: {str(punt).replace('.', ',')}\n"
        return result.strip()

def menu():
    ex = None
    print("1. Crear Examen.")
    print("2. Introducir Pregunta.")
    print("3. Imprimir Examen.")
    print("4. Generar Examen.")
    print("5. Salir")

    opcion = int(input("Introduce una opción: "))
    while opcion != 5:
        if opcion == 1:
            tema = str(input("Introduce el nombre del módulo: "))
            ex = Examen(tema)
        elif opcion == 2:
            tema = str(input("Introduce el tema: "))
            pregunta = str(input("Introduce la pregunta: ")).lower()
            respuesta = str(input("Introduce la respuesta: ")).lower()
            puntuacion = float(input("Introduce la puntuación: "))
            if tema == "":
                ex.insertar_pregunta(pregunta, respuesta, puntuacion)
            else:
                ex.insertar_pregunta(pregunta, respuesta, puntuacion, tema)
        elif opcion == 3:
            print(ex)
        elif opcion == 4:
            tema = str(input("Introduce el tema para el examen: "))
            num_preguntas = int(input("Introduce el número de preguntas: "))
            ex.generar_examen(tema, num_preguntas)
        opcion = int(input("Introduce una opción: "))

menu()