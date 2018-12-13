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
					if(matching.size()!=0) {//검색 데이터 사이즈가 0이 아닌 경우=존재하는 경우 
						SuccessView.msg("모든 검색이 완료되었습니다.");
						SuccessView.allMDataPrint(matching);
					} else {
						SuccessView.msg("요청한 데이터가 존재하지 않습니다.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
					FailView.errorMsg("비정상적인 실행이 발생하였습니다. 유효한 값으로 다시 시도하십시오.");
				}
			}

		
		public void selectReqRes2(int matchingId) {
			try {
				
				MatchingDTO matching = MatchingDAO.getMatching(matchingId);
				if(matching!=null) {//검색 데이터 사이즈가 0이 아닌 경우=존재하는 경우 
					SuccessView.msg("요청한 매칭 DB 검색이 완료되었습니다.");
					SuccessView.dataMPrint(matching);
					
				} else {
					SuccessView.msg("요청한 데이터가 존재하지 않습니다.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

			
			//저장요청 조절 메소드
			public boolean insertReqRes(int matchingId, String matchingName, String animalId, String humanId, String matchingSitu) {
				try {
					boolean result = MatchingDAO.addMatching(new MatchingDTO(matchingId, matchingName, animalId, humanId, matchingSitu));
					if(result==true) {
						SuccessView.msg("새로운 매칭이 생성되었습니다.");
				
					}else {
						SuccessView.msg("매칭 생성이 실패하였습니다.");
					}
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					FailView.errorMsg("비정상적인 실행이 발생하였습니다. 유효한 값으로 다시 시도하십시오.");
					return false;
				}
				
				
			}
			
			
			public boolean updateReqRes(int matchingId, String matchingSitu) {
				try {
					boolean result = MatchingDAO.updateMatching(matchingId, matchingSitu);
					if(result==true) {
						SuccessView.msg("매칭이 갱신되었습니다.");
				
					}else {
						SuccessView.msg("매칭 갱신이 실패하였습니다.");
					}
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					FailView.errorMsg("비정상적인 실행이 발생하였습니다. 유효한 값으로 다시 시도하십시오.");
					return false;
				}
				
				
			}
			
			
			//삭제요청 조절 메소드
			
			public boolean deleteReqRes(int matchingId){
				try {
				boolean result=MatchingDAO.deleteMatching(matchingId);
				if(result==true) {
					SuccessView.msg("매칭 DB가 삭제되었습니다.");
				}else {
					SuccessView.msg("해당 매칭데이터 존재하지 않습니다.");
				}
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				FailView.errorMsg("비정상적인 실행이 발생하였습니다. 유효한 값으로 다시 시도하십시오.");
				return false;
			}
			}
}

