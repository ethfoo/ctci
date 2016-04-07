package recursion_9;

import java.util.*;

/**
 * 在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，元素值各不相同，编写一个方法，判断在数组A中是否存在魔术索引。
 * 请思考一种复杂度优于o(n)的方法。 给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
 * 
 * @author ethan
 *
 */
public class MagicIndex {
	public boolean findMagicIndex(int[] A, int n) {
		return binarySearch(A, 0, n-1);
	}
	
	private boolean binarySearch(int[] A, int left, int right){
		int n = (left+right)/2;
		int index = A[n];
		if( left > right ){
			return false;
		}
		
		if( index > n ){
			return binarySearch(A, left, n-1);
		}
		else if( index < n){
			return binarySearch(A, n+1, right); 
		}
		else{
			return true;
		}
		
	}
	
	public static void main(String args[]){
		int[] A = {-3, -1 ,1, 3, 7, 9 ,11, 15};
		boolean ret = new MagicIndex().findMagicIndex(A, A.length);
		System.out.println(ret);
	}
}
