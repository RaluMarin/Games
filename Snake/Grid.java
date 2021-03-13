package Snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Grid extends JPanel implements ActionListener{
	
	 int Pixel=15;
	 int Height=700;
	 int Width=700;
	 int TotalPixels=Height/2;
	
	 int lengthSnake=3;
	 int [] x=new int [TotalPixels];
	 int [] y=new int [TotalPixels];
	
	 
	 int foodCoordX;
	 int foodCoordY;
		
	 boolean movingLeft=false;
	 boolean movingRight=false;
	 boolean movingDown=false;
	 boolean movingUp=false;
	 
	 boolean Run=false;
	 static int speed = 100;
	 Timer timer;
	
	Grid (){
		setBackground(Color.BLACK);
		addKeyListener(new Keys());
		setFocusable(true);
		initialize();	
	 	    }
	
	protected void paintComponent(Graphics g) {
	     super.paintComponent(g);
	     draw(g);
	 }

	
	void draw(Graphics g) {
	     
	     if (Run == true) {
	         for (int i = 0; i < lengthSnake; i++) {
	        	 	 g.setColor(Color.RED);
	                 g.fillRect(x[i],y[i],Pixel, Pixel);   
	         		 g.setColor(Color.YELLOW);
	         		 g.fillRect(foodCoordX, foodCoordY, Pixel, Pixel); }	         
	   } else {
		   gameStop(g);		  
	     }
	 }
	
	
	public void initialize() {
		 Run=true;
		 createFood();
		 
		 for (int i = 0; i < lengthSnake; i++) {
	         x[i]=(Width / 2);
	         y[i]=(Height / 2);
	     }
		 
		 movingLeft=true;
		 timer = new Timer(speed, this);
		 timer.start();
		 repaint();
	}
	
	public void moveSnake() {
	    for (int i = lengthSnake; i > 0; i--) {
	        x[i] = x[(i - 1)];
	        y[i] = y[(i - 1)];
	    }
	    
	    if (movingDown==true) {
	        y[0] += Pixel;
	    }
	  
	    if (movingUp==true) {
	        y[0] -= Pixel;
	    }
	    
	    if (movingLeft==true) {
	        x[0] -= Pixel;
	    }
	  
	    if (movingRight==true) {
	        x[0] += Pixel;
	    }
	   
   
	}

		public void actionPerformed(ActionEvent e) {
			moveSnake();
			EatFood() ;
			OutOfThePicture();
			repaint();
		}
		
		 private class Keys extends KeyAdapter {

		     @Override
		     public void keyPressed(KeyEvent e) {
		    	 
		    	 int key = e.getKeyCode();
		    	 
		    	 if ((key == KeyEvent.VK_LEFT) && (movingRight==false)) {
		        	 movingLeft=true;
		        	 movingUp=false;
		        	 movingDown=false;
		       
		         }
		         if ((key== KeyEvent.VK_RIGHT) && (movingLeft==false)) {
		        	 movingRight=true;
		        	 movingUp=false;
		        	 movingDown=false;
		        
		             
		         }
		         if ((key == KeyEvent.VK_UP) && (movingDown==false)) {
		        	 movingUp=true;
		        	 movingRight=false;
		        	 movingLeft=false;
		        
		         }
		         if ((key == KeyEvent.VK_DOWN) && (movingUp==false)) {
		        	 movingDown=true;
		        	 movingRight=false;
		        	 movingLeft=false;
		        	
		         }
		         moveSnake();
	            }
	       
	      
		    	 
		    	 
		 }
		 
		  void createFood() {
			 Random rand= new Random();
			 foodCoordX=rand.nextInt(TotalPixels)+50;
			 foodCoordY=rand.nextInt(TotalPixels)+50;
			 
		 }
		 
		 void EatFood() {
			 if ((Math.abs(foodCoordX-x[0])<=Pixel-5) && ((Math.abs(foodCoordY-y[0])<=Pixel-5)))
			 { lengthSnake++;
			 	createFood();}
		 }
		 
		 void OutOfThePicture() {
			 if ((x[0]<=0 || y[0]<=0) ||( x[0]>=Height || y[0]>=Height)) {
				Run=false;
			 }							 
		 }

		 void gameStop(Graphics g) {
			
		}
		 
		 
		 }

	

