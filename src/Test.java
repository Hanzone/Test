import javax.jnlp.ExtendedService;
import java.util.*;

/**
 * Created by haorenpu on 2017/2/20.
 */
public class Test<E, V> {
    public static void main(String args[]) throws Exception{

//        System.out.println("Hell Yeah!");
//        System.out.println("Hell Yeah!");
//        System.out.print("Hell Yeah!");

        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();

        //testMethod(s1, s2);

//        for (SmsSendConfig s : SmsSendConfig.values()) {
//            System.out.println(s);
//            System.out.println(s.ordinal());
//        }
//
//        Father s = new Son();
        EnumDemo.A.apply();
    }

    /**
     * do testing thing
     */
    private void testMethod(Set<? extends E> s1, Set<V> s2) throws Exception{


        //Set<E> result = new HashSet<E>(s1);
        //result.addAll(s2);
        //return result;


    }

    private enum SmsSendConfig {

        ALIDAYU,
        ALIDAYU2,
        ALIDAYU3,
        ALIDAYU4,
        MWXJK;
    }

}
