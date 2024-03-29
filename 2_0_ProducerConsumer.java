
import java.util.concurrent.Semaphore;
import java.util.*;

public class produerConsumer{
    public static void main(String args[]){
        Semaphore semaphoreProducer = new Semaphore(1);
        Semaphore semaphoreConsumer = new Semaphore(0);
        System.out.println("Producer semaphore permit :0 || Consumer semaphore permit :1");

        Producer producer = new Producer(semaphoreProducer,semaphoreConsumer);
        Consumer consumer = new Consumer(semaphoreConsumer,semaphoreProducer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }
}
class Producer implements Runnable{
    Semaphore semaphoreProducer;
    Semaphore semaphoreConsumer;

    public Producer(Semaphore semaphoreProducer,Semaphore semaphoreConsumer){
        this.semaphoreProducer= semaphoreProducer;
        this.semaphoreConsumer=semaphoreConsumer;
    }
    public void run(){
        for(int i=1;i<=5;i++){
            try{
                semaphoreProducer.acquire();
                System.out.println("Producer "+i);
                semaphoreConsumer.release();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


class Consumer implements Runnable{
    Semaphore semaphoreConsumer;
    Semaphore semaphoreProducer;

    public Consumer(Semaphore semaphoreConsumer, Semaphore semaphoreProducer){
        this.semaphoreConsumer=semaphoreConsumer;
        this.semaphoreProducer=semaphoreProducer;
    }
    public void run(){
        for(int i=1;i<=5;i++){
            try{
                semaphoreConsumer.acquire();
                System.out.println("Consumer :"+i);
                semaphoreProducer.release();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
}
