package rescue.view;

import java.io.IOException;
import java.io.*;

import rescue.controll.HumanController;

public class HumanView {

	public static void SelectView(HumanController human){
		
		

		InputStreamReader in2 = new InputStreamReader(System.in);
		HumanController h = HumanController.getInstance();
		System.out.println("원하는 회원 정보를 조회하고 싶다면 키보드로 입력해주세요.");

		System.out.println("1. 모든 회원정보 보기");
		
		System.out.println("2. 회원아이디로 정보 검색");	
		
		System.out.println("3. 회원정보 추가하기");
		
		System.out.println("4. 회원ID로 정보 삭제하기");
		
		System.out.println("5. 회원 선호동물 갱신하기");
		
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