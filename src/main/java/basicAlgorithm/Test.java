package basicAlgorithm;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String a = "12.3.4";
        String[] list = a.split("\\.");
        System.out.println(Arrays.toString(list));
    }
}
