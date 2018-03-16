import com.sun.xml.internal.ws.api.model.CheckedException;

import javax.management.RuntimeMBeanException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

/**
 * Created by Haorenpu on 07/11/2017.
 */
public class Father {

    Father() {
        System.out.println("Father");
    }
    Father(String s) {
        System.out.println(s);
    }

    static {
        System.out.println("Father init");
    }

    public static final String HELLO = "HELLO";

    protected void method1(Father f) throws IOException {
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        bw.write("father method1");
        bw.close();

        if (f != null) {
        }
    }


    private String name;


    public String getName() throws RuntimeException {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Father father = (Father) o;

        return name.equals(father.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
