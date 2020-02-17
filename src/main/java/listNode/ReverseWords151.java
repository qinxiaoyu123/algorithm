package listNode;



public class ReverseWords151 {
    public String reverseWords(String s) {
        String [] s1 = s.trim().split("\\s+");
        int idx = s1.length;
        if(idx == 0 ) return null;
        StringBuilder stringNew = new StringBuilder();
        for(int i = s1.length -1;i>=0;i--){
            stringNew.append(s1[i]);
            if(i != 0){
                stringNew.append(" ");
            }
        }
        return stringNew.toString();
    }
    public static void main(String []args){
        ReverseWords151 r = new ReverseWords151();
        System.out.println(r.reverseWords("  hello world!  ")+"aaa");
    }
}
