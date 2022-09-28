import java.time.Duration;
import java.time.Instant;

public class Game {

    Player Player1;
    Player Player2;

    Board Board;

    Duration GameDuration;

    private static Instant gameStartInstant;

    Game(Player player1, Player player2, int dimentions){
        assert player1 != null : "Player 1 can not be null";
        assert player2 != null : "Player 2 can not be null";
        
        if(player1 == null || player2 == null)
            throw new NullPointerException("Player can not be null");        

        Player1 = player1;
        Player2 = player2;
        
        Board = new Board(dimentions);

        gameStartInstant = Instant.now();
    }

    /**
     * Checks the entire board for winning condition
     * @return Return the player that has won, or null of there is no winning condition.
     */
    public Player WinningCondition(){
        int Player1VerticalCounter      = 0;
        int Player1HorizontalCounter    = 0;
        int Player2VerticalCounter      = 0;
        int Player2HorizontalCounter    = 0;
        
        for(int i = 0 ; i < Rules.BOARD_DIMENTIONS ; i++ ){
            for(int j = 0 ; j < Rules.BOARD_DIMENTIONS ; j++ ){
                if(Board.getCell(i, j).Player   == Player1)
                    Player1HorizontalCounter++;
                if(Board.getCell(i,j).Player    == Player2)
                    Player2HorizontalCounter++;
                if(Board.getCell(j, i).Player   == Player1)
                    Player1VerticalCounter++;
                if(Board.getCell(i,j).Player    == Player2)
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
    public boolean WinningCindition(Cell cell){

        Player player = cell.getPlayer();

        int VerticalIndex       = cell.getVerticalCoordinate();
        int HorizontalIndex     = cell.getHorizontalCoordinate();

        int VerticalCounter     = 0;
        int HorizontalCounter   = 0;

        for(int i = 0 ; i < Rules.BOARD_DIMENTIONS ; i++ ){
            if(Board.getCell(HorizontalIndex, i).getPlayer() == player)
                VerticalCounter++;
            if(Board.getCell(i, VerticalIndex).getPlayer() == player)
                HorizontalCounter++;
        }
        return HorizontalCounter == Rules.BOARD_DIMENTIONS || VerticalCounter == Rules.BOARD_DIMENTIONS;
    }
}