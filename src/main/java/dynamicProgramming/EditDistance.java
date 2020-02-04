package dynamicProgramming;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class EditDistance {
    static int N = 1000;
    static char [][] arry = new char[1010][11];
    static int [][] f = new int[11][11];
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] line = reader.readLine().split("\\s+");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
        for(int i = 0;i<n;i++){
            arry[i] = reader.readLine().trim().toCharArray();
        }
        for(int i = 0;i<m;i++){
            String []s = reader.readLine().trim().split("\\s+");
            char [] a = s[0].toCharArray();
            int k = Integer.parseInt(s[1]);
            int count = 0;
            for(int j = 0;j<n;j++){
                int t = minEditDistance(arry[j],a);
                if(t<=k) count++;
            }
            System.out.println(count);
        }
    }

    private static int minEditDistance(char[] chars, char[] a) {
        int n1 = chars.length, n2 = a.length;
        for(int i = 1; i<= n1;i++) f[i][0] = i;
        for(int i = 1; i<=n2;i++)  f[0][i] = i;
        for(int i = 1; i<= n1;i++){
            for(int j = 1;j<=n2;j++){
                f[i][j] = Math.min(f[i-1][j]+1, f[i][j-1]+1);
                if(chars[i-1] == a[j-1]) f[i][j] = Math.min(f[i][j], f[i-1][j-1]);
                else f[i][j] = Math.min(f[i][j], f[i-1][j-1]+1);
            }
        }
        return f[n1][n2];
    }
}
