package DailyChallenge.Jan24;

import java.util.Stack;

public class Jan29_232 {
    static class MyQueue {
        Stack<Integer> insStk;
        Stack<Integer> queue;

        public MyQueue() {
            insStk = new Stack<>();
            queue = new Stack<>();
        }

        public void push(int x) {
            insStk.push(x);
        }

        public int pop() {
            if(queue.empty()){
                while(!insStk.isEmpty()){
                    queue.push(insStk.pop());
                }
            }
            return queue.pop();
        }

        public int peek() {
            if(queue.isEmpty()){
                while(!insStk.isEmpty()){
                    queue.push(insStk.pop());
                }
            }
            return queue.peek();
        }

        public boolean empty() {
            return insStk.isEmpty() && queue.isEmpty();
        }
    }
}
