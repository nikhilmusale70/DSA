package Hashing2GeometryAndString;

import java.util.HashSet;
import java.util.Objects;

/*
* Problem Description
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.

Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.



Problem Constraints
1 <= N <= 2000
0 <= A[i], B[i] <= 109



Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.



Output Format
Return the number of unordered quadruplets that form a rectangle.



Example Input
Input 1:

 A = [1, 1, 2, 2]
 B = [1, 2, 1, 2]
Input 1:

 A = [1, 1, 2, 2, 3, 3]
 B = [1, 2, 1, 2, 1, 2]


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 All four given points make a rectangle. So, the answer is 1.
Explanation 2:

 3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
                                           (1, 1), (3, 1), (3, 2), (1, 2)
                                           (2, 1), (3, 1), (3, 2), (2, 2)*/

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object obj) {
        Pair p = (Pair) obj;
        return this.x == p.x && this.y == p.y;
    }
    @Override
    public int hashCode() {
        // created unique hahcode so no duplicates will enter
        return Objects.hash(x, y);
    }
}
public class CountRectangles {
    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2};
        int[] B = {1, 2, 1, 2};
        CountRectangles obj = new CountRectangles();
        System.out.println(obj.solve(A,B));
    }

    public int solve(int[] A, int[] B) {
        HashSet<Pair> hs = new HashSet<>();
        for (int i=0; i<A.length; i++){
            hs.add(new Pair(A[i], B[i]));
        }

        int ans=0;
        for (int i=0; i<A.length-1; i++){
            int x1=A[i], y1=B[i];
            for (int j=i+1; j<A.length; j++){
                //get 2 diagonal points
                int x2=A[j], y2=B[j];
                if(x1==x2 || y1==y2)
                    continue;
                Pair point1 = new Pair(x1, y2);
                Pair point2 = new Pair(x2, y1);
                //see if there exist the other 2 points that is
                //x1,y2 and x2,y1

                if(hs.contains(point1) && (hs.contains(point2)) ){
                    ans++;
                }
            }
        }
        return ans/2;
    }
}
