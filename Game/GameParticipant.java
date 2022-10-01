package Game;

import java.awt.*;

public abstract class GameParticipant {

    Player player;
    Color Color;

    public Player getPlayer() {
        return player;
    }
    
    public boolean isPlayer(Player playerToCompare) {
        return player == playerToCompare;
    }

    public void setColor(Color color) {        
        Color = color;
    }

    public Color getColor() {
        return Color;
    }
}
