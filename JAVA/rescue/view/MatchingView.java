package rescue.view;

import java.io.IOException;
import java.io.InputStreamReader;
import rescue.controll.MatchingController;

public class MatchingView {

	public static void SelectView(MatchingController human) {
		InputStreamReader in2 = new InputStreamReader(System.in);
		MatchingController m = MatchingController.getInstance();
		System.out.println("원하는 매칭 정보를 조회하고 싶다면 키보드로 입력해주세요.");

		System.out.println("1. 모든 매칭정보 보기");
		
		System.out.println("2. 매칭ID로 정보 검색");	
		
		System.out.println("3. 매칭정보 추가하기");
		
		System.out.println("4. 매칭ID로 정보 삭제하기");
		
		System.out.println("5. 매칭ID로 매칭진행상태 갱신하기");
		
		try {
			int i=in2.read();
					
			if(i=='1') {	
				m.selectReqRes();
			}else if(i=='2') {	
				m.selectReqRes2(9);
			}else if(i=='3') {
				m.insertReqRes(9, "MATCHDRAGON", "anidrg001", "dragonian", "MATCHED");
			}else if(i=='4') {
				m.deleteReqRes(9);
			}else if(i=='5') {
				m.updateReqRes(9, "PROCEEDING");
			}else {
				System.out.println("올바르지 않은 값입니다.");
			}
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}


