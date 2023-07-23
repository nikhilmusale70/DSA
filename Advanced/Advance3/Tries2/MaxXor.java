package Tries2;

public class MaxXor {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        MaxXor obj = new MaxXor();
        System.out.println(obj.solve(A));
    }

    public int solve(int[] A) {
        //create a trie tree
        for(int i=0; i<A.length; i++){
            String str = String.format("%30s", Integer.toBinaryString(A[i])).replaceAll(" ", "0");
            constructTrie(str);
        }

        //now lets find out the max xor
        int maxXor = Integer.MIN_VALUE;

        for (int i=0; i<A.length; i++){
            String str = String.format("%30s", Integer.toBinaryString(A[i])).replaceAll(" ", "0");
            maxXor = Math.max(maxXor, searchInTrie(str));
        }

        return maxXor;
    }

    TrieNode root = new TrieNode();
    static class TrieNode{
        TrieNode[] child;
        TrieNode() {
            child = new TrieNode[2];
        }
    }

    int searchInTrie(String number){
        StringBuilder ans = new StringBuilder();
        TrieNode temp = root;

        for(int i=0; i<number.length(); i++){
            int curr = Integer.parseInt(number.charAt(i)+"");
            if(curr==1){
                if(temp.child[0]!=null){
                    ans.append(0);
                    temp = temp.child[0];
                }
                else{
                    ans.append(1);
                    temp = temp.child[1];
                }
            }
            //curr==0
            else{
                if(temp.child[1]!=null){
                    ans.append(1);
                    temp = temp.child[1];
                }
                else{
                    ans.append(0);
                    temp=temp.child[0];
                }
            }
        }
        //convert ans into int
        int intAns = Integer.parseInt(ans+"", 2) ^ Integer.parseInt(number, 2);
        return intAns;
    }

    void constructTrie(String number){
        TrieNode temp = root;
        for(int i=0; i<number.length(); i++) {
            int curr = Integer.parseInt(number.charAt(i) + "");
            if (temp.child[curr] == null) {
                temp.child[curr] = new TrieNode();
            }
            temp = temp.child[curr];
        }
    }
}
