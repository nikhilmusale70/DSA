package DailyChallenge.April24;

public class April8_1700 {
    public static void main(String[] args) {
        int[] students = {0,0,1,1,0,0,0,0,1,0,0,1,1,0,1,1};
        int[] sandwiches = {1,0,0,0,0,0,0,1,0,0,1,0,1,1,1,0};

        April8_1700 obj = new April8_1700();
        System.out.println(obj.countStudents(students, sandwiches));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int studentWith0 = 0;
        int studentWith1;
        for(int num: students){
            if(num==0) studentWith0++;
        }
        studentWith1 = students.length - studentWith0;

        for (int sandwich : sandwiches) {
            if (studentWith0 == 0 && sandwich == 0) {
                return studentWith1;
            }
            else if (studentWith1 == 0 && sandwich == 1) {
                return studentWith0;
            }
            if (sandwich == 0) studentWith0--;
            else studentWith1--;
        }

        return 0;
    }
}
