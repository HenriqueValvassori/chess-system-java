package chess;

import boardgame.piece;
import boardgame.position;

public abstract class chesspiece extends piece{

	private color color;

	public chesspiece(boardgame.board board, chess.color color) {
		super(board);
		this.color = color;
	}

	public color getColor() {
		return color;
	}

	protected boolean isthereopponentpiece(position position) {
		chesspiece p = (chesspiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	
}
