import com.puppycrawl.tools.checkstyle.utils.ScopeUtil;

public class Board {
    // declare instance variables here!
    int[][] board;
    public Board(int x, int y) { // constructor!
        board = new int[x][y];
    }
    public void placePiece(Piece p) { // updates the state of the board with the information of the Piece
        int r = p.getRow();
        int c = p.getCol()-1;
        if (p instanceof MegaPiece) {
            for (int i=r-1;i<=r+1;i++){
                for (int j=c-1;j<=c+1;j++){
                    board[i][j] = p.color;
                }
            }

        } else {
            board[r][c] = p.color;
        }
    }


    public int[][] getBoardPieces() { // getter function for boardPieces array
        return board;
    }

    public void displayAll() { // displays the entire board
        // that's quite a nice display we've got right now (displays nothing)
        System.out.print("   ");
        for (int i=1;i<=Math.min(9,board[0].length);i++){
            System.out.print(i + "  ");
        }
        for (int i=10;i<=board[0].length;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i=0;i<board.length;i++){
            System.out.print("#  ");
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==0){
                    System.out.print(".  ");
                }else if (board[i][j]==1){
                    System.out.print("X  ");
                }else{
                    System.out.print("O  " );
                }
            }
            System.out.println("#");
        }
        for (int i=0;i<board[0].length+2;i++){
            System.out.print("#  ");
        }
        System.out.println();
    }
    public boolean checkForWin(int player) { //FIXME
        for (int i=0;i<board.length-4;i++){
            for (int j=0;j<board[0].length;j++) {
                boolean works = true;
                for (int x=0;x<5;x++){
                    if (board[i+x][j]!=player){
                        works = false;
                        break;
                    }
                }
                if (works){
                    return true;
                }
            }
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length-4;j++) {
                boolean works = true;
                for (int x=0;x<5;x++){
                    if (board[i][j+x]!=player){
                        works = false;
                        break;
                    }
                }
                if (works){
                    return true;
                }
            }
        }
        for (int i=0;i<board.length-4;i++){
            for (int j=0;j<board[0].length-4;j++) {
                boolean works = true;
                for (int x=0;x<5;x++){
                    if (board[i+x][j+x]!=player){
                        works = false;
                        break;
                    }
                }
                if (works){
                    return true;
                }
            }
        }
        for (int i=0;i<board.length-4;i++){
            for (int j=4;j<board[0].length;j++) {
                boolean works = true;
                for (int x=0;x<5;x++){
                    if (board[i+x][j-x]!=player){
                        works = false;
                        break;
                    }
                }
                if (works){
                    return true;
                }
            }
        }
        return false;
    }

}
