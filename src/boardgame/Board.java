package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public int getRows() {
        return rows;
    }


    public int getColumns() {
        return columns;
    }


    public Board(int rows, int columns) {
        /*defensive programming*/
    if(rows<1||columns<1){
        throw new BoardException("To set a new board, you have to define a positive number");
    }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Piece piece(int row, int column) {
        if(!positionExits(row, column)){
            throw new BoardException("Not a valid position");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if(!positionExits(position.getRow(),position.getColumn())){
            throw new BoardException("Not a valid position");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There already exists a piece in the given position: " + position);
        }

        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExits(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExits(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if(!positionExits(position.getRow(),position.getColumn())){
            throw new BoardException("Not a valid position");
        }
        return piece(position.getRow(), position.getColumn()) != null;
    }

}
