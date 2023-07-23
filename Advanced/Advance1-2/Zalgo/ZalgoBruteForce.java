package Zalgo;

import adv12Utils.ScaUtils;

public class ZalgoBruteForce {
    public static void main(String[] args) {
        String a = "xxyzxxyzwxxyzxxyzx";
        System.out.println(a.length());
        ZalgoBruteForce obj = new ZalgoBruteForce();
        ScaUtils.printNormalArray(obj.zalgo(a));
    }

    int[] zalgo(String str){
        int[] zArr = new int[str.length()];
        int i=0; int j=0;
        int count=0;
        while(i<str.length()){
            int z = i;
            count = 0;
            j=0;
            while(j<str.length() && z<str.length()){
                if (str.charAt(j)==str.charAt(z)){
                    count++;
                }
                else
                    break;
                j++;z++;
            }
            zArr[i]=count;
            i++;
        }
        return zArr;
    }
}
