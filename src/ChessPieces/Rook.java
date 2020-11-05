package ChessPieces;

import BoardGame.Board;

import java.util.ArrayList;
import java.util.LinkedList;

import static Helper.Constants.ROOK_VALUE;

public final class Rook extends Piece {
    boolean hadMoved;

    public Rook(final Integer line, final Integer column, final String color) {
        value = ROOK_VALUE;
        this.line = line;
        this.column = column;
        team = color;
        type = "Rook";
        hadMoved = false;
        history = new LinkedList<>();
    }
    public ArrayList<Position> getMoves() {
        Board board = Board.getInstance();
        ArrayList<Position> moves = new ArrayList<>();
        // move down
        for (int i = line + 1; i <= 8; ++i) {
            if (isOnBoard(i, column)) {
                if (board.isEmpty(i, column)) {
                    if (board.isMoveValid(this, new Position(i, column))) {
                        moves.add(new Position(i, column));
                    }
                } else {
                    if (!board.getPiece(i, column).getTeam().equals(team)) {
                        if (board.isMoveValid(this, new Position(i, column))) {
                            moves.add(new Position(i, column));
                        }
                    }
                    break;
                }
            }
        }
        // move up
        for (int i = line - 1; i >= 1; --i) {
            if (isOnBoard(i, column)) {
                if (board.isEmpty(i, column)) {
                    if (board.isMoveValid(this, new Position(i, column))) {
                        moves.add(new Position(i, column));
                    }
                } else {
                    if (!board.getPiece(i, column).getTeam().equals(team)) {
                        if (board.isMoveValid(this, new Position(i, column))) {
                            moves.add(new Position(i, column));
                        }
                    }
                    break;
                }
            }
        }
        // move right
        for (int i = column + 1; i <= 8; ++i) {
            if (isOnBoard(line, i)) {
                if (board.isEmpty(line, i)) {
                    if (board.isMoveValid(this, new Position(line, i))) {
                        moves.add(new Position(line, i));
                    }
                } else {
                    if (!board.getPiece(line, i).getTeam().equals(team)) {
                        if (board.isMoveValid(this, new Position(line, i))) {
                            moves.add(new Position(line, i));
                        }
                    }
                    break;
                }
            }
        }
        // move left
        for (int i = column - 1; i >= 1; --i) {
            if (isOnBoard(line, i)) {
                if (board.isEmpty(line, i)) {
                    if (board.isMoveValid(this, new Position(line, i))) {
                        moves.add(new Position(line, i));
                    }
                } else {
                    if (!board.getPiece(line, i).getTeam().equals(team)) {
                        if (board.isMoveValid(this, new Position(line, i))) {
                            moves.add(new Position(line, i));
                        }
                    }
                    break;
                }
            }
        }

        return moves;
    }
}
