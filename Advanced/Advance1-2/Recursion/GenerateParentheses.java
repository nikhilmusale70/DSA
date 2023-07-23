package Recursion;

import java.util.ArrayList;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        System.out.println(obj.generateParenthesis(3));
    }

    public ArrayList<String> generateParenthesis(int A) {
        //storing count of open bracket and close bracket
        ArrayList<String> ansArr = new ArrayList<>();
        logicToGenerate(A, A, "",ansArr);
        return ansArr;
    }
    void logicToGenerate(int openBracket, int closeBracket, String op, ArrayList<String> ans){
        if (openBracket==0&&closeBracket==0){
            ans.add(op);
            return;
        }
        if(openBracket!=0){
            logicToGenerate(openBracket-1, closeBracket, op+"(", ans);
        }
        if(openBracket<closeBracket){
            logicToGenerate(openBracket, closeBracket-1, op+")", ans);
        }
    }
}
