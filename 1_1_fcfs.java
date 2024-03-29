import java.util.*;
public class fcfs{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int bt[]=new int[10];
        int wt[]=new int[10];
        int tat[]=new int[10];
        float totalwt=0;
        float totaltat=0;
        System.out.println("Enter the number of processes");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter the burst time of process "+(i+1)+" :");
            bt[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            if(i==0) wt[i]=0;
            else wt[i]=wt[i-1]+bt[i-1];
            tat[i]=wt[i]+bt[i];
            totalwt+=wt[i];
            totaltat+=tat[i];
        }
        System.out.println("Process No\tBurst time\t waiting t\t Turn around t");
        for(int i=0;i<n;i++){
            System.out.println("\t"+(i+1)+"\t\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
        }
        System.out.println("Average waiting time is :"+(totalwt/n));
        System.out.println("Average turn around time is :"+(totaltat/n));
    }
}
