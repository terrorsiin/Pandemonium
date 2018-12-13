package rescue.view;
import java.io.IOException;
import java.io.InputStreamReader;
import rescue.controll.AnimalController;



public class AnimalView {

	public static void SelectView(AnimalController animal){
		
		

		InputStreamReader in2 = new InputStreamReader(System.in);
		AnimalController a = AnimalController.getInstance();
		System.out.println("���ϴ� ���� ������ ��ȸ�ϰ� �ʹٸ� Ű����� �Է����ּ���.");

		System.out.println("1. ��� �������� ����");
		
		System.out.println("2. ����ID�� ���� �˻�");	
		
		System.out.println("3. �������� �߰��ϱ�");
		
		System.out.println("4. ����ID�� ���� �����ϱ�");
		
		System.out.println("5. �����ǰ����� �����ϱ�");
		
		try {
			int i=in2.read();
					
			if(i=='1') {	
				a.selectReqRes();
			}else if(i=='2') {
				a.selectReqRes2("anidrg001");
			}else if(i=='3') {
				a.insertReqRes("anidrg001", "DRAGON", "M", "G");
			}else if(i=='4') {
				a.deleteReqRes("anidrg001");
			}else if(i=='5') {
				a.updateReqRes("anidrg001", "Y");
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
	
	
