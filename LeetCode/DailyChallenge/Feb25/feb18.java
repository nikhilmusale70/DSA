package DailyChallenge.Feb25;

public class feb18 {
    public static void main(String[] args) {
        String  pattern = "IIIDIDDD";
        feb18 obj = new feb18();
        System.out.println(obj.smallestNumber(pattern));
    }

    public String smallestNumber(String pattern) {
        int counter = 1;
        boolean[] arr = new boolean[10];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(ch=='I'){
                while(!arr[counter]){
                    counter++;
                }
                sb.append(counter++);
            }
            int temp = i;
            while(pattern.charAt(temp)=='D'){
                temp++;
                counter++;
            }
            int tempCounter = counter;

            while(temp>i){
                sb.append(counter--);
                temp--;
            }
            counter = tempCounter;
        }
        return sb.toString();
    }
}
