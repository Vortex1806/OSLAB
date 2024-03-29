import java.util.*;
public class scan{
    static void calculate(int arr[],int size,int head,int disk,String direction){
        Vector<Integer> left= new Vector<Integer>();
        Vector<Integer> right= new Vector<Integer>();
        Vector<Integer> sequence= new Vector<Integer>();
        int seek=0;
        int distance,cur_track;
        if(direction.equals("left")) left.add(0);
        else if(direction.equals("right")) right.add(disk-1);
        for(int i=0;i<size;i++){
            if(arr[i]<head) left.add(arr[i]);
            else right.add(arr[i]);
        }
        Collections.sort(right);
        Collections.sort(left);
        int run=2;
        while(run-- > 0){
            if(direction.equals("left")){
                for(int i=left.size()-1;i>=0;i--){
                    cur_track=left.get(i);
                    distance=Math.abs(cur_track-head);
                    seek+=distance;
                    sequence.add(cur_track);
                    head=cur_track;
                }
                direction="right";
            }
            else if(direction.equals("right")){
                for(int i=0;i<right.size();i++){
                    cur_track=right.get(i);
                    distance=Math.abs(cur_track-head);
                    seek+=distance;
                    sequence.add(cur_track);
                    head=cur_track;
                }
                direction="left";
            }
        }
        System.out.println("The total seek distance is "+seek);
        System.out.println("The seek sequence is ");
        for(int i=0;i<sequence.size();i++) System.out.print("  "+sequence.get(i));

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
        System.out.println("Enter the disk size");
        int disk=sc.nextInt();
        System.out.println("Enter the direction");
        String direction=sc.next();
        calculate(arr,size,head,disk,direction);
    }
}
