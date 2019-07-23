package mancala;
import java.io.*;
import java.util.*;

public class mancalaBestMoves {

	//GREEDY ALGORITHM TO SOLVE MANCALA
	
	public static void main(String[] args) throws Exception {
		
		String file = "mancalaInputFile.txt";
		String file2 = "mancalaOutputFile.txt";
		MancalaSolver (file, file2);
	}
	
	public static void MancalaSolver (String file, String file2) {
						
		try {
			FileWriter fw = new FileWriter (file2);
				
		    try {
		       
	          Scanner f = new Scanner(new File(file));
		      int numberOfProblems = Integer.parseInt(f.nextLine());
		            	            
		      //For each problem
		      for (int a = 0; a < numberOfProblems; a++) {
		    	  
		  		  int pebbles = 0;
		    	  int[] mancalaBoard = new int[12]; //adjust '12' if Mancala Board Size Differs
		    	  String[] ln = f.nextLine().split("\\s+");
		    	  
		    	  for (int i = 0; i < mancalaBoard.length; i++) {
		    		  mancalaBoard[i] = Integer.parseInt(ln[i]);
		    		  if (mancalaBoard[i] == 1)
		    			  pebbles++; //get starting pebbles
		    	  }
		    	  
		    	  //Mancala: Get the max number of moves possible
		    	  int moves = 0;
		    	  moves = RecursiveMancala (mancalaBoard, moves);
		    	  pebbles -= moves; //Each move costs a pebble
		    	  fw.write(pebbles + "\n");
		    	  fw.write(System.getProperty("line.separator"));
		      }
		      
			  f.close();  
			  fw.close();
		    }
		    catch (FileNotFoundException e){
		    	System.out.println("File not found!");
		        System.exit(1);
		    }
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int RecursiveMancala (int[] mancalaBoard, int moves) {
		
		int bestMoves = 0;
		int bestMoves2 = 0;
		
		  for (int i = 0; i < mancalaBoard.length; i++) {
    		  			  
    		  if (mancalaBoard[i] == 1) { //pebble found
    			  
    			  if (i + 2 < mancalaBoard.length) { //is there space to move forward
    				  if (mancalaBoard[i+1] == 1 && mancalaBoard[i+2] == 0) {
    					  //make new array and update a counter
    					  int[] newBoard = new int[mancalaBoard.length];
    					  for (int j = 0; j < mancalaBoard.length; j++) {
    						  newBoard[j] = mancalaBoard[j];
    					  }
    					  newBoard[i] = 0;
    					  newBoard[i+1] = 0;
    					  newBoard[i+2] = 1;
    					  moves++;
    					  bestMoves = RecursiveMancala (newBoard, moves);
    					  moves = 0;
    				  }
    			  }
    			  
    			  if (i - 2 >= 0) { //is there space to move backward
       				  if (mancalaBoard[i-1] == 1 && mancalaBoard[i-2] == 0) {
       					  //make new array and update a counter
       					  int[] newBoard = mancalaBoard;
    					  for (int j = 0; j < mancalaBoard.length; j++) {
    						  newBoard[j] = mancalaBoard[j];
    					  }
    					  newBoard[i] = 0;
    					  newBoard[i-1] = 0;
    					  newBoard[i-2] = 1;
    					  moves++;
    					  bestMoves2 = RecursiveMancala (newBoard, moves);
    					  moves = 0;
    				  } 
    			  }
    			  
    		  }
    		  
    	  }
		  
		  if (bestMoves != 0 || bestMoves2 != 0) {
			  if (bestMoves > bestMoves2) {
				  return bestMoves;
			  }
			  else {
				  return bestMoves2;
			  }
		  }
		  
		  return moves;
		  
	}
	
}
