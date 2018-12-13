package rescue.model.dto;

public class Manage {
	private String id;
	private String name;
	private String gender;

	
	public Manage() {}


	public Manage(String id, String name, String gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[아이디 : ");
		builder.append(id);
		builder.append(" 이름 : ");
		builder.append(name);
		builder.append(" 성별 : ");
		builder.append(gender);
		return builder.toString();
	}
}
