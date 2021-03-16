package Invadors;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



public class gridInvadors extends JPanel implements ActionListener{
	/**
	 * Image Pic;
	//Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Raluca\\eclipse-workspace\\tutorial\\src\\Invadors\\Pictures\\Background.png");
	
	public Main() {
		ImageIcon obj=new ImageIcon("C:\\Users\\Raluca\\eclipse-workspace\\Games\\src\\Invadors\\Background.jpg");
		Pic=obj.getImage();
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Pic, 0, 0, null);
     }
	 */
	
	 private static final long serialVersionUID = 1L;
	 Image Pic;
	 Image Pic2;
	 Image Pic3;
	 
	 int Pixel=15;
	 int Height=800;
	 int Width=600;
	 int TotalPixels=Width/2;
	 
	 int PostionRocket;
	 int AlienX[][]=new int [20][10];
	 int AlienY[][]=new int [20][10];
	 int AlienShootingX;
	 int AlienShootingY;
	 boolean Invading=false;
	 Random rand;
	 
	 boolean drawing=true;
	 boolean[] AlienNumber=new boolean[40];
	 boolean[] AlienInvader=new boolean[40];
	 
	 boolean movingLeft=false;
	 boolean movingRight=false;
	 
	 boolean Shoot=false;
	 int ShootY=600;
	 int StoreX;
	 	 	 
	 boolean Run=false;
	 
	 static int speed = 100;
	 Timer timer;
	
	gridInvadors(){
		ImageIcon obj=new ImageIcon("C:\\Users\\Raluca\\eclipse-workspace\\Games\\src\\Invadors\\Background.jpg");
		ImageIcon rocket=new ImageIcon("C:\\Users\\Raluca\\eclipse-workspace\\Games\\src\\Invadors\\Rocket.jpg");
		ImageIcon alien=new ImageIcon("C:\\Users\\Raluca\\eclipse-workspace\\Games\\src\\Invadors\\alien.jpg");
		
		Pic=obj.getImage();
		Pic2=rocket.getImage();
		Pic3=alien.getImage();
		
		addKeyListener(new Keys());
		setFocusable(true);
		initialize();	
	//	AlienInvading();
	 	
		
	}

	private void initialize() {
		 Run=true;
		 PostionRocket=Width/2;
		 createMonsters();
		 Invading=true;
		 AlienShootingY=1000;
		 AlienShootingX=1000;
		 timer = new Timer(speed, this);
		 timer.start();
		 repaint();
		
	}
	
	public void moveRocket() {
	    int count=0;
	   
	  
	    if (Invading==true && AlienShootingY<=500 && AlienNumber[count]==true) {
	    	AlienShootingY += Pixel;
	    	 
	    			if((Math.abs(AlienShootingY-500)<=15) && (Math.abs(AlienShootingX-PostionRocket)<=15))
	    			Run=false;
	    	}
	    	
	    else { AlienInvading();
	    	
	    }   		
	    
		
	    if (movingRight==true) {
	    	PostionRocket += Pixel;
	        movingRight=false;
	    }
	    
	    if (movingLeft==true) {
	    	PostionRocket -= Pixel;
	        movingLeft=false;
	    }
	    if (Shoot==true) {
	    	
	    	ShootY -= Pixel;
	    	for (int j=0;j<3;j++)
			{for (int i=0;i<10;i++) {				
				if((Math.abs(ShootY-AlienY[i][j])<=20) && (Math.abs(StoreX-AlienX[i][j])<=20) && AlienNumber[count]==true) {
					 Shoot=false;
					 ShootY=600;
					// drawing=false;
					 AlienNumber[count]=false;
					 AlienInvader[count]=false;
				}
				count++;
				//drawing=true;
			}
			
			}
	    	if(ShootY<=0)
	    	{	 Shoot=false;
			  	 ShootY=600;}
	    }   
	   // drawing=true;
	
		}

	public void createMonsters() {
		int positionX=Width/5;
		int positionY=200;
		int count=0;
		for (int j=0;j<3;j++)
		{for (int i=0;i<10;i++)			
		{	AlienX[i][j]=positionX;
			AlienY[i][j]=positionY;				
			AlienNumber[count]=true;
			AlienInvader[count]=true;
			count++;
			positionX+=60;}
			positionX=Width/5;
			positionY+=60;}
			
		
			
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Pic, 0, 0, null);
        draw(g);
     
     }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		moveRocket();
		//AlienInvading();
		
		
		repaint();
	}
	
	 void AlienInvading() {
		 	rand= new Random();
		 	
		 	int i;
		 	int j;
		 	
		 	
		 	 	 i=rand.nextInt(10);
			 	 j=rand.nextInt(3);
		 	  	 AlienShootingX=AlienX[i][j];
		 		 AlienShootingY=AlienY[i][j];
		 		
		 
		 			
		 	  
		 	 /*else 
		 	    count++;
		 	 { i=rand.nextInt(5)+1;
			   j=rand.nextInt(2)+1;}*/
			  
	}

	private class Keys extends KeyAdapter {

	     @Override
	     public void keyPressed(KeyEvent e) {
	    	 
	    	 int key = e.getKeyCode();
	    	 
	    	 if (key == KeyEvent.VK_LEFT) {
	        	 movingLeft=true;
	       
	         }
	         if (key== KeyEvent.VK_RIGHT)  {
	        	 movingRight=true;
	        	  
	         }
	         if (key == KeyEvent.VK_UP)  {
	        	 Shoot=true;
	        	 StoreX=PostionRocket;
	        	 
	         }
	         moveRocket();
	       
	         }
	     
	     	
            }
       
      
void draw(Graphics g) {
	 int count=0;
	 
	     if (Run == true) {
	
	         	 g.drawImage(Pic2, PostionRocket,500, null);
	         	
	         	for (int i=0;i<3;i++)
	         	{	for (int j=0;j<10;j++)	         		
	         		{if(AlienNumber[count]==true)
	         		g.drawImage(Pic3, AlienX[j][i],AlienY[j][i], null);
	         		count++;
	         		}
	         		
	        		}
	         	for (int i=0;i<30;i++)
	         	if(AlienInvader[i]==true)
	         	{	g.setColor(Color.RED);
	         		g.fillRect(AlienShootingX+30, AlienShootingY, Pixel/2, Pixel/2); }
       	 	 
	        	 	 g.setColor(Color.YELLOW);
	        	 	 g.fillRect(StoreX+30, ShootY, Pixel/2, Pixel/2); 
	        	 	// g.fillRect(StoreX+30, ShootY, Pixel/2, Pixel/2);
	         
	  } else {
		   gameStop(g);		  
	     }
	     
		
	}
	void gameStop(Graphics g) {
		String message = "Game over";

	    // Create a new font instance
	    Font font = new Font("Times New Roman", Font.BOLD, 20);
	    FontMetrics metrics = getFontMetrics(font);

	    // Set the color of the text to red, and set the font
	    g.setColor(Color.red);
	    g.setFont(font);

	    // Draw the message to the board
	    g.drawString(message, (Width - metrics.stringWidth(message)) / 2,
	            Height / 2);

	   

	
}

}
