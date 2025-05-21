class alcancia:
    def __init_(self):
        self.__dinero = 0
    def meter_dinero(self,cantidad):
        if cantidad>0:
            self.__dinero += cantidad
            print(f"Metiste $", {cantidad},"en la alcancia.")
    def ver_dinero(self):
        print(f"Tienes $", {self.__dinero}, "en la alcancia")
mi_alcancia=alcancia()
mi_alcancia.meter_dinero(10)
mi_alcancia.ver_dinero()