import matplotlib.pyplot as plt
import random

mygraph = {}
mygraph["Boston"] = ["Albany", "New York", "Nashua", "Portland"];
mygraph["Bangor"] = ["Portland"]
mygraph["Nashua"] = ["Boston", "Portland"]
mygraph["Portland"] = ["Bangor", "Boston", "Nashua"]
mygraph["Albany"] = ["Boston", "New York"]
mygraph["New York"] = ["Albany", "Baltimore", "Boston", "Philadelphia", "Washington"]
mygraph["Baltimore"] = ["New York", "Philadelphia", "Washington"]
mygraph["Philadelphia"] = ["New York", "Pittsburgh", "Baltimore"]
mygraph["Pittsburgh"] = ["Philadelphia"]
mygraph["Washington"] = ["New York", "Baltimore"]

visited = []
starting = "Boston"
for i in range(1000):
    visited.append(starting);
    starting = random.choice(mygraph[starting])

#print(visited)

mycount = {}

for i in visited:
    if i in mycount.keys():
        mycount[i] = mycount[i] + 1
    else:
        mycount[i] = 1

for k in mycount.keys():
    print(k, mycount[k])


cities = ["Boston", "New York", "Nashua", "Albany", "Washington", "Philadelphia", "Portland", "Baltimore", "Pittsburgh", "Bangor"]
citiesx = [1, 2, 2, 2, 3, 3, 3, 4, 4, 4]
citiesy = [2, 3, 1, 4, 3, 2, 1, 4, 2, 1]
citiessize = []
for i in range(len(cities)):
    citiessize.append(mycount[cities[i]] * 10)
print(citiessize)

plt.scatter(citiesx, citiesy, s=citiessize)

for x,y,z in zip(citiesx,citiesy,cities):

    # this method is called for each point
    plt.annotate(z, # this is the text
                 (x,y), # this is the point to label
                 textcoords="offset points", # how to position the text
                 xytext=(0,10), # distance from text to points (x,y)
                 ha='center') # horizontal alignment can be left, right or center


for i in range(len(cities)):
    print(cities[i], end=" ")
    for j in mygraph[cities[i]]:
        idx = cities.index(j)
        print(cities[idx], end=" ")
        print(citiesx[i], citiesy[i], citiesx[idx], citiesy[idx])
        plt.plot([citiesx[i], citiesx[idx]], [citiesy[i], citiesy[idx]])

plt.show()
