package rescue.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import rescue.exception.NotExistException;
import rescue.model.dto.*;


//�Ŵ���
public class MatchingManagement {
	private static MatchingManagement instance = new MatchingManagement();
	
	private MatchingManagement(){}
	
	public static MatchingManagement getInstance(){
		return instance;
	}
		
	
	//Animal CRUD ���
	public static void notExistAnimal(String animalId) throws NotExistException, SQLException{
		AnimalDTO animal = AnimalDAO.getAnimal(animalId);
		if(animal == null){
			throw new NotExistException("�������� �ʴ� ���������Դϴ�.");
		}
	}
	public static boolean addAnimal(AnimalDTO animal) throws SQLException{
		return AnimalDAO.addAnimal(animal);	
	}
	public static boolean updateAnimal(String animalId, String health) throws SQLException, NotExistException{
		notExistAnimal(animalId);
		return AnimalDAO.updateAnimal(animalId, health);
	}
	public boolean deleteAnimal(String animalId) throws SQLException, NotExistException{
		notExistAnimal(animalId);
		return AnimalDAO.deleteAnimal(animalId);
	}
	public static AnimalDTO getAnimal(String animalId) throws SQLException, NotExistException{
		AnimalDTO animal = AnimalDAO.getAnimal(animalId);
		if(animal == null){
			throw new NotExistException("�������� �ʴ� ���� �����Դϴ�.");
		}
		return animal;
	}
	public static ArrayList<AnimalDTO> getAllanimals() throws SQLException{
		return AnimalDAO.getAllAnimals();
	}
	
	
	
	//Human - CRUD
	/*public static void notExistHuman(String HumanId) throws NotExistException, SQLException{
		HumanDTO Human = HumanDAO.getHuman(HumanId);
		if(Human == null){
			throw new NotExistException("�������� �ʴ� ȸ�������Դϴ�.");
		}
	}
	public static boolean addHuman(HumanDTO Human) throws SQLException{
		return HumanDAO.addHuman(Human);
	}
	public static boolean updateHuman(String HumanId, String favorite) throws SQLException, NotExistException{
		notExistHuman(HumanId);
		return HumanDAO.updateHuman(HumanId, favorite);
	}
	public boolean deleteHuman(String HumanId) throws SQLException, NotExistException{
		notExistHuman(HumanId);
		return HumanDAO.deleteHuman(HumanId);
	}
	public static HumanDTO getHuman(String HumanId) throws SQLException{
		return HumanDAO.getHuman(HumanId);
	}
	public static ArrayList<HumanDTO> getAllHumans() throws SQLException{
		return HumanDAO.getAllHumans();
	}*/
	
	public static void notExistHuman(String humanId) throws NotExistException, SQLException{
		HumanDTO human = HumanDAO.getHuman(humanId);
		if(human == null){
			throw new NotExistException("�������� �ʴ� ȸ�������Դϴ�.");
		}
	}
	public static boolean addHuman(HumanDTO human) throws SQLException{
		return HumanDAO.addHuman(human);	
	}
	public static boolean updateHuman(String humanId, String favorite) throws SQLException, NotExistException{
		notExistAnimal(humanId);
		return HumanDAO.updateHuman(humanId, favorite);
	}
	public boolean deleteHuman(String humanId) throws SQLException, NotExistException{
		notExistAnimal(humanId);
		return HumanDAO.deleteHuman(humanId);
	}
	public static HumanDTO getHuman(String humanId) throws SQLException, NotExistException{
		HumanDTO human = HumanDAO.getHuman(humanId);
		if(human == null){
			throw new NotExistException("�������� �ʴ� ȸ�������Դϴ�.");
		}
		return human;
	}
	public static ArrayList<HumanDTO> getAllHumans() throws SQLException{
		return HumanDAO.getAllHumans();
	}
	
	
	//��Ī - CRUD
	public static void notExistMatching(int matchingId) throws NotExistException, SQLException{
		MatchingDTO matching = MatchingDAO.getMatching(matchingId);
		if(matching == null){
			throw new NotExistException("�������� �ʴ� ��Ī �����Դϴ�.");
		}
	}
	public static boolean addMatching(MatchingDTO matching) throws SQLException{
		return MatchingDAO.addMatching(matching);
	}
	public static boolean updateMatching(int matchingId, String matchingSitu) throws SQLException, NotExistException{
		notExistMatching(matchingId);
		return MatchingDAO.updateMatching(matchingId, matchingSitu);
	}
/*	public static boolean updateMatchingHuman(int matchingId, String  humanId) 	throws SQLException, NotExistException{
		notExistMatching(matchingId);
		return MatchingDAO.updateMatchingHuman(matchingId, humanId);*/
	
	public static boolean deleteMatching(int matchingId) throws SQLException, NotExistException{
		notExistMatching(matchingId);
		return MatchingDAO.deleteMatching(matchingId);
	}
	
	//���κ���������Ʈ id�� ���� ���� �˻��ϴ� �޼ҵ� 
	public static MatchingDTO getMatching(int matchingId) throws SQLException, NotExistException{
		MatchingDTO matching = MatchingDAO.getMatching(matchingId);
		if(matching == null){
			throw new NotExistException("�������� �ʴ� ��Ī �����Դϴ�.");
		}
		return matching;
	}
	
	public static ArrayList<MatchingDTO> getAllMatchings() throws SQLException{
		return MatchingDAO.getAllMatchings();
	}
	
	
	
}
