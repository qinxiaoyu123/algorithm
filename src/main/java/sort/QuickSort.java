package sort;

import java.util.*;

public class QuickSort {
    public void quickSort(int[] arg, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >> 1;
        int x = arg[mid];
        int i = l;
        int j = r;
        while (i < j) {
            while (arg[i] < x) i++;
            while (arg[j] > x) j--;
            if (i != j) {
                int tmp = arg[i];
                arg[i] = arg[j];
                arg[j] = tmp;
                i++;
                j--;
            }
        }
        quickSort(arg, l, j);
        quickSort(arg, j + 1, r);
    }

    public static void main(String[] args) {
//        int[] a = {3, 2, 4, 1, 5};
////        new QuickSort().quickSort(a, 0, 4);
////        System.out.println(Arrays.toString(a));
////        List<Integer> arry = new ArrayList<>(Arrays.asList(1,23,2));
////        Iterator<Integer> iter = arry.iterator();

        Map<Integer, Integer> maps = new HashMap<>();
        maps.put(1, 2);
        maps.put(3, 1);
        Iterator<Map.Entry<Integer, Integer>> iter = maps.entrySet().iterator();
        Iterator<Integer> keys = maps.keySet().iterator();
        while (keys.hasNext()) {
            int tmp = keys.next();
            System.out.println(tmp);
            maps.put(tmp + 1, tmp + 1);
        }
        ArrayList<Integer> arryList = new ArrayList<>();
        LinkedList<Integer> lists = new LinkedList<>();
        lists.add(2);
        lists.addFirst(1);


        lists.add(0, 1);

    }
}
