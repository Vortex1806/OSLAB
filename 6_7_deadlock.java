import java.util.*;
public class Deadlock{
    private int P;
    private int R;
    private void calculateNeed(int need[][],int alloc[][],int maxm[][]){
        for(int i=0;i<P;i++){
            for(int j=0;j<R;j++) need[i][j]=maxm[i][j]-alloc[i][j];
        }
    }
    private boolean isSafe(int processes[],int avail[],int alloc[][],int maxm[][]){
        int need[][]=new int[P][R];
        calculateNeed(need,alloc,maxm);
        boolean finish[]= new boolean[P];
        int safeSeq[]=new int[P];
        int work[]=new int[R];
        for(int i=0;i<R;i++) work[i]=avail[i];
        int count=0;
        while(count<P){
            boolean found=false;
            for(int p=0;p<P;p++){
                if(!finish[p]){
                    int j;
                    for(j=0;j<R;j++){
                        if(need[p][j]>work[j]) break;
                    }
                    if(j==R){
                        for(int k=0;k<R;k++) work[k]+=alloc[p][k];
                        safeSeq[count++]=p;
                        finish[p]=true;
                        found=true;
                    }
                }
            }
            if(!found){
                System.out.println("System not in safe state \n");
                return false;
            }
        }
        System.out.println("System is in safe state\n Safe sequence is ");
        for(int i=0;i<P;i++) System.out.println(" P"+safeSeq[i]);
        return true;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Deadlock ds = new Deadlock();
        System.out.println("Enter the number of processes");
        ds.P=sc.nextInt();
        System.out.println("Enter the number of resources ");
        ds.R=sc.nextInt();
        int processes[]=new int[ds.P];
        for (int i = 0; i < ds.P; i++) processes[i] = i;
        int[] avail = new int[ds.R];
        System.out.println("Enter the available instances of resources:"); 
        for (int i = 0; i < ds.R; i++) avail[i] = sc.nextInt();
        int[][] maxm = new int[ds.P][ds.R];
        System.out.println("Enter the maximum resources that can be allocated to processes:");
        for (int i = 0; i < ds.P; i++) for (int j = 0; j < ds.R; j++) maxm[i][j] = sc.nextInt();
        int[][] alloc = new int[ds.P][ds.R];
        System.out.println("Enter the resources allocated to processes:");
        for (int i = 0; i < ds.P; i++) for (int j = 0; j < ds.R; j++) alloc[i][j] = sc.nextInt();
        ds.isSafe(processes, avail, alloc, maxm);
        sc.close();
    }
}
