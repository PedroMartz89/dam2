
parar = False
aprobados = 0
suspendidos = 0
media = 0
indice = 1
nota = 0
totalAlumnos = 0

nota = input(f"Introduce la nota del alumno {indice}: ")
while nota != "":
    nota = float(nota)
    if nota > 5:
        aprobados += 1
    elif nota < 5:
        suspendidos += 1

    indice += 1
    media += float(nota)
    nota = input(f"Introduce la nota del alumno {indice}: ")
totalAlumnos = aprobados + suspendidos
media = media / totalAlumnos

print(f"Alumnos aprobados: {aprobados}")
print(f"Alumnos suspendidos: {suspendidos}")
print(f"Nota media: {media}")
