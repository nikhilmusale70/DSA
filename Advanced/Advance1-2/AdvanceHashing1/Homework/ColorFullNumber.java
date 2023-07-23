package AdvanceHashing1.Homework;

import java.util.HashSet;

/*Problem Description
Given a number A, find if it is COLORFUL number or not.

If number A is a COLORFUL number return 1 else, return 0.

What is a COLORFUL Number:

A number can be broken into different consecutive sequence of digits.
The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324 and 245.
This number is a COLORFUL number, since the product of every consecutive sequence of digits is different


Problem Constraints
1 <= A <= 2 * 109



Input Format
The first and only argument is an integer A.



Output Format
Return 1 if integer A is COLORFUL else return 0.



Example Input
Input 1:

 A = 23
Input 2:

 A = 236


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Possible Sub-sequences: [2, 3, 23] where
 2 -> 2
 3 -> 3
 23 -> 6  (product of digits)
 This number is a COLORFUL number since product of every digit of a sub-sequence are different.
Explanation 2:

 Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
 2 -> 2
 3 -> 3
 6 -> 6
 23 -> 6  (product of digits)
 36 -> 18  (product of digits)
 236 -> 36  (product of digits)
 This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
*/
public class ColorFullNumber {
    public static void main(String[] args) {
        ColorFullNumber obj = new ColorFullNumber();
        System.out.println(obj.colorful(236));
    }

    public int colorful(int A) {
        String str = Integer.toString(A);
        HashSet<Long> hs = new HashSet<>();
        long product;
        for (int i=0; i<str.length(); i++){

            long currentVal = Integer.parseInt(String.valueOf(str.charAt(i)));
            product=currentVal;
            if (hs.contains(product))
                return 0;
            else
                hs.add(product);
            //another pointer to gather all the substring,keep left pointer i stable
            for (int j=i+1; j<str.length(); j++){
                product *= Integer.parseInt(String.valueOf(str.charAt(j)));
//                System.out.println("For i: "+i + " j: "+j+ " product: "+product);
                if (hs.contains(product))
                    return 0;
                else
                    hs.add(product);
            }
        }

        return 1;
    }
}
