package nowcoder.ctci;

import java.util.Arrays;


/**
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串空格。
给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
测试样例：
"This is nowcoder","is This nowcoder"
返回：true
"Here you are","Are you here"
返回：false
 * @author ethan
 *
 */
public class Same_3 {
    public boolean checkSam(String stringA, String stringB) {
    	if( stringA.length() != stringB.length() ){
    		return false;
    	}
    	if( sort(stringA).equals( sort(stringB) )){
    		return true;
    	}
    	return false;
    }
    
    private String sort(String str){
    	char[] strArray = str.toCharArray();
    	Arrays.sort(strArray);
    	return new String(strArray);
    }
}