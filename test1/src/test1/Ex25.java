package test1;

import java.util.Random;

public class Ex25 {
	public static void main(String[] args) {

		Random r = new Random();

		int[] point = { 92, 32, 52, 9, 81, 2, 68 };

		int num1 = r.nextInt(6) + 1;
		int num2 = r.nextInt(6) + 1;
		int dis = 0;
		int min = 0;
		int index = 0;
		if (num1 != num2) {
			System.out.println(num1 + " " + num2);

			if (num1 > num2) {
				dis = num1 - num2;
				min = point[num2];
				for (int i = num2; i <= num1; i++) {
					if (min > point[i]) {
						min = point[i];
					}
				}
			}
			if (num1 < num2) {
				dis = num2 - num1;
				min = point[num1];
				for (int i = num1; i <= num2; i++) {
					if (min > point[i]) {
						min = point[i];
					}
				}
			}

			for (int i = 0; i < point.length; i++) {
				if (min == point[i]) {
					index = i;
				}

			}

		}

		System.out.printf("result = [%d,%d]", dis, index);

	}
}
