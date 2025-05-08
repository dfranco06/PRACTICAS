import math

class Figura:
    def __init__(self, lados, longitud):
        self.lados = lados
        self.longitud = longitud
    
    def calcular_perimetro(self):
        return self.lados * self.longitud
    
    def calcular_area(self):
        if self.lados == 3:  
            return (math.sqrt(3) / 4) * (self.longitud ** 2)
        elif self.lados == 4:
            return self.longitud ** 2
        elif self.lados == 5: 
            return (1/4) * math.sqrt(5 * (5 + 2 * math.sqrt(5))) * (self.longitud ** 2)
        elif self.lados == 6: 
            return (3 * math.sqrt(3) / 2) * (self.longitud ** 2)
        else:
            return None 

def solicitar_datos():
    try:
        lados = int(input("Ingrese el número de lados de la figura (3, 4, 5, 6): "))
        if lados not in [3, 4, 5, 6]:
            print("Figura no soportada. Solo se permiten triángulo equilátero (3), cuadrado (4), pentágono (5) o poligono(6).")
            return
        longitud = int(input("Ingrese la longitud de los lados: "))
        figura = Figura(lados, longitud)
        print(f"Perímetro: {figura.calcular_perimetro()}")
        area = figura.calcular_area()
        if area is not None:
            print(f"Área: {area}")
        else:
            print("No se pudo calcular el área para esta figura.")
    except ValueError:
        print("Entraa no válida. Asegúrese de ingresar números enteros para los lados y números para la longitud.")

if __name__ == "__main__":
    solicitar_datos()