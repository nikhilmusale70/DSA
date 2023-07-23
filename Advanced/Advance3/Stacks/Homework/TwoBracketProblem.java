package Stacks.Homework;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class TwoBracketProblem {
    public static void main(String[] args) {

        /*
        * lo -> - + - +
        * go -> - + -
        *
        * */
        String A = "-(a-(-z-(b-(c+t)-x)+l)-q)";
        String B = "-a+l-b-(z-(c+t)-x-q)";
        TwoBracketProblem obj = new TwoBracketProblem();
        System.out.println(obj.solve(A,B));
    }

    public String checkFunction(String A){
        Stack<Character> global = new Stack<>();
        char local = '+';
        StringBuilder ans = new StringBuilder();

        for (int i=0; i<A.length(); i++){
            if(A.charAt(i)=='-' || A.charAt(i)=='+'){
                if (global.isEmpty())
                    local = A.charAt(i);
                else {
                    local = giveProperSign(global.peek(), A.charAt(i));
                }
            }
            else if(A.charAt(i)=='('){
                global.push(local);
            }
            else if(A.charAt(i)==')'){
                global.pop();
            }
            else{
                ans.append(local).append(A.charAt(i));
            }
        }

        return ans.toString();
    }
    char giveProperSign(char first, char second){
        if( (first=='+' && second=='-') || (first=='-' && second=='+') ){
            return '-';
        }
        return '+';
    }

    int[] sortString(String A){
        int[] signArr = new int[26];
        Arrays.fill(signArr, 0);
        //0 -> positive
        //1 -> negative

        for (int i=1; i<A.length(); i+=2){
            signArr[A.charAt(i)-'a']=A.charAt(i-1)=='-'?1:0;
        }
        return signArr;
    }
    public int solve(String A, String B) {
        String C = checkFunction(A);
        String D = checkFunction(B);
        int[] CsignArr = sortString(C);
        int[] DsignArr = sortString(D);

        for (int i=0; i<CsignArr.length; i++){
            if (CsignArr[i] != DsignArr[i]){
                return 0;
            }
        }

        return 1;
    }


}
