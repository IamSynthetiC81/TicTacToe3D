import javax.naming.directory.InvalidAttributesException;

import Exceptions.InvalidLevel;
import Exceptions.LevelOutOfBounds;

public class Board {

    Cell[][] Board;
    private static int BoardDimentions;

    Board(int dimentions){
        BoardDimentions = dimentions;

        Board = initBoard(dimentions);
    }

    private Cell[][] initBoard(int dimentions){
        Cell[][] Board = new Cell[dimentions][dimentions];
        for(int i = 0 ; i < dimentions ; i++ ){
            for (int j = 0 ; j < dimentions ; j++ ){
                Board[i][j] = new Cell(i, j);
            }
        }
        return Board;
    }    

    public Cell getCell(int i, int j){
        assert i >= 0 && i <= BoardDimentions :"i out of bounds";
        assert j >= 0 && j <= BoardDimentions :"j out of bounds";
        
        return Board[i][j];
    }

    public void MakeMove(Cell cell, Player player, int level) throws InvalidLevel, LevelOutOfBounds, NullPointerException{
        cell.makeMove(player, level, false);       
    }
}
