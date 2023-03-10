package ex0125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Ex03Update {

	public static void main(String[] args) {

		// 회원 정보를 수정하는 기능
		Scanner sc = new Scanner(System.in);
		// 1. id, pw, name, tel을 입력받기
		System.out.println("====회원 정보 수정====");
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("PW 입력 : ");
		String pw = sc.next();

		Connection conn = null;
		PreparedStatement psmt = null;

		// 2. 회원의 pw, name, tel를 수정해주는 프로그램 작성.
		System.out.print("수정할 이름 입력 : ");
		String updateName = sc.next();
		System.out.print("수정할 전화번호 입력 : ");
		String updateTel = sc.next();

		// 1) 드라이버 동적 할당
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user_id = "hr";
			String user_pw = "hr";
			conn = DriverManager.getConnection(url, user_id, user_pw);
			// Update
			String sql = "update big_member set name = ?, tel = ? where id = ? and pw = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, updateName);
			psmt.setString(2, updateTel);
			psmt.setString(3, id);
			psmt.setString(4, pw);

			int row = psmt.executeUpdate();
			if (row > 0) {
				System.out.println("회원정보 수정 성공");
			} else {
				System.out.println("아이디와 비밀번호를 확인하세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
