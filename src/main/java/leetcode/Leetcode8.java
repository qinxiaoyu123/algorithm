package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leetcode8 {
    public static void main(String[] args) {
        Leetcode8 l = new Leetcode8();
        l.myAtoi("aaa");
    }

    //字符串转整数
    public int myAtoi(String str) {
        //去掉开头和后面的空格
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        //判断开头是否是非法字符，除+ - 数字以外
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+') {
            return 0;
        }
        boolean flag = true;
        if (str.charAt(0) == '-') {
            flag = false;
        }

        long result = 0L;
        int i = Character.isDigit(str.charAt(0)) ? 0 : 1;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            result = result * 10 + (str.charAt(i++) - '0');

            if (flag && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (!flag && (-result) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }


        return flag ? (int) result : (int) -result;
    }
}
