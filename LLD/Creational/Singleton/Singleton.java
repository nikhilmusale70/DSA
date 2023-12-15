package Creational.Singleton;

public class Singleton {
    class Example{
//      lazy initialization
//      Example s_instance = new Example();
        static Example s_instance;
        public Example getInstance(){
            if(s_instance==null){
                synchronized (Example.class) {
                    s_instance = new Example();
                }
            }
            return s_instance;
        }
        private Example(){
        }
    }
}
