from joblib import load
import sys

argument = sys.argv[1:]

clf = load('C:\\Users\\alani\\IdeaProjects\\Tic-Tac-Toe\\src\\neuralNetwork.joblib')
inputs = []
for i in argument:
    for y in i:
        inputs.append(int(i))
prediction = clf.predict([inputs])

print(int(prediction))
