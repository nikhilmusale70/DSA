package Graph1.HomeWork;

import java.util.ArrayList;

/* Valid Path
Solved
feature icon
Using hints is now penalty free
Use Hint
Problem Description
There is a rectangle with left bottom as (0, 0) and right up as (x, y).

There are N circles such that their centers are inside the rectangle.

Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.



Problem Constraints
0 <= x , y, R <= 100

1 <= N <= 1000

Center of each circle would lie within the grid



Input Format
1st argument given is an Integer x , denoted by A in input.

2nd argument given is an Integer y, denoted by B in input.

3rd argument given is an Integer N, number of circles, denoted by C in input.

4th argument given is an Integer R, radius of each circle, denoted by D in input.

5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle

6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle



Output Format
Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).



Example Input
Input 1:

 x = 2
 y = 3
 N = 1
 R = 1
 A = [2]
 B = [3]
Input 2:

 x = 3
 y = 3
 N = 1
 R = 1
 A = [0]
 B = [3]


Example Output
Output 1:

 NO
Output 2:

 YES


Example Explanation
Explanation 1:

 There is NO valid path in this case
Explanation 2:

 There is many valid paths in this case.
 One of the path is (0, 0) -> (1, 0) -> (2, 0) -> (3, 0) -> (3, 1) -> (3, 2) -> (3, 3).*/
public class ValidPath {
    public static void main(String[] args) {
        int x = 41;
        int y = 67;
        int N = 1;
        int R = 0;
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(3);

        System.out.println(new ValidPath().solve(x,y, N, R, A, B));
    }


    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        if(C==0) return "YES";

        boolean[][] visited = new boolean[A+1][B+1];
        dfs(visited, 0,0,A, B, D, E, F);
        return visited[A][B]?"YES":"NO";
    }

    void dfs(boolean[][] visited, int X, int Y, int endX, int endY, int Radious, ArrayList<Integer> E, ArrayList<Integer> F){
        if(!isValid(X, Y, endX, endY, Radious, E, F, visited)) return;

        visited[X][Y] = true;
        if(X== endX && Y==endY) return;

        for(int i=0; i<8; i++){
            int currX = X + x[i];
            int currY = Y + y[i];
            dfs(visited, currX, currY, endX, endY, Radious, E, F);
        }
    }
    int[] x = {0,0,1,-1,-1,1,1,-1};
    int[] y = {1,-1,0,0,1,1,-1,-1};

    boolean isValid(int x, int y, int C, int D, int R, ArrayList<Integer> circleX, ArrayList<Integer> circleY, boolean[][] visited){
        if(x<0 || y<0 || x>C || y>D || visited[x][y]) return false;
        for(int i=0; i<circleX.size(); i++){
            //iterating on mid pts of circle
            int h = circleX.get(i);
            int k = circleY.get(i);

            //using formula
            //Distance^2 = ((x - h)^2 + (y - k)^2), if r square is more then we are in circle otherwise we are outside of circle
            int dis = ( ((x - h) * (x-h) ) + ((y-k) * (y-k)) );
            if(dis <= R * R) return false;
        }

        return true;
    }
}
