package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class memberDAO {

	// Data Access Object : 데이터에 접근하는 것을 도와주는 객체
	// DB랑 연결해서 insert, delete,update,select하는 코드들의 모음
	// 메소드 형태로 코드 작성
	// 보통 SQL쿼리를 실행하고, 실행 결과 리턴 받기
	Connection conn = null;
	PreparedStatement psmt = null;
	memberDTO dto = null;
	ResultSet rs = null;

	// 중복으로 작성되고 있는 driver 동적 로딩부터 연결 생성까지 ---> 메서드로 빼기
	// 재사용
//------------------------------------------------------------------DB연결 메소드-----------------------------------------------------------//
//	public void getConn() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String user_id = "hr";
//			String user_pw = "hr";
//			conn = DriverManager.getConnection(url, user_id, user_pw);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

//------------------------------------------------------------------DB연결 메소드-----------------------------------------------------------//	
	public void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@gjaischool-b.ddns.net:1525:xe";
			
			//jdbc:oracle:thin --> protocol
			//@localhost --> 서버주소, @IP주소
			// :1521 --> port number : 1525
			// : xe --> DB 이름
			String user_id = "cgi_3_0131_3";
			String user_pw = "smhrd3";
			conn = DriverManager.getConnection(url, user_id, user_pw);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//------------------------------------------------------------------DB종료 메소드-----------------------------------------------------------//
	public void endConn() {
		// 위에서 예외 상황이 발생하더라도 반드시 한번은 들어오는 구간
		// 6. DB 연결 종료 -----> 자원 반납
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//------------------------------------------------------------------회원가입 메소드-----------------------------------------------------------//
	public int join(String id, String pw, String name, String tel) {

		int row = 0;
		try {

			getConn();
			String sql = "insert into big_member values(?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			psmt.setString(4, tel);

			row = psmt.executeUpdate();

		} catch (Exception e) {
			// 예외상황 발생 시 내용을 출력해준다.
			e.printStackTrace();
		} finally {
			endConn();

		}
		return row;

	}

//------------------------------------------------------------------로그인 메소드------------------------------------------------------------//
	public memberDTO login(String id, String pw) {

		try {

			getConn();
			String sql = "select * from big_member where id = ? and pw = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();
			if (rs.next()) {
				String uid = rs.getString(1);
				String upw = rs.getString(2);
				String uname = rs.getString("name");
				String utel = rs.getString("tel");
				uname = rs.getString("name");
				dto = new memberDTO(uid, upw, uname, utel);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			endConn();

		}
		return dto;
	}

//---------------------------------------------------------------전체 회원 목록 메소드------------------------------------------------------------//
	public ArrayList<memberDTO> user() {

		ArrayList<memberDTO> dto = new ArrayList<memberDTO>();
		try {
			// 2) 드라이버 동적 로딩

			getConn();
			String sql = "select * from big_member";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String uid = rs.getString("id");
				String upw = rs.getString("pw");
				String uname = rs.getString("name");
				String utel = rs.getString("tel");
				dto.add(new memberDTO(uid, upw, uname, utel));

			}

		} catch (Exception e) {
			// 반드시 넣어 줘야한다.
			e.printStackTrace(); // 에러를 콘솔창에 출력
		} finally {
			endConn();

		}
		return dto;
	}

//---------------------------------------------------------------회원 정보 수정 메소드------------------------------------------------------------//
	public int update(memberDTO dto) {
		int row = 0;
		try {
			getConn();
			String sql = "update big_member set name = ?, tel = ? where id = ? and pw = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTel());
			psmt.setString(3, dto.getId());
			psmt.setString(4, dto.getPw());

			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			endConn();
		}
		return row;
	}

//---------------------------------------------------------------회원 정보 탈퇴 메소드------------------------------------------------------------//
	public int delete(memberDTO dto) {
		int row = 0;
		try {
			// 2) 드라이버 동적 로딩
			getConn();
			// 4) SQL문 준비
			String sql = "delete big_member where id = ? and pw = ?";

			// 5) 실행 준비 상태 만들기
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			row = psmt.executeUpdate();
		} catch (Exception e) {
			// 반드시 넣어 줘야한다.
			e.printStackTrace(); // 에러를 콘솔창에 출력
		} finally {
			endConn();
		}
		return row;
	}

}
