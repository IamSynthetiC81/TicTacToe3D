import java.lang.System.Logger.Level;

import javax.naming.directory.InvalidAttributesException;

import Exceptions.InvalidLevel;
import Exceptions.LevelOutOfBounds;

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
     * @throws LevelOutOfBounds Throws when the level is out of bounds. 
     *                          see {@link Exceptions.LevelOutOfBounds} for more details
     * @throws InvalidLevel Throws when the level is incompatible with the current level of the cell
     *                          see {@link InvalidLevel} for more details.
     * @throws NullPointerException Throws when the player is null and the {@code Force } flag is set to false.
     */
    public void makeMove(Player player, int Level, boolean Force) throws LevelOutOfBounds, InvalidLevel{
        if(!Force){
            if(Level > Rules.MAX_LEVEL || Level < 0)
                throw new LevelOutOfBounds();
            if(Level <= CurrentLevel)
                throw new InvalidLevel();
            if(player == null)
                throw new NullPointerException("Player can not be null");
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
