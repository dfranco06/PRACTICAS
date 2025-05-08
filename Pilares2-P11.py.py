from math import pi
from abc import ABC, abstractmethod

class Figura(ABC):
    @abstractmethod
    def calcular_area():
            pass

class Circulo(Figura):
      def __init__(self, radio):
            self.radio = radio

      def areaCirculo(self):
            return math.pi() * self.radio ** 2
      
class Rectangulo(Figura):
      def __init__(self, ancho, largo):
            self.ancho = ancho
            self.largo = largo

      def areaRectangulo(self):
            return self.ancho * self.largo