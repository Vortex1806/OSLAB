import java.util.concurrent.*;

public class DiningPhilosopher{
    static int philosopher=5;
    static Philosopher[] philosophers = new Philosopher[philosopher];
    static Semaphore [] chopsticks = new Semaphore[philosopher];
    
    public static void main(String [] args){
        for(int i=0;i<5;i++){
            chopsticks[i]=new Semaphore(1);
        }
        for(int i=0;i<5;i++){
            philosophers[i]=new Philosopher(i);
            philosophers[i].start();
        }
    }
    static class Philosopher extends Thread{
        private final int id;
        public Philosopher(int id){
            this.id=id;
        }
        public void run(){
            while(true){
                try{
                    chopsticks[id].acquire();
                    chopsticks[(id+1)%philosopher].acquire();
                    System.out.println("Philospher "+(id+1)+" Is eating");
                    chopsticks[id].release();
                    chopsticks[(id+1)%philosopher].release();
                    System.out.println("Philosopher "+(id+1)+" Finishded eating");
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }

}
