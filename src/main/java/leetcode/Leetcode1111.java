package leetcode;

import java.util.Stack;

public class Leetcode1111 {
    //有效括号的嵌套深度
    public static void main(String[] args) {
        String s = "(()())";
        Leetcode1111 l = new Leetcode1111();
        int[] a = l.maxDepthAfterSplit(s);
        for (int i = 0; i < s.length(); i++) {
            System.out.println(a[i]);
        }

    }

    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < seq.length(); i++) {

            if (seq.charAt(i) == '(') {
                s.push(seq.charAt(i));
                result[i] = s.size() % 2;
            }
            else {
                result[i] = s.size() % 2;
                s.pop();
            }

        }
        return result;
    }
}
//    public int[] maxDepthAfterSplit(String seq) {
//
//        Stack<Character> s = new Stack<>();
//        Stack<Integer> index = new Stack<>();
//        int[] result = new int[seq.length()];
//        for (int i = 0; i < seq.length(); i++) {
//            if (seq.charAt(i) == '(') {
//                if (s.empty()) {
//                    s.push(seq.charAt(i));
//                    index.push(i);
//                    result[i] = 0;
//                } else {
//                    result[i] = 1 - result[index.peek()];
//                    s.push(seq.charAt(i));
//                    index.push(i);
//                }
//            }
//
//            if (seq.charAt(i) == ')') {
//                s.pop();
//                int idx = index.pop();
//                result[i] = result[idx];
//
//            }
//
//        }
//        return result;
//    }

