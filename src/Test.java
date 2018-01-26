import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haorenpu on 2017/2/20.
 */
public class Test {


    public static void main(String args[]) throws Exception {





        Integer.valueOf("11.0");

        print(getString(new BigDecimal("2222.455000")));



    }

    private static void print(Object t) {
        System.out.println(t);
    }

    public static String getPrettyNumber(Object obj) {
        return BigDecimal.valueOf(getDouble(obj))
                .stripTrailingZeros().toString();
    }

    /**
     * obj 转换成BigDecimal
     * @param obj
     * @return
     */
    public static BigDecimal getBigDecimal(Object obj) {
        double num = getDouble(obj);
        return new BigDecimal(String.valueOf(num));
    }

    public static double getDouble(Object obj){
        double res = 0;
        if(obj instanceof Integer){
            res = (Integer)obj;
        }else if(obj instanceof Float){
            res = (Float)obj;
        }else if(obj instanceof Double){
            res = (Double)obj;
        }else if(obj instanceof Number){
            Number num = (Number)obj;
            res = num.doubleValue();
        }else{
            try{
                res= Double.parseDouble(getString(obj));
            }catch(Exception e){}
        }
        return res;
    }

    public static float getFloat(Object obj){
        float res = 0;
        if(obj instanceof Integer){
            res = (Integer)obj;
        }else if(obj instanceof Float){
            res = (Float)obj;
        }else if(obj instanceof Number){
            Number num = (Number)obj;
            res = num.floatValue();
        }else{
            try{
                res= Float.parseFloat(getString(obj));
            }catch(Exception e){}
        }
        return res;
    }

    public static String getString(Object obj) {
        if (null == obj) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        } else {
            return obj.toString();
        }
    }
    public static boolean isDecimal(String value, int len1, int len2) {
        if (value == null || "".equals(value)) {
            return false;
        }
        boolean checkFloat = false;
        checkFloat = value.matches("^\\-?([0-9]\\d*)(\\.\\d+)?$");
        if (checkFloat) {
            String[] ar = value.split("[.]");
            if (ar.length == 2) {
                if (ar[0].replaceAll("-", "").length() > len1 || ar[1].length() > len2) {
                    checkFloat = false;
                }
            } else if (ar.length == 1) {
                if (ar[0].replaceAll("-", "").length() > len1) {
                    checkFloat = false;
                }
            } else {
                checkFloat = false;
            }
        }
        return checkFloat;
    }


}