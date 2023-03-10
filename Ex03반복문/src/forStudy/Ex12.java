package forStudy;

public class Ex12 {

	public static void main(String[] args) {
		// 문제 12.
		// 2~30까지의 약수를 구하세요.
		// 2의 약수
		for (int j = 1; j <= 2; j++) { // 2의 약수를 구하려면 2보다 큰 수는 범위에서 제외되므로 1부터 2까지 조건문 범위를 지정해준다.
			if (2 % j == 0) { // 2의 약수를 구하려면 2로 나머지 연산을 했을 때 0이 나오면 2의 약수이다.
//				System.out.println(j);
			}
		}
		System.out.println();
		// 3의 약수
		for (int j = 1; j <= 3; j++) {// 3의 약수를 구하려면 3보다 큰 수는 범위에서 제외되므로 1부터 3까지 조건문 범위를 지정해준다.
			if (3 % j == 0) {// 3의 약수를 구하려면 2로 나머지 연산을 했을 때 0이 나오면 3의 약수이다.
//				System.out.println(j);
			}
		}

		// 다중 for문
		for (int i = 2; i <= 30; i++) { // 2부터 30까지의 약수를 구하려면 초기값은 2부터 30까지 범위를 설정해주며 1씩 증가하게 조건문 범위를 지정한다.
			System.out.printf("%d의 약수 : ", i); // i의 값이 증가 될 때마다 무슨 수의 약수인지 확인하기 위한 출력문 생성
			for (int j = 1; j <= i; j++) { // i의 약수를 구하려면 범위는 1부터 i까지 범위를 설정해주고
				if (i % j == 0) { // i의 약수를 구하려면 j의 값이 증가될 때마다 나누어 떨어지는 값을 출력해준다.
					System.out.print(j + " "); // j의 값은 i의 약수이므로 출력해준다.
				}

			}
			System.out.println(); // for_2번째 구문이 끝나면 해당 i의 약수는 다 구해졌으므로 한 줄을 띄어 구분해준다.
		}

	}

}
