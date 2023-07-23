package tries;

import java.util.Arrays;

public class CreateSearchTrie {
    static class TrieNode{
        TrieNode[] childs;
        boolean isSet;
        TrieNode(){
            childs = new TrieNode[26];
            isSet = false;
        }
    }

    public static void main(String[] args) {
        String[] A = {"hat", "cat", "rat" };
        CreateSearchTrie obj = new CreateSearchTrie();

        TrieNode root = new TrieNode();

        root = obj.insertStringInTrie(A[0], root); //haven't inserted all the arr A
        int isIt = obj.isStringInTrie("hat" , root);

        System.out.println(isIt);
    }
    int isStringInTrie(String str, TrieNode root){
        TrieNode temp = root;
        for(int i=0; i<str.length(); i++){
            int currChar = str.charAt(i)-'a';
            if(temp.childs[currChar]==null)
                return 0;
            temp = temp.childs[currChar];
        }
        if(temp.isSet)
            return 1;
        return 0;
    }
    public TrieNode insertStringInTrie(String str, TrieNode root) {
        //lets create a trie with str
        TrieNode temp = root;
        for(int i=0; i<str.length(); i++){
            int curr = str.charAt(i)-'a';

            if(temp.childs[curr]==null){
                temp.childs[curr] = new TrieNode();
            }
            temp = temp.childs[curr];
        }
        temp.isSet = true;
        return root;
    }
}
