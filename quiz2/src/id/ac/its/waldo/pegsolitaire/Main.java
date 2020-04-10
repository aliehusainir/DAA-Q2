package id.ac.its.waldo.pegsolitaire;

import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Stack<char[][]> stack = new Stack<char[][]>();
		char[][] board = new char[7][7];
		for(int y=0; y<7; y++) {
			for(int x=0; x<7; x++) {
				if((x > 1 && x < 5) || (y > 1 && y < 5)) board[x][y] = 'O';
				else board[x][y] = '-';
			}
		}
		board[3][3] = 'X';
		if(!solve(32, board, stack)) {
			System.out.println("Solution not found.");
			return;
		}
		int counter = 1;
		while(!stack.isEmpty()) {
			System.out.println("Langkah ke-"+(counter++)+":");
			char[][] solution = stack.pop();
			for(int y=0; y<7; y++) {
				for(int x=0; x<7; x++) {
					System.out.print(solution[x][y]+" ");
					if(x == 6) System.out.println();
				}
			}
			System.out.println();
		}
	}
	
	public static boolean solve(int pegs, char[][] board, Stack<char[][]> stack) {
		if(pegs == 1 && board[3][3] == 'O') {
			char[][] clone2d = new char[7][7];
			for(int k=0; k<7; k++) {
				clone2d[k] = board[k].clone();
			}
			stack.add(clone2d);
			return true;
		}
		for(int y=0; y<7; y++) {
			for(int x=0; x<7; x++) {
				if(board[x][y] == 'O') {
					if(y > 1 && board[x][y-1] == 'O' && board[x][y-2] == 'X') {
						board[x][y] = 'X';
						board[x][y-1] = 'X';
						board[x][y-2] = 'O';
						if(solve(pegs-1, board, stack)) {
							board[x][y] = 'O';
							board[x][y-1] = 'O';
							board[x][y-2] = 'X';
							char[][] clone2d = new char[7][7];
							for(int k=0; k<7; k++) {
								clone2d[k] = board[k].clone();
							}
							stack.add(clone2d);
							return true;
						}
						board[x][y] = 'O';
						board[x][y-1] = 'O';
						board[x][y-2] = 'X';
					}
					if(x < 5 && board[x+1][y] == 'O' && board[x+2][y] == 'X') {
						board[x][y] = 'X';
						board[x+1][y] = 'X';
						board[x+2][y] = 'O';
						if(solve(pegs-1, board, stack)) {
							board[x][y] = 'O';
							board[x+1][y] = 'O';
							board[x+2][y] = 'X';
							char[][] clone2d = new char[7][7];
							for(int k=0; k<7; k++) {
								clone2d[k] = board[k].clone();
							}
							stack.add(clone2d);
							return true;
						}
						board[x][y] = 'O';
						board[x+1][y] = 'O';
						board[x+2][y] = 'X';
					}
					if(y < 5 && board[x][y+1] == 'O' && board[x][y+2] == 'X') {
						board[x][y] = 'X';
						board[x][y+1] = 'X';
						board[x][y+2] = 'O';
						if(solve(pegs-1, board, stack)) {
							board[x][y] = 'O';
							board[x][y+1] = 'O';
							board[x][y+2] = 'X';
							char[][] clone2d = new char[7][7];
							for(int k=0; k<7; k++) {
								clone2d[k] = board[k].clone();
							}
							stack.add(clone2d);
							return true;
						}
						board[x][y] = 'O';
						board[x][y+1] = 'O';
						board[x][y+2] = 'X';
					}
					if(x > 1 && board[x-1][y] == 'O' && board[x-2][y] == 'X') {
						board[x][y] = 'X';
						board[x-1][y] = 'X';
						board[x-2][y] = 'O';
						if(solve(pegs-1, board, stack)) {
							board[x][y] = 'O';
							board[x-1][y] = 'O';
							board[x-2][y] = 'X';
							char[][] clone2d = new char[7][7];
							for(int k=0; k<7; k++) {
								clone2d[k] = board[k].clone();
							}
							stack.add(clone2d);
							return true;
						}
						board[x][y] = 'O';
						board[x-1][y] = 'O';
						board[x-2][y] = 'X';
					}
				}
			}
		}
		return false;
	}
}