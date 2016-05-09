package recursion_9;
/**
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * @author ethan
 *
 */
import java.util.*;

//可以用堆栈，也可以数左右括号的个数
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
    	int count = 0;//左括号的个数

    	for( int i=0; i<n; i++){
    		if( '(' == A.charAt(i)){
    			count++;
    		}else if( ')' == A.charAt(i)){
    			count--;
    			if( count <0 ){
    				return false;
    			}
    		}else{
    			return false;
    		}
    	}
    	
    	if( count != 0 ){
    		return false;
    	}
    	
    	return true;
    }
}