package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;


public class EightDigital {
    static HashMap<String, Integer> dis = new LinkedHashMap<String, Integer>();
    static Queue<String> que = new LinkedList<String>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static String end = "12345678x";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        StringBuffer line1 = new StringBuffer();
        for (int i = 0; i < line.length; i++) line1.append(line[i]);
//        System.out.println("line1 >"+line1);
        que.offer(line1.toString());
        dis.put(line1.toString(), 0);
        dfs();
    }

    private static void dfs() {
        while (que.size() > 0) {
            String tmp = que.poll();
//            System.out.println("tmp >"+tmp);
            if (tmp.equals(end)) {
                System.out.println(dis.get(tmp));
                return;
            }
            int k = tmp.indexOf("x");
            for (int i = 0; i < 4; i++) {

                int x = k / 3 + dx[i];
                int y = k % 3 + dy[i];
                if (x >= 0 && x < 3 && y >= 0 && y < 3) {
                    int k1 = 3 * x + y;
                    char[] tmpChar = tmp.toCharArray();
                    char c = tmpChar[k];
                    tmpChar[k] = tmpChar[k1];
                    tmpChar[k1] = c;
                    String tmp1 = String.valueOf(tmpChar);
                    if (!dis.containsKey(tmp1)) {
                        que.offer(tmp1);
                        dis.put(tmp1, dis.get(tmp) + 1);
                    }
                }

            }
        }
        System.out.println(-1);
    }
}
