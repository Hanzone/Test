
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by haorenpu on 2017/2/20.
 */
public class Test {


    static int ii;
    private Integer ss;

    public static void main(String args[]) throws Exception {


        //print(getInt("1.000"));

//        String s = null;
////        print("null".equals(s));
//
//        print(Integer.parseInt("1.00"));

//        print(getInt("010000".split("\\.")[0]));


        print(new BigDecimal(1).divide(new BigDecimal(3), 2, BigDecimal.ROUND_HALF_UP));


    }

    public void pp() {
        print(Test.this.getClass() == this.getClass());
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