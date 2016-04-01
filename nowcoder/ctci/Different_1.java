package nowcoder.ctci;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 确定一个字符串中的字符是否是否全都不同
 * 这里的思路是排序，然后判断排序后数组是否存在相同的两个数
 * 如果可以有辅助内存使用，可以用hashMap(字符个数有限，一般用字符数组）或位向量
 * @author ethan
 *
 */
public class Different_1{
    public boolean checkDifferent(String iniString) {
    	char[] string = iniString.toCharArray();
    	Arrays.sort(string);
    	
    	char last=string[0];
    	for(int i=1; i<string.length; i++){
    		if( string[i] == last){
    			return false;
    		}
    		last = string[i];
    	}
    	
		return true;
    }
    
    public static void main(String args[]){
    	Scanner scan = new Scanner(System.in);
    	Different_1 dif = new Different_1();
    	
    	while( scan.hasNext() ){
     		 String input = null;
    		 input = scan.next();
    		 boolean result = dif.checkDifferent(input);
    		 System.out.println(result);
    	}
    	
    }
}