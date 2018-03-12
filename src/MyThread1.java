/**
 * Created by Haorenpu on 11/03/2018.
 */
public class MyThread1 extends Thread{

    private ThreadTestFa obj;
    public MyThread1(ThreadTestFa obj) {
        super();
        this.obj = obj;
    }

    @Override
    public void run() {

        System.out.println("MyThread1 start");
        int i = 0;
        while (++i<=5000) {
            obj.sayHello();
        }
        System.out.println("MyThread1 i:" + obj.i);
        System.out.println("MyThread1 end");

    }

}
