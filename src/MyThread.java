public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(1000);
            System.out.print("线程: " + currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}