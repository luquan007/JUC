import java.util.concurrent.TimeUnit;

public class Lock8Dome {
    public static void main(String[] args) {
        Phone phone1=new Phone();
        Phone phone2=new Phone();
        new Thread(()->{phone1.Email();},"t1").start();
        new Thread(()->{phone2.SMS();},"t2").start();
        //new Thread(()->{phone1.hello();},"t3").start();
    }
}


class Phone{
    public static synchronized void Email(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------email");
    }
    public static synchronized void SMS(){
        System.out.println("-------SMS");
    }
    public void hello(){
        System.out.println("----hello");
    }
}