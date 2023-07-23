package Maths4Combimatrics;

import java.util.Arrays;

public class SortedPermutationRank {
    public static void main(String[] args) {
        SortedPermutationRank obj = new SortedPermutationRank();
        System.out.println(obj.findRank("DTNGJPURFHYEW"));;
    }
    int[] factCal;
    public int findRank(String A) {
        int mod = 1000003;
        factCal = new int[25];
        factCal[0]=1;
        factCal[1]=1;
        for (int i=2; i<factCal.length; i++){
            factCal[i] = (i*factCal[i-1]%mod)%mod;
        }
        return calculateRank(A, factCal);
    }
    int calculateRank(String A, int[] factCal){
        long mod = 1000003;
        char[] chr = A.toCharArray();
        Arrays.sort(chr);

        long ans = 0;
        //lets find number less than what we want
        for(int i=0; i<chr.length; i++){
            int charLessThanWhatWeNeed = 0;
//            System.out.println(Arrays.toString(chr));

            for (int j=0; j<chr.length; j++){
                if (A.charAt(i)==chr[j]){
                    chr[j] = '\0';
                    break;
                }
                if (chr[j]!='\0')
                    charLessThanWhatWeNeed++;
            }


//            System.out.println("Current Char: " + A.charAt(i) + " : " + charLessThanWhatWeNeed + " Fact: "+ (A.length()-1-i) + "!");

            ans += ((long) charLessThanWhatWeNeed * factCal[A.length()-1-i])%mod;
        }


        return (int)(ans+1%mod);
    }
}
//342501