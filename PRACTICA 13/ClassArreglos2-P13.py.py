from NumPy import array 
import NumPy as np

class arreglos:
    def _init_(self,v):
        self.arregloMP=np.array(v)
        self.arregloList=[v]
    
    def insertar(self,v):
        self.arregloList.append(v)

    def insertarMP(self,v):
        self.arregloMP.insert(np.arregloMP, v)

    def eliminar (self,i):
        self.arregloList.pop(i)

    def eliminarMP(self,i):
        self.arregloMP.delete(i)

    def modificar(self,i,v):
        self.arregloList[i]=v

    def modificarMP(self,i,v):
        self.arregloMP[i]=v

lista=arreglos.insertar()

