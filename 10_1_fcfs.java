import java.util.*;
public class fcfs{
    static void calculate(int arr[],int size,int head){
        int seek=0;
        int distance,cur_track;
        for(int i=0;i<size;i++){
            cur_track=arr[i];
            distance = Math.abs(cur_track-head);
            seek+=distance;
            head=cur_track;
        }
        System.out.println("The total seek distance is "+seek);
        System.out.println("The seek sequence is ");
        for(int i=0;i<size;i++) System.out.print("  "+arr[i]);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the initial head posisition");
        int head =sc.nextInt();
        System.out.println("Enter the number of services");
        int size=sc.nextInt();
        int arr[]=new int[size];
        System.out.println("Enter the service posisitons ");
        for(int i=0;i<size;i++) arr[i]=sc.nextInt();
        calculate(arr,size,head);
    }
}
