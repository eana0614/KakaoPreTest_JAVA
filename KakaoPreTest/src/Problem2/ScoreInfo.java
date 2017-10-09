package Problem2;

public class ScoreInfo {
	private double basicScore;
	private char bonus;
	private boolean optionAble;
	private char option;
	private double roundScore;
	
	public ScoreInfo(double score,char bo, boolean opA, char op) {
		this.basicScore = score;
		this.bonus = bo;
		this.optionAble = opA;
		this.option = op;
		this.roundScore = score;
	}
	
	public char getBonus() {
		return bonus;
	}

	public void setRoundScore(double input) {
		this.roundScore = input;
	}

	public double getBasicScore() {
		return basicScore;
	}

	public boolean isOptionAble() {
		return optionAble;
	}

	public char getOption() {
		return option;
	}

	public double getRoundScore() {
		return roundScore;
	}
	

}
