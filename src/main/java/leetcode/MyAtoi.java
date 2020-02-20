package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyAtoi {
    public int myAtoi(String str) {
        int INT_MAX = (int) (Math.pow(2,31)-1);
        int INT_Min = (int) -(Math.pow(2,31));
        boolean flag = false;//为正数
        int idx = 0;
        while(str.charAt(idx) == ' '){
            idx++;
        }

        str = str.substring(idx);
        Pattern p = Pattern.compile("[a-z,A-Z].*");
        Matcher m = p.matcher(str);
        if(m.lookingAt()) return 0;

        if(str.charAt(0) == '-'){
            flag = true;
        }
        p = Pattern.compile("[0-9]+");
        m = p.matcher(str);
        int value = 0;
        if(m.find()){
//            System.out.println(m.group());
            value = Integer.parseInt(m.group());
        }
        if(flag) {
            value = -value;
            if(value<INT_Min) return INT_Min;
            else return value;
        }
        if(value>INT_MAX) return INT_MAX;
        return value;
    }
    public static void main(String []args){
        MyAtoi a = new MyAtoi();
        System.out.println(a.myAtoi("   -42"));
        System.out.println(a.myAtoi("Words and 987"));
        System.out.println(a.myAtoi("   -42"));
    }
}
