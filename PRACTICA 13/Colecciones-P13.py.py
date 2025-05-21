#Dulce Maria Franco Madera 

#Crear una lista con 5 valores mixtos.
#Crear una lista de 5 valores del mismo tipo con numpy. 
#Las listas anteriores convertirlas a tuplas y conjuntos.
#Crear un diccionario de 5 elementos con valores distintos tipos.

import numpy as np 

lista_mixta= [48, "Hola", 3.14, False, [1,2,3,4,5]]
lista_numerica=np.array([10,20,30,40,50])

tupla_mixta = tuple(lista_mixta)
tupla_numerica = tuple(lista_numerica)

conjunto_mixto = tuple(lista_mixta)  
conjunto_numerico = tuple(lista_numerica)

diccionario= {
    "cantidad":150,
    "nombre": "Dulce Franco",
    "pi": 3.1416,
    "alumno": False,
    "edades": ["15","18","20","25"]
}

print("Lista mixta:", lista_mixta)
print("Lista numerica:", lista_numerica)
print("Tupla mixta:", tupla_mixta)
print("Tupla numerica:", tupla_numerica)
print("Conjunto mixto:", conjunto_mixto)
print("Conjunto numerico:", conjunto_numerico)
print("Diccionario:", diccionario)