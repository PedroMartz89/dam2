# C = "hola"

# for e in C:
#     print(e)

# print("")

# for i in range(len(C)):
# #    print(C[i])
# #   print(str(i) , ".-", C[i])
#     print(f"{i}.- {C[i]}")
    
s = int(input("segundos = "))
m = int(input("minutos = "))
# if S == 60:
#     S = 0

s = (s+1) % 60
m = (m+1) % 60

print("segundos = ",s)
print("minutos = ",m)