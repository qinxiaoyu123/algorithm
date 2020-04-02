package leetcode;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.delete("aabccbdef"));
    }
    public String delete(String s){
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'a'){
                stack.push('a');
            }
            else if(s.charAt(i) == 'b'){
                continue;
            }
            else if(s.charAt(i) == 'c'){
                if(stack.peek() == 'a'){
                    stack.pop();
                }
                else{
                    stack.push('c');
                }
            }
            else{
                stack.push(s.charAt(i));
            }

        }
        while(!stack.empty()){
            Character c = stack.pop();
            result.append(c);
        }
        return result.reverse().toString();
    }

}
