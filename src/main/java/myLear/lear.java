package myLear;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lear {
    public static void main(String[] args) {
        Fruits fruits = new Fruits();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                3,
                5,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100),
                new ThreadPoolExecutor.AbortPolicy());


        threadPool.submit(() -> {
            fruits.solaApple();
            fruits.solaCherry();
            fruits.solaMango();
        });

    }

}

class Fruits {
    Lock lock = new ReentrantLock();
    private int apple = 10;
    private int mango = 20;
    private int cherry = 30;


    public void solaApple() {
        lock.lock();
        try {
            while (apple > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + apple + "个苹果");
                apple--;
            }
        } finally {
            lock.unlock();
        }
    }

    public void solaMango() {
        lock.lock();
        try {
            while (mango > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + mango + "个芒果");
                mango--;
            }
        } finally {
            lock.unlock();
        }
    }

    public void solaCherry() {
        lock.lock();
        try {
            while (cherry > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + cherry + "个车厘子");
                cherry--;
            }
        } finally {
            lock.unlock();
        }
    }

}
