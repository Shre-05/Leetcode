from collections import deque
class Graph:
    def __init__(self,vertex):
        self.mat=[[0]*vertex for i in range(vertex)]
        self.size=vertex
    def add_edge(self,src,dest):
        if(0<=src<self.size and 0<=dest<self.size):
            self.mat[src][dest]=1
            self.mat[dest][src]=1
        else:
            print("Invalid edge")
    def print(self):
        for row in self.mat:
            print(' '.join(map(str,row)))
    def dfs(self,src):
        self.visited=[False]*self.size
        stack=[src]

        while(stack):
            v=stack.pop()
            if(self.visited[v]==False):
                self.visited[v]=True
                print(v,end="->")
                for i in range(self.size):
                    if(self.mat[v][i]==1 and self.visited[i]==False):
                        stack.append(i)

    def bfs(self,src):
        self.visited=[False]*self.size
        self.queue=deque([src])
        self.visited[src]=True

        while(self.queue):
            v=self.queue.popleft()
            print(v,end="->")
            for i in range(self.size):
                if(self.mat[v][i]==1 and self.visited[i]==False):
                    self.visited[i]=True
                    self.queue.append(i)




g=Graph(5)
g.add_edge(0,1)
g.add_edge(1,2)
g.add_edge(1,3)
g.add_edge(3,4)
g.print()
g.dfs(0)
print()
g.bfs(0)