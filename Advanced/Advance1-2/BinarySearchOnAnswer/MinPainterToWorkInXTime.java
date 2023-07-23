package BinarySearchOnAnswer;

public class MinPainterToWorkInXTime {
    public static void main(String[] args) {
        int[] boards = {185, 186, 938, 558, 655, 461, 441, 234, 902, 681};
        int unitOfTime = 10;
        int minTime = 19000;
        MinPainterToWorkInXTime obj = new MinPainterToWorkInXTime();
        System.out.println(obj.numberOfPainter(unitOfTime, minTime, boards));

    }
    int numberOfPainter(int unitTime,  int minTime, int[] boards){
        if (boards.length==0){
            return 0;
        }
        int numberOfPainter=1;
        int timeConsumed =0;
        for (int i=0; i<boards.length; i++){
            if(minTime >= timeConsumed+boards[i]*unitTime){
                timeConsumed += boards[i]*unitTime;
            }
            else {
                numberOfPainter++;
                timeConsumed=boards[i]*unitTime;
            }

            System.out.println("Painter" + numberOfPainter + " time: "+timeConsumed);
        }
        return numberOfPainter;
    }
}
