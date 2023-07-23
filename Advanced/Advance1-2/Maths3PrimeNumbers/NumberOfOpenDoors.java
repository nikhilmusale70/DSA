package Maths3PrimeNumbers;

/*
Problem Description
Given an integer A, which denotes the number of doors in a row numbered 1 to A. All the doors are closed initially.

A person moves to and fro, changing the states of the doors as follows: the person opens a door that is already closed and closes a door that is already opened.

In the first go, he/she alters the states of doors numbered 1, 2, 3, … , A.
In the second go, he/she alters the states of doors numbered 2, 4, 6 ….
In the third go, he/she alters the states of doors numbered 3, 6, 9 …
This continues till the A'th go in, which you alter the state of the door numbered A.

Find and return the number of open doors at the end of the procedure.



Problem Constraints
1 <= A <= 109



Input Format
The only argument given is integer A.



Output Format
Return the number of open doors at the end of the procedure.



Example Input
Input 1:

 A = 5
Input 2:

 A = 6


Example Output
Output 1:

 2
Output 2:

 2


Example Explanation
Input 1:

 In the first go, he/she alters the states of doors numbered 1, 2, 3, 4, 5. Now, all doors are open.
 In the second go, he/she closes the doors numbered 2, 4.
 In the third go, he/she closes the door numbered 3.
 In the fourth go, he/she open the door numbered 4.
 In the fifth go, he/she closes the door numbered 5.
 Doors opened at the end are 1 and 4.
Input 2:

 In the first go, he/she alters the states of doors numbered 1, 2, 3, 4, 5, 6. Now, all doors are open.
 In the second go, he/she closes the doors numbered 2, 4, 6.
 In the third go, he/she closes the door numbered 3 and opens door 6.
 In the fourth go, he/she open the door numbered 4.
 In the fifth go, he/she closes the door numbered 5.
 In the sixth go, he/she closes the door numbered 6.
 Doors opened at the end are 1 and 4.
 */
public class NumberOfOpenDoors {
    public static void main(String[] args) {
        int A = 9507698;
        System.out.println(solve(A));
    }
    public static int solve(int A) {
        //false- door close
        //true- open door

        int openDoor=0;
        //just find perfect square number
        for (int i=0; i*i<=A; i++){
            if (i*i<=A){
                openDoor++;
            }
        }
        return openDoor;
    }

}
