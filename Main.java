//Fan Yang
//Conference Project

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class Main{
  
  public static MyJFrame gui;
  
  public static void main(String[] args) throws Exception{
    // ask the user to enter a txt file that contains the initial settings
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter the txt file: ");
    String filename = keyboard.nextLine();
    Scanner input = new Scanner(new File(filename));
    int size = input.nextInt();
    // create grid
    Cell[][] grid;
    grid = new Cell[size][size];
    // set up grid base on txt file & print out the initial setting
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++){
        if (input.hasNext()) {
          String word  = input.next();
          if (word.equals(".")){
            grid[i][j] = new Cell(false);
          }else{
            grid[i][j] = new Cell(true);
          }
          System.out.print(grid[i][j] + " " );
        } else {
          System.out.println("Error! Not enough data in input file!");
          return;
        }
      }
      System.out.println();
    }
    input.close(); 
    createGui(grid);
    while (true) {
      update(grid);
      gui.repaint();
      Thread.sleep(500);
    }
    /* this version calls printGrid to print out new grids and time steps on console ( instead of creating gui)
    for (int i = 1; i <= 10; i++) {
      System.out.println("Time step " + i + ":");
      update(grid);
      printGrid(grid);
    }
    */
  }
    /*the part creates random preset instead of a designed preset
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++){
      Random random = new Random();
      grid[i][j] = new Cell(random.nextBoolean());
      System.out.print(grid[i][j] + " " );
      }
      System.out.println();
    }
    */
  
  //update the grid base on rules
  public static void update(Cell[][] grid){
    int left, right, up, down, n;
    // find location of neighboring cells
    for(int i = 0; i < grid.length; i++){ 
      if (i == 0){up = grid.length-1;}else{up = i - 1;}
      if (i == grid.length-1){down = 0;}else{down = i + 1;}
      for(int j = 0; j < grid[i].length; j++){
        if (j == 0){left = grid[i].length - 1;}else{left = j - 1;}
        if (j == grid[i].length - 1){right = 0;}else{right = j + 1;}
        //calculate how many neigbhors are "alive"
        n = 0;
        if (grid[up][left].getCurrentState() == true) n++;
        if (grid[up][j].getCurrentState() == true) n++;
        if (grid[up][right].getCurrentState() == true) n++;
        if (grid[i][left].getCurrentState() == true) n++;
        if (grid[i][right].getCurrentState() == true) n++;
        if (grid[down][left].getCurrentState() == true) n++;
        if (grid[down][j].getCurrentState() == true) n++;
        if (grid[down][right].getCurrentState() == true) n++;
        // set cell's state based on the number of "live" neigbhors
        if ( n <= 1 || n >= 4){
          grid[i][j].setNextState(false); 
        }else if ( n == 2 && grid[i][j].getCurrentState() == false){
          grid[i][j].setNextState(false);
        }else if ( n == 2 && grid[i][j].getCurrentState() == true){
          grid[i][j].setNextState(true);
        }else if ( n == 3 && grid[i][j].getCurrentState() == false){
          grid[i][j].setNextState(true);
        }else if ( n == 3 && grid[i][j].getCurrentState() == true){
          grid[i][j].setNextState(true);
        }
      }
    }
    //make each Cell's currentState be its nextState value
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++){
        grid[i][j].updateBoolean();
      }
    }
  }
  public static void createGui(Cell[][] grid){
     gui = new MyJFrame(grid);
  }
  public static void printGrid(Cell[][] grid){
    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[i].length; j++){
        System.out.print(grid[i][j] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
}
  
  
  