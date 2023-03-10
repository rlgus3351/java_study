package ArrayList기초;

import java.util.ArrayList;

public class Ex복습 {

	public static void main(String[] args) {

		// Java에서 배열
		// 인덱스를 통해 접근
		// 크기가 정해진다(생성)

		int[] array;
		array = new int[5];
		// Java 1.1
		String name = new String("asd");

		// 자료구조 (Data Structure)
		// 배열 : 인덱스를 사용, 첨자를 사용한다.

		// List 인터페이스를 구현받아서

		// get --> return 값이 object타입
		// <> : Generic -> 강한 타입 체크
		// Java 1.8 이상부터 생성시 타입체크 생략가능
		ArrayList<String> musicList = new ArrayList<>();
		
		// add(요소), add(index, 요소)
		musicList.add("Hype boy");
		musicList.add("안티프레즐");
		musicList.add("사건의 지평선");
		musicList.add("Love Dive");
		musicList.add("When I Move");
		
		// remove(index)
//		musicList.remove(3);
		
		//clear()
//		musicList.clear();
		
		//인덱스 0번이 b를 가지고 있는지.
		System.out.println(musicList.get(0).contains("b"));
		
		
		// get(index)
//		System.out.println(musicList.get(2));
		
		for (int i = 0; i < musicList.size(); i++) {
			System.out.println(musicList.get(i));	
		}
		
		System.out.println("여기도착");
		
	}

}
