package Music;

import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class MusicPlayer {
	// 전역변수 선언
	static ArrayList<MusicDTO> musicList = null;
	static MP3Player mp3 = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 5개의 음악이 담긴 뮤직 플레이어

		// int -> Integer : Wrapper Class

		musicList = new ArrayList<>();
		mp3 = new MP3Player();

		musicList.add(new MusicDTO("뉴진스", "Hype boy", "C:/mp3/뉴진스-HypeBoy.mp3"));
		musicList.add(new MusicDTO("르세라핌", "Antifragile", "C:/mp3/르세라핌-Antifragile.mp3"));
		musicList.add(new MusicDTO("아이브", "LoveDive", "C:/mp3/아이브-LoveDive.mp3"));
		musicList.add(new MusicDTO("윤하", "사건의지평선", "C:/mp3/윤하-사건의지평선.mp3"));
		musicList.add(new MusicDTO("카라", "WhenIMove", "C:/mp3/카라-WhenIMove.mp3"));

		int index = 0; // 현재 재생되고 있는 음악의 인덱스.
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("메뉴를 선택하세요 >> ");
			System.out.print("[1] 재생 [2] 검색 [3] 노래 추가 [4] 노래 삭제 [5] 종료 >> ");
			int menu = sc.nextInt();
			if (menu == 1) {
				// 재생
				playSong(index);

				while (true) {
					System.out.print("[1] 정지 [2] 이전 곡 [3] 다음 곡 [4] 이전 메뉴 >> ");
					int input = sc.nextInt();

					if (input == 1) {
						// 정지
						mp3.stop();
					} else if (input == 2) {
						// 이전 곡
						mp3.stop();
						if (mp3.isPlaying() == true) {
							mp3.stop();
						}
						index--;
						if (index == -1) {
							index = musicList.size() - 1;
						}
						playSong(index);
					} else if (input == 3) {
						// 다음 곡
						if (mp3.isPlaying() == true) {
							mp3.stop();
						}
						index++;
						// 만약, index가 범위를 벗어난다면
						// index를 다시 0으로
						if (index == musicList.size()) {
							index = 0;
						}

						playSong(index);
					} else if (input == 4) {
						break;
					}

				}
			} else if (menu == 2) {
				// 노래 검색
			} else if (menu == 3) {
				// 노래 추가
			} else if (menu == 4) {
				// 노래삭제
			} else if (menu == 5) {
				// 종료
				System.out.print("종료되었습니다.");
				break;
			} else {
				System.out.print("잘못 입력하셨습니다.");
			}

		}

	}

	public static void playSong(int index) {
		String singer = musicList.get(index).getSinger();
		String title = musicList.get(index).getTitle();
		String path = musicList.get(index).getPath();

		mp3.play(path);
		System.out.printf("%s-%s%n", singer, title);
	}
}
