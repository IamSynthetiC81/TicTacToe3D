package UserInterface;

import Game.*;
import javax.swing.*;
import java.awt.*;

public class GameBoard_Cell extends JButton {
    private int VerticalCoordinate;
    private int HorizontalCoordinate;
    
    protected GameParticipant Symbol;
    protected int Level;

    GameBoard_Cell(int VerticalCoordinate, int HorizontalCoordinate) {
        this.VerticalCoordinate = VerticalCoordinate;
        this.HorizontalCoordinate = HorizontalCoordinate;

        this.Symbol = null;
        this.Level = 0;
    }

    public void ParseMove(GameParticipant symbol, int Level ) {
        this.Level = Level;
        this.Symbol = Symbol;
    }

    public int getVerticalCoordinate() {
        return VerticalCoordinate;
    }

    public int getHorizontalCoordinate() {
        return HorizontalCoordinate;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(150, 150, 100, 100);
        g2d.setColor(this.Symbol.getColor());
    }

}
