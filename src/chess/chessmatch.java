package chess;
import boardgame.board;
import boardgame.piece;
import boardgame.position;
import chess.pieces.king;
import chess.pieces.rook;


public class chessmatch {
	
	private board board;
	
	public chessmatch() {
		board = new board(8,8);
		initialSetup();
	}
	
	public chesspiece[][] getpieces(){
	
		chesspiece[][] mat = new chesspiece[board.getRows()][board.getColumns()];
		
		for(int i = 0; i<board.getRows(); i++) {
			for(int j = 0; j<board.getColumns(); j++) {
				mat[i][j] = (chesspiece) board.piece(i,j);
			}
			
		}
		return mat;
	}
	
	public chesspiece performchessmove(chessposition sourceposition,chessposition targetposition) {
		position source = sourceposition.toposition();
		position target = targetposition.toposition();
		validatesourceposition(source);
		validatetargetposition(source, target);
		piece capturedpiece = makemove(source, target); 
		return (chesspiece)capturedpiece;
}
	private void validatesourceposition(position position) {
		if(!board.thereisapiece(position)) {
			throw new chessexception("there is no piece on source position");
		}
		if(!board.piece(position).isthereanypossiblemove()) {
			throw new chessexception("there is no possible move for the chosen piece");
		}
	}
	private void validatetargetposition(position source, position target) {
		if(!board.piece(source).possiblemove(target)) {
			throw new chessexception("the chosen piece can't move to target position");
		}
	}
	
	private piece makemove(position source,position target) {
		piece p = board.removepiece(source);
		piece capturedpiece = board.removepiece(target);
		board.placepiece(p,  target);
		return capturedpiece;
		
	}
	
	private void placenewpiece(char column, int row, chesspiece piece) {
		board.placepiece(piece, new chessposition(column, row).toposition());
	}
	private void initialSetup(){
		
		placenewpiece('c', 1, new rook(board, color.WHITE));
        placenewpiece('c', 2, new rook(board, color.WHITE));
        placenewpiece('d', 2, new rook(board, color.WHITE));
        placenewpiece('e', 2, new rook(board, color.WHITE));
        placenewpiece('e', 1, new rook(board, color.WHITE));
        placenewpiece('d', 1, new king(board, color.WHITE));

        placenewpiece('c', 7, new rook(board, color.BLACK));
        placenewpiece('c', 8, new rook(board, color.BLACK));
        placenewpiece('d', 7, new rook(board, color.BLACK));
        placenewpiece('e', 7, new rook(board, color.BLACK));
        placenewpiece('e', 8, new rook(board, color.BLACK));
        placenewpiece('d', 8, new king(board, color.BLACK));
		
	}
	
}



