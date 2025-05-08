import numpy as np
class Array:
    def __init__(self):
        self.arreglo = np.array([2, 3, 5])
    def eliminar(self, indice):
        if 0 <= indice < len(self.arreglo):
            self.arreglo = np.delete(self.arreglo, indice)
            print("La lista nueva es esta", self.arreglo)
        else:
            print("El indice no es valido en este caso")
    def insertar(self):
        elemento = int(input("Ingrese el nuevo elemento a insertar: "))
        self.arreglo = np.append(self.arreglo, elemento)
        print("La nueva lista es", self.arreglo)
    def modificar(self):
        indice = int(input("Ingrese el indice del elemento a modificar: "))
        if 0 <= indice < len(self.arreglo):
            nuevo_elemento = input("Ingrese el nuevo valor: ")
            if nuevo_elemento.isdigit():
                self.arreglo[indice] = int(nuevo_elemento)
                print("La nueva lista es", self.arreglo)
            else:
                print("Numero invalido")
        else:
            print("Indice fuera de rango")

lista = Array()
indice = int(input("Ingrese el indice del valor a eliminar: "))
lista.eliminar(indice)
print("Inserta un nuevo valor a la lista")
lista.insertar()
print("Inserta el indice y el nuevo valor que tomará en su lugar")
lista.modificar()