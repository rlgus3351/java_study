package ex0125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex04selectAll {

	public static void main(String[] args) {

		// 모든 회원의 아이디, 이름, 전화번호 출력하기

		// select * from big_member
		// 아이디 이름 전화번호
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {

			// 2) 드라이버 동적 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 3) DB 연결 통로 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user_id = "hr";
			String user_pw = "hr";
			conn = DriverManager.getConnection(url, user_id, user_pw);

			// 4) SQL문 준비
			String sql = "select * from big_member";

			// 5) 실행 준비 상태 만들기
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			System.out.printf("아이디\t 이름\t 전화번호\t\n");
			while (rs.next()) {
				String uid = rs.getString("id");
				String uname = rs.getString("name");
				String utel = rs.getString("tel");
				System.out.printf("%s\t %s\t %s\n", uid, uname, utel);
			}

		} catch (Exception e) {
			// 반드시 넣어 줘야한다.
			e.printStackTrace(); // 에러를 콘솔창에 출력
		} finally {
			try {
				// 8) 사용했던 객체들 담기 (나중에 만들어진 순서대로)
				if (rs != null) {
					rs.close();
				}
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
