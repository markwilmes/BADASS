from flask import Flask
import MySQLdb
import sys

sys.path.insert(0, '/home/user/Dropbox/softDevMethodsTools/BADASS/RESTfulServer.py')

server = Flask(__name__)

@server.route('/')
def index():
	return "welcome to the page!"

@server.route('/queryDB', methods=['POST'])
def query():
	if not request.json or not 'title' in request.json:
		abort(400)

	query = {
	'username': request.json['username'],
	'password': request.json['password']
	}
	db = MySQLdb.connect(host="localhost",user="root",passwd="mysql",db="BADASS")
	cursor = db.cursor()

	cursor.execute("SELECT users FROM BADASS.authentication_database WHERE users = '" + query['username'] + "'' AND password = '" + query['password'] + "';")

	thing = ""

	for row in cursor.fetchall():
		thing += str(row[0]) + '\n'

	return thing


@server.route('/insertData', methods=['POST'])
def insert():
	if not request.json or not 'title' in request.json:
		abort(400)

	data = {
	'username': request.json['username'],
	'password': request.json['password']
	}

	db = MySQLdb.connect(host="localhost",user="root",passwd="mysql",db="BADASS")
	cursor = db.cursor()

	cursor.execute("INSERT into BADASS.authentication_database VALUES (" + data.username + "," + data.password + ";")


if __name__ == '__main__':
    server.run(debug=True)