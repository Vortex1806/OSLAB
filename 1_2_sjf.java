import java.util.*;
public class sjf{
    public static void main(String[] args){
        int bt[]=new int[10];
        int wt[]=new int[10];
        int tat[]=new int[10];
        int process[]= new int[10];
        float totalwt=0;
        float totaltat=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter the burst time of process "+(i+1)+" ;");
            bt[i]=sc.nextInt();
            process[i]=i+1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(bt[j]>bt[j+1]){
                    int temp=bt[j+1];
                    bt[j+1]=bt[j];
                    bt[j]=temp;
                    temp=process[j+1];
                    process[j+1]=process[j];
                    process[j]=temp;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(i==0) wt[i]=0;
            else wt[i]=bt[i-1]+wt[i-1];
            tat[i]=wt[i]+bt[i];
            totalwt+=wt[i];
            totaltat+=tat[i];
        }
        System.out.println("Process\t||\tBurst\t||\tWaiting\t||\tTAT");
        for(int i=0;i<n;i++){
            System.out.println((i+1)+"\t||\t"+ bt[i]+"\t||\t"+wt[i]+"\t||\t"+tat[i]);
        }
        System.out.println("Average TAT time :"+(totaltat/n));
        System.out.println("Average waiting time :"+(totalwt/n));
    }
}
