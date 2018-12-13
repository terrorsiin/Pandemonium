package rescue.model.dto;


public class AnimalDTO extends Manage {
	private String health;
	
	public AnimalDTO() {}

	public AnimalDTO(String health) {
		this.health = health;
	}
	public AnimalDTO(String id, String name, String gender, String health) {
		super(id, name, gender);
		this.health = health;
		
		
	}

	

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" 건강 상태 : ");
		builder.append(health);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
