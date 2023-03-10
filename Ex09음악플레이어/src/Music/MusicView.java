package Music;

import java.util.Scanner;

public class MusicView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Model : MusicDTO, Music DAO
		// View : MusicView
		// Controller : MusicCon

		Scanner sc = new Scanner(System.in);

		MusicCon con = new MusicCon();
		// 사용하지 않는 클래스 import 해제
		// Ctrl + Shift + o
		int index = 0;

		System.out.println("==========뮤직 플레이어==========");
		while (true) {

			System.out.print("[1] 재생 [2] 종료 >> ");
			int menu = sc.nextInt();
			if (menu == 1) {
				// 재생
				con.play(index);

				while (true) {

					System.out.print("[1] 정지 [2] 이전 곡 [3] 다음 곡 [4] 이전 메뉴 >> ");
					int input = sc.nextInt();
					if (input == 1) {
						con.stop();
						// 정지
					} else if (input == 2) {
						// 이전 곡
						index--;
						if (index == -1) {
							index = 5;
						}
						con.play(index);
					} else if (input == 3) {
						// 다음곡
						index++;
						if (index == 5) {
							index = 0;
						}
						con.play(index);
					} else if (input == 4) {
						break;
					}

				}

			} else if (menu == 2) {
				// 종료
				System.out.println("종료 되었습니다.");
				break;
			}

		}

	}

}
