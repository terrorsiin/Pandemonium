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
						if(animal.size()!=0) {//�˻� ������ ����� 0�� �ƴ� ���=�����ϴ� ��� 
							SuccessView.msg("��� �˻��� �Ϸ�Ǿ����ϴ�.");
							SuccessView.allADataPrint(animal);
						} else {
							SuccessView.msg("��û�� �����Ͱ� �������� �ʽ��ϴ�.");
						}
					} catch (SQLException e) {
						e.printStackTrace();
						FailView.errorMsg("���������� ������ �߻��Ͽ����ϴ�. ��ȿ�� ������ �ٽ� �õ��Ͻʽÿ�.");
					}
				}
			
		public void selectReqRes2(String animalId) {
				try {
					
					AnimalDTO animal = AnimalDAO.getAnimal(animalId);
					if(animal!=null) {//�����ϴ� ��� 
						SuccessView.msg("��û�� ���� DB �˻��� �Ϸ�Ǿ����ϴ�.");
						SuccessView.dataAPrint(animal);
						
					} else {
						SuccessView.msg("��û�� �����Ͱ� �������� �ʽ��ϴ�.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
				
				//�����û ���� �޼ҵ�
			public boolean insertReqRes(String animalId, String animalName, String gender, String health) {
				try {
					boolean result = AnimalDAO.addAnimal(new AnimalDTO(animalId, animalName, gender, health));
					if(result==true) {
						SuccessView.msg("���ο� ���������� �����Ǿ����ϴ�.");
					}else {
						SuccessView.msg("�������� ������ �����Ͽ����ϴ�.");
					}
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					FailView.errorMsg("���������� ������ �߻��Ͽ����ϴ�. ��ȿ�� ������ �ٽ� �õ��Ͻʽÿ�.");
					return false;
				}
			}
				
				//����
			public boolean updateReqRes(String animalId, String health) {
				try {
					boolean result = AnimalDAO.updateAnimal(animalId, health);
						if(result==true) {
						SuccessView.msg("���������� ���ŵǾ����ϴ�.");
					}else {
						SuccessView.msg("�������� ���ſ� �����Ͽ����ϴ�.");
					}
						return true;
					} catch (SQLException e) {
						e.printStackTrace();
						FailView.errorMsg("���������� ������ �߻��Ͽ����ϴ�. ��ȿ�� ������ �ٽ� �õ��Ͻʽÿ�.");
						return false;
				}
					
					
					
			}
				
				//������û ���� �޼ҵ�
				
				public boolean deleteReqRes(String animalId){
					try {
					boolean result=AnimalDAO.deleteAnimal(animalId);
					if(result==true) {
						SuccessView.msg("������ �����Ǿ����ϴ�.");
					}else {
						SuccessView.msg("�ش� ���������� �������� �ʽ��ϴ�.");
					}
					return true;
					
				} catch (SQLException e) {
					e.printStackTrace();
					FailView.errorMsg("���������� ������ �߻��Ͽ����ϴ�. ��ȿ�� ������ �ٽ� �õ��Ͻʽÿ�.");
					return false;
				}
					
				}


		
}
