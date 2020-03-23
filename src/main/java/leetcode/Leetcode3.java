package leetcode;

import java.util.*;

public class Leetcode3 {
//    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//    public int lengthOfLongestSubstring(String s) {
//        Set<Character> sets = new HashSet<>();
//        Queue<Character> queue = new LinkedList<>();
//        int result = 0;
//        for(int i = 0;i<s.length();i++){
//            Character c = s.charAt(i);
//            if(sets.contains(c)){
//                result = Math.max(result, queue.size());
//                Character tmp;
//                do{
//                    tmp = queue.poll();
//                    sets.remove(tmp);
//
//                }while(!queue.isEmpty() && !tmp.equals(c));
//            }
//
//            sets.add(c);
//            queue.offer(c);
//            result = Math.max(result, queue.size());
//
//        }
//        return result;
//    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> maps = new HashMap<>();
        int result = 0;
        int l = 0;
        for(int i = 0;i<s.length();i++){
            Character c = s.charAt(i);
            if(maps.containsKey(c)){
                l = Math.max(maps.get(c)+1,l);
            }
            maps.put(c,i);
            result = Math.max(result, i-l+1);

        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(new Leetcode3().lengthOfLongestSubstring(s));
    }
}
