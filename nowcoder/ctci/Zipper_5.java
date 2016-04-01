package nowcoder.ctci;

/**
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
给定一个string iniString为待压缩的串(长度小于等于3000)，保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
测试样例
"aabcccccaaa"
返回："a2b1c5a3"
"welcometonowcoderrrrr"
返回："welcometonowcoderrrrr"
 * @author ethan
 *
 */
import java.util.*;

public class Zipper_5 {
    public static String zipString(String iniString) {
    	char[] charArray = iniString.toCharArray();
    	
    	StringBuilder sb = new StringBuilder();
    	char last = charArray[0];
    	int count = 1;
    	for(int i=1; i<charArray.length; i++){
    		if( charArray[i] == last ){
    			count++;
    		}else{
    			sb.append(last);
    			sb.append(count);
    			count = 1;
    		}
    		last = charArray[i];
    	}
    	sb.append(last);
    	sb.append(count);
    	
    	if( sb.length() > iniString.length() ){
    		return iniString;
    	}
    	
    	return sb.toString();
    }
    public static void main(String args[]){
    	System.out.println(zipString("aabccccdde"));
    }
}