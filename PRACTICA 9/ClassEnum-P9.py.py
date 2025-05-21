from enum import Enum 
class consecutivo(Enum):
    lunes=1
    martes=2
    miercoles=3

print(consecutivo.lunes)
print(consecutivo.lunes.value)
print(type(consecutivo.lunes))
print(type(consecutivo.lunes.value))