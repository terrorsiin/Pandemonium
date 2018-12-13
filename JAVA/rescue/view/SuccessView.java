package rescue.view;

import java.util.ArrayList;

import rescue.model.dto.AnimalDTO;
import rescue.model.dto.HumanDTO;
import rescue.model.dto.MatchingDTO;


public class SuccessView {
	public static void msg(String message) {
		System.out.println("Á¤»ó ½ÇÇàµÊ : " + message);
	}

	


	public static void allADataPrint(ArrayList<AnimalDTO> animal) {
		for(AnimalDTO dto:animal) {
			System.out.println(dto);
		}
	}
	
	
	public static void allHDataPrint(ArrayList<HumanDTO> human) {
		for(HumanDTO dto:human) {
			System.out.println(dto);
		}
		
	}


	public static void allMDataPrint(ArrayList<MatchingDTO> matching) {
		for(MatchingDTO dto:matching) {
			System.out.println(dto);
		}
	}
	public static void dataMPrint(MatchingDTO matching) {
		System.out.println(matching);
	}


	public static void dataAPrint(AnimalDTO animal) {
			System.out.println(animal);
	}
	
	public static void dataHPrint(HumanDTO human) {
		System.out.println(human);
}
	
}

