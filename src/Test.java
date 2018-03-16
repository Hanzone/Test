
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by haorenpu on 2017/2/20.
 */
class Test {


    static int ii;
    private Integer ss;

    public static void main(String args[]) throws Exception {



//
//        Map<String, Object> map = new HashMap<>();
//        map.put("GainQuantity", "1.20000");
//        map.put("activityQuantity", new BigDecimal("100.20000"));
//        map.put("actiQuantity", new BigDecimal("100.0000"));
//        map.pu`t(null, new BigDecimal("100.0000"));
//
//        Son son = new Son();
//        //map.put("son", son);
//
//        List list = new ArrayList();
//        list.add(map);
//        list.add("100.00");
//        list.add(son);
//        list.add(null);
//        Map map1 = dealMapTrimQuantityZero(map);
//        print("sas");


//        Scanner in = new Scanner(System.in);
//        while (true) {
//            String i = in.nextLine();
//            print(i);
//            if ("1.2".equals(i)) break;
//        }


        print(testFinally());
    }

    static private int testFinally(){

        int x;
        try {
            x = 10;
            return x;
        } finally {
            x = 30;
            //return x;
        }

    }

    public void pp() {
        print(Test.this.getClass() == this.getClass());
    }

    public static Map dealMapTrimQuantityZero(Map<String,Object> map){

        Map<String,Object> dealedMap = new HashMap<String,Object>();

        for(Map.Entry<String, Object> temp : map.entrySet()){

            //取得map中的value
            Object value = temp.getValue();
            String key = temp.getKey();
            String keyTemp = key.toUpperCase();

            //如果value是集合类型深度递归继续处理
            if(value instanceof List){
                List<Map> list = (List<Map>)value;
                List<Map> list1 = new ArrayList<Map>();
                for(Map temp1 : list){
                    Map tempMap1 = dealMapTrimQuantityZero(temp1);
                    list1.add(tempMap1);
                }
                dealedMap.put(key, list1);
            }else if(value instanceof Map){
                Map temp2 = dealMapTrimQuantityZero((Map)value);
                dealedMap.put(key, temp2);
            }else if(null == value){
                dealedMap.put(key,"");
            }else if (keyTemp.contains("QUANTITY")){
                String num = value.toString();
                if(num.indexOf(".") > 0){
                    num = num.replaceAll("0+?$", "");//去掉尾部多余的0
                    num = num.replaceAll("[.]$", "");//如最后一位是.则去掉
                }
                dealedMap.put(key, num);
            }else{
                dealedMap.put(key, value);
            }
        }
        return dealedMap;
    }

    private static int getIntValue(String str) {
        int r = 0;
        if (str != null && str.length() != 0) {
            StringBuffer bf = new StringBuffer();
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c >= '0' && c <= '9') {
                    bf.append(c);
                } else if (c == ',') {
                    continue;
                } else {
                    if (bf.length() != 0) {
                        break;
                    }
                }
            }
            try {
                r = Integer.parseInt(bf.toString());
            } catch (Exception e) {
            }
        }
        return r;
    }


    /**
     * 检测指定字符串是否符合正浮点数，而且整数位数不大于传入参数len1，小数位数不大于传入参数len2
     *
     * @param value 待验证的字符串
     * @param len1  整数位数最大范围
     * @param len2  小数位数最大范围
     * @return 如果字符串符合浮点数，而且整数位数不大于传入参数len1，小数位数不大于传入参数len2，则返回true，否则返回false
     */
    public static boolean isPositiveFloatValid(String value, int len1, int len2) {
        if (value == null || "".equals(value)) {
            return false;
        }
        boolean checkFloat = false;
        checkFloat = value.matches("^([0-9]\\d*)(\\.\\d+)?$") && !value.matches("^0+(\\.0+)?$");
        if (checkFloat) {
            String[] ar = value.split("[.]");
            if (ar.length == 2) {
                if (ar[0].length() > len1 || ar[1].length() > len2) {
                    checkFloat = false;
                }
            } else if (ar.length == 1) {
                if (ar[0].length() > len1) {
                    checkFloat = false;
                }
            } else {
                checkFloat = false;
            }
        }
        return checkFloat;
    }

    private static void print(Object t) {
        System.out.println(t);
    }

    public static int getInt(Object obj) {
        //对象为空返回0
        if (null == obj) {
            return 0;
        }
        //对像为Integer类型直接返回
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        //对象为String类型
        else if (obj instanceof String) {
            try {
                return Integer.parseInt(String.valueOf(obj));
            } catch (Exception e) {
                return 0;
            }
        } else if (obj instanceof Number) {
            Number num = (Number) obj;
            return num.intValue();
        } else {
            return 0;
        }
    }


    /**
     * obj 转换成BigDecimal
     *
     * @param obj
     * @return
     */
    public static BigDecimal getBigDecimal(Object obj) {
        //对象为空返回0
        if (null == obj) {
            return new BigDecimal(0);
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        } else if (obj instanceof Number) {
            return new BigDecimal(String.valueOf(obj));
        } else if (obj instanceof String) {
            try {
                return new BigDecimal((String) obj);
            } catch (Exception e) {
                return new BigDecimal(0);
            }
        } else {
            return new BigDecimal(0);
        }
    }

    public static double getDouble(Object obj) {
        double res = 0;
        if (obj instanceof Integer) {
            res = (Integer) obj;
        } else if (obj instanceof Float) {
            res = (Float) obj;
        } else if (obj instanceof Double) {
            res = (Double) obj;
        } else if (obj instanceof Number) {
            Number num = (Number) obj;
            res = num.doubleValue();
        } else {
            try {
                res = Double.parseDouble(getString(obj));
            } catch (Exception e) {
            }
        }
        return res;
    }

    public static float getFloat(Object obj) {
        float res = 0;
        if (obj instanceof Integer) {
            res = (Integer) obj;
        } else if (obj instanceof Float) {
            res = (Float) obj;
        } else if (obj instanceof Number) {
            Number num = (Number) obj;
            res = num.floatValue();
        } else {
            try {
                res = Float.parseFloat(getString(obj));
            } catch (Exception e) {
            }
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

    public static boolean isFloatValid(String value, int len1, int len2) {
        if (value == null || "".equals(value)) {
            return false;
        }
        boolean checkFloat = false;
        checkFloat = value.matches("^([0-9]\\d*)(\\.\\d+)?$");
        if (checkFloat) {
            String[] ar = value.split("[.]");
            if (ar.length == 2) {
                if (ar[0].length() > len1 || ar[1].length() > len2) {
                    checkFloat = false;
                }
            } else if (ar.length == 1) {
                if (ar[0].length() > len1) {
                    checkFloat = false;
                }
            } else {
                checkFloat = false;
            }
        }
        return checkFloat;
    }


}