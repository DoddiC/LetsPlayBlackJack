import sqlite3

conn = sqlite3.connect('blackjack.db')
c = conn.cursor()

c.execute('DROP TABLE users')

conn.commit()
conn.close()