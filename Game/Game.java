import java.time.Duration;
import java.time.Instant;

import Exceptions.InvalidLevel;
import Exceptions.LevelOutOfBounds;
import Exceptions.OngoingGameException;

public class Game implements GameInterface{

    Player Player1;
    Player Player2;

    Board Board;

    Duration GameDuration;
    
    GameState State;

    private static Instant gameStartInstant;
    private Player Winner = null;


    Game(Player player1, Player player2, int dimentions){
        assert player1 != null : "Player 1 can not be null";
        assert player2 != null : "Player 2 can not be null";
        
        if(player1 == null || player2 == null)
            throw new NullPointerException("Player can not be null");        

        Player1 = player1;
        Player2 = player2;
        
        Board = new Board(dimentions);

        State = GameState.Ongoing;

        gameStartInstant = Instant.now();
    }

    /**
     * Checks the entire board for winning condition
     * @return Return the player that has won, or null of there is no winning condition.
     * @implNote Diagonal winning conditin is omited.
     * @deprecated This function is deprecated by {@link #WinningCindition(Cell) which is more efficient}
     */
    private Player WinningCondition(){
        int Player1VerticalCounter      = 0;
        int Player1HorizontalCounter    = 0;
        int Player2VerticalCounter      = 0;
        int Player2HorizontalCounter    = 0;
        
        for(int i = 0 ; i < Rules.BOARD_DIMENTIONS ; i++ ){
            for(int j = 0 ; j < Rules.BOARD_DIMENTIONS ; j++ ){
                if(Board.getCell(i, j).getPlayer()   == Player1)
                    Player1HorizontalCounter++;
                if(Board.getCell(i,j).getPlayer()    == Player2)
                    Player2HorizontalCounter++;
                if(Board.getCell(j, i).getPlayer()   == Player1)
                    Player1VerticalCounter++;
                if(Board.getCell(i,j).getPlayer()    == Player2)
                    Player2VerticalCounter++;                
            }
            if(Player1HorizontalCounter == Rules.BOARD_DIMENTIONS)
                return Player1;
            if(Player2HorizontalCounter == Rules.BOARD_DIMENTIONS)
                return Player2;
            if(Player1VerticalCounter   == Rules.BOARD_DIMENTIONS)
                return Player1;
            if(Player2VerticalCounter   == Rules.BOARD_DIMENTIONS)
                return Player2;

            Player1VerticalCounter      = 0;
            Player2VerticalCounter      = 0;
            Player1HorizontalCounter    = 0;
            Player2HorizontalCounter    = 0;
            
        }
        return null;
    }
    
    /** 
     * Receives a cell where the last move was made and checks for winning conditions.
     * @param cell Cell where the last move was made.
     * @return Return true if there is a winnign condition, false if not.
     */
    private boolean WinningCondition(Cell cell){
        Player player = cell.getPlayer();

        int VerticalIndex       = cell.getVerticalCoordinate();
        int HorizontalIndex     = cell.getHorizontalCoordinate();

        boolean isInDiagonal    = VerticalIndex == HorizontalIndex;

        int VerticalCounter     = 0;
        int HorizontalCounter   = 0;
        int DiagonalIndex_1     = 0;
        int DiagonalIndex_2     = 0;


        for(int i = 0 ; i < Rules.BOARD_DIMENTIONS ; i++ ){
            if(Board.getCell(HorizontalIndex, i).getPlayer() == player)
                VerticalCounter++;
            if(Board.getCell(i, VerticalIndex).getPlayer() == player)
                HorizontalCounter++;
            if(isInDiagonal){
                if(Board.getCell(i, i).getPlayer() == player)
                    DiagonalIndex_1++;
                if(Board.getCell(Rules.BOARD_DIMENTIONS - i, i).getPlayer() == player)
                    DiagonalIndex_2++;
            }
        }
        return  HorizontalCounter   == Rules.BOARD_DIMENTIONS || 
            VerticalCounter     == Rules.BOARD_DIMENTIONS || 
            DiagonalIndex_1     == Rules.BOARD_DIMENTIONS || 
            DiagonalIndex_2     == Rules.BOARD_DIMENTIONS  ;
    }

    /**
     * Parses a move into the board.
     * @param cell Cell where the move takes place.
     * @param player Player who made the move.
     * @param level Level of the move.
     * @return Returns {@code True} if there is a winning condition, and false if not.
     * @throws LevelOutOfBounds Throws when the level is out of bounds.
     * @throws InvalidLevel Throws when the level is incompatible with the current level of the cell.
     * @throws NullPointerException Throws when the player parameter is null;
     */
    public boolean Move(Cell cell, Player player, int level) throws NullPointerException, InvalidLevel, LevelOutOfBounds{
        assert cell != null : "Cell can not be null";
        assert (player == Player1 || player == Player2) : "Player must be part of the game";
        
        Board.MakeMove(cell, player, level);
    
        boolean Win =  WinningCondition(cell);    

        if(Win){
            Winner = player;
            if(player == Player1)
                State = GameState.Player_1_Victorious;
            else
                State = GameState.Player_2_Victorious;
        }

        return Win;
    }

    public Player getWinner() throws OngoingGameException{
        if (State == GameState.Ongoing)
            throw new OngoingGameException();
        if (State == GameState.Stalemate)
            return null;
        
        return Winner;
    }


}