package DailyChallenge.oct24;

public class oct16_1405 {
    public static void main(String[] args) {
        int a = 2, b = 2, c = 2;
        String str = "aabaa";
        oct16_1405 obj = new oct16_1405();
        System.out.println(obj.longestDiverseString(a, b, c));
    }

    public String longestDiverseString(int a, int b, int c) {
        int strLength = a+b+c;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        int streakA = 0, streakB = 0, streakC = 0;
        while(idx<strLength){
            if(a>=b && a>=c && streakA<2 || (a>0 && (streakB==2 || streakC==2))){
                sb.append('a');
                streakB = 0;
                streakC = 0;
                streakA++;
                a--;
            }
            else if(b>=a && b>=c && streakB<2 || (b>0 && (streakA==2 || streakC==2))){
                sb.append('b');
                streakA = 0;
                streakC = 0;
                streakB++;
                b--;
            }
            else if(c>=a && c>=b && streakC<2 || (c>0 && (streakA==2 || streakB==2))){
                sb.append('c');
                streakB = 0;
                streakA = 0;
                streakC++;
                c--;
            }
            idx++;
        }
        return sb.toString();
    }
}
