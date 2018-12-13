package rescue.view;

import java.io.IOException;


import java.io.*;
import rescue.controll.*;


public class HomeView {
	
	
	public static void main(String args[]) throws Exception {
		
		InputStreamReader in = new InputStreamReader(System.in);
	
		System.out.println("유기동물 매칭서비스 정보조회 페이지입니다.");
		System.out.println("원하시는 DB 정보 조회를 하려면 선택하세요.");
		System.out.println("----------------------------");
		System.out.println("1. 동물정보 보기");
		System.out.println("2. 회원정보 보기");
		System.out.println("3. 매칭정보 보기");

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
				System.out.println("올바르지 않은 값입니다.");
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
		
		
