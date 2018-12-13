package rescue.view;
import java.io.IOException;
import java.io.InputStreamReader;
import rescue.controll.AnimalController;



public class AnimalView {

	public static void SelectView(AnimalController animal){
		
		

		InputStreamReader in2 = new InputStreamReader(System.in);
		AnimalController a = AnimalController.getInstance();
		System.out.println("원하는 동물 정보를 조회하고 싶다면 키보드로 입력해주세요.");

		System.out.println("1. 모든 동물정보 보기");
		
		System.out.println("2. 동물ID로 정보 검색");	
		
		System.out.println("3. 동물정보 추가하기");
		
		System.out.println("4. 동물ID로 정보 삭제하기");
		
		System.out.println("5. 동물건강정보 수정하기");
		
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
	
	
