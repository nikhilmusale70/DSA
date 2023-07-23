package tries;

import java.lang.*;
import java.util.*;


public class AutoComplete {
    static class TrieNode{
        int []arr;
        TrieNode[]child;
        public TrieNode(){
            this.child=new TrieNode[26];
            this.arr=new int[5];


        }
    }
    static  TrieNode root=new TrieNode();

    static  class Pair{
        int weightage;
        String S;
        public Pair(int x,String y){
            this.weightage=x;
            this.S=y;
        }
    }

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        while(T-->0){
            int stringsize=in.nextInt();
            int prefixes=in.nextInt();
            String[] word=new String[stringsize];
            for(int i=0;i<stringsize;i++){
                word[i]=in.next();
            }
            int []weight=new int[stringsize];
            for(int i=0;i<stringsize;i++){
                weight[i]=in.nextInt();
            }
            String[]pf=new String[prefixes];
            for(int i=0;i<prefixes;i++){
                pf[i]=in.next();
            }

            root=new TrieNode();
            Pair[] pairs=new Pair[weight.length];
            for (int i = 0; i < pairs.length; i++) {
                pairs[i]=new Pair(weight[i], word[i]);
            }
            Comparator<Pair> comparator=new Comparator<Pair>() {
                public int compare(Pair a,Pair b){
                    return b.weightage-a.weightage;
                }

            };
            Arrays.sort(pairs,comparator);
            HashMap<Integer,String> map=new HashMap<>();
            for( Pair ele: pairs){
                map.put(ele.weightage, ele.S);

            }

            for (int i = 0; i < pairs.length; i++) {
                TrieNode curr=root;
                for (int j = 0; j <pairs[i].S.length(); j++) {
                    int index=pairs[i].S.charAt(j)-'a';
                    if(curr.child[index]==null){
                        curr.child[index]=new TrieNode();
                    }
                    int len=0;
                    while(len<5){
                        if(curr.child[index].arr[len]==0){
                            curr.child[index].arr[len]=pairs[i].weightage;
                            break;
                        }else{
                            len++;
                        }
                    }
                    curr=curr.child[index];
                }

            }

            for (int i = 0; i < pf.length; i++) {
                TrieNode curr=root;
                boolean flag=true;
                for (int j = 0; j < pf[i].length(); j++) {
                    int index=pf[i].charAt(j)-'a';
                    if(curr.child[index]==null){
                        System.out.println("-1"+" ");
                        flag=false;
                        break;
                    }
                    curr=curr.child[index];
                }
                if(flag){
                    int len=0;
                    while(len<5 && curr.arr[len]!=0 ){
                        System.out.print(map.get(curr.arr[len])+" ");
                        len++;
                    }
                    System.out.println();
                }

            }
        }
    }
}
