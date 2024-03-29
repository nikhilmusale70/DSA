package Maths3PrimeNumbers;

import adv12Utils.ScaUtils;

public class CountOfDivisor {
    public static void main(String[] args) {
        int[] A = { 1238, 1751, 1391, 1038, 1605, 609, 1381, 1551, 1316, 1838, 959, 1710, 604, 117, 1011, 171, 76, 668, 1975, 893, 477, 75, 1413, 1441, 623, 144, 443, 1048, 1607, 214, 1502, 1766, 571, 751, 1227, 1876, 1280, 1808, 1392, 891, 1570, 1996, 1763, 1908, 1308, 971, 1504, 1912, 931, 1123, 358, 1628, 1873, 158, 1168, 23, 205, 1553, 1544, 169, 1682, 508, 469, 1295, 67, 923, 1461, 124, 1042, 195, 1549, 1280, 1361, 1170, 760, 1509, 955, 466, 92, 1714, 645, 1559, 983, 415, 1837, 1515, 226, 130, 1107, 70, 913, 393, 1960, 862, 564, 1649, 182, 1064, 1863, 1102, 213, 1407, 1606, 749, 1737, 1633, 1377, 1277, 299, 807, 1241, 1307, 1175, 1557, 1332, 1529, 1950, 365, 1560, 1681, 294, 276, 904, 1045, 1281, 67, 722, 149, 1275, 797, 1381, 705, 866, 954, 87, 472, 1636, 938, 302, 1669, 655, 482, 1347, 1883, 499, 844, 890, 960, 1320, 1029, 889, 286, 1045, 164, 1268, 98, 135, 232, 1103, 1948, 477, 824, 422, 1313, 2, 298, 867, 1492, 1371, 1798, 392, 373, 706, 1960, 1947, 457, 743, 793, 677, 1582, 15, 1249, 519, 1230, 1709, 268, 1315, 967, 724, 1737, 1548, 1633, 1061, 1696, 1621, 209, 239, 1417, 264, 1954, 632, 479, 67, 352, 1807, 1890, 1432, 712, 794, 441, 1267, 818, 994, 10, 1675, 1949, 941, 1304, 554, 1795, 1510, 673, 551, 1326, 308, 1063, 1125, 498, 986, 1884, 625, 830, 976, 1679, 1217, 379, 1795, 1796, 1260, 361, 1421, 994, 1317, 807, 540, 1866, 1348, 1010, 1449, 298, 1852, 1250, 281, 798, 714, 1293, 1881, 1438, 358, 517, 130, 436, 416, 151, 824, 1913, 1596, 87, 1295};
        ScaUtils.printNormalArray(solve(A));
    }
    static int[] S; static int NP=1001001;

    public static int[] solve(int[] A) {
        calSieve();
        int[] ans = new int[A.length];
        for (int i=0; i<A.length; i++){
            ans[i] = calNoOfDivisors(A[i]);
        }
        return ans;
    }
    static int calNoOfDivisors(int num){
        int calNoOfDiv=1;
        while (num>1){
            int spf = S[num];
            int pow=1;
            while (S[num]==spf){
                pow++;
                num/=spf;
            }
            calNoOfDiv *= pow;
        }
        return calNoOfDiv;
    }
    // S[x] = smallest prime factor of x

    static void calSieve(){
        S = new int[NP];
        for (int i=2; i*i<=NP; i++){
            if (S[i]==0){
                S[i]=i;
                for (int j=i*i; j<NP; j+=i){
                    S[j]=i;
                }
            }
        }
        for(int i=1; i<NP; i++){
            if(S[i]==0){
                S[i] = i;
            }
        }
    }
}
