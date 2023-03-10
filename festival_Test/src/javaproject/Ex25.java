package javaproject;

import java.util.Random;

public class Ex25 {

	public static void main(String[] args) {
		Random r = new Random();
		// point 배열에 값 넣기
		int[] point = { 92, 32, 52, 9, 81, 2, 68 };

		// 최소, 거리, 인덱스 번호를 저장할 변수 선언
		int min = 0;
		int distance = 0;
		int index = 0;

		// num1, num2의 번호를 0~7까지의번호를 랜덤으로 받기 위해서
		int num1 = r.nextInt(7);
		int num2 = r.nextInt(7);

		if (num1 != num2) { // num1, num2의 번호가 다를 때 출력--> 확인하기위해
			System.out.println(num1);
			System.out.println(num2);
		}
		// case1
		if (num1 > num2) { // num1 > num2일때
			min = point[num2]; // num2의 값을 최소값으로 지정하여 num2 부터 num1까지의 값을 비교
			distance = num1 - num2; // 거리 차는 큰 수에서 작은 수를 뺀 값
			for (int i = num2; i < num1; i++) { // num2~ num1까지 진행
				if (min > point[i]) { // 최소값보다 작은 값이 존재하면 그 값을 min에 저장
					min = point[i];
				}
			}
		}
		// case2
		if (num2 > num1) { // num2 > num1일때
			min = point[num1]; // num1의 값을 최소값으로 지정하여 num1 부터 num2까지의 값을 비교
			distance = num2 - num1;
			for (int i = num1; i < num2; i++) {
				if (min > point[i]) {// 최소값보다 작은 값이 존재하면 그 값을 min에 저장
					min = point[i];
				}
			}
		}
		// 인덱스 출력하기위해서 min값과 같은 인덱스의 번호를 찾아 그 값을 index에 대입해주기
		for (int i = 0; i < point.length; i++) {
			if (min == point[i]) {
				index = i;
			}
		}

		System.out.printf("result = [%d,%d]", distance, index);

	}

}
