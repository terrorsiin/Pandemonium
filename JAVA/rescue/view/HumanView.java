package rescue.view;

import java.io.IOException;
import java.io.*;

import rescue.controll.HumanController;

public class HumanView {

	public static void SelectView(HumanController human){
		
		

		InputStreamReader in2 = new InputStreamReader(System.in);
		HumanController h = HumanController.getInstance();
		System.out.println("���ϴ� ȸ�� ������ ��ȸ�ϰ� �ʹٸ� Ű����� �Է����ּ���.");

		System.out.println("1. ��� ȸ������ ����");
		
		System.out.println("2. ȸ�����̵�� ���� �˻�");	
		
		System.out.println("3. ȸ������ �߰��ϱ�");
		
		System.out.println("4. ȸ��ID�� ���� �����ϱ�");
		
		System.out.println("5. ȸ�� ��ȣ���� �����ϱ�");
		
		try {
			int i=in2.read();
					
			if(i=='1') {	
				h.selectReqRes();
			}else if(i=='2') {
				h.selectReqRes2("dragonian");
			}else if(i=='3') {
				h.insertReqRes("dragonian", "Dok", "M", "DRAGON");
			}else if(i=='4') {
				h.deleteReqRes("dragonian");
			}else if(i=='5') {
				h.updateReqRes("dragonian", "DOG");
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