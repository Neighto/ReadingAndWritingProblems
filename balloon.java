package A5; //Package Name Subject to Change
import java.io.*;
import java.util.*;

public class balloon {

	//FIRE ARROWS AT BALLOONS
	
	public static void main(String[] args) throws Exception {
		
		String file = "testBalloons.txt";
		String file2 = "testBalloons_solution.txt";
		ArrayList<ArrayList<Integer>> result = ReadFile (file);
		WriteFile (result, file2);
	}
	
	public static ArrayList<ArrayList<Integer>> ReadFile (String file) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); //Will contain the list of balloons in each index
		
		//FILL RESULT
        try {
            Scanner f = new Scanner(new File(file));
            int numberOfProblems = Integer.parseInt(f.nextLine());
            
            String[] ln = f.nextLine().split("\\s+");
            
            int[] problemSize = new int[numberOfProblems];
            for (int i = 0; i < numberOfProblems; i++) {
            	problemSize[i] = Integer.parseInt(ln[i]);
            }
                        
            for (int j = 0; j < numberOfProblems; j++) {
            
	            String[] problem = f.nextLine().split("\\D+");
	            ArrayList<Integer> res = new ArrayList<>();
	            for (int i = 0; i < problemSize[j]; i++) {
	            	res.add(Integer.parseInt(problem[i]));
	            }
	            result.add(res);
            }
            f.close();
                        
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
            System.exit(1);
        }
        
        return result;
	}
	
	public static void WriteFile (ArrayList<ArrayList<Integer>> result, String file) {
		
		//File Writing Equipment
		try {
			FileWriter fw = new FileWriter (file);
			
			//LETS SOLVE THE BALLOON CRISIS
			int arrows = 0;
			int currentHeight = 0;
			ArrayList<Integer> problemIndex = new ArrayList<>();
			
			for (int i = 0; i < result.size(); i++) { //loop through test case
				arrows = 0; // reset arrow count
				problemIndex = result.get(i); //easier access to arraylist we want
				
				while (problemIndex.size() > 0) { //while balloons are still out there
					currentHeight = problemIndex.get(0); //get the first index
	
					for (int j = 0; j < problemIndex.size(); j++) { //loop through balloons
						if (currentHeight == problemIndex.get(j)) {
							currentHeight--; //arrow height goes down
							problemIndex.remove(j); //remove the popped balloon
							j--; //go back one because of removal
						}
					}
					arrows++; //that's an arrow for ya
				}
				fw.write(arrows + "\n"); //write the arrows
			}
			fw.close();
		}
		catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
	}
	
}





