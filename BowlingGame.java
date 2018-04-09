// TODO: Auto-generated Javadoc
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 *
 * @author BCC1117
 */
public class BowlingGame {
	
	/** The Constant X. */
	public static final int X = 10;
	

    /**
     * The frames.
     *
     */
   
	
	static Scanner in = new Scanner(System.in);
	
	
   
    /** The frames. */
    public static String[] frames = {"XXXXXXXXXXXX",
    									"9-9-9-9-9-9-9-9-9-9-",
    									"5/5/5/5/5/5/5/5/5/5/5",
    									"X7/9-X-88/-6XXX81"};
    
    /**
     * 
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
    	
    
    	
    	//weak user interface,a bit overboard
    	System.out.println("Welcome to Ben's Bowling Alley");
    	//String inputs are already pre-declared
    	
    	for(int i=0; i<frames.length; i++) {
            System.out.println("\n Score of game with [" + frames[i] + "] as input: " + score(parser(frames[i])));
            System.out.println("\n");													// logic ^
            
        }
    }

    /**
     * score.
     *
     * @param frames the frames
     * @return the int
     */
    static int score(int[] frames) {
    	do {
        int total = 0;
        int gameScore = 0;
        for(int i = 0; i <= frames.length-4; i++) {
        	
            if(frames[i] ==10) {
                total = total + 10 + frames[i+1] + frames[i+2];
            } else if(frames[i] + frames[1 + i] == 10) {
                total = total + 10 + frames[i + 2];
                i++; //forceful increment
            } else {
                total = total + frames[i] + frames[i+1];
                i++;  //forceful increment
            }
        } //extra 3 frames should there be strikes or spares.
        for(int j = frames.length-3; j < frames.length; j++) {
            total += frames[j];
        }
        return total;
    }while(frames.length < 12);
    	
    }
    	

   
    /**
     * Parser class
     *
     * @param f the f
     * @return the int[]
     */
    public static int[] parser(String f) {
    	
    	int[] game = new int[f.length()];
    	//int scores = 0;     
        int frame = 0;
        
        

        for(int i = 0 ; i < f.length(); i++) {
            String score = String.valueOf(f.charAt(i));

            switch (score) {
                case "X":
                    game[frame] = 10;
                    System.out.print("Strike! ");
                    break;
                case "x": //just for lowercase
                    game[frame] = 10;
                    System.out.print("Strike! ");
                    break;
                case "/":
                    int prev = game[frame-1];
                    int temp = -(prev - 10);
                    game[frame] = temp; //calculate spare 
                    System.out.print(game[frame] + " + ");
                    break;
                case "-":
                    game[frame] = 0;
                    System.out.print("Miss! ");
                    break;
                default:
                    game[frame] = Integer.parseInt(score);
                    System.out.print(game[frame] + " + ");
                    break;
            }
            frame++;
        }
        return game; 
    }
}


