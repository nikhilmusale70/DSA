package DailyChallenge.April24;

public class April9_2073 {
    public static void main(String[] args) {
        int[] tickets = {84,49,5,24,70,77,87,8};
        April9_2073 obj = new April9_2073();
        System.out.println(obj.timeRequiredToBuy(tickets, 3));
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int ticketToBuy = tickets[k];
        int time = 0;

        for(int i=0; i<tickets.length; i++){
            if(i<=k)
                time += Math.min(ticketToBuy, tickets[i]);
            else
                time += Math.min(ticketToBuy-1, tickets[i]);
        }

        return time;
    }
}
