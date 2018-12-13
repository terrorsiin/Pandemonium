package rescue.controll;

import java.sql.SQLException;
import java.util.ArrayList;

import rescue.view.FailView;
import rescue.view.HumanView;
import rescue.view.SuccessView;
import rescue.model.dao.HumanDAO;
import rescue.model.dto.HumanDTO;

public class HumanController {
	private static HumanController instance = new HumanController();

		private HumanController() {}

		public static HumanController getInstance() {
					return instance;
		}
				
		
		public void humanMap() {
			HumanView.SelectView(null);
		}
		
				
	public void selectReqRes(){
			try {
					ArrayList<HumanDTO> human = HumanDAO.getAllHumans();
						if(human.size()!=0) {//�˻� ������ ����� 0�� �ƴ� ���=�����ϴ� ��� 
							SuccessView.msg("��� �˻��� �Ϸ�Ǿ����ϴ�.");
							SuccessView.allHDataPrint(human);
						} else {
							SuccessView.msg("��û�� �����Ͱ� �������� �ʽ��ϴ�.");
						}
					} catch (SQLException e) {
						e.printStackTrace();
						FailView.errorMsg("���������� ������ �߻��Ͽ����ϴ�. ��ȿ�� ������ �ٽ� �õ��Ͻʽÿ�.");
					}
				}
			
			public void selectReqRes2(String HumanId) {
				try {
					
					HumanDTO human = HumanDAO.getHuman(HumanId);
					if(human!=null) {//�����ϴ� ��� 
						SuccessView.msg("��û�� ȸ���� �˻��� �Ϸ�Ǿ����ϴ�.");
						SuccessView.dataHPrint(human);
						
					} else {
						SuccessView.msg("��û�� �����Ͱ� �������� �ʽ��ϴ�.");
						FailView.errorMsg("���������� ������ �߻��Ͽ����ϴ�. ��ȿ�� ������ �ٽ� �õ��Ͻʽÿ�.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
				
				//�����û ���� �޼ҵ�
				public boolean insertReqRes(String humanId, String humanName, String gender, String favorite) {
					try {
						boolean result = HumanDAO.addHuman(new HumanDTO(humanId, humanName, gender, favorite));
						if(result==true) {
							SuccessView.msg("���ο� ȸ�������� �����Ǿ����ϴ�.");
						}else {
							SuccessView.msg("ȸ������ ������ �����Ͽ����ϴ�.");
						}
						return true;
					} catch (SQLException e) {
						e.printStackTrace();
						FailView.errorMsg("���������� ������ �߻��Ͽ����ϴ�. ��ȿ�� ������ �ٽ� �õ��Ͻʽÿ�.");
						return false;
					}
					
					
				}
				
				public boolean updateReqRes(String humanId, String favorite) {
					try {
						boolean result = HumanDAO.updateHuman(humanId, favorite);
						if(result==true) {
							SuccessView.msg("ȸ�������� ���ŵǾ����ϴ�.");
						}else {
							SuccessView.msg("ȸ������ ���ſ� �����Ͽ����ϴ�.");
						}
						return true;
					} catch (SQLException e) {
						e.printStackTrace();
						FailView.errorMsg("���������� ������ �߻��Ͽ����ϴ�. ��ȿ�� ������ �ٽ� �õ��Ͻʽÿ�.");
						return false;
					}
				}
				
				//������û ���� �޼ҵ�
				
				public boolean deleteReqRes(String humanId){
					try {
					boolean result=HumanDAO.deleteHuman(humanId);
					if(result==true) {
						SuccessView.msg("ȸ���� �����Ǿ����ϴ�.");
					}else {
						SuccessView.msg("�ش� ȸ�������� �������� �ʽ��ϴ�.");
					}
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					FailView.errorMsg("���������� ������ �߻��Ͽ����ϴ�. ��ȿ�� ������ �ٽ� �õ��Ͻʽÿ�.");
					return false;
				}
					
				}

		
}
