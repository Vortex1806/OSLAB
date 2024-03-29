import java.util.*;
public class fifo{
    private static void pageFaults(int frames, int pages, int [] page){
        HashSet<Integer> s = new HashSet<>(frames);
        Queue<Integer> indexes =new LinkedList<>();
        int faults=0;
        for(int i=0;i<pages;i++){
            if(s.size()<frames){
                if(!s.contains(page[i])){
                    s.add(page[i]);
                    indexes.add(page[i]);
                    faults++;
                }
            }
            else{
                if(!s.contains(page[i])){
                    int val=indexes.peek();
                    indexes.poll();
                    s.remove(val);
                    s.add(page[i]);
                    indexes.add(page[i]);
                    faults++;
                }
            }
        }
        System.out.println("The number of page fautls ="+faults);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("ENter the number of frames");
        int frames=sc.nextInt();
        System.out.println("Enter the number pages");
        int pages=sc.nextInt();
        System.out.println("Enter the pages");
        int page[]=new int[pages];
        for(int i=0;i<pages;i++){
            page[i]=sc.nextInt();
        }
        pageFaults(frames,pages,page);
        sc.close();
    }
}
