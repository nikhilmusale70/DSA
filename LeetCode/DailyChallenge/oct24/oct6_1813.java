package DailyChallenge.oct24;

public class oct6_1813 {
    public static void main(String[] args) {
        oct6_1813 obj = new oct6_1813();
        String sentence1 = "My name is Haley", sentence2 = "My Haley";
        System.out.println(obj.areSentencesSimilar(sentence1, sentence2));
    }
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int start = 0;
        int end1 = s1.length-1;
        int end2 = s2.length-1;

        if(s1.length<s2.length){
            return areSentencesSimilar(sentence2, sentence1);
        }

        while (start<s2.length && s1[start].equals(s2[start])){
            start++;
        }

        while(end2>=0 && s1[end1].equals(s2[end2])){
            end1--;
            end2--;
        }

        return end2<start;
    }
}
