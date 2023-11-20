package Contest.Weekly.WeeklyContest372;

public class q100122 {
    public static void main(String[] args) {
        q100122 obj = new q100122();
        String s = "1111";
        System.out.println(obj.minimumSteps(s));
    }

    public long minimumSteps(String s) {
        int i=0;
        long swaps=0;
        long multi=0;

        while(i<s.length()){
            long disOfNextOne=0;
            if(s.charAt(i)=='1'){
                multi++;
                disOfNextOne = findNextOne(s, i+1);
                swaps += multi*disOfNextOne;
            }
            i += disOfNextOne==0?1: (int) disOfNextOne;
        }

        return swaps;
    }
    long findNextOne(String s, int idx){
        long dist=0;
        while(idx<s.length() && s.charAt(idx)!='1') {
            idx++;
            dist++;
        }
        return dist;
    }
}
