package Sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.geom.Line2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

class main {
	
	
	public static void main(String[] args) 
		{
		
            
		    JFrame window = new JFrame("Sudoku");	    
		    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	    
		    window.getContentPane().add(new Sudoku());
		    window.setBounds(300,375,300,375);
		    window.setVisible(true);
		
		   
		}
}


