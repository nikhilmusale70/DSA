package DailyChallenge.Dec23;

public class Dec1_1662 {
    public static void main(String[] args) {
        Dec1_1662 obj = new Dec1_1662();
        String[] word1 = {"ngtcdeyfigpimwjuffkzwefazn","obzglsjzwcwokttknywj","qewixtnkmxyrpdyyrzqotqdfzafzxrpjhqdjjmtut","p"};
        String[] word2 = {"ngtcdeyfigpimwjuffkzwefaznobzglsjzwcwokttknywjqewixtnkmxyrpdyyrzqo","tqdfzafzx","rpjhqdjjm","tut","p"};
        System.out.println(obj.arrayStringsAreEqual(word1, word2));
    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int pointer1 = 0, idx1=0;
        int pointer2 = 0, idx2=0;

        while(pointer1<word1.length && pointer2<word2.length){
            if(word1[pointer1].charAt(idx1) != word2[pointer2].charAt(idx2)){
                return false;
            }
            idx1++;
            idx2++;

            if(idx1 == word1[pointer1].length()){
                pointer1++;
                idx1=0;
            }
            if(idx2 == word2[pointer2].length()){
                pointer2++;
                idx2=0;
            }
        }
        if(pointer1!=word1.length || pointer2!=word2.length){
            return false;
        }
        return true;
    }
}
