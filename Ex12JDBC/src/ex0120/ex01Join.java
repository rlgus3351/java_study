package ex0120;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ex01Join {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 사용자한테 id, pw, 이름 , 전화번호 입력받기
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("PW 입력 : ");
		String pw = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("전화 번호 입력 : ");
		String tel = sc.next();

		// JDBC

		// Runtime Error : 실행 중 발생하는 에러(문법적으로는 문제 x --> 실행 시 오류가 발생 가능성이 있어 예외처리가 필요)
		// Syntax Error : 문법 자체에 에러가 있는 것

		// try - catch : 예외처리 구문
		// 예외 상황이 발생하더라도 실행을 멈추지 않음
		// try문 안에 있는 코드를 실행
		// 만약에 예외상황이 발생한다면 실행을 멈추고 catch문을 실행
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// 1. 드라이버 동적 로딩(데이터 베이스 종류 결정)
			// 동적 로딩이란?
			// : 실행하는 순간에 자료형을 결정하는 것
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩 완료");

			// 2. DB 연결 통로를 열어주는 작업
			// ---> 접속 URL , userid, password필요
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user_id = "hr";
			String user_pw = "hr";
			conn = DriverManager.getConnection(url, user_id, user_pw);

			// 3. SQL문 준비.
			// 회원가입 >> big_member 테이블 데이터 추가
			// insert구문
			String sql = "insert into big_member values(?,?,?,?)";
			// ?인자
			// : 사용자로부터 어떤 데이터가 들어올지 모를 때 사용
			// : 지정한 데이터 공간만큼 비워놓고 실행하기 전까지 대기

			// 4. sql문 전송(실행)
			psmt = conn.prepareStatement(sql);

			// -------> 전송하기 전에 sql문을 담아서 전송할 수 있는 형식으로 변경

			// ? 인자 채우는 작업 진행 (!! 반드시 실행 전에 진행할 것!!)
			// 데이터 바인딩 (data binding)작업
			// sql index = > 1번부터

			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			psmt.setString(4, tel);

			// 반드시 물음표 인자를 전부 채워준 후에 실행해야 한다!!
			// 행의 변화의 값을 리턴해준다.

			int row = psmt.executeUpdate();
			// excuteUpdate() : insert, update, delete DML 에만 사용
			// DML : 테이블의 변화를 주는 언어들.

			// 5. 결과를 이용한 작업처리
			// 사용자한테 어떤 결과를 보여줄지 정의
			if (row > 0) {
				System.out.println("회원가입 성공");
			} else {
				System.out.println("회원가입 실패");
			}

		} catch (Exception e) {
			// 예외상황 발생 시 내용을 출력해준다.
			e.printStackTrace();
		} finally {
			// 위에서 예외 상황이 발생하더라도 반드시 한번은 들어오는 구간
			// 6. DB 연결 종료 -----> 자원 반납
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
