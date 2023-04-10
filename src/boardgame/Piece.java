package boardgame;

public class  Piece {
    protected Position position; //matrix position
    private Board board;

    protected Position getPosition() {
        return position;
    }

    public Piece(Board board) {
        this.board = board;
        position = null;
    }
}
