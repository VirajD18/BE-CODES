public class NQueen {
	private boolean isSafe(int row, int col, char[][] board) {
		//horizontal
		for (int j = 0; j < board.length; j++) {
			if(board[row][j]=='Q') {
				return false;
			}
		}
		//vertical
		for(int i=0;i<board.length;i++) {
			if(board[i][col]=='Q') {
				return false;
			}
		}
		//upperleft
		int r=row;
		for(int c=col;c>=0 && r>=0;c--,r--) {
			if(board[r][c]=='Q') {
				return false;
			}
		}
		//upper right
		r=row;
		for(int c=col;c<board.length && r>=0;c++,r--) {
			if(board[r][c]=='Q') {
				return false;
			}
		}
		//lower left
		r=row;
		for(int c=col;c>=0 && r<board.length;c--,r++) {
			if(board[r][c]=='Q') {
				return false;
			}
		}
		r=row;
		for(int c=col;c<board.length && r<board.length;c++,r++) {
			if(board[r][c]=='Q') {
				return false;
			}
		}
		return true;
	}
	//backtracking
	private void helper(List<List<String>> allboards, char[][] board, int col) {
		if(col==board.length) {
			saveboard(allboards,board);
			return;
		}
		for (int row = 0; row < board.length; row++) {
			if(isSafe(row,col,board)) {
				board[row][col]='Q';
				helper(allboards, board, col+1);
				board[row][col]='.';
			}
		}
		
	}

	private void saveboard(List<List<String>> allboards, char[][] board) {
		String row="";
		List<String> newboard=new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			row="";
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j]=='Q') {
					row+='Q';
				}
				else {
					row+='.';
				}
			}
			newboard.add(row);
		}
		allboards.add(newboard);
	}
	public List<List<String>> solvenQueen(int n){
		List<List<String>> allboards=new ArrayList<>();
		char[][] board=new char[n][n];
		
		helper(allboards,board,0);
		return allboards;
	}
	public static void main(String[] args) {
		NQueen nQueen = new NQueen();
		List<List<String>> sol = nQueen.solvenQueen(4);
		System.out.println(sol);
	}
}
