package rescue.view;

import java.io.IOException;


import java.io.*;
import rescue.controll.*;


public class HomeView {
	
	
	public static void main(String args[]) throws Exception {
		
		InputStreamReader in = new InputStreamReader(System.in);
	
		System.out.println("���⵿�� ��Ī���� ������ȸ �������Դϴ�.");
		System.out.println("���Ͻô� DB ���� ��ȸ�� �Ϸ��� �����ϼ���.");
		System.out.println("----------------------------");
		System.out.println("1. �������� ����");
		System.out.println("2. ȸ������ ����");
		System.out.println("3. ��Ī���� ����");

		MatchingController m = MatchingController.getInstance();
		HumanController h = HumanController.getInstance();
		AnimalController a = AnimalController.getInstance();
	
		try {
			int i=in.read();
					
			if(i=='1') {	
				a.animalMap();
			}else if(i=='2') {
				h.humanMap();
			}else if(i=='3') {
				m.matchingMap();
			}else {
				System.out.println("�ùٸ��� ���� ���Դϴ�.");
				}
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
		
		
