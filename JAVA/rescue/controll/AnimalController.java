package rescue.controll;

import java.sql.SQLException;
import java.util.ArrayList;

import rescue.view.AnimalView;
import rescue.view.FailView;
import rescue.view.SuccessView;
import rescue.model.dao.AnimalDAO;
import rescue.model.dto.AnimalDTO;

public class AnimalController {
	private static AnimalController instance = new AnimalController();

		private AnimalController() {}

		public static AnimalController getInstance() {
					return instance;
		}
				
		
	public void animalMap() {
		AnimalView.SelectView(null);
	}

				
	public void selectReqRes(){
			try {
					ArrayList<AnimalDTO> animal = AnimalDAO.getAllAnimals();
						if(animal.size()!=0) {//검색 데이터 사이즈가 0이 아닌 경우=존재하는 경우 
							SuccessView.msg("모든 검색이 완료되었습니다.");
							SuccessView.allADataPrint(animal);
						} else {
							SuccessView.msg("요청한 데이터가 존재하지 않습니다.");
						}
					} catch (SQLException e) {
						e.printStackTrace();
						FailView.errorMsg("비정상적인 실행이 발생하였습니다. 유효한 값으로 다시 시도하십시오.");
					}
				}
			
		public void selectReqRes2(String animalId) {
				try {
					
					AnimalDTO animal = AnimalDAO.getAnimal(animalId);
					if(animal!=null) {//존재하는 경우 
						SuccessView.msg("요청한 동물 DB 검색이 완료되었습니다.");
						SuccessView.dataAPrint(animal);
						
					} else {
						SuccessView.msg("요청한 데이터가 존재하지 않습니다.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
				
				//저장요청 조절 메소드
			public boolean insertReqRes(String animalId, String animalName, String gender, String health) {
				try {
					boolean result = AnimalDAO.addAnimal(new AnimalDTO(animalId, animalName, gender, health));
					if(result==true) {
						SuccessView.msg("새로운 동물정보가 생성되었습니다.");
					}else {
						SuccessView.msg("동물정보 생성이 실패하였습니다.");
					}
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					FailView.errorMsg("비정상적인 실행이 발생하였습니다. 유효한 값으로 다시 시도하십시오.");
					return false;
				}
			}
				
				//갱신
			public boolean updateReqRes(String animalId, String health) {
				try {
					boolean result = AnimalDAO.updateAnimal(animalId, health);
						if(result==true) {
						SuccessView.msg("동물정보가 갱신되었습니다.");
					}else {
						SuccessView.msg("동물정보 갱신에 실패하였습니다.");
					}
						return true;
					} catch (SQLException e) {
						e.printStackTrace();
						FailView.errorMsg("비정상적인 실행이 발생하였습니다. 유효한 값으로 다시 시도하십시오.");
						return false;
				}
					
					
					
			}
				
				//삭제요청 조절 메소드
				
				public boolean deleteReqRes(String animalId){
					try {
					boolean result=AnimalDAO.deleteAnimal(animalId);
					if(result==true) {
						SuccessView.msg("동물이 삭제되었습니다.");
					}else {
						SuccessView.msg("해당 동물정보는 존재하지 않습니다.");
					}
					return true;
					
				} catch (SQLException e) {
					e.printStackTrace();
					FailView.errorMsg("비정상적인 실행이 발생하였습니다. 유효한 값으로 다시 시도하십시오.");
					return false;
				}
					
				}


		
}
