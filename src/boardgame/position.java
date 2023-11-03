package boardgame;

public class position {
	
	private int rows;
	private int column;
	public position(int rows, int column) {
		
		this.rows = rows;
		this.column = column;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	public void setvalues(int row, int column) {
		this.rows = row;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return rows + " , " + column;
	}
	
	
}
