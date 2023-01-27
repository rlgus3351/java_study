package javaproject;

import java.util.Arrays;
import java.util.Scanner;

public class Ex36 {

	public static void main(String[] args) {
		// 스캐너 가져오기, 알파벳 빈도수 구하기 출력, 입력칸 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("==== 알파벳 빈도수 구하기 ====");
		System.out.print("입력 >>> ");

		// 알파벳의 비교하여 개수를 담을 배열 선언.
		int[] word_count = new int[26];
		// 알파벳 string타입으로 저장
		String text = sc.nextLine();
		String lowerText = text.toLowerCase(); // 입력받은 텍스트를 모두 소문자로 변환
		String alphabet = "abcdefghijklmnopqrstuvwxyz"; // 비교할 소문자 알파벳을 string 타입으로 저장

//------------------------------------------------------------------------배열 비교------------------------------------------------------------------------//
		for (int i = 0; i < lowerText.length(); i++) { // 입력한 텍스트와 알파벳 a~z까지 비교하는 조건문
			for (int j = 0; j < alphabet.length(); j++) {
				if (lowerText.charAt(i) == alphabet.charAt(j)) { // i는 입력한 텍스트의 인덱스, j는 알파벳 비교 a~z까지의 j값.
					word_count[j] += 1; // 비교하여 맞으면 word_count의 값 j는 알파벳 인덱스의 값과 같으므로 a가 있으면 0번째 인덱스의 값을 증가.
				}
			}
		}
//------------------------------------------------------------------------배열 출력------------------------------------------------------------------------//
		for (int i = 0; i < word_count.length; i++) {
			System.out.println((char) ('a' + i) + ":" + word_count[i]);
		}
	}

}
