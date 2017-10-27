import requests

r = requests.post('http://127.0.0.1:5000/insertData',data={'username':'Bob','password':'password1'})
print(r.text)