# type of graph:
# undirected grapg
# directed graph
# weighted graph

# implementation of graph using Matrix
# Undirectd graph
class Undirected_Graph:
    def __init__(self,vertex):
        self.mat=[[0]*vertex for x in range(vertex)]
        self.size=vertex

    # add edges inside the graph
    def add_edge(self,src,dest):
        if(0<=src<self.size and 0<=dest<self.size):
            self.mat[src][dest]=1
            self.mat[dest][src]=1
        else:
            print("Invalid edges given..")
    def print_graph(self):
        for row in self.mat:
            print(' '.join(map(str,row)))

g=Undirected_Graph(4)
g.add_edge(0,1)
g.add_edge(0,3)
g.add_edge(1,2)
g.print_graph()

print("")
# Directed Grpah
class Directed_Grpah:
    def __init__(self,vertex):
        self.mat=[[0]*vertex for x in range(vertex)]
        self.size=vertex
    # add an edge
    def add_edge(self,src,dest):
        if(0<=src<self.size and 0<=dest<self.size):
            self.mat[src][dest]=1
        else:
            print("Invalid edge!")

    def print_graph(self):
        for row in self.mat:
            print(' '.join(map(str,row)))

dg=Directed_Grpah(4)
dg.add_edge(0,1)
dg.add_edge(0,3)
dg.add_edge(2,1)
dg.print_graph()

print("")
# Weighted graph
class Weighted_Graph:
    def __init__(self,vertex):
        self.mat=[[0]*vertex for x in range(vertex)]
        self.size=vertex
    def add_edge(self,src,dest,weight):
        if(0<=src<self.size and 0<=dest<self.size):
            self.mat[src][dest]=weight
        else:
            print("Invalid edge!")

    def print_graph(self):
        for row in self.mat:
            print(' '.join(map(str,row)))

wg=Weighted_Graph(4)
wg.add_edge(0,1,3)
wg.add_edge(0,3,10)
wg.add_edge(2,1,5)
wg.print_graph()

## implementation of graph using Adjacency list:
class AD_Graph:
    def __init__(self):
        self.adList={}

    def add_vertex(self,vertex):
        if vertex not in self.adList:
            self.adList[vertex]=[]
        
    def add_edge(self,src,dest):
        self.add_vertex(src)
        self.add_vertex(dest)

        self.adList[src].append(dest)
        self.adList[dest].append(src)
    
    def print_graph(self):
        for vertex in self.adList:
            print(vertex,"->",self.adList[vertex])

    
obj=AD_Graph()
obj.add_edge(0,1)
obj.add_edge(1,2)
obj.add_edge(0,3)
obj.print_graph()
