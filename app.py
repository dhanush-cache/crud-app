import random

from faker import Faker
import mysql.connector as sql


def number():
    x = random.randint(200, 999)
    y = random.randint(1000, 9999)
    return f"({x}) {x}-{y}"


conn = sql.connect(
    host="localhost",
    user="root",
    password="1234",
    database="college"
)
cursor = conn.cursor()

query = "DROP TABLE IF EXISTS students"
cursor.execute(query)

query = """CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    phone VARCHAR(15),
    email VARCHAR(50)
)"""

cursor.execute(query)

entries = 100
fake = Faker()
query = "INSERT INTO students (name, phone, email) VALUES (%s, %s, %s)"

for i in range(entries):
    print("Inserting row: ", i)

    name = fake.name()
    phone = number()
    email = fake.email()

    values = (name, phone, email)
    cursor.execute(query, values)

conn.commit()
conn.close()
