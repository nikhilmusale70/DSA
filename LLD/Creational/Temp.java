package Creational;

public class Temp {
    public static void main(String[] args) {
        Temp obj = new Temp();
        obj.randomNumberPrinter(1,10);
    }
    void randomNumberPrinter(int from, int to){
        //print random numbers from - to
        for(int i=from; i<=to; i++){
            MyRunnable mr = new MyRunnable(i);
            Thread t = new Thread(mr);
            t.start();
        }
    }
    static class MyRunnable implements Runnable{
        int num;
        @Override
        public void run(){
            System.out.print(num + " ");
        }
        public MyRunnable(int num){
            this.num = num;
        }
    }
}
