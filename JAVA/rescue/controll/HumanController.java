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
						if(human.size()!=0) {//검색 데이터 사이즈가 0이 아닌 경우=존재하는 경우 
							SuccessView.msg("모든 검색이 완료되었습니다.");
							SuccessView.allHDataPrint(human);
						} else {
							SuccessView.msg("요청한 데이터가 존재하지 않습니다.");
						}
					} catch (SQLException e) {
						e.printStackTrace();
						FailView.errorMsg("비정상적인 실행이 발생하였습니다. 유효한 값으로 다시 시도하십시오.");
					}
				}
			
			public void selectReqRes2(String HumanId) {
				try {
					
					HumanDTO human = HumanDAO.getHuman(HumanId);
					if(human!=null) {//존재하는 경우 
						SuccessView.msg("요청한 회원의 검색이 완료되었습니다.");
						SuccessView.dataHPrint(human);
						
					} else {
						SuccessView.msg("요청한 데이터가 존재하지 않습니다.");
						FailView.errorMsg("비정상적인 실행이 발생하였습니다. 유효한 값으로 다시 시도하십시오.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
				
				//저장요청 조절 메소드
				public boolean insertReqRes(String humanId, String humanName, String gender, String favorite) {
					try {
						boolean result = HumanDAO.addHuman(new HumanDTO(humanId, humanName, gender, favorite));
						if(result==true) {
							SuccessView.msg("새로운 회원정보가 생성되었습니다.");
						}else {
							SuccessView.msg("회원정보 생성이 실패하였습니다.");
						}
						return true;
					} catch (SQLException e) {
						e.printStackTrace();
						FailView.errorMsg("비정상적인 실행이 발생하였습니다. 유효한 값으로 다시 시도하십시오.");
						return false;
					}
					
					
				}
				
				public boolean updateReqRes(String humanId, String favorite) {
					try {
						boolean result = HumanDAO.updateHuman(humanId, favorite);
						if(result==true) {
							SuccessView.msg("회원정보가 갱신되었습니다.");
						}else {
							SuccessView.msg("회원정보 갱신에 실패하였습니다.");
						}
						return true;
					} catch (SQLException e) {
						e.printStackTrace();
						FailView.errorMsg("비정상적인 실행이 발생하였습니다. 유효한 값으로 다시 시도하십시오.");
						return false;
					}
				}
				
				//삭제요청 조절 메소드
				
				public boolean deleteReqRes(String humanId){
					try {
					boolean result=HumanDAO.deleteHuman(humanId);
					if(result==true) {
						SuccessView.msg("회원이 삭제되었습니다.");
					}else {
						SuccessView.msg("해당 회원정보는 존재하지 않습니다.");
					}
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					FailView.errorMsg("비정상적인 실행이 발생하였습니다. 유효한 값으로 다시 시도하십시오.");
					return false;
				}
					
				}

		
}
