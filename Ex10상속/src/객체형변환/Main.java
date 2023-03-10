package 객체형변환;

public class Main {

	public static void main(String[] args) {

		// 1. 객체 생성

		// Phone p1
		Phone p1 = new Phone();

		// SmartPhone iPhone
		SmartPhone iPhone = new SmartPhone();

		// Casting
		// 형변환 ---> 레퍼런스 타입의 형변환은 어떻게 일어날까?
		// 레퍼런스 타입의 형변환
		// : 상속이 전제되어 있어야하며, 객체 내 필드와 메소드의 접근 권한에 따라 결정된다.
		// 강제형변환인지 자동형변환인지 결정된다.

		// 1) UpCasting
		// : 자식(서브, 하위)클래스가 부모(슈퍼, 상위) 클래스로
		// ex) 아이폰은 핸드폰이다 ------> 말이된다. 자동으로 변환이 가능하다.

		Phone p = new SmartPhone();
		p.call();
		// 객체(하위클래스) 내에 모든 필드와 메소드에 접근할 수 있는게 아니라
		// 상위 클래스의 필드와 메소드에만 접근이 가능하다.
		p.message();
		// 오버라이딩 된 메소드에 한해서는 하위클래스가 가지고 있는 메소드를 사용한다.

		// 2) DownCasting
		// : 부모(슈퍼, 상위)클래스가 자식(서브, 하위)클래스로 강제형변환
		// 이미 Upcasting 된 객체를 Down 시킬 때 가능

		// SmartPhone sp = (SmartPhone) new Phone();
		// 문법적으로는 오류가 나지 않고 comfile 시 오류가 난다.
		// Phone 설계도만으로는 SmartPhone 객체를 만들 수 없다.
		// : 업캐스팅 된 객체를 다시 본래의 자료형을 강제로 되돌리는 것

		SmartPhone sp1 = (SmartPhone) p;
		sp1.wifi();
		sp1.message();

	}

}
