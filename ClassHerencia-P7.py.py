class Animal:
    def __init__(self, nombre,raza):
        self.nombre = nombre
        self.raza= raza
    
    def hacer_sonido(self):
        return "Sonido genérico"

class Perro(Animal): 
    def hacer_sonido(self):
        return "Guau guau"

# Uso de herencia
perrito = Perro("Firulais","Doberman")
print(perrito.nombre) 
print(perrito.hacer_sonido()) 
print(perrito.raza)

print("3-------------------------------------------------------------------------------------------")