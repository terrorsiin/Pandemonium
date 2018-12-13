package rescue.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rescue.model.dto.HumanDTO;
import rescue.model.util.DBUtility;

public class HumanDAO {
	//INSERT
	public static boolean addHuman(HumanDTO human) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtility.getConnection();
			pstmt = con.prepareStatement("insert into human values(?, ?, ?, ?)");
			pstmt.setString(1, human.getId());
			pstmt.setString(2, human.getName());
			pstmt.setString(3, human.getGender());
			pstmt.setString(4, human.getFavorite());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtility.close(con, pstmt);
		}
		return false;
	}

	//UPDATE
	public static boolean updateHuman(String humanId, String favorite) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtility.getConnection();
			
			pstmt = con.prepareStatement("update human set favorite=? where Human_id=?");
			pstmt.setString(1, favorite);
			pstmt.setString(2, humanId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}		
		}finally{
			DBUtility.close(con, pstmt);
		}
		return false;
	}


	//DELETE
	public static boolean deleteHuman(String humanId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtility.getConnection();
			pstmt = con.prepareStatement("delete from human where human_id=?");
			pstmt.setString(1, humanId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}catch(SQLException s){
			s.printStackTrace();
			throw s;
		}finally{
			DBUtility.close(con, pstmt);
		}
		return false;
	}

	//SELECT(id)
	public static HumanDTO getHuman(String humanId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HumanDTO human = null;
		
		try{
			con = DBUtility.getConnection();
			pstmt = con.prepareStatement("select * from human where human_id=?");
			pstmt.setString(1, humanId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				human = new HumanDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}			
		}finally{
			DBUtility.close(con, pstmt, rs);
		}
		return human;
	}

	//SELECT ALL
	public static ArrayList<HumanDTO> getAllHumans() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<HumanDTO> list = null;
		try{
			con = DBUtility.getConnection();
			pstmt = con.prepareStatement("select * from human");
			rs = pstmt.executeQuery();
			
			list = new ArrayList<HumanDTO>();
			while(rs.next()){
				list.add(new HumanDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)) );
			}
		}catch(SQLException s){
			s.printStackTrace();
			throw s;
		}finally{
			DBUtility.close(con, pstmt, rs);
		}
		return list;
	}
}