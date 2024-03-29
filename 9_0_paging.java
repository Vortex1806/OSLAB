import java.util.*;
public class paging{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int ms,ps,nop,rempages,x,y,offset,np;
        int s[]=new int[10];
        int fno[][]=new int[10][10];
        System.out.println("Enter the memory size");
        ms=sc.nextInt();
        System.out.println("Enter the page size");
        ps=sc.nextInt();
        nop=ms/ps;
        System.out.println("Number of pages available in memory are "+nop);
        rempages=nop;
        System.out.println("Enter the number of process");
        np=sc.nextInt();
        for(int i=1;i<=np;i++){
            System.out.println("Enter the number of pages for process "+i);
            s[i]=sc.nextInt();
            if(s[i]>rempages){
                System.out.println("Memory is full !!!");
                break;
            }
            rempages-=s[i];
            System.out.println("Enter the page table for process i");
            for(int j=0;j<s[i];j++){
                fno[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the logical address and get the physical addres !!");
        System.out.println("Enter the process number, page number and offset");
        x=sc.nextInt();
        y=sc.nextInt();
        offset=sc.nextInt();
        if(x>np || y>s[x] || offset>ps){
            System.out.println("Invalid reference ");
            System.exit(0);
        }
        else{
            System.out.println("The physical address is "+(fno[x][y]*ps+offset));
        }

    }
}
