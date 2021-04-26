import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DadeWorkDome {
    public static void main(String[] args) {

        Object lockA=new Object();
        Object lockB=new Object();

        new Thread(()->{
            synchronized (lockA){
                System.out.println("已有A锁，想要获得B锁");
                synchronized (lockB){
                    System.out.println("成功获取B");
                }
            }
            },"B").start();
        new Thread(()->{
            synchronized (lockB){
                System.out.println("已有B锁，想要获得A锁");
                synchronized (lockA){
                    System.out.println("成功获取A");
                }
            }
        },"A").start();
    }
}

