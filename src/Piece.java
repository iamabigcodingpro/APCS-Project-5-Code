public class Piece {
    // instance variables go here!
    int col;
    int row;
    int color;
    Board board;
    public Piece(int col, int color, Board board) { // constructor!

        this.col = col;
        this.color = color;
        this.board = board;
        this.row = findRow(col,board);
    }

    private int findRow(int column, Board board) { // given the state of the board, and a column, it returns the row
        int[][] boardPieces = board.getBoardPieces();
        column--;
        if (this instanceof MegaPiece) {
            for (int i=0;i<boardPieces.length;i++){
                if (boardPieces[i][column-1]!=0 || boardPieces[i][column]!=0 || boardPieces[i][column+1]!=0){
                    row = i-2;
                    return i-2;
                }
            }
            row = boardPieces.length-2;
            return boardPieces.length-2;
        } else {
            for (int i=0;i<boardPieces.length;i++){
                if (boardPieces[i][column]!=0){
                    row = i-1;
                    return i-1;
                }
            }
            row = boardPieces.length-1;
            return boardPieces.length-1;
        }
    }
    public int getCol() {
        return col;
    } //FIXME
    public int getRow() {
        return row;
    }
    public int getColor() {
        return color;
    }
}
