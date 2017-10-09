package Problem6;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class FriendBlock {

	private int height;
	private int width;
	private String[] board;


	public FriendBlock(int m, int n, String[] strings) {

		this.height = m;
		this.width = n;
		this.board = strings;

	}

	public void runRemoveBlock() {

		Block[][] blocks = createBlock(board);

		ArrayList<String> index = isFourBlock(blocks);

		while (!(index.size() == 0)) {

			blocks = removeFourBlocks(blocks, index);
			index = isFourBlock(blocks);
			
		}

		int deleteCount = countRemainBlock(blocks);

		System.out.println("OUTPUT : " + deleteCount + " Deleted.");

	}

	private int countRemainBlock(Block[][] blocks) {

		int count = 0;

		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[0].length; j++) {
				if (blocks[i][j].getBlocks() == '-') {
					count++;
				}
			}
		}

		return count;
	}

	private Block[][] removeFourBlocks(Block[][] blocks, ArrayList<String> index) {

		Block[][] result;

		for (int i = 0; i < index.size(); i++) {

			StringTokenizer tokenizer = new StringTokenizer(index.get(i), "/");

			int indexY = Integer.parseInt(tokenizer.nextToken());
			int indexX = Integer.parseInt(tokenizer.nextToken());

			blocks[indexY][indexX].setBlocks('-');
			blocks[indexY + 1][indexX].setBlocks('-');
			blocks[indexY + 1][indexX + 1].setBlocks('-');
			blocks[indexY][indexX + 1].setBlocks('-');
		}

		blocks = relocationblock(blocks);

		result = reBulidBlock(blocks);

		return result;
	}

	private Block[][] reBulidBlock(Block[][] blocks) {

		String[] strs = new String[blocks.length];
		String temp = "";

		for (int i = 0; i < strs.length; i++) {
			for (int j = 0; j < blocks[0].length; j++) {
				temp = temp + blocks[i][j].getBlocks();
			}

			strs[i] = temp;
			temp = "";
		}

		return createBlock(strs);
	}

	private Block[][] relocationblock(Block[][] blocks) {

		for (int i = 0; i < blocks[0].length; i++) {
			while (!correctRelocation(blocks, blocks.length, i)) {

				int indexB = findBlock(blocks, i);
				int countNull = countNull(blocks, i, indexB);

				blocks[indexB + countNull][i].setBlocks(blocks[indexB][i].getBlocks());
				blocks[indexB][i].setBlocks('-');
			}
		}
		return blocks;
	}

	private int countNull(Block[][] blocks, int x, int indexB) {
		int count = 0;

		for (int i = indexB; i < blocks.length; i++) {
			if (blocks[i][x].getBlocks() == '-') {
				count++;
			}
		}

		return count;
	}

	private int findBlock(Block[][] blocks, int x) {

		int result = -1;

		for (int i = blocks.length - 2; i >= 0; i--) {
			if (blocks[i][x].getBlocks() != '-' && blocks[i + 1][x].getBlocks() == '-') {
				result = i;
				break;
			}
		}

		return result;
	}

	private boolean correctRelocation(Block[][] blocks, int hei, int x) {

		String temp = "";
		String regex = "^-*[A-Z]*$";

		for (int i = 0; i < hei; i++) {
			temp = temp + blocks[i][x].getBlocks();
		}

		if (temp.matches(regex)) {
			return true;
		} else {
			return false;
		}
	}

	private ArrayList<String> isFourBlock(Block[][] blocks) {

		ArrayList<String> indexs = new ArrayList<>();
		String temp = "";

		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[0].length - 1; j++) {
				if (isSameBlock(blocks, i, j)) {
					temp = i + "/" + j;
					indexs.add(temp);
				}
			}
		}

		return indexs;
	}

	private boolean isSameBlock(Block[][] blocks, int i, int j) {

		boolean re = false;

		char c = blocks[i][j].getBlocks();

		if (blocks[i][j].getDown() != null && blocks[i][j].getRight() != null) {
			char rc = blocks[i][j].getRight().getBlocks();
			char dc = blocks[i][j].getDown().getBlocks();
			char diagonalc = blocks[i][j].getDown().getRight().getBlocks();

			if ( c >= 'A' && c <= 'Z' && c == rc && c == dc && c == diagonalc) {
				re = true;
			}

		}

		return re;
	}

	private Block[][] createBlock(String[] boards) {
		Block[][] result = new Block[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {

				result[i][j] = new Block();
				result[i][j].setBlocks(boards[i].charAt(j));

			}
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {

				// isLoactedTopLine
				if (i == 0) {
					result[i][j].setUp(null);
				} else {
					result[i][j].setUp(result[i - 1][j]);
				}

				// isLocatedBottomLine
				if (i == height - 1) {
					result[i][j].setDown(null);
				} else {
					result[i][j].setDown(result[i + 1][j]);
				}

				// isLocatedLeftLine
				if (j == 0) {
					result[i][j].setLeft(null);
				} else {
					result[i][j].setLeft(result[i][j - 1]);
				}

				// isLocatedRightLine
				if (j == width - 1) {
					result[i][j].setRight(null);
				} else {
					result[i][j].setRight(result[i][j + 1]);
				}
			}
		}

		return result;
	}

}
