package DailyChallenge.Nov;

public class nov2_2490 {
    public static void main(String[] args) {
        String sentence = "leetcode exercises sound delightful";
        nov2_2490 obj = new nov2_2490();
        System.out.println(obj.isCircularSentence(sentence));
    }
    public boolean isCircularSentence(String sentence) {
        boolean isWordSingle = true;
        for(int i=0; i<sentence.length(); i++){
            if(sentence.charAt(i)==' ') {
                isWordSingle = false;
                if(sentence.charAt(i-1) != sentence.charAt(i+1)){
                    return false;
                }
            }
        }
        if(isWordSingle){
            return sentence.charAt(0)==sentence.charAt(sentence.length()-1);
        }

        return true;
    }
}
