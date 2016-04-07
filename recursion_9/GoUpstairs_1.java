package recursion_9;

import java.util.*;

/**
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 * @author ethan
 *
 */
public class GoUpstairs_1 {
	private static Map cache = new HashMap();

	//递归的动态规划
	public static int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (cache.containsKey(n)) {
			return (int) cache.get(n);
		} else {
			int ret = countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
			cache.put(n, ret);
			return ret;
		}

	}
	
	//循环的动态规划
	public static int count(int n){
		
		int[] f = new int[n+1];
		f[0] = 1;
		f[1] = 1;
		f[2] = 2;
		
		for(int i=3; i<=n; i++){
			f[i] = f[i-1] + f[i-2] + f[i-3];	
		}
		
		return f[n];
		
	}
	
	public static void main(String args[]){
		int result = count(80);
		System.out.println(result);
	}
}