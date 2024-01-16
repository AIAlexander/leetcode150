package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/1/9
 */
public class ZigzagConversionNo6 {


    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        String[] results = new String[numRows];
        for (int i = 0; i < results.length; i++) {
            results[i] = new String();
        }
        boolean isDown=false;
        int index=0;
        for(int i=0; i<s.length(); i++){
            results[index]+=s.charAt(i);
            if(index==0||index==numRows-1){
                isDown=!isDown;//第一次index=0时，isDown修改为true说明可以继续往下走；当index=numRows的时候说明不能继续往下走，然后把isDown修改为false
            }
            index+=isDown?1:-1;
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<results.length;i++){
            sb.append(results[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
