from flask import Flask
from flask import request
import MySQLdb
from flask import jsonify
 
app = Flask(__name__)
 
@app.route("/")
def hello():
    return "Welcome to the BADASS server"

@app.route('/queryDB', methods=['POST'])
def query():
	#if not request.json or not 'title' in request.json:
	#	abort(400)

	json_dict = request.get_json()
	query = {
	'username': json_dict['username'],
	'password': json_dict['password']
	}
	db = MySQLdb.connect(host="localhost",user="root",passwd="mysql",db="BADASS")
	cursor = db.cursor()

	cursor.execute("SELECT username FROM BADASS.users WHERE username = '" + query['username'] + "' AND password = '" + query['password'] + "';")

	thing = ""

	for row in cursor.fetchall():
		thing += str(row[0]) + '\n'

	return thing


@app.route('/insertData', methods=['POST'])
def insert():

	#input_json = request.get_from(force=True) # failing right here!!!
	#if not request.json or not 'title' in request.json:
	#	abort(400)
	json_dict = request.get_json()
	data = {
	'username': json_dict['username'],
	'password': json_dict['password']
	}

	db = MySQLdb.connect(host="localhost",user="root",passwd="mysql",db="BADASS")
	cursor = db.cursor()

	resp = cursor.execute("INSERT into BADASS.users VALUES (8,'" + data['username'] + "','" + data['password'] + "');")
	db.commit()
	return "data inserted!"

 
if __name__ == "__main__":
	app.run(debug=True)