package DailyChallenge.March24;

public class March19_621 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        March19_621 obj = new March19_621();
        System.out.println(obj.leastInterval(tasks, n));
    }

    public int leastInterval(char[] tasks, int n) {
        // Array to store frequency of tasks
        int[] freq = new int[26];
        int maxFreq = 0;

        // Calculate frequency of each task and find maximum frequency
        for (char task : tasks) {
            int index = task - 'A';
            freq[index]++;
            maxFreq = Math.max(maxFreq, freq[index]);
        }

        // Count the number of tasks with maximum frequency
        int numOfTasksWithMaxFreq = 0;
        for (int frequency : freq) {
            if (frequency == maxFreq) {
                numOfTasksWithMaxFreq++;
            }
        }

        // Calculate the interval needed
        int interval = Math.max((n + 1) * (maxFreq - 1) + numOfTasksWithMaxFreq, tasks.length);
        return interval;
    }
}
