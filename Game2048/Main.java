package Game2048;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


public class Main {
	
	
	 static int [][] Game= new int[4][4];
	 static int Score=0;
	 
	public static void main(String[] args) {
	//	String [] buttons= {"w","s","d","a"};
		int sum=0;
		
		initialize();
	
		while(Score!=2048)
		{Scanner button = new Scanner(System.in);    
	    String key = button.nextLine(); 
		
	    if (key.equals("w")) {
	    	for(int i=2;i>=0;i--) {		
	    			for(int j=0;j<4;j++) {
	    				
	    				if(Game[i][j]<=Game[i+1][j])
	    				{
	    					if(Game[i][j]==Game[i+1][j])
	    					{	Game[i][j]=Game[i+1][j]+Game[i+1][j];
	    						Score=Score+Game[i+1][j];
	    					    Game[i+1][j]=0;}
	    					if(Game[i][j]<Game[i+1][j] && Game[i][j]==0)
	    						{Game[i][j]=Game[i+1][j];
	    						Game[i+1][j]=0;}}  				
	    			}}	  	    
	    						}
	    
	    if (key.equals("s")) {
	    	for(int i=0;i<3;i++) {		
	    			for(int j=0;j<4;j++) {
	    				
	    				if(Game[i][j]>=Game[i+1][j])
	    				{
	    					if(Game[i+1][j]==Game[i][j])
	    					{	Game[i+1][j]=Game[i][j]+Game[i][j];
	    						Score=Score+Game[i][j];
	    					    Game[i][j]=0;}
	    					if(Game[i+1][j]<Game[i][j] && Game[i+1][j]==0)
	    						{Game[i+1][j]=Game[i][j];
	    						Game[i][j]=0;}}	    				
	    			}}	  
	    
	    						}
	    
	    if (key.equals("d")) {
	    		
	    			for(int j=0;j<3;j++) {
	    				for(int i=0;i<4;i++) {
	    				if(Game[i][j]>=Game[i][j+1])
	    				{
	    					if(Game[i][j+1]==Game[i][j])
	    					{	Game[i][j+1]=Game[i][j]+Game[i][j];
	    						Score=Score+Game[i][j];
	    					    Game[i][j]=0;}
	    					if(Game[i][j+1]<Game[i][j] && Game[i][j+1]==0)
	    						{Game[i][j+1]=Game[i][j];
	    						Game[i][j]=0;}}	    				
	    			}}	  
	    
	    						}
	    if (key.equals("a")) {
	    	
	    			for(int j=2;j>=0;j--) {
	    				for(int i=0;i<4;i++) {		
	    				if(Game[i][j]<=Game[i][j+1])
	    				{
	    					if(Game[i][j]==Game[i][j+1])
	    					{	Game[i][j]=Game[i][j+1]+Game[i][j+1];
	    						Score=Score+Game[i][j+1];
	    					    Game[i][j+1]=0;}
	    					if(Game[i][j]<Game[i][j+1] && Game[i][j]==0)
	    						{Game[i][j]=Game[i][j+1];
	    						Game[i][j+1]=0;}}  				
	    			}}	  	    
	    						}
	    
	    initialize()	;
		}
		
		
		
		
		
	}
	

	public static void initialize() {
		Random rand= new Random();
		Random Chance= new Random();
		int ChanceNum=Chance.nextInt(10);
		int row=rand.nextInt(4);
		int col=rand.nextInt(4);
		
		// Chance of 80% to be initialized with 2
		while (Game[row][col]==0) {
			if(ChanceNum<9)
				Game[row][col]=2;
				
			    //System.out.println(Game[row][col]);			
			else 
			{	Game[row][col]=4;	
						
		}	
		Print() ;
	}}

	public static void Print() {
		System.out.println("Score= " + Score);
		System.out.println(" " );
		for(int i=0;i<4;i++) {
			System.out.println("-------------------------");
			for (int j=0;j<4;j++) {
				
			System.out.print(" || ");
			System.out.print(Game[i][j]);		
			//System.out.print(" || ");
			
		
			}		
			System.out.print(" || ");
			System.out.println("                 ");}
			System.out.println("-------------------------");
			System.out.println(" " );
			System.out.println("Input a key w,s,d,a" );
	}
	
		
	
}
