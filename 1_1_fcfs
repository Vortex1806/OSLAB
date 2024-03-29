import java.util.Scanner;
public class fcfs {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int bt[] = new int[20];
    int wt[] = new int[20];
    int tt[] = new int[20];
    float awt = 0;
    float att = 0;
    int n = 0;
    
    System.out.print("Enter the number of processes: ");
    n = sc.nextInt();
    
    System.out.println("\nEnter the Burst Time for each process.");
    for (int i = 0; i < n; i++) {
      bt[i] = sc.nextInt();
    }
  
    wt[0] = 0;
    for (int i = 1; i < n; i++) {
      wt[i] = bt[i - 1] + wt[i - 1];
    }
  
    for (int i = 0; i < n; i++) {
      tt[i] = bt[i] + wt[i];
    }
    
    System.out.println("\nProcesses ||" + " Burst Time ||" + " Arrival Time ||" + " Waiting Time ||" +" Turn-Around Time ");
    for (int i = 0; i < n; i++) {
      awt = awt + wt[i];
      att = att + tt[i]; 
      System.out.println(i + 1 + "\t ||\t" + bt[i] + "\t||\t" + "\t||\t" + wt[i] + "\t||\t " + tt[i]);
    }
    awt = awt / n; 
    att = att / n;
    System.out.println("\nAverage waiting time = " + awt);
    System.out.println("\nAverage turn around time = " + att);
  }
}
