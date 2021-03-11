package Sudoku;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.List;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set; 


public class Sudoku extends JPanel{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	JTextField field[][] = new JTextField[4][4];
	JTextField GridEx[][] = new JTextField[4][4];
	int digit;
	String digitString;
	JButton buttonClicked0 = new JButton("New");
	JButton buttonClicked1 = new JButton("Solve");
	JButton buttonClicked2 = new JButton("Clear");	
	int [][]digitGood=new int [4][4];
	int [][]digitGoodCheck=new int [4][4];
	
    		                                           

    public Sudoku() {
    	   	
     setLayout(new GridLayout(5,4,1,1));
     setBackground(Color.white);
     checkInit() ;
     initializebuttons();
     add(buttonClicked0);
     add(buttonClicked1);
     add(buttonClicked2);
     
    
     buttonClicked2.addActionListener((ActionEvent e) -> {
    	 
    	 clearAll();
         
         });
     
     buttonClicked0.addActionListener((ActionEvent e) -> {
		for(int x = 0; x < 4; x++)
        { for(int y = 0; y < 4; y++) {
        	if (digitGoodCheck[x][y]!=0) 
                field[x][y].setText("");}}
            
        checkInit();
        for(int x = 0; x < 4; x++)
        { for(int y = 0; y < 4; y++) {
        	if (digitGoodCheck[x][y]!=0) {
  				 field[x][y].setText(String.valueOf(digitGoodCheck[x][y])); 
        }}}
    
         });
     
     
     buttonClicked1.addActionListener((ActionEvent e) -> {
    	 
    	 if(checkCorrect()==false || checkForWin()==false)
         	JOptionPane.showMessageDialog(null, "Try again");
    	 	
    	 else
        	{if(checkForWin()==true);
            JOptionPane.showMessageDialog(null, "You won");
        	
        	}
         });
    	       
    }   
    
    
 
    public void initializebuttons()
    {	
        for(int x = 0; x < 4; x++)
        { for(int y = 0; y < 4; y++) {
       
            field[x][y] = new JTextField();    
            final Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK);
            Font font1 = new Font("SansSerif", Font.BOLD, 20);
            field[x][y].setHorizontalAlignment(JTextField.CENTER);
            field[x][y].setFont(font1);
            field[x][y].setBorder(fieldBorder);
          
            if (digitGoodCheck[x][y]!=0) {
				 field[x][y].setFont(font1);
				 field[x][y].setText(String.valueOf(digitGoodCheck[x][y]));     
				 add(field[x][y]);	 
			}
            else
           {  	field[x][y].setText("");
            	add(field[x][y]); 
       
           }   
        }
        }
       
    }
   
     
        public boolean checkForWin()
        { int[] indRow=new int [4];
          int[] indCol=new int [4];
          int suma;
          boolean a=false;
          boolean b=false;        
          boolean d=false;
          
          
          for(int x = 0; x < 4; x++) {
        	  for(int y = 0; y < 4; y++) {
        		  indRow[x]=digitGood[x][y];
        		  indCol[y]=digitGood[x][y];
        		  
        	  }}
        //horizontal win check
        	for(int x = 0; x < 4; x++)
            { 	            	
            	suma=digitGood[x][0]+digitGood[x][1]+digitGood[x][2]+digitGood[x][3];           	
                if(suma==10 && checkDuplicate(indRow)==false)
                    a=true;
            	}
                 
            //vertical win check
        	for(int y = 0; y < 4; y++)
            { 	suma=digitGood[0][y]+digitGood[1][y]+digitGood[2][y]+digitGood[3][y];
            	if( suma==10 && checkDuplicate(indCol)==false )            		
                    b=true;         
            }
                
        if(a==true && b==true)
            	d=true;
			return d;			
        }
        
        
        
        public boolean  checkCorrect() {
        	boolean b = true;
        	
        	for(int i=0;i<4;i++) {
        		for(int j=0;j<4;j++)
        	{digitGood[i][j]=Integer.parseInt(field[i][j].getText()); 
        	if (digitGood[i][j]<1  || digitGood[i][j]>4)
        		b=false;					        		
        }}
        	return b;
        }
       
        void clearAll() {
        	for(int x = 0; x < 4; x++)
            { for(int y = 0; y < 4; y++) {
       	   if (digitGoodCheck[x][y]==0) 
                    field[x][y].setText("");}}                        
        }
        
        public static boolean checkDuplicate(int[] array){
            Boolean duplicate = false;
            Set<Integer> set= new HashSet<>();
            for(int i : array){
                if(set.contains(i)){
                    duplicate = true;
            } else {
                set.add(i);         
            }
            }
            return duplicate;
        }
     
       public void paint(Graphics g) {

            		super.paintChildren(g);
            		g.setColor(Color.BLACK);                     
                    g.drawLine( 141, 0, 141, 268 ); 
                    g.drawLine( 0, 134, 300, 134 );
                }
        
       
     public boolean initializeSudoku() { 
    	 Random rand = new Random(); 
    	 Random rand1 = new Random();
    	 Random rand2 = new Random(); 
    	 int  num;
    	 int  col;
    	 int row;
    	 int[] indRow=new int [5];
         int[] indCol=new int [5];
         boolean a=false;
         boolean b=false;    
         int [] c=new int [10];    
         boolean d=false;
         int chk1;
         int chk2;
         int chk3;
         int chk4;
       		  
         for(int i=0;i<4;i++) {
        	 for(int j=0;j<4;j++) {
        		 digitGoodCheck[i][j]=0;
        	 }}             	  	
    	 
    	 for(int i=0;i<4;i++) {
    		num=rand.nextInt(5);
   		  	col=rand1.nextInt(4);
   		  	row=rand2.nextInt(4);   			
    		digitGoodCheck[row][col]=num;
    			 
    		indRow[row]=num;
    		num=rand.nextInt(5);
    		indCol[col]=num;}
    			 
    			 for(int y = 0; y < 4; y++)
                     if (checkDuplicate(indCol)==false && indCol[y]!=0)
                       b=true;
             	

             for(int y = 0; y < 4; y++)
                     if (checkDuplicate(indRow)==false && indRow[y]!=0)
                       a=true;
             	
                   
                     for(int i=0;i<4;i+=2) {
                    	 for(int j=0;j<4;j+=2) {
                    		 chk1=digitGoodCheck[i][j];
                             chk2=digitGoodCheck[i+1][j];
                             chk3=digitGoodCheck[i][j+1];
                             chk4=digitGoodCheck[i+1][j+1];
                             
                    		 if (( chk1==chk2) || (chk2==chk3) || (chk4==chk3)|| (chk1==chk4) || (chk2==chk3))
                    		  c[i]=100;
                    	 }}
                    		  
                    		 Boolean duplicate = false;
                             Set<Integer> set= new HashSet<>();
                             for(int i : c)
                             { if(set.contains(100))
                             {       duplicate = true;
                             }}       
                                              
                     
           if(a==true && b==true) 
        	   if(duplicate==false)
               	d=true;  
           
		return d;   	
     }
     

       		  
       		void checkInit() {       		
      				{ while(initializeSudoku()!=true)
      					initializeSudoku();     				     			     				
      				}     			
       		
       			}
       		        
        
    }
    	    
        
    