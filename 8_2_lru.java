import java.util.*;
public class lru{
    private static void faulty(int page[],int pages,int frames){
        HashSet<Integer> s= new HashSet<>(frames);
        HashMap<Integer,Integer> indexes= new HashMap<>();
        int faults=0;;
        for(int i=0;i<pages;i++){
            if(s.size()<frames){
                if(!s.contains(page[i])){
                    s.add(page[i]);
                    faults++;
                }
            }
            else{
                if(!s.contains(page[i])){
                    int lru=Integer.MAX_VALUE;
                    int val=0;
                    Iterator<Integer> itr= s.iterator();
                    while(itr.hasNext()){
                        int temp=itr.next();
                        if(indexes.get(temp)<lru){
                            lru=indexes.get(temp);
                            val=temp;
                        }
                    }
                    s.remove(val);
                    indexes.remove(val);
                    faults++;
                    s.add(page[i]);
                }
            }
            indexes.put(page[i],i);
        }
        System.out.println("The number of pagefualts are "+faults);
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
        faulty(page,pages,frames);
        sc.close();
    }
}

