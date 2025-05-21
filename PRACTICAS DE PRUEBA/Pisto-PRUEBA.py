class Pisto:
    def __init__(self,hielera,hielera2):
        self.__hielera=hielera
        self.hielera2=hielera2

    def pistear1(self):
        self .__hielera="vaciar"
        return self .__hielera
    
    def pistear2(self):
        self.hielera2="Mah. esta vacia"
        return self.hielera2
    
fiesta=Pisto("Carton en hielera","Unas cuantas frias")
print(fiesta.pistear1())
print(fiesta.pistear2)