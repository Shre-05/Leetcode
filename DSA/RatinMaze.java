/*
Rat in Maze
Solved
Difficulty: MediumAccuracy: 35.75%Submissions: 455K+Points: 4Average Time: 25m
Given a square binary matrix maze[][] containing values 0 and 1, find all possible paths for a rat to travel from the top-left cell to the bottom-right cell. The rat can move in four directions: up(U), down(D), left(L), and right(R).

1 represents an open cell through which the rat can move.
0 represents a blocked cell that cannot be traversed.
The rat can move only through open cells and cannot visit the same cell more than once in a path. Return all valid paths as strings consisting of 'U', 'D', 'L', and 'R', representing the sequence of moves taken by the rat.

Note: Return the paths in lexicographically increasing order. If no valid path exists, return an empty list.

Examples:

Input: maze[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: There are two valid paths from the source cell (0, 0) to the destination cell (3, 3).

Input: maze[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists as the destination cell (1, 1) is blocked.
Constraints:

2 ≤ mat.size() ≤ 5
0 ≤ mat[i][j] ≤ 1
mat[i].size() = mat.size()
 */
import java.util.*;
class RatinMazeSolution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> ans=new ArrayList<>();
        int n=maze.length;
        
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        char[] direction = {'D', 'L', 'R', 'U'};
        boolean[][] visited=new boolean[n][n];
        
        if(maze[0][0]==0 || maze[n-1][n-1]==0){
            return ans;
        }
        return solve(maze,0,0,n,"",ans,visited,di,dj,direction);
    }
    public ArrayList<String> solve(int[][]maze,int row,int col,int n,String path,ArrayList<String>ans,boolean[][]visited,int di[],int[]dj,char []direction){
        // base condition
        if(row==n-1 && col==n-1){
            ans.add(path);
            return ans;
        }
        visited[row][col]=true;
        // loop through all the direction
        for(int i=0;i<4;i++){
            int nrow=row+di[i];
            int ncol=col+dj[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && !visited[nrow][ncol] && maze[nrow][ncol]==1){
                solve(maze,nrow,ncol,n,path+direction[i],ans,visited,di,dj,direction);
                
            }
            
        }
        visited[row][col]=false;
        
        return ans;
    }
    
}