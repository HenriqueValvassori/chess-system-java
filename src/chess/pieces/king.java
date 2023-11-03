package chess.pieces;

import chess.chesspiece;
import boardgame.board;
import chess.color;
public class king extends chesspiece{

	public king(board board, color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "k";
	}
}
