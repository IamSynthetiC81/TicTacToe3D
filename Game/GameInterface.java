import Exceptions.*;

public interface GameInterface {
    
    /**
     * Parses a move into the cell.
     * 
     * @param cell Cell where the move takes place.
     * @param player Player which makes the move.
     * @param level Level of the move.
     * @return Returns true if the move was a winning move, false if not.
     * @throws NullPointerException Occurs when the cell or the player parameter is null;
     * @throws InvalidLevel Occurs when the level parameter is incompatible with the current level.
     * @throws LevelOutOfBounds Occurs when the level parameter is out of bounds.
     */
    boolean Move(Cell cell, Player player, int level) throws NullPointerException, InvalidLevel, LevelOutOfBounds;

    // /**
    //  * Starts a game between two players.
    //  * @param player1 Player 1 of the game.
    //  * @param player2 player 2 of the game.
    //  * @return Returns true if game was succesfully created, false if not.
    //  * @throws NullPointerException Throws when either player is null.
    //  */
    // boolean StartGame(Player player1, Player player2) throws NullPointerException;



}
