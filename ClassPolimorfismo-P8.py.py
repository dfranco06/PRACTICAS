# 3. Polimorfismo: Permite que diferentes clases tengan métodos con el mismo nombre pero con diferente comportamiento.
def hacer_sonar(animal):
    print(animal.hacer_sonido())

gato = Animal("Michi")
perro = Perro("Rex")

hacer_sonar(gato) 
hacer_sonar(perro)  

print("4-------------------------------------------------------------------------------------------")