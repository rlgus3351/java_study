package 상속기초;

public class Main {

	public static void main(String[] args) {

		// 1. 다중상속을 지원 x
		// 2. 상속의 횟수에 제한을 두지 않는다.
		// 3. 모든 클래스는 java.lang.Object를 상속받는다.

		// Parents p 객체 생성
		Parents p = new Parents();

		// Child c 객체 생성
		Child c = new Child();

		p.makeGalbi();
		p.makeKimchi();
		c.makeKimchi();
		c.makeKal();
		p.makeKimchi();
	}
	
}
