package rescue.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rescue.model.dto.AnimalDTO;
import rescue.model.util.DBUtility;

public class AnimalDAO {
	//INSERT
	public static boolean addAnimal(AnimalDTO animal) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtility.getConnection();
			pstmt = con.prepareStatement("insert into animal values(?, ?, ?, ?)");
			pstmt.setString(1, animal.getId());
			pstmt.setString(2, animal.getName());
			pstmt.setString(3, animal.getGender());
			pstmt.setString(4, animal.getHealth());
			
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
	public static boolean updateAnimal(String animalId, String health) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtility.getConnection();
			
			pstmt = con.prepareStatement("update animal set Health=? where Animal_id=?");
			pstmt.setString(1, health);
			pstmt.setString(2, animalId);
			
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
	public static boolean deleteAnimal(String animalId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtility.getConnection();
			pstmt = con.prepareStatement("delete from animal where animal_id=?");
			pstmt.setString(1, animalId);
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
	public static AnimalDTO getAnimal(String animalId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AnimalDTO animal = null;
		
		try{
			con = DBUtility.getConnection();
			pstmt = con.prepareStatement("select * from animal where animal_id=?");
			pstmt.setString(1, animalId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				animal = new AnimalDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}			
		}finally{
			DBUtility.close(con, pstmt, rs);
		}
		return animal;
	}

	//SELECT ALL
	public static ArrayList<AnimalDTO> getAllAnimals() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<AnimalDTO> list = null;
		try{
			con = DBUtility.getConnection();
			pstmt = con.prepareStatement("select * from animal");
			rs = pstmt.executeQuery();
			list = new ArrayList<AnimalDTO>();
			while(rs.next()){
				list.add(new AnimalDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
