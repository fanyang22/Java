//Fan Yang
//Conference Project

import java.awt.geom.*;
import java.awt.Color;

public class Cell{
  
  private boolean currentState;
  private boolean nextState;
  private int x, y, height, width;
  private Rectangle2D.Double rect;

  public Cell(boolean currentState){
    this.currentState = currentState;  
  }
  
  public String toString() {
    if (this.currentState == true) {
      return "x";
    } else {
      return ".";
    }
  }
  
  public boolean getCurrentState() {
    return this.currentState;
  }
  
  public void setNextState(boolean value) {
    this.nextState = value;
  }
  
  public boolean updateBoolean(){
    this.currentState = nextState;
    return currentState;
  }
  
  public void setRect(int x, int y, int height, int width){
    this.x = x;
    this.y = y;
    this.height = height;
    this.width = width;
  }
  
  public Rectangle2D.Double getRect(){
    Rectangle2D.Double rect = new Rectangle2D.Double(x, y, height, width);
    return rect;
  }
  
  public Color getColor(){
    if (this.currentState == true) {
      return Color.BLACK;
    } else {
      return Color.WHITE;
    }
  }
  
}