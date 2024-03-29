import java.util.*;
public class bestfit{
    static void best(int blockSize[],int m, int processSize[],int n){
        int allocation[]=new int[n];
        for(int i=0;i<n;i++) allocation[i]=-1;
        for(int i=0;i<n;i++){
            int bst=-1;
            for(int j=0;j<m;j++){
                if(blockSize[j]>=processSize[i]){
                    if(bst==-1 || blockSize[bst]>blockSize[j]) bst=j;
                }
            }
            if(bst!=-1){
                allocation[i]=bst;
                blockSize[bst]-=processSize[i];
            }
        }
        System.out.println("Process No \t Process size \t Block no \t");
        for(int i=0;i<n;i++){
            System.out.print((i+1)+"\t\t"+processSize[i]+"\t\t");
            if(allocation[i]!=-1) System.out.println(allocation[i]);
            else System.out.println("Not allocated");
        }
    }
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of blocks");
        int m=sc.nextInt();
        int blockSize[]=new int[m];
        System.out.println("Enter the size of the blocks");
        for(int i=0;i<m;i++) blockSize[i]=sc.nextInt();
        System.out.println("Enter the number of processes");
        int n=sc.nextInt();
        int processSize[]=new int[n];
        System.out.println("Enter the size of the Processes");
        for(int i=0;i<n;i++) processSize[i]=sc.nextInt();
        best(blockSize,m,processSize,n);
    }
}
