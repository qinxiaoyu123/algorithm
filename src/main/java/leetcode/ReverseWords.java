package leetcode;

public class ReverseWords {
    public String reverseWords(String s) {
        if(s == null) return s;
        StringBuilder result = new StringBuilder();
        for(String ss:s.split("\\s+")){
            char [] tmpChar = ss.toCharArray();
            int i = 0, j = tmpChar.length-1;
            while(i<=j){
                char tmp = tmpChar[i];
                tmpChar[i] = tmpChar[j];
                tmpChar[j] = tmp;
                i++;
                j--;
            }
            result.append(tmpChar).append(" ");
        }
        return result.toString().trim();
    }
    public static void main(String []args){

    }

}
