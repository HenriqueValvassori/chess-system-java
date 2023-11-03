package aplication;


import java.util.InputMismatchException;
import java.util.Scanner;

import chess.chessexception;
import chess.chessmatch;
import chess.chesspiece;
import chess.chessposition;

public class programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		chessmatch chessmatch = new chessmatch();
		
		while(true) {
			try {
			UI.clearScreen();
			UI.printboard(chessmatch.getpieces());
			System.out.println();
			System.out.print("source:");
			chessposition source = UI.readchessposition(sc);
			
			System.out.println();
			System.out.print("target:");
			chessposition target = UI.readchessposition(sc);
			
			chesspiece capturedpiece = chessmatch.performchessmove(source, target);
			}
			catch(chessexception e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		
		
	}

}
