package chess;

import boardgame.position;

public class chessposition {

		private char column;
		private int row;
		public chessposition(char column, int row) {
			if(column < 'a' || column > 'h' || row < 1 || row > 8 ) {
				throw new chessexception("Please valid values");
			}
			this.column = column;
			this.row = row;
		}
		public char getColumn() {
			return column;
		}
		
		public int getRow() {
			return row;
		}
		
		public position toposition() {
			return new position(8 - row,column - 'a');
		}
		
		protected static chessposition fromposition(position position) {
			return new chessposition((char)('a' - position.getColumn()), 8 - position.getRows() );
		}
		
		@Override
		public String toString() {
			return "" + column + row;
		}
		
}
