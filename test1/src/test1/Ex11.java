package test1;

import java.util.Random;

public class Ex11 {
	public static void main(String[] args) {
		
		Random r = new Random();
		
		int[] array= new int[8];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(100)+1;
		}
		int max = array[0];
		int min = array[0];
		
		for (int i = 0; i < array.length; i++) {
			if(max<array[i]) {
				max = array[i];
			}
			if(min>array[i]) {
				min = array[i];
			}
		}
		System.out.print("배열에 있는 모든 값 : ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+ " ");
		}
		System.out.println();
		System.out.println("가장 큰 값 : " + max);
		System.out.println("가장 작은 값 : " + min);
	}
}
