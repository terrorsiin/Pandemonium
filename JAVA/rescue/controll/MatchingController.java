package rescue.controll;

import java.sql.SQLException;
import java.util.ArrayList;

import rescue.view.FailView;
import rescue.view.MatchingView;
import rescue.view.SuccessView;
import rescue.model.dao.MatchingDAO;
import rescue.model.dto.MatchingDTO;


public class MatchingController {

	private static MatchingController instance = new MatchingController();

		public MatchingController() {}

			public static MatchingController getInstance() {
				return instance;
			}
			
			
			
			
			public void matchingMap() {
				MatchingView.SelectView(null);
			}
			
			
		public void selectReqRes(){
			try {
					ArrayList<MatchingDTO> matching = MatchingDAO.getAllMatchings();
					if(matching.size()!=0) {//�˻� ������ ����� 0�� �ƴ� ���=�����ϴ� ��� 
						SuccessView.msg("��� �˻��� �Ϸ�Ǿ����ϴ�.");
						SuccessView.allMDataPrint(matching);
					} else {
						SuccessView.msg("��û�� �����Ͱ� �������� �ʽ��ϴ�.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
					FailView.errorMsg("���������� ������ �߻��Ͽ����ϴ�. ��ȿ�� ������ �ٽ� �õ��Ͻʽÿ�.");
				}
			}

		
		public void selectReqRes2(int matchingId) {
			try {
				
				MatchingDTO matching = MatchingDAO.getMatching(matchingId);
				if(matching!=null) {//�˻� ������ ����� 0�� �ƴ� ���=�����ϴ� ��� 
					SuccessView.msg("��û�� ��Ī DB �˻��� �Ϸ�Ǿ����ϴ�.");
					SuccessView.dataMPrint(matching);
					
				} else {
					SuccessView.msg("��û�� �����Ͱ� �������� �ʽ��ϴ�.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

			
			//�����û ���� �޼ҵ�
			public boolean insertReqRes(int matchingId, String matchingName, String animalId, String humanId, String matchingSitu) {
				try {
					boolean result = MatchingDAO.addMatching(new MatchingDTO(matchingId, matchingName, animalId, humanId, matchingSitu));
					if(result==true) {
						SuccessView.msg("���ο� ��Ī�� �����Ǿ����ϴ�.");
				
					}else {
						SuccessView.msg("��Ī ������ �����Ͽ����ϴ�.");
					}
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					FailView.errorMsg("���������� ������ �߻��Ͽ����ϴ�. ��ȿ�� ������ �ٽ� �õ��Ͻʽÿ�.");
					return false;
				}
				
				
			}
			
			
			public boolean updateReqRes(int matchingId, String matchingSitu) {
				try {
					boolean result = MatchingDAO.updateMatching(matchingId, matchingSitu);
					if(result==true) {
						SuccessView.msg("��Ī�� ���ŵǾ����ϴ�.");
				
					}else {
						SuccessView.msg("��Ī ������ �����Ͽ����ϴ�.");
					}
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					FailView.errorMsg("���������� ������ �߻��Ͽ����ϴ�. ��ȿ�� ������ �ٽ� �õ��Ͻʽÿ�.");
					return false;
				}
				
				
			}
			
			
			//������û ���� �޼ҵ�
			
			public boolean deleteReqRes(int matchingId){
				try {
				boolean result=MatchingDAO.deleteMatching(matchingId);
				if(result==true) {
					SuccessView.msg("��Ī DB�� �����Ǿ����ϴ�.");
				}else {
					SuccessView.msg("�ش� ��Ī������ �������� �ʽ��ϴ�.");
				}
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				FailView.errorMsg("���������� ������ �߻��Ͽ����ϴ�. ��ȿ�� ������ �ٽ� �õ��Ͻʽÿ�.");
				return false;
			}
			}
}

