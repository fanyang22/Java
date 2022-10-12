//Fan Yang
//Conference Project

import javax.swing.*;  // JFrame, JPanel, JButton
import java.awt.*;     // Color, Font, FlowLayout, GridLayout, BorderLayout

public class MyJFrame extends JFrame{
  public static int w;
  public static int h;
  public MyJPanel drawing;
  
  //constructor
  public MyJFrame(Cell[][] grid){
    this.drawing = new MyJPanel(grid);
    this.add(drawing);
    // configure frame parameters
    w = grid.length * 50;
    h = w + 20;
    this.setSize(w, h);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Game Of Life");
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
    
}