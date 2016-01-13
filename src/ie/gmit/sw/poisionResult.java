package ie.gmit.sw;

public class poisionResult implements Resultable {
	private double score;
	private String plainText;
	private int key;

	public poisionResult(double score, String plainText, int key) {
		super();
		this.score = score;
		this.plainText = plainText;
		this.key = key;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getPlainText() {
		return plainText;
	}

	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	@Override
	public int compareTo(Resultable o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
