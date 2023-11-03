package chess.pieces;

import chess.chesspiece;
import boardgame.position;
import boardgame.board;
import chess.color;

public class rook extends chesspiece{

	public rook(board board, color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "R";
	}
	public boolean[][] possiblemoves(){
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		boardgame.position p = new position(0, 0);
		
		//above
		
		p.setvalues(position.getRows() - 1, position.getColumn());
		while(getBoard().positionexists(p) && !getBoard().thereisapiece(p)) {
			mat[p.getRows()][p.getColumn()] = true;
			p.setRows(p.getRows() - 1);
		}
		if( getBoard().positionexists(p) && isthereopponentpiece(p) ) {
			mat[p.getRows()][p.getColumn()] = true;
		}
		
		//left
		
				p.setvalues(position.getRows(), position.getColumn() - 1);
				while(getBoard().positionexists(p) && !getBoard().thereisapiece(p)) {
					mat[p.getRows()][p.getColumn()] = true;
					p.setRows(p.getRows() - 1);
				}
				if( getBoard().positionexists(p) && isthereopponentpiece(p) ) {
					mat[p.getRows()][p.getColumn()] = true;
				}
				
			//right
				
				p.setvalues(position.getRows(), position.getColumn() + 1);
				while(getBoard().positionexists(p) && !getBoard().thereisapiece(p)) {
					mat[p.getRows()][p.getColumn()] = true;
					p.setRows(p.getRows() + 1);
				}
				if( getBoard().positionexists(p) && isthereopponentpiece(p) ) {
					mat[p.getRows()][p.getColumn()] = true;
				}
				
				//below
				
				p.setvalues(position.getRows() + 1, position.getColumn());
				while(getBoard().positionexists(p) && !getBoard().thereisapiece(p)) {
					mat[p.getRows()][p.getColumn()] = true;
					p.setRows(p.getRows() + 1);
				}
				if( getBoard().positionexists(p) && isthereopponentpiece(p) ) {
					mat[p.getRows()][p.getColumn()] = true;
				}
				
				return mat;
		
		return mat;
	}
	
}
