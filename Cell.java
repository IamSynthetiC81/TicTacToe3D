import java.lang.System.Logger.Level;

import javax.naming.directory.InvalidAttributesException;

public class Cell {
    private static int VerticalCoordinate;
    private static int HorizontalCoordinate;

    private Player Player;
    private int CurrentLevel;

    Cell(int VerticalCoordinate, int HorizontalCoordinate){
        this.VerticalCoordinate = VerticalCoordinate;
        this.HorizontalCoordinate = HorizontalCoordinate;

        this.Player = null;
        this.CurrentLevel = 0;
    }

    /**
     * Passes a move into the {@link Cell cell}.
     * @param player The player that made the move. 
     * @param Level The level of the move.
     * @param Force Forces the {@value Level} into the cell
     * @throws Exception 
     */
    public void makeMove(Player player, int Level, boolean Force) throws Exception{
        if(!Force){
            if(Level > Rules.MAX_LEVEL || Level < 0)
                throw new Exception("Level of " + Level + " is out of bounds");    
            if(Level <= CurrentLevel)
                throw new InvalidAttributesException("Level of " + Level + " is not bigger than the current cell level of " + CurrentLevel);
        }

        this.Player = player;
        this.CurrentLevel = Level;
    }

    public int getVerticalCoordinate(){
        return VerticalCoordinate;
    }

    public int getHorizontalCoordinate(){
        return HorizontalCoordinate;
    }

    public int getLevel(){
        return CurrentLevel;
    }

    public Player getPlayer(){
        return Player;
    }

    


}
