package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {

    public void recurse(int n) {
    	//divided and conquer?
		if (n==1) return;

    	int factor = n%2==0 ? 2 : 3;

    	while (n%factor!=0) factor+=2;

	    System.out.print(factor+" ");
	    recurse(n/factor);
    }

	public static void main(String[] args) {
		new Solution().recurse(132);
    }
}
