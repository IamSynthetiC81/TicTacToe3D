package UserInterface;

import javax.swing.JPanel;

public class GameBoard extends JPanel {

    GameBoard_Cell[][] GameBoardCells;
    
    private int GridDimentions;

    public GameBoard(int GridDimentions) {
        this.GridDimentions = GridDimentions;
    }

    
    
}
