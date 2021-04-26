import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Product {
    public static void main(String[] args) {
        Apple apple=new Apple();
            new Thread(()->{ for (int i = 0; i <10; i++) apple.add();},"A").start();
            new Thread(()->{ for (int i = 0; i <10; i++) apple.sub();},"B").start();
    }
}

class Apple{
    private int app=0;
    public synchronized void add(){
        if (app!=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        app++;
        System.out.println(Thread.currentThread().getName()+"==="+app);
        this.notify();
    }
    public synchronized void sub(){
        if (app==0){
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}
        app--;
        System.out.println(Thread.currentThread().getName()+"==="+app);
        this.notify();
    }
}