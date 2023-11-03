package boardgame;

public class board {
	private int rows;
	private int columns;
	private piece[][] pieces;
	public board(int rows, int column) {
		
		if(rows < 1 || column < 1) {
			throw new boardexception("Error to creating board: add 1 row and 1 column, please");
		}
		this.rows = rows;
		this.columns = column;
		pieces = new piece[rows][column];
	}
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	
	public piece piece(int row, int column) {
		if(!positionexists(row,column)) {
			throw new boardexception("Position is not on the board");
		}
		return pieces[row][column];
	}
	public piece piece(position position) {
		if(!positionexists(position)) {
			throw new boardexception("Position is not on the board");
		}
		return pieces[position.getRows()][position.getColumn()];
	}
	public void placepiece(piece piece, position position) {
		if (thereisapiece(position)) {
			throw new boardexception("there is already a piece on position  " + position);
		}
		pieces[position.getRows()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public piece removepiece(position position) {
		if(!positionexists(position)){
			throw new boardexception("Position is not on the board");
		}
		if(piece(position) == null) {
			return null;
		}
		piece aux = piece(position);
		aux.position = null;
		pieces[position.getRows()][position.getColumn()] = null;
		return aux;
	}
	
	private boolean positionexists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	public boolean positionexists(position position) {
		return positionexists(position.getRows(),position.getColumn());
	}
	public boolean thereisapiece(position position) {
		if(!positionexists(position)) {
			throw new boardexception("Position is not on the board");
		}
		return piece(position) != null;
	}
}
