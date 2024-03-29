
import java.util.*;

public class worstfit{
    static void worst(int blockSize[],int m,int processSize[],int n){
        int allocation[]=new int[n];
        for(int i=0;i<n;i++) allocation[i]=-1;
        for(int i=0;i<n;i++){
            int wst=-1;
            for(int j=0;j<m;j++){
                if(blockSize[j]>=processSize[i]){
                    if(wst==-1 || blockSize[wst]<blockSize[j]) wst=j;
                }
            }
            if(wst!=-1){
                allocation[i]=wst;
                blockSize[wst]-=processSize[i];
            }
        }
        System.out.println("Process no\tProcess size\t block no");
        for(int i=0;i<n;i++){
            System.out.print("\t"+(i+1)+"\t\t"+processSize[i]+"\t\t");
            if(allocation[i]!=-1) System.out.println(allocation[i]);
            else System.out.println("not allocated");
        }
    }
     public static void main(String[] args){
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
        worst(blockSize,m,processSize,n);
    }
}
