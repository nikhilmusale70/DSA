package DailyChallenge.May24;

public class May1_2000 {
    public static void main(String[] args) {
        String  word = "abcdefd";
        char ch ='d';
        May1_2000 obj = new May1_2000();
        System.out.println(obj.reversePrefix(word, ch));
    }
    public String reversePrefix(String word, char ch) {
        int occurrence = word.indexOf(ch);
        if (occurrence==-1) return word;

        StringBuilder sb = new StringBuilder(word.substring(0, occurrence+1));
        sb.reverse().append(word.substring(occurrence+1));
        return sb.toString();
    }
}
