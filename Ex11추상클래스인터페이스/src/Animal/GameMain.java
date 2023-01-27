package Animal;

import java.util.Scanner;

public class GameMain extends PlusGame {

	public static void main(String[] args) {
		PlusGame game = new PlusGame();
		Scanner sc = new Scanner(System.in);
		while (true) {

			game.makeRandom();
			game.quiz();
			int answer = sc.nextInt();
			if (game.checkAnswer(answer)) {
				System.out.println("정답입니다.");
				game.rankUp();
			} else {
				System.out.println("오답입니다.");
			}
		}

	}
}
