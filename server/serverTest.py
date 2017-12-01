import requests
import json

#r = requests.post('http://10.233.8.59:5000/insertData',data={'username':'Bob','password':'password1'})
#print(r.text)
headers = {'Content-Type' : 'application/json'}
thingy = {'username':'Bob','password':'password1'}
jsonStuff = json.dumps(thingy)
r = requests.post('http://127.0.0.1:5000/queryDB',data=jsonStuff,headers=headers)
print(r.text)
