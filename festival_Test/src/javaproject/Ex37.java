package javaproject;

import java.util.Scanner;

public class Ex37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3! = 1*2*3 = 6

		// 키보드 입력을 받기 위한 스캐너 가져오기
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int num = sc.nextInt();

		// 결과값을 저장할 변수 result 값 0으로 초기화
		int result = 0;
		int cnt = 1;
		// 1*1 + 1*2 + 1*3 --> 3!
		for (int i = 1; i <= num; i++) {
			cnt *= i; // cnt에 증가되는 i의 값을 곱하여 저장
			result = cnt; // cnt 값을 result에 저장
		}
		System.out.println("출력 : " + result); // result 값 출력
	}

}
