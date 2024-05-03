package DailyChallenge.May24;

public class May3_165 {
    public static void main(String[] args) {
        String version1 = "1.01", version2 = "1.001";
        May3_165 obj = new May3_165();
        System.out.println(obj.compareVersion(version1, version2));
    }
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for(int i=0; i<v1.length || i<v2.length; i++){
            int num1 = i<v1.length? Integer.parseInt(v1[i]):0;
            int num2 = i<v2.length? Integer.parseInt(v2[i]):0;

            int compare = Integer.compare(num1, num2);
            if(compare!=0) return compare;
        }
        return 0;
    }
}