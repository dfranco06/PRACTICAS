import array
class arreglo:
    def _init_(self,v):
    self.list = array.array('i'[1, 2, 3, 4, 5, 6])

    def insert(self,n):
        if isinstance(n, int):
            self.list.append(n)
            print("A tu lista se le agrego tu elemento: ",self.lista.tolist())
        else:
            print("Solamente se aceptan valores de tipo entero.")
    
    def eliminar(self,n):
        if isinstance(num, int) and num in self.lista:
            self.list.remove(n)
            print("El elemento a eliminar a sido removido con exito.")
        else:
            print("El valor que necesitas remover no es valido o no se encuentra en la lista.")
    
    def modify(self,index,nv):
        try:
            index=int(index)
            nv=int(nv)

            if 0<=index < len(self.list):
                self.list[index]=nv
                print("Tu lista a sido actualizada:", self.list.tolist())
            else:
                print("El indice se encuentra fuera del rango.")
        except ValueError:
            print("Solo ingresa numeros enteros.")




        