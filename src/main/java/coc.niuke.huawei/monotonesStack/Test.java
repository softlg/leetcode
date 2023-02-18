package coc.niuke.huawei.monotonesStack;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author c
 * @date 2023/2/13 15:31
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            getResult(str);
        }
    }

    public static void getResult(String str){
        //
        int sum = Integer.parseInt(str.substring(4,5));
        int A = Integer.parseInt(str.substring(0,1));
        int B = Integer.parseInt(str.substring(2,3));
        int result = 0;
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i <= sum; i++) {
            result = A * i + B * (sum - i);
            res.add(result);
        }
        int[] ints = res.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(ints);
    }
}
