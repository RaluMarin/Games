package Invadors;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel{
	
	
	public static void main(String[] args) {
		
	    EventQueue.invokeLater(new Runnable() {
	    	 public void run() {
	    	JFrame window = new JFrame("Invadors");	    
	    	Main Pic=new Main();
		    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	 
		    window.add(Pic);
		    window.setSize(800,600);
		    window.getContentPane().add(new gridInvadors());
		 //   window.setBounds(150,0,700,700);
		    window.setVisible(true);}
	  });
	    
}

	}


