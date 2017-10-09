package Problem2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DartGame {

	final String regular = "^[0-9]+[S,D,T][*,#]?[0-9]+[S,D,T][*,#]?[0-9]+[S,D,T][*,#]?$";
	final String roundsRegular = "[0-9]+[S,D,T][*,#]?";

	public void runDartGame(String str) {

		ScoreInfo[] rounds = createroundsScore(str);

		int result = (int) calculateRoundsScore(rounds);
		
		System.out.println("!] [ "+str+" ] Result : "+result);
	}

	private double calculateRoundsScore(ScoreInfo[] rounds) {
		
		double tmp;
		double sum = 0;
		rounds = calculateBonus(rounds);
		
		
		for(int i=0; i<rounds.length; i++) {
			tmp = rounds[i].getRoundScore();
			if(rounds[i].isOptionAble()) { // 옵션이 있을 때
				if(rounds[i].getOption() == '*') {
					if(i < 2) {
						if(rounds[i+1].isOptionAble()) {
							if(rounds[i+1].getOption() == '*') { //현 : * 다 : *
								rounds[i].setRoundScore(tmp * 4);
							}else { //현 : * 다 : #
								rounds[i].setRoundScore(tmp * 2);
							}
						}else { // 현 : * 다 : 옵션 없음
							rounds[i].setRoundScore(tmp * 2);
						}
					}else { // 현 : * (마지막 라운드)
						rounds[i].setRoundScore(tmp * 2);
					}
				}else { // 현재 : #
					if(i < 2) {
						if(rounds[i+1].isOptionAble()) {
							if(rounds[i+1].getOption() == '*') { // # *
								rounds[i].setRoundScore(tmp * -2);
							}else {
								rounds[i].setRoundScore(tmp * -1); // # #
							}
						}else {
							rounds[i].setRoundScore(tmp * -1); // # X
						}
					}else {
						rounds[i].setRoundScore(tmp * -1); // # (마지막 라운드)
					}
				}
				
			}else { // 옵션 없을 때
				if(i < 2) {
					if(rounds[i+1].isOptionAble()) { // 다음거에는 옵션 있을때
						if(rounds[i+1].getOption() == '*') {
							rounds[i].setRoundScore(tmp * 2);
						}
					}
				}
			}
			
			sum += rounds[i].getRoundScore();
		}
		
		return sum;
		
	}

	private ScoreInfo[] calculateBonus(ScoreInfo[] rounds) {
		
		for(int i=0; i<rounds.length; i++) {
			
			double basic = rounds[i].getBasicScore();
			
			switch (rounds[i].getBonus()) {
			case 'S':
				rounds[i].setRoundScore(Math.pow(basic, 1));
				break;
				
			case 'D':
				rounds[i].setRoundScore(Math.pow(basic, 2));
				break;
				
			case 'T':
				rounds[i].setRoundScore(Math.pow(basic, 3));
				break;

			default:
				System.err.println("!] Incorrect Bonus input.");
				break;
			}
			
		}
		
		return rounds;
	}

	private ScoreInfo[] createroundsScore(String str) {
		String[] rounds = new String[3];
		int count = 0;

		if (str.matches(regular)) {

			Pattern pattern = Pattern.compile(roundsRegular);
			Matcher matcher = pattern.matcher(str);

			while (matcher.find()) {
				rounds[count] = matcher.group(0);
				count++;
			}

		} else {
			System.err.println("!] Incorrect Input.");
		}
		
		ScoreInfo[] scores = covertScoreInfoArray(rounds);
		
		return scores;
	}

	private ScoreInfo[] covertScoreInfoArray(String[] rounds) {
		
		ScoreInfo[] result = new ScoreInfo[rounds.length];
		
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher matcher;
		
		for(int i=0; i<result.length; i++) {
			
			matcher = pattern.matcher(rounds[i]);
			matcher.find();
			
			double score = Double.valueOf(matcher.group(0)).doubleValue();
			
			int index = matcher.group(0).length();
			
			char bouns = rounds[i].charAt(index);
			
			boolean optionAble = false;
			char opt = '?';
			
			if(rounds[i].length() == index+2) {
				optionAble = true;
				opt = rounds[i].charAt(rounds[i].length()-1);
			}
			
			result[i] = new ScoreInfo(score, bouns, optionAble, opt);
		}
		
		return result;
	}

}
