import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int X, int[] A){
        Set<Integer> result = new HashSet<>();
        for(int i = 0;i<A.length;i++){
            if(A[i]<= X && A[i]>=1){
                result.add(A[i]);
            }
            if(result.size() == X){
                return i;
            }
        }
        return -1;
    }
}

public class Other {

    //青蛙过河

}
