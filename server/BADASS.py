from flask import Flask
from flask import request
import MySQLdb
 
app = Flask(__name__)
 
@app.route("/")
def hello():
    return "Welcome to the BADASS server"

@app.route('/queryDB', methods=['POST'])
def query():
	#if not request.json or not 'title' in request.json:
	#	abort(400)

	query = {
	'username': request.form['username'],
	'password': request.form['password']
	}
	db = MySQLdb.connect(host="localhost",user="root",passwd="mysql",db="BADASS")
	cursor = db.cursor()

	cursor.execute("SELECT username FROM BADASS.authentication_database WHERE username = '" + query['username'] + "' AND password = '" + query['password'] + "';")

	thing = ""

	for row in cursor.fetchall():
		thing += str(row[0]) + '\n'

	return thing


@app.route('/insertData', methods=['POST'])
def insert():

	#input_json = request.get_from(force=True) # failing right here!!!
	#if not request.json or not 'title' in request.json:
	#	abort(400)
	data = {
	'username': request.form['username'],
	'password': request.form['password']
	}

	db = MySQLdb.connect(host="localhost",user="root",passwd="mysql",db="BADASS")
	cursor = db.cursor()

	resp = cursor.execute("INSERT into BADASS.authentication_database VALUES ('" + data['username'] + "','" + data['password'] + "');")
	db.commit()
	return "data inserted!"

 
if __name__ == "__main__":
	app.run(debug=True)