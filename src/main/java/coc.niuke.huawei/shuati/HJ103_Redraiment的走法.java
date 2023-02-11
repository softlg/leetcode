package coc.niuke.huawei.shuati;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author c
 * @date 2023/1/29 1:45
 */
public class HJ103_Redraiment的走法 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。
        他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            scan.nextLine();
            String[] input1 = scan.nextLine().split(" ");
            int[] intArr = Arrays.stream(input1).mapToInt(Integer::parseInt).toArray();
            int[] k=new int[intArr.length];
            for(int j=1;j<intArr.length;j++){
                for(int i=0;i<j;i++){
                    if(intArr[i]<intArr[j]){
                        k[j]=Math.max(k[j],k[i]+1);
                    }
                }
            }
            Arrays.sort(k);
            System.out.println(k[k.length-1]+1);
        }
    }
}
