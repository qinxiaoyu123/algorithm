package graph;

class Fuel{
    //占用时间，大于0表示被占用
    int time;
    //当前余量
    int value;

    public Fuel(int time, int value) {
        this.time = time;
        this.value = value;
    }
}
public class Solution {
    public int solution(int []A, int X, int Y, int Z){
        Fuel [] fuels = new Fuel[3];
        fuels[0] = new Fuel(0, X);
        fuels[1] = new Fuel(0, Y);
        fuels[2] = new Fuel(0, Z);
        //迭代时间
        //第carIndex个汽车安排完加油
        int carIndex = -1;
        for(int tim = 0;;){
            //占用时间到，清0
            for(int k = 0;k<3;k++){
                if(fuels[k].time == tim){
                    fuels[k].time = 0;
                }
            }
            int waitTime = 1;
//            System.out.println("carIndex "+carIndex);
            for(int i = carIndex+1;i<A.length;i++){
                //用来指示是否找到加油桶
                boolean flag1 = false;
                boolean flag2 = false;
                waitTime = 1;
                for(int j = 0;j<3;j++){
                    //可以直接用
                    if(A[i] <= fuels[j].value && fuels[j].time == 0){
                        fuels[j].time = A[i];
                        fuels[j].value = fuels[j].value - A[i];
                        flag1 = true;
                        carIndex = i;
                        if(carIndex == A.length -1) return tim;
                        break;
                    }
                }
                if(!flag1){//没有直接可以用的，等待
                    waitTime = 0x3f3f3f3f;
                    for(int j = 0;j<3;j++){
                        if(A[i] <= fuels[j].value && fuels[j].time != 0){
                            waitTime = Math.min(fuels[j].time - tim, waitTime);
                            flag2 = true;
                        }
                    }
                    if(!flag2) return -1;
                    else break;
                }
            }
            tim = tim +waitTime;
        }

    }
    public static void main(String []args){
        Solution s = new Solution();
        int n = s.solution(new int[]{2,8,4,3,2}, 7, 11, 3);
//        int n = s.solution(new int[]{5}, 4, 0, 3);
        System.out.println(n);

    }
}
