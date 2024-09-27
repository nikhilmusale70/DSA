package DailyChallenge.sept24;

public class sept26_729 {
    public static void main(String[] args) {

    }
    class MyCalendar {
        int pastStart;
        int pastEnd;
        MyCalendar calendar;

        public MyCalendar() {
            calendar = new MyCalendar();
        }

        public boolean book(int start, int end) {
            if(start>this.pastEnd) {
                this.pastStart = start;
                this.pastEnd = end;
                return true;
            }
            return false;
        }
    }
}
