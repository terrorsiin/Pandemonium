package rescue.view;

import java.io.IOException;
import java.io.InputStreamReader;
import rescue.controll.MatchingController;

public class MatchingView {

	public static void SelectView(MatchingController human) {
		InputStreamReader in2 = new InputStreamReader(System.in);
		MatchingController m = MatchingController.getInstance();
		System.out.println("���ϴ� ��Ī ������ ��ȸ�ϰ� �ʹٸ� Ű����� �Է����ּ���.");

		System.out.println("1. ��� ��Ī���� ����");
		
		System.out.println("2. ��ĪID�� ���� �˻�");	
		
		System.out.println("3. ��Ī���� �߰��ϱ�");
		
		System.out.println("4. ��ĪID�� ���� �����ϱ�");
		
		System.out.println("5. ��ĪID�� ��Ī������� �����ϱ�");
		
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
				System.out.println("�ùٸ��� ���� ���Դϴ�.");
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


