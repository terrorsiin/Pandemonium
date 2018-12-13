package rescue.model.dto;

public class MatchingDTO {
	private int matchingId;
	private String matchingName;
	private String animalId;
	private String humanId;
	private String matchingSitu;
	
	public MatchingDTO() {}
	
	public MatchingDTO(String animalId, String humanId, String matchingSitu) {
		this.animalId = animalId;
		this.humanId = humanId;
		this.matchingSitu = matchingSitu;
	}
	
	
	public MatchingDTO(int matchingId, String matchingName,
			String animalId, String humanId,
			String matchingSitu) {
		super();
		this.matchingId = matchingId;
		this.matchingName = matchingName;
		this.animalId = animalId;
		this.humanId = humanId;
		this.matchingSitu = matchingSitu;
		}

	
	
	public int getMatchingId() {
		return matchingId;
	}

	public void setMatchingId(int matchingId) {
		this.matchingId = matchingId;
	}

	public String getMatchingName() {
		return matchingName;
	}

	public void setMatchingName(String matchingName) {
		this.matchingName = matchingName;
	}

	public String getAnimalId() {
		return animalId;
	}

	public void setAnimalId(String animalId) {
		this.animalId = animalId;
	}

	public String getHumanId() {
		return humanId;
	}

	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}

	public String getMatchingSitu() {
		return matchingSitu;
	}

	public void setMatchingSitu(String matchingSitu) {
		this.matchingSitu = matchingSitu;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[��Ī id : ");
		builder.append(matchingId);
		builder.append(", ��Ī�� : ");
		builder.append(matchingName);
		builder.append(", ���� ���� : ");
		builder.append(animalId);
		builder.append(", ȸ�� ���� : ");
		builder.append(humanId);
		builder.append(", �Ծ� ���� ���� : ");
		builder.append(matchingSitu);
		builder.append(" ] ");
		
		return builder.toString();
	}
}
