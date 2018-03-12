/**
 * Created by Haorenpu on 11/03/2018.
 */
public class ThreadTestFa {
    int i = 0;
    synchronized public void sayHello() {
        i++;
        //System.out.println(i);
    }
}
