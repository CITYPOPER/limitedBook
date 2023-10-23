package limitedBook.model.prod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import limitedBook.model.prod.ProdPageInfoVO;
import limitedBook.model.prod.ProdDAO;
import limitedBook.model.prod.ProdDTO;

public class ProdDAO {
	
	private PreparedStatement pstmt = null;
	private Connection con = null;
	
	Context init = null;
	DataSource ds = null;
	
	ResultSet rs = null;
	
	public ProdDAO() {
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
	
	public boolean insertProd(ProdDTO prod) {
		
		boolean success = false;
//		dbConnect();
		String sql = "insert into prod(p_id,p_code,p_name,p_img, ";
			   sql += "p_etc,p_date)";
			   sql += "values(?,?,?,?,?,?)";
			   
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, prod.getP_id());
			pstmt.setString(2, prod.getP_code());
			pstmt.setString(3, prod.getP_name());
			pstmt.setString(4, prod.getP_img());
			pstmt.setString(5, prod.getP_etc());
			pstmt.setString(6, prod.getP_date());
			
			
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
	
	public ArrayList<ProdDTO> getProdList(){
//		dbConnect();
		ArrayList<ProdDTO> list = new ArrayList<ProdDTO>();
		
		String SQL = "select * from prod";
		try {
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ProdDTO prod = new ProdDTO();
				prod.setP_id( rs.getInt("p_id") );
				prod.setP_code( rs.getString("p_code") );
				prod.setP_name( rs.getString("p_name") );
				prod.setP_img( rs.getString("p_img") );
				prod.setP_etc( rs.getString("p_etc") );
				prod.setP_date( rs.getString("p_date") );
				list.add(prod);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return list;
	}
	
	public ArrayList<ProdDTO> getProdListForPage(ProdPageInfoVO bpiVO){
//		dbConnect();
		ArrayList<ProdDTO> list = new ArrayList<ProdDTO>();
		
		String SQL = "select * from prod ORDER BY p_id limit ?, ?";
		String SQL2 = "select count(*) from prod";
		
		ResultSet rs;
		
		try {
			pstmt = con.prepareStatement(SQL2);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bpiVO.setRecordCnt(rs.getInt(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		bpiVO.adjPageInfo();
		
		try {
			pstmt = con.prepareStatement(SQL);
			
			pstmt.setInt(1, bpiVO.getStartRecord());
			pstmt.setInt(2, bpiVO.getLimitCnt());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProdDTO prod = new ProdDTO();
				prod.setP_id( rs.getInt("p_id") );
				prod.setP_code( rs.getString("p_code") );
				prod.setP_name( rs.getString("p_name") );
				prod.setP_img( rs.getString("p_img") );
				prod.setP_etc( rs.getString("p_etc") );
				prod.setP_date( rs.getString("p_date") );
				list.add(prod);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		
		return list;
	}

	public ProdDTO getProd(int p_id) {
//		dbConnect();
		String SQL = "select * from prod where p_id = ?";
		ProdDTO prod = new ProdDTO();
		
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, p_id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			prod.setP_id( rs.getInt("p_id") );
			prod.setP_code( rs.getString("p_code") );
			prod.setP_name( rs.getString("p_name") );
			prod.setP_img( rs.getString("p_img") );
			prod.setP_etc( rs.getString("p_etc") );
			prod.setP_date( rs.getString("p_date") );;
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return prod;
	}
	
	public boolean updateProd(ProdDTO prod) {
		boolean success = false;
//		dbConnect();
		String sql = "update prod set p_code=?, p_name=?, p_img=?, p_etc=?, ";
		sql += "p_date=? where p_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, prod.getP_code());
			pstmt.setString(2, prod.getP_name());
			pstmt.setString(3, prod.getP_img());
			pstmt.setString(4, prod.getP_etc());
			pstmt.setString(5, prod.getP_date());
			pstmt.setInt(6, prod.getP_id());

			
			int rowUdt = pstmt.executeUpdate();
			
			if(rowUdt == 1) success = true;
		}catch(SQLException e) {
			e.printStackTrace();
			return success;
		}
		finally {
			disConnect();
		}
		return success;
	}
	
	public boolean deleteProd(int p_id) {
		boolean success = false;
//		dbConnect();
		String sql ="delete from prod where p_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, p_id);
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
}
