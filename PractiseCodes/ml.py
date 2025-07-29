#wAP in python to  implement Naive Bays algorithm




#Predictt class for x=(overcast,cool,high,srong)




weather=    ['Sunny','Sunny','Overcast','Rainy','Rainy','Rainy','Rainy','Overcast','Sunny','Sunny','Rainy','Sunny','Overcast','Rainy']
temp=       ['Hot','Hot','Hot','Mild','Cool','Cool','Cool','Mild','Cool','Mild','Mild','Mild','Hot','Mild']
humidity=   ['High','High','High','High','Normal','Normal','Normal','High','Normal','Normal','Normal','High','Normal','High']
wind=       ['Weak','Strong','Weak','Weak','Weak','Strong','Strong','Weak','Weak','Weak','Strong','Strong','Weak','Strong']
play=       ['No','No','Yes','Yes','Yes','No','Yes','No','Yes','Yes','Yes','Yes','Yes','No']


from sklearn import preprocessing


le = preprocessing.LabelEncoder()


we = le.fit_transform(weather)
t  = le.fit_transform(temp)
wn =le.fit_transform(wind)
h=le.fit_transform(humidity)
p  =le.fit_transform(play)


features = zip(we,t,h,wn)
inp = list(features)
print("Input data : ")
print(inp)
print("Actual Output : ")
print(p)


from sklearn.naive_bayes import GaussianNB
model = GaussianNB()
model.fit(inp,p)


predicted = model.predict([[1,1,1,1]])


if(predicted==1):
  print("Play tennis")
else:
  print("Dont play tennnis")


print("Predicted Value : ")
print(predicted)



















