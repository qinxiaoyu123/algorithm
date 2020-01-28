package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

import static java.util.Arrays.sort;

class Weight {
    int left;
    int right;
    int weight;

    public Weight(int left, int right, int weight) {
        this.left = left;
        this.right = right;
        this.weight = weight;
    }
}

class MyComparator implements Comparator<Weight> {
    @Override
    public int compare(Weight o1, Weight o2) {
        return o1.weight - o2.weight;
    }
}

public class Kruskal {
    static int N = 200010;
    static int M = 400010;
    static Weight[] weights = new Weight[N];
    static int idx = 0;
    static int[] p = new int[N];
    static int sum = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        while (m-- > 0) {
            String[] list = reader.readLine().split(" ");
            int a = Integer.parseInt(list[0]), b = Integer.parseInt(list[1]), c = Integer.parseInt(list[2]);
            idx++;
            weights[idx] = new Weight(a, b, c);
        }
        sort(weights, 1, idx, new MyComparator());
        for (int i = 1; i <= idx; i++) {
            Weight tmp = weights[i];
            int left = weights[i].left;
            int right = weights[i].right;
            int we = weights[i].weight;
            int pLeft = find(left);
            int pRight = find(right);
            if (pLeft != pRight) {
                sum += we;
                p[pLeft] = pRight;
                count++;
            } else {
                continue;
            }
            if (count == (n - 1)) {
                break;
            }

        }
        if (count == (n - 1)) System.out.println(sum);
        else System.out.println("impossible");
    }

    private static int find(int left) {
        if (p[left] != left) p[left] = find(p[left]);
        return p[left];
    }


}
