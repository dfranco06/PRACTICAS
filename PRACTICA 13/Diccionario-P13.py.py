#Dulce Maria Franco Madera 
#01/Abril/2025

Dic={"x":"equis","y":"ye","D":"De"}
Dic2=dict(x="equis", Y="ye", D="De")

print(Dic['y'])
print(Dic.get('x'))
print(Dic.get('z'))#None

Dic['x']="equisD"
Dic['z']="zeta"

del Dic['y']
x=Dic.pop('y')
print(x)#"ye"

print('x' in Dic)#True

llaves=Dic.keys()
print(llaves)#['x','y','D']
Valores=Dic.values()
p=Dic.items()