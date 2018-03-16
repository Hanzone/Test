import java.util.HashMap;
import java.util.Map;

/**
 * Created by Haorenpu on 14/03/2018.
 */
public class TestClone implements Cloneable {

    public Map map = new HashMap();

    public TestClone() {
        map.put("ss", "s11");
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
