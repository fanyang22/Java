//Fan Yang
//Conference Project

import javax.swing.*;  // JFrame, JPanel, JButton
import java.awt.*;     // Color, Font, FlowLayout, GridLayout, BorderLayout
import java.awt.geom.*;

public class MyJPanel extends JPanel {
  private Cell[][] grid;
  // constructor
  public MyJPanel(Cell[][] grid){
    this.grid = grid;
    // initialize graphics info in each grid Cell
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++){
        grid[i][j].setRect(i*50,j*50,50,50);
      }
    }
  }
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D pen = (Graphics2D) g;
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++){
        Rectangle2D.Double rect = grid[i][j].getRect();
        pen.setColor(grid[i][j].getColor());
        pen.fill(rect);
        pen.setColor(Color.WHITE);
        pen.draw(rect);
      }
    }
  }
}
