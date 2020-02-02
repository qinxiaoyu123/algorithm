package basicAlgorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N = 100010;
    static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s+");
        int n = Integer.parseInt(line[0]), q = Integer.parseInt(line[1]);
        int idx = 0;
        for (String s : reader.readLine().split("\\s+")) {
            f[idx++] = Integer.parseInt(s);
        }
        while (q-- > 0) {
            int a = Integer.parseInt(reader.readLine());
            System.out.println(findLeft(a, n));
            System.out.println(findRight(a, n));
        }
    }

    private static int findRight(int a, int n) {
        int l = 0, r = n - 1;
        int mid;
        while (l < r) {
            mid = (l + r) >> 1;
            if (f[mid] >= a) r = mid;
            else l = mid + 1;
        }
        if (f[l] != a) return -1;
        else return l;
    }

    private static int findLeft(int a, int n) {
        int l = 0, r = n - 1;
        int mid;
        while (l < r) {
            mid = (l + r + 1) >> 1;
            if (f[mid] <= a) l = mid;
            else r = mid - 1;
        }
        if (f[l] != a) return -1;
        else return l;
    }


}
