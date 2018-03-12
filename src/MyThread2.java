/**
 * Created by Haorenpu on 11/03/2018.
 */
public class MyThread2 extends Thread {

    private ThreadTestFa obj;
    public MyThread2(ThreadTestFa obj) {
        super();
        this.obj = obj;
    }

    @Override
    public void run() {

        System.out.println("MyThread2 start");
        int i = 0;
        while (++i<=5000) {
            obj.sayHello();
        }
        System.out.println("MyThread2 i:" + obj.i);
        System.out.println("MyThread2 end");

    }

}
