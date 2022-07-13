class Solution {
    public void solve(char[][] board) {
        
        if(board.length == 0)
            return;
        
        for(int i=0; i<board[0].length; i++) { //Iterating column
            if(board[0][i] == 'O') //condition for first row in grid
                dfs(board, 0, i);
            if(board[board.length - 1][i] == 'O')
                dfs(board, board.length - 1, i); //condition for last row in grid
        }
        
        for(int i=0; i<board.length; i++) {
            if(board[i][0] == 'O') //condition for first column in grid
                dfs(board, i, 0);
            if(board[i][board[0].length - 1] == 'O') ////condition for last column in grid
                dfs(board, i, board[0].length - 1);
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == '#')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        return;
    }
    
    public void dfs(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')
            return;
        
        board[i][j] = '#';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}