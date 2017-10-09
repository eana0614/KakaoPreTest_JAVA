package Problem6;

public class Block {
	
	private Block up;
	private Block left;
	private Block right;
	private Block down;
	
	private char blocks;
	
	public Block() {
		
	}
	
	public char getBlocks() {
		return blocks;
	}
	
	public void setBlocks(char b) {
		this.blocks = b;
	}

	public Block getUp() {
		return up;
	}

	public void setUp(Block up) {
		this.up = up;
	}

	public Block getLeft() {
		return left;
	}

	public void setLeft(Block left) {
		this.left = left;
	}

	public Block getRight() {
		return right;
	}

	public void setRight(Block right) {
		this.right = right;
	}

	public Block getDown() {
		return down;
	}

	public void setDown(Block down) {
		this.down = down;
	}
	
	

}
