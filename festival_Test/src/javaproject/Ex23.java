package javaproject;

import java.util.Scanner;

public class Ex23 {
	public static void main(String[] args) {
		// 단 수와 곱해지길 원하는 수를 입력하여 이와 같이 출력되게 하시오
		// 예시
		// 단수 입력 :
		// 2
		// 어느수 까지 출력 :
		// 2단 2*1 =2 ~ 2*6 = 12

		// 0. 스캐너 가져오기
		Scanner sc = new Scanner(System.in);

		// 1. 단수 입력문 출력, 단수 변수에 저장
		System.out.println("단수 입력 : ");
		int num = sc.nextInt();

		// 2. 어느 수까지 출력할지 물어보고 변수에 저장
		System.out.println("어느수 까지 출력 : ");
		int rows = sc.nextInt();

		// 3. 입력한 단 출력
		System.out.printf("%d단\n", num);

		// 4. for 문을 이용하여, 시작값 1부터 rows까지 출력 반복
		for (int i = 1; i <= rows; i++) {
			System.out.printf("%d*%d=%d\n", num, i, num * i);
		}

	}

}
