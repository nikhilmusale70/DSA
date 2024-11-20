package DailyChallenge.Nov;

public class nov20_2516 {
    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;
        nov20_2516 obj = new nov20_2516();
        System.out.println(obj.takeCharacters(s, k));
    }
    public int takeCharacters(String s, int k) {
        if(s.length()<3*k){
            return -1;
        }

        int countA = 0, countB = 0, countC = 0;
        for(char ch: s.toCharArray()){
            if (ch=='a') countA++;
            else if(ch=='b') countB++;
            else countC++;
        }
        if(countA<k || countB<k || countC<k) return -1;

        int maxWindow = 0;
        int left = 0, right = 0;
        while(right<s.length()){
            char toRemove = s.charAt(right);

            if (toRemove=='a') countA--;
            else if(toRemove=='b') countB--;
            else countC--;

            while(countA<k || countB<k || countC<k){
                char toAdd = s.charAt(left);
                if (toAdd=='a') countA++;
                else if(toAdd=='b') countB++;
                else countC++;
                left++;
            }

            maxWindow = Math.max(maxWindow, right+1-left);
            right++;
        }
        return s.length()-maxWindow;
    }
}
