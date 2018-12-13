package rescue.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rescue.model.dto.MatchingDTO;
import rescue.model.util.DBUtility;
public class MatchingDAO {
	
	public static boolean addMatching(MatchingDTO matching) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtility.getConnection();
			pstmt = con.prepareStatement("insert into matching values(?, ?, ?, ?, ?)");
			pstmt.setInt(1, matching.getMatchingId());
			pstmt.setString(2, matching.getMatchingName());
			pstmt.setString(3, matching.getAnimalId());
			pstmt.setString(4, matching.getHumanId());
			pstmt.setString(5, matching.getMatchingSitu());
			
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
	//수정
	//매칭ID로  동물 수정하기
	/*public static boolean updateMatchingAnmimal(int matchingId, String animalId) throws SQLException{		
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtility.getConnection();
			
			pstmt = con.prepareStatement("update matching set animal_id=? where matching_id=?");
			pstmt.setString(1, animalId);
			pstmt.setInt(2, matchingId);
			
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
	
	//수정
	//매칭ID로  사람 수정하기
	public static boolean updateMatchingHuman(int matchingId, String humanId) throws SQLException{		
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtility.getConnection();
			
			pstmt = con.prepareStatement("update matching set human_id=? where matching_id=?");
			pstmt.setString(1, humanId);
			pstmt.setInt(2, matchingId);
			
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
	*/
	
	
	public static boolean updateMatching(int matchingId, String matchingSitu) throws SQLException{		
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtility.getConnection();
			
			pstmt = con.prepareStatement("update matching set matching_situ=? where matching_id=?");
			pstmt.setString(1, matchingSitu);
			pstmt.setInt(2, matchingId);
			
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
	
	//삭제 
	public static boolean deleteMatching(int matchingId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtility.getConnection();
			pstmt = con.prepareStatement("delete from matching where matching_id=?");
			pstmt.setInt(1, matchingId);
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
	
	//프로보노 프로젝트 id로 해당 프로보노프로젝트 검색
	public static MatchingDTO getMatching(int matchingId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MatchingDTO matching = null;
		
		try{
			con = DBUtility.getConnection();
			pstmt = con.prepareStatement("select * from matching where matching_id=?");
			pstmt.setInt(1, matchingId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				matching = new MatchingDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		}catch(SQLException s){
			s.printStackTrace();
			throw s;
		}finally{
			DBUtility.close(con, pstmt, rs);
		}
		return matching;
	}
	
	//모든 프로보노 프로젝트 검색 
	public static ArrayList<MatchingDTO> getAllMatchings() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MatchingDTO> list = null;
		try{
			con = DBUtility.getConnection();
			pstmt = con.prepareStatement("select * from matching");
			rs = pstmt.executeQuery();
			
			list = new ArrayList<MatchingDTO>();
			while(rs.next()){
				list.add( new MatchingDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)) );
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
