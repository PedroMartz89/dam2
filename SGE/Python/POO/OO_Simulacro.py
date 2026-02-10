

class Alumno:
    def __init__(self, nombre, edad=18):
        self.nombre = nombre
        self.edad = edad

class Aula:
    def __init__(self,  ciclo = "DAM", curso = 1):
        self.ciclo = ciclo
        if curso not in [1,2]:
            raise ValueError("El curso debe ser 1 o 2")
        self.curso = curso
        self.listadoAlumnos = list()

    def __str__(self):
        return (f"Ciclo: {self.ciclo}"
                f"Curso: {self.curso}"
                f"Alumnos: {[a.nombre for a in self.listadoAlumnos]}")

    def insertar_alumno(self, alumno):
        if alumno not in self.listadoAlumnos:
            if len(self.listadoAlumnos) >= 30:
                return "Aula llena"
            self.listadoAlumnos.append(alumno)
            return "Correcto"
        else:
            return "El alumno ya está en el aula."

    def existe_alumno(self, nombreAlumno):
        for alumno in self.listadoAlumnos:
            if alumno.nombre == nombreAlumno:
                return True
        return False

    def alumnos_menores(self):
        resultado = {}

        for alumno in self.listadoAlumnos:
            if alumno.edad < 20:
                clave = "menores"
            else:
                clave = alumno.edad // 10

            if clave not in resultado:
                resultado[clave] = []

            resultado[clave].append(alumno.nombre)

        return resultado

alumnos_creados = []
aula_actual = None

while True:
    print("\n--- MENÚ ---")
    print("1. Crear Alumno\n2. Crear Aula\n3. Inserta Alumno Aula\n4. Mostrar Todos")
    print("5. Existe Alumno\n6. Inserta Alumnos Aula no repetidos\n7. Alumnos Menores\n8. Salir")

    opcion = input("Selecciona una opción: ")

    if opcion == "1":
        nom = input("Nombre: ")
        ed = int(input("Edad (Enter para 18): ") or 18)
        alumnos_creados.append(Alumno(nom, ed))
        print(f"Alumno {nom} creado.")

    elif opcion == "2":
        ciclo = input("Ciclo: ")
        curso = int(input("Curso (1 o 2): "))
        try:
            aula_actual = Aula(ciclo, curso)
            print(f"Aula de {ciclo} creada.")
        except ValueError as e:
            print(e)

    elif opcion == "3":
        if not aula_actual or not alumnos_creados:
            print("Error: Necesitas un aula y al menos un alumno.")
            continue
        alu = alumnos_creados[-1]
        aula_actual.insertar_alumno(alu)
        print(f"{alu.nombre} añadido al aula.")

    elif opcion == "4":
        if aula_actual:
            print(aula_actual)
        else:
            print("No hay aula creada.")
    elif opcion == "5":
        nom = input("Nombre: ")
        print(aula_actual.existe_alumno(nom))

    elif opcion == "6":
        if aula_actual:
            print("Distribución por edades:", aula_actual.alumnos_menores())
        else:
            print("Crea un aula primero.")

    elif opcion == "8":
        print("Saliendo")
        break