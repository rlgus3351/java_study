package model;

public class memberDTO {

	// DTO : Data Transfer Object 데이터를 이동할 수 있게 하는 나만의 자료형
	// Table 마다 한 개씩 갖는다.
	// Table Column들을 필드로 갖는다.
	// 접근제한자 사용후 - getter,setter 메소드 , 생성자 메소드 만들어주기

	// 필드 정의하기
	// id,pw,name,tel
	private String id;
	private String pw;
	private String name;
	private String tel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	// 모든 필드를 초기화 하는 생성자 ==> AllArgsConstructor
	public memberDTO(String id, String pw, String name, String tel) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
	}
	// 기본 생성자
	// 유연성을 확보하기 위해
	public memberDTO() {
		
	}
	

}
