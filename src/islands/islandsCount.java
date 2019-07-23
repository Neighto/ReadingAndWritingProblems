package islands;
import java.io.*;
import java.util.*;

public class islandsCount {

	//COUNT THE ISLANDS
	
	public static void main(String[] args) throws Exception {
			
		String file = "islandsInputFile.txt";
		String file2 = "islandsOutputFile.txt";
		IslandCount (file, file2);
	}
		
	public static void IslandCount (String file, String file2) {
			
	//Use a Recursive Algorithm (GetNeighbors is recursive)
			
		int[][] result = null;
		int islands = 0;
		
		try {
			FileWriter fw = new FileWriter (file2);
				
			//FILL RESULT
		    try {
		       
	          Scanner f = new Scanner(new File(file));
		      int numberOfProblems = Integer.parseInt(f.nextLine());
		            	            
		      //loop through each problem
		      for (int a = 0; a < numberOfProblems; a++) {
		            	
		    	  String[] ln = f.nextLine().split("\\s+");
			       int y = Integer.parseInt(ln[0]);
			       int x = Integer.parseInt(ln[1]);			            
			       result = new int[y][x];
			            
			       //fill result with current map
			       for (int j = 0; j < y; j++) {
			            ln = f.nextLine().split("");
			            for (int i = 0; i < x; i++) {
			            	if (ln[i].equals("#")) 
			            		result[j][i] = 0;
			            	else
			            		result[j][i] = 1;
			            }
			       }
			            
			       //search for land
			       for (int j = 0; j < result.length; j++) {
			            for (int i = 0; i < result[j].length; i++) {
			            	if (result[j][i] != 0) { //found land
			            		GetNeighbors (result, j, i);
			            		islands++;
			            	}
			            }
			       }
			            
				   fw.write(islands + "\n");
				   fw.write(System.getProperty("line.separator"));
				   islands = 0;
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
		
	public static void GetNeighbors (int[][] array, int y, int x) {
		//Assuming updating array updates result...
		//In other function we will up the number of islands each time
		//GetNeighbors is called and set all island members to zero.
			
    		if (x + 1 < array[y].length) {
    			if (array[y][x+1] != 0) {
    				array[y][x+1] = 0;
    				GetNeighbors (array, y, x + 1);
    			}
    		}
    		if (x - 1 >= 0) {
    			if (array[y][x-1] != 0) {
    				array[y][x-1] = 0;
    				GetNeighbors (array, y, x - 1);
    			}
    		}
    		if (y + 1 < array.length) {
    			if (array[y+1][x] != 0) {
    				array[y+1][x] = 0;
    				GetNeighbors (array, y + 1, x);
    			}
    		}
    		if (y - 1 >= 0) {
    			if (array[y-1][x] != 0) {
    				array[y-1][x] = 0;
    				GetNeighbors (array, y - 1, x);
    			}
    		}
	}
	
}
