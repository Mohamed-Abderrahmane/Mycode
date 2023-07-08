# Td 5 
from multiprocessing import connection
import pandas as pd
import sqlite3
from sqlite3 import Error


def create_connection(path):
    connection = None
    try:
        connection = sqlite3.connect(path)
        print("Connection to SQLite DB successful")
    except Error as e:
        print("The error '{e}'occured")

    return connection

connection = create_connection("vote.sqlite")


#1

vote= pd.read_sql("SELECT * from vote",connection,index_col="Class")
votes = vote.copy()
votes.iloc[:,:-1] = (votes.iloc[:,:-1] =="y")
regroup = votes.groupby("Class")
vals = regroup.sum()
print(vals)


# votes.to_sql("votes",connection)

from matplotlib import pyplot as plt
X = [1, 50]
Y = [value * 3 for value in X]
#plt.plot(X, Y)
# plt.show()

#
Z = [1,2,3]
W = [2,4,1]
plt.plot(Z, W)
plt.show()


#

# plt.show()