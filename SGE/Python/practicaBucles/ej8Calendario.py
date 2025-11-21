numDias = int(input("Introduce el número de días: "))
comienzo = int(input("Introduce el día de comienzo: "))

print(f"L\tM\tX\tJ\tV\tS\tD")
for j in range(comienzo):
    print("",end="\t")

for i in range(1, numDias+1):
    print(i, end= "\t")
    if (i + comienzo) % 7 == 0:
        print()