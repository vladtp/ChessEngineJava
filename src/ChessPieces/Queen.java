package ChessPieces;

import BoardGame.Board;

import java.util.ArrayList;
import java.util.LinkedList;

import static Helper.Constants.QUEEN_VALUE;

public final class Queen extends Piece {

    public Queen(final Integer line, final Integer column, final String color) {
        value = QUEEN_VALUE;
        this.line = line;
        this.column = column;
        team = color;
        type = "Queen";
        hadMoved = false;
        history = new LinkedList<>();
    }
    public ArrayList<Position> getMoves() {
        Board board = Board.getInstance();
        ArrayList<Position> moves = new ArrayList<>();
        // up-right
        for (int i = line + 1, j = column + 1; i <= 8 && j <= 8; ++i, ++j) {
            if (isOnBoard(i, j)) {
                if (board.isEmpty(i, j)) {
                    if (board.isMoveValid(this, new Position(i, j))) {
                        moves.add((new Position(i, j)));
                    }
                } else {
                    if (!board.getPiece(i, j).getTeam().equals(team)) {
                        if (board.isMoveValid(this, new Position(i, j))) {
                            moves.add(new Position(i, j));
                        }
                    }
                    break;
                }
            }
        }
        // up-left
        for (int i = line + 1, j = column - 1; i <= 8 && j >= 1; ++i, --j) {
            if (isOnBoard(i, j)) {
                if (board.isEmpty(i, j)) {
                    if (board.isMoveValid(this, new Position(i, j))) {
                        moves.add((new Position(i, j)));
                    }
                } else {
                    if (!board.getPiece(i, j).getTeam().equals(team)) {
                        if (board.isMoveValid(this, new Position(i, j))) {
                            moves.add(new Position(i, j));
                        }
                    }
                    break;
                }
            }
        }
        // down-left
        for (int i = line - 1, j = column - 1; i >= 1 && j >= 1; --i, --j) {
            if (isOnBoard(i, j)) {
                if (board.isEmpty(i, j)) {
                    if (board.isMoveValid(this, new Position(i, j))) {
                        moves.add((new Position(i, j)));
                    }
                } else {
                    if (!board.getPiece(i, j).getTeam().equals(team)) {
                        if (board.isMoveValid(this, new Position(i, j))) {
                            moves.add(new Position(i, j));
                        }
                    }
                    break;
                }
            }
        }
        // down-right
        for (int i = line - 1, j = column + 1; i >= 1 && j <= 8; --i, ++j) {
            if (isOnBoard(i, j)) {
                if (board.isEmpty(i, j)) {
                    if (board.isMoveValid(this, new Position(i, j))) {
                        moves.add(new Position(i, j));
                    }
                } else {
                    if (!board.getPiece(i, j).getTeam().equals(team)) {
                        if (board.isMoveValid(this, new Position(i, j))) {
                            moves.add(new Position(i, j));
                        }
                    }
                    break;
                }
            }
        }
        // move up
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
        // move down
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
