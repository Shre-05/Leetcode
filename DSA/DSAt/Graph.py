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

# Gaph transversal methods:
class DFS:
    def __init__(self,vertex):
        self.mat=[[0]*vertex for x in range(vertex)]
        self.size=vertex
    # add the edges:
    def add_edge(self,src,dest):
        if(0<=src<self.size and 0<=dest<self.size):
            self.mat[src][dest]=1
            self.mat[dest][src]=1
        else:
            print("Invalid edge!")

    # dfs logic:
    def dfs(self,src):
        visited=[False]*self.size #an array to store if the vertex is visited or not
        stack=[src] #a stack which stores the vertexes

        while(stack): #while stack is not empty
            v=stack.pop()
            if(visited[v]==False): #if the node is not visited
                print(v,end="->")
                visited[v]=True #make it as visited
            
            for i in range(self.size):
                if(self.mat[v][i]==1 and visited[i]==False): #if the edges are connected but node i is not visited
                    stack.append(i)

d=DFS(6)
d.add_edge(0,1)
d.add_edge(0,2)
d.add_edge(2,3)
d.add_edge(2,4)
d.add_edge(3,5)
d.add_edge(4,5)
d.dfs(0)

print("")
from collections import deque
class BFS:
    def __init__(self,vertex):
        self.mat=[[0]*vertex for i in range(vertex)]
        self.size=vertex

    def add_edge(self,src,dest):
        if(0<=src<self.size and 0<=dest<self.size):
            self.mat[src][dest]=1
            self.mat[dest][src]=1
        else:
            print("Invalid edge!")
    def bfs(self,src):
        visited=[False]*self.size
        queue=deque([src])
        visited[src]=True

        while(queue):
            v=queue.popleft()
            print(v,end="->")

            for i in range(self.size):
                if(self.mat[v][i]==1 and visited[i]==False):
                    visited[i]=True
                    queue.append(i)

b=BFS(8)
b.add_edge(0,1)
b.add_edge(0,3)
b.add_edge(1,3)
b.add_edge(3,5)
b.add_edge(3,4)
b.add_edge(5,4)
b.add_edge(4,6)
b.add_edge(6,2)
b.add_edge(6,7)

b.bfs(0)