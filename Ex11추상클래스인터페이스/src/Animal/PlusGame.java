package Animal;

import java.util.Random;

public class PlusGame implements IGame {

	int num1;
	int num2;
	int level = 9;
	int result;
	Random r = new Random();

	public void rankUp() {
		level *= 10;
	}


	@Override
	public void makeRandom() {
		num1 = r.nextInt(level) + 1;
		num2 = r.nextInt(level) + 1;
	}

	@Override
	public void quiz() {
		System.out.printf("%d + %d = ", num1, num2);
	}

	@Override
	public boolean checkAnswer(int answer) {
		return answer == num1 + num2;

	}

}
