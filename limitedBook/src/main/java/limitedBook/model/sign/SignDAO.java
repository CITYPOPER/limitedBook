package limitedBook.model.sign;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import limitedBook.model.sign.SignDTO;

public class SignDAO {
	
	private PreparedStatement pstmt = null;
	private Connection con = null;
	
	Context init = null;
	DataSource ds = null;
	
	ResultSet rs = null;
	
	public SignDAO() {
		super();
		dbConnect();
	}
	
	public void dbConnect() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc_mariadb2");
			con = ds.getConnection();
			
			System.out.println("DB연결 성공!!!");
		}catch(Exception e) {
			System.out.println("DB연결 실패!!!");
			e.printStackTrace();
		}
	}
	
	public void disConnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean insertSign(SignDTO sign) {
		
		boolean success = false;
//		dbConnect();
		String sql = "insert into signup(signup_num,signup_name,signup_email,signup_password)";
			   sql += "values(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sign.getSignup_num());
			pstmt.setString(2, sign.getSignup_name());
			pstmt.setString(3, sign.getSignup_email());
			pstmt.setString(4, sign.getSignup_password());

			
			
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		}
		finally {
			disConnect();
		}
		return success;
	}
	
	public boolean loginSign(SignDTO sign) {
		
		boolean success = false;
//		dbConnect();
		String sql = "SELECT * FROM signup WHERE signup_email = ?";
		sql += " AND signup_password = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sign.getSignup_email());
			pstmt.setString(2, sign.getSignup_password());

			
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				success = true;
			}else {
				success = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return success;
		}
		finally {
			disConnect();
		}
		return success;
	}

}
