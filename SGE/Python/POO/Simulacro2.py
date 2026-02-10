import random

class Examen:
    def __init__(self, modulo):
        self.Modulo = str(modulo)
        self.Preguntas = dict() #clave: "Python" valor: [(Pregunta, respuesta, puntuacion), (), ()]

    def __str__(self):
        result = ""
        for clave, valor in self.Preguntas.items():
            result = result + f"Tema: {clave}"
            for p, r, punt in valor:
                result = result + f"\nPregunta: {p}"
                result = result + f"\nRespuesta: {r}"
                result = result + f"\nPuntuación: {str(punt).replace('.', ',')}\n"
        return result.strip()

    def insertar_pregunta(self, pregunta, respuesta, puntuacion, tema="python"):
        if not tema in self.Preguntas.keys():
            self.Preguntas[tema] = []
        self.Preguntas[tema].append((pregunta, respuesta, puntuacion))

    def generar_examen(self, tema, num_preguntas):
        puntuacion_obtenida = 0.0
        puntuacion_maxima = 0.0

        if str(tema) not in self.Preguntas:
            print("El tema no existe")
            return
        preguntas = self.Preguntas[tema]
        if int(num_preguntas) > len(preguntas):
            print("No hay preguntas suficientes.")
            return

        pregunta_elegida = random.sample(preguntas, int(num_preguntas))

        for preg, resp, puntos in pregunta_elegida:
            puntuacion_maxima += float(puntos)
            print(f"Pregunta: {preg}")
            respuesta = str(input(f"Respuesta: "))
            if str(respuesta).strip().lower() == str(resp):
                puntuacion_obtenida += float(puntos)

        print(f"Total de preguntas: {num_preguntas}")
        print(f"Puntuación máxima posible: {str(puntuacion_maxima).replace('.', ',')}")
        print(f"Puntuacón obtenida: {str(puntuacion_obtenida).replace('.', ',')}")

def menu():
    print("1. Crear Examen.")
    print("2. Introducir Pregunta.")
    print("3. Imprimir Examen.")
    print("4. Generar Examen.")
    print("5. Salir")
    ex = None
    opcion = int(input("Introduce una opción: "))
    while opcion != 5:
        if opcion == 1:
            modulo = str(input("Introduce el nombre del módulo: ")).lower()
            ex = Examen(modulo)
        elif opcion == 2:
            unidad = str(input("Introduce el tema (vacío para Python): ")).lower()
            pregunta = str(input("Introduce la pregunta: "))
            respuesta = str(input("Introduce la respuesta: ")).lower()
            puntuacion = float(input("Introduce la puntuación: "))
            if unidad != "":
                ex.insertar_pregunta(pregunta, respuesta, puntuacion, unidad)
            else:
                ex.insertar_pregunta(pregunta, respuesta, puntuacion)
        elif opcion == 3:
            print(ex.__str__())
        elif opcion == 4:
            unidad = str(input("Introduce el tema: ")).lower()
            num_preguntas = int(input("Introduce el número de preguntas: "))
            ex.generar_examen(unidad, num_preguntas)
        opcion = int(input("Introduce una opción: "))

menu()