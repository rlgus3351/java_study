package Animal;

public class 기린 extends 포유류 {

	// 메소드 중복정의 : 오버로딩(한 클래스 내에서)
	// 메소드 재정의 : 오버라이딩(상속 관계에서)

	@Override
	public void 울다() {
		System.out.println("아아아앙아앙");
	}
}
