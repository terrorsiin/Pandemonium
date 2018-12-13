package rescue.model.dto;

import rescue.model.dto.Manage;

public class HumanDTO extends Manage{
	private String favorite;

	
	public HumanDTO() {}
	
	public HumanDTO(String favorite) {
		
		this.favorite = favorite;
	}
	
	public HumanDTO(String id, String name, String gender, String favorite) {
		super(id, name, gender);
		this.favorite = favorite;
	}

	public String getFavorite() {
		return favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" 선호 동물 : ");
		builder.append(favorite);
		builder.append("]");
		return builder.toString();
	}
	

}
