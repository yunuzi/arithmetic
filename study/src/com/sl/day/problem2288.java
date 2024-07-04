package com.sl.day;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem2288
 * @Date：2024-6-18 9:07
 * @Filename：problem2288
 */
public class problem2288 {
    public String discountPrices(String sentence, int discount) {
        double k = (double) (100 - discount) / 100.00;
        // 创建一个 DecimalFormat 实例来格式化数字，保留两位小数
        DecimalFormat df = new DecimalFormat("0.00");
        HashMap<Integer[], Double> map = new HashMap();
        char[] charArray = sentence.toCharArray();
        for(int i = 0;i< charArray.length;i++){
            if(charArray[i] == '$' && i > 0 && charArray[i - 1] == ' ' ||( i==0 && charArray[i] == '$') ){
                i++;
                for(int j = i;j< charArray.length;){
                    if(charArray[j] == 48){
                        break;
                    }
                    while(j < charArray.length && 48<=charArray[j] && charArray[j] <=57){
                        j++;
                    }
                    if ((j == charArray.length &&  48<=charArray[j - 1] && charArray[j -1] <=57) || charArray[j] == ' ' && j > i) {
                        double v = Double.parseDouble(sentence.substring(i, j)) * k;
                        map.put(new Integer[]{i,j},Math.round(v * 100.0) / 100.0);
                        i = j;
                        break;
                    }else {
                        i = j;
                        break;
                    }
                }
            }
        }

        Integer [][] arr = new Integer[map.size()][2];
        int x = 0;
        for(Integer[] a : map.keySet()){
            arr[x++] = a;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        StringBuffer s = new StringBuffer(sentence);
        for(int i = arr.length - 1;i >= 0;i--){
            s.replace(arr[i][0],arr[i][1], df.format((map.get(arr[i]))));
        }
        return s.toString();
    }

    @Test
    public void test(){
        System.out.println(discountPrices("1$2", 50));
    }
}
