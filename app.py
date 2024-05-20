from pathlib import Path
from faker import Faker
import sqlite3

fake = Faker()

Path("app/college.db").unlink()
conn = sqlite3.connect("app/college.db")
cursor = conn.cursor()

query = """CREATE TABLE IF NOT EXISTS students (
id INTEGER PRIMARY KEY,
name TEXT,
phone TEXT,
email TEXT
)"""
cursor.execute(query)


for _ in range(100):
    if _ % 100 == 0:
        print(_)
    name = fake.name()
    phone = fake.phone_number()
    email = fake.email()
    query = "INSERT INTO students (name, phone, email) VALUES (?, ?, ?)"
    values = (name, phone, email)
    cursor.execute(query, values)

conn.commit()
conn.close()
