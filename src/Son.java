import java.util.HashMap;

/**
 * Created by Haorenpu on 07/11/2017.
 */
public class Son extends Father {
//    Son() {
//
//        super("sa");
//        System.out.println("Son");
//
//    }
    public String name;


    public void method1(Son s) {
        System.out.println("son method1");
        print("sas");
    }

    public void print(String t) {
        System.out.println(t);
    }
}
