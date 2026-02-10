class Alumno:
    def __init__(self, Nombre, E=18):
        self.Nombre = Nombre
        self.Edad = E

class Aula:
    def __init__(self, C="DAM", Curso = 1):
        self.Ciclo = C
        self.Curso = Curso
        self.LAlum = list()
    def InsertarAlumno(self, A):
        if len(self.LAlum) < 30:
            self.LAlum.append(A)
            resultado = "Correcto"
        else:
            resultado = "Aula llena"
        return resultado
    def ExisteAlumno(self, Nombre):
        Existe = False
        i = 0 
        while i < len(self.LAlum) and not Existe:
            if Nombre == self.LAlum[i].Nombre:
                Existe = True
            else:
                i += 1
        return Existe

    def ExisteAlumnov2(self, Nombre):
        i = 0 
        while i < len(self.LAlum) and Nombre != self.LAlum[i].Nombre:
                i += 1
        return i < len(self.LAlum)

    def AlumnosMenores(self):
        D = dict()
        for a in self.LAlum:
            if a.Edad < 18:
                if "menores" in D:
                    D["menores"].append(a.Nombre)
                else:
                    D["menores"] = [a.Nombre]
            else:
                Decada = a.Edad // 10
                if Decada in D:
                    D[Decada].append(a.Nombre)
                else:
                    D[Decada] = [a.Nombre]
        return D
    def __str__(self):
        resultado = f"Ciclo: {self.Ciclo}\n"
        resultado +=f"Curso: {self.Curso}\n"
        resultado +=f"Alumno: "
        for a in self.LAlum:
            resultado += a.Nombre + ", "
        return resultado[:-2]

print("0.- Salir")
print("1.- Crear Alumno")
print("2.- Crear Aula")
print("3.- Insertar Alumno Aula")
print("4.- Mostrar Todos")
print("5.- Existe Alumno")
print("6.- Insertar Alumno Aula no repetidos")
print("7.- Alumnos Menores")
opcion = int(input("Opcion: "))
while opcion != 0:
    if opcion == 1:
        N = input("Nombre: ")
        E = input("Edad: ")
        if E == "":
            Alum = Alumno(N)
        else:
            Alum = Alumno(N, int(E))
 #       print(Alum.Nombre)
    elif opcion == 2:
        CDam = Aula()
 #       print(CDam.LAlum)
    elif opcion == 3:
        print(CDam.InsertarAlumno(Alum))
 #       print(CDam.LAlum[0].Nombre)
    elif opcion == 4:
        print(CDam)
    elif opcion == 5:
        N = input("Nombre: ")
        if CDam.ExisteAlumno(N):
            print("Existe")
        else:
            print("No existe")
    elif opcion == 6:
        pass
    elif opcion == 7:
        print(CDam.AlumnosMenores())
    opcion = int(input("Opcion: "))