package Snake;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Sudoku.Sudoku;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    EventQueue.invokeLater(new Runnable() {
	    	  public void run() {
	    	JFrame window = new JFrame("Snake");	    
		    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	    
		    window.getContentPane().add(new Grid());
		    window.setBounds(150,0,700,700);
		    window.setVisible(true);}
	   });
	    
}
}
