package boardgame;

public abstract class piece {
	protected position position;
	private board board;
	public piece(boardgame.board board) {
		
		this.board = board;
		position = null;
	}
	protected board getBoard() {
		return board;
	}
	public abstract boolean[][] possiblemoves();
	
	
	public boolean possiblemove(position position) {
		return possiblemoves()[position.getRows()][position.getColumn()];
	}
	public boolean isthereanypossiblemove() {
		boolean[][] mat = possiblemoves();
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
}
