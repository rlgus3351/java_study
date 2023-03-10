package ArrayList기초;

import java.util.ArrayList;

public class Ex02PersonMain {

	public static void main(String[] args) {

		// 1. Person 자료형을 보관할 수 있는 pList라는 이름을 가진 ArrayList 생성하기

		ArrayList<Person> pList = new ArrayList<Person>();

		// 2. 데이터 추가하기(팀원 데이터 추가하기)
		// Person p1 = new Person("임경남",20);
		// pList.add(p1);
		pList.add(new Person("권기현", 26));
		pList.add(new Person("왕지강", 20));
		pList.add(new Person("이세미", 25));
		pList.add(new Person("김연우", 23));
		pList.add(new Person("심형선", 20));

		// 3. 팀원 이름 출력하기!
//		System.out.println(pList.get(2).getName());

		// 4. 팀원 이름, 나이 전부 출력하기
		for (int i = 0; i < pList.size(); i++) {
			System.out.println(pList.get(i).getName() + "\t" + pList.get(i).getAge());

		}
		// for-each문
		// 배열의 크기를 몰라도 배열의 크기만큼 조건문이 돈다.
		for (Person p : pList) {
			System.out.println(p.getName() + "\t" + p.getAge());
		}

	}

}
