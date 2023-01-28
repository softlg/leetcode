package coc.niuke.huawei.greed;
import java.util.Scanner;
/**
 * @author c
 * @date 2023/1/29 1:29
 */
public class HJ92_在字符串中找出连续最长的数字串 {
    /*
    难度：中等
    --------------------------------------------------------------------------------
    题目：
        输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
        本题含有多组样例输入。
    --------------------------------------------------------------------------------
    解题思路：

    --------------------------------------------------------------------------------
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) {
            String str = in.nextLine();
            doSearch(str);
        }
    }

    public static void doSearch(String string){
        int n = 0, maxOne = 0;
        // 遍历一遍获取长度最大值，时间复杂度O(n)
        for(int i=0; i < string.length(); i++){
            if(Character.isDigit(string.charAt(i))){
                n++;
                maxOne = Integer.max(maxOne,n);
            }else{
                n = 0;
            }
        }
        // 再遍历一遍获取长度为最大值的子串，并判断子串中是否全是数字，时间复杂度O(n)
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= string.length() - maxOne; i++){
            String st = string.substring(i,i + maxOne);
            if(0 == st.replaceAll("[0-9]","").length()){
                sb.append(st);
            }
        }
        System.out.println(sb+","+ maxOne);
    }
}