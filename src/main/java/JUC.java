import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUC {
    public static void main(String[] args) {
       Ticket ticket = new Ticket();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        },"A").start();
        ThreadPoolExecutor threadPool= new ThreadPoolExecutor(
                2,
                3,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(27),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 30; i++) {
            int number=i+1;
            threadPool.submit(()->{
                System.out.println(Thread.currentThread().getName()+"\t"+"卖出第"+number+"张票");
            });
        }

        threadPool.shutdown();
//        new Thread(()->{for (int i=1;i<=31;i++) ticket.sale();},"A").start();
//        new Thread(()->{for (int i=1;i<=31;i++) ticket.sale();},"B").start();
//        new Thread(()->{for (int i=1;i<=31;i++) ticket.sale();},"C").start();
    }

}
class Ticket
{
    private int number=30;
    Lock lock=new ReentrantLock(true); //可重入锁，默认是非公平锁   公平锁，true

    public void sale()
    {
        lock.lock();
        try {
            if(number>0)
            {
                System.out.println(Thread.currentThread().getName()+"\t"+"卖出的票号是："+(number--)+"还剩下的票数是："+number);
            }
        } finally {
            lock.unlock();
        }
    }
}