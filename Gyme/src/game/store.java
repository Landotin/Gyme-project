package game;
	
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Font;
	import java.awt.GradientPaint;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	
	import javax.swing.BorderFactory;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.SwingConstants;
	
	public class store extends gyme {
		private fight fight;
		 public store() {     
			 super();
			 fight = new fight();
		 }
		 public static void main(String[] args) {
			//Store Frame
		     JFrame f_store;
		     JLabel s_skills, s_xp;
		     JLabel s_xp1, s_xp2, s_xp3;
		     JButton s_back, s_exer1, s_exer2, s_exer3;
		     JLabel s_achieve, s_count, s_exer11, s_exer22, s_exer33,s_total1, s_total2, s_total3;
		   
		     f_store = new JFrame();
		     f_store.setTitle("Store");
		     f_store.setSize(800, 600);
		     f_store.setLayout(null);
		     f_store.setResizable(false);
		     f_store.getContentPane().setBackground(DARK_BACKGROUND);
		       JPanel storePanel = new JPanel() {
		           @Override
		           protected void paintComponent(Graphics g) {
		               Graphics2D g2d = (Graphics2D) g;
		               GradientPaint gradient = new GradientPaint(0, 0, DARK_BACKGROUND, 0, getHeight(), DARK_PURPLE);
		               g2d.setPaint(gradient);
		               g2d.fillRect(0, 0, getWidth(), getHeight());
		           }
		       };
		       storePanel.setLayout(null);
		       storePanel.setBounds(0, 0, 800, 600);
		              
		       //Add panel to frame
		       f_store.add(storePanel);
		       f_store.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       f_store.setVisible(true);
		     
		     f_store.setLayout(null);
		   
		     //Back button
		     s_back = new JButton ("Go Home");
		     s_back.setBounds(650, 500, 100, 30);
		     s_back.setBackground(VIBRANT_PURPLE);
		     s_back.setForeground(Color.WHITE);
		     s_back.setFont(new Font("Arial", Font.BOLD, 14));
		     s_back.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
		     s_back.setFocusPainted(false);
		    
		   
		     //Header
		     s_skills = new JLabel ("Currency: ");
		     s_skills.setBounds(10, 10, 100, 50);
		     s_skills.setBackground(DARK_PURPLE);
		     s_skills.setForeground(Color.MAGENTA);
		     
		     
		     s_xp = new JLabel("XP =" + gyme.xp[0]);
		     s_xp.setBounds(70, 10, 100, 50);
		     s_xp.setBackground(DARK_PURPLE);
		     s_xp.setForeground(Color.MAGENTA);
		     
		   
		     //Button for buying new set of exercise
		     s_exer1 = new JButton ("Dip");
		     s_exer1.setBounds(10, 50, 90, 40);
		     s_exer1.setBackground(VIBRANT_PURPLE);
		     s_exer1.setForeground(Color.WHITE);
		     s_exer1.setFont(new Font("Arial", Font.BOLD, 14));
		     s_exer1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
		     s_exer1.setFocusPainted(false);
		    
		     
		     s_exer2 = new JButton ("Plank");
		     s_exer2.setBounds(10, 100, 90, 40);
		     s_exer2.setBackground(VIBRANT_PURPLE);
		     s_exer2.setForeground(Color.WHITE);
		     s_exer2.setFont(new Font("Arial", Font.BOLD, 14));
		     s_exer2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
		     s_exer2.setFocusPainted(false);
		     
		     
		     s_exer3 = new JButton ("Jumping Jacks");
		     s_exer3.setBounds(10, 150, 130, 40);
		     s_exer3.setBackground(VIBRANT_PURPLE);
		     s_exer3.setForeground(Color.WHITE);
		     s_exer3.setFont(new Font("Arial", Font.BOLD, 14));
		     s_exer3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
		     s_exer3.setFocusPainted(false);
		   
		     //Cost of exercise
		     s_xp1 = new JLabel ("10xp");
		     s_xp1.setBounds(110, 50, 100, 50);
		     s_xp1.setBackground(DARK_PURPLE);
		     s_xp1.setForeground(Color.MAGENTA);
		     
		     
		     s_xp2= new JLabel ("10xp");
		     s_xp2.setBounds(110, 100, 100, 50);
		     s_xp2.setBackground(DARK_PURPLE);
		     s_xp2.setForeground(Color.MAGENTA);
		    
		     
		     s_xp3= new JLabel ("10xp");
		     s_xp3.setBounds(150, 150, 100, 50);
		     s_xp3.setBackground(DARK_PURPLE);
		     s_xp3.setForeground(Color.MAGENTA);
		   
		     //Achievements
		     s_achieve = new JLabel ("Achievements: ");
		     s_achieve.setBounds(10, 300, 100, 50);
		     s_achieve.setBackground(DARK_PURPLE);
		     s_achieve.setForeground(Color.MAGENTA);
		     
		     s_count = new JLabel ("0/60");
		     s_count.setBounds(110, 300, 100, 50);
		     s_count.setBackground(DARK_PURPLE);
		     s_count.setForeground(Color.MAGENTA);
		     
		     
		     s_exer11= new JLabel ("Push Up: ");
		     s_exer11.setBounds(10, 350, 100, 50);
		     s_exer11.setBackground(DARK_PURPLE);
		     s_exer11.setForeground(Color.MAGENTA);
		     
		     s_exer22= new JLabel ("Sit Up: ");
		     s_exer22.setBounds(10, 380, 100, 50);
		     s_exer22.setBackground(DARK_PURPLE);
		     s_exer22.setForeground(Color.MAGENTA);
		     
		     s_exer33= new JLabel ("Pull Up: ");
		     s_exer33.setBounds(10, 410, 100, 50); 
		     s_exer33.setBackground(DARK_PURPLE);
		     s_exer33.setForeground(Color.MAGENTA);
		     
		     s_total1= new JLabel ("0");
		     s_total1.setBounds(70, 350, 100, 50);
		     s_total1.setBackground(DARK_PURPLE);
		     s_total1.setForeground(Color.MAGENTA);
		     
		     s_total2= new JLabel ("0");
		     s_total2.setBounds(70, 380, 100, 50);
		     s_total2.setBackground(DARK_PURPLE);
		     s_total2.setForeground(Color.MAGENTA);
		     
		     s_total3= new JLabel ("0");
		     s_total3.setBounds(70, 410, 100, 50);
		     s_total3.setBackground(DARK_PURPLE);
		     s_total3.setForeground(Color.MAGENTA);
		   
		     f_store.setVisible(true);
		   
		     
		     
		     storePanel.add(s_back);
		     storePanel.add(s_skills);
		     storePanel.add(s_xp);
		     storePanel.add(s_exer1);
		     storePanel.add(s_exer2);
		     storePanel.add(s_exer3);
		     storePanel.add(s_xp1);
		     storePanel.add(s_xp2);
		     storePanel.add(s_xp3);
		     storePanel.add(s_achieve);
		     storePanel.add(s_count);
		     storePanel.add(s_exer11);
		     storePanel.add(s_exer22);
		     storePanel.add(s_exer33);
		     storePanel.add(s_total1);
		     storePanel.add(s_total2);
		     storePanel.add(s_total3);
		     
		     s_back.addActionListener(new ActionListener() {
		    	 public void actionPerformed(ActionEvent e) {
		    		 f_store.setVisible(false);
		    		 f_homepage.setVisible(true);
		    		
		    	 }
		     });
		     
		    
		     s_exer1.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		             if (gyme.xp[0] >= 10) {
		                 gyme.xp[0] -= 10;     
		                 gyme.isDipPurchased = true;
		                 s_xp.setText("XP: " + gyme.xp[0]); 
		                 if (gyme.isDipPurchased) {
		                 JOptionPane.showMessageDialog(f_store, "Dip skill purchased!");
		                    s_exer1.setEnabled(false);  // Disable button after purchase
		                 }
	
		             } 
		       
		                    else {
		            	 JOptionPane.showMessageDialog(f_store, "You don't have enough XP to buy this skill!");
		             }
		         }
		     });
		     	if (gyme.isDipPurchased) {
	        
	                s_exer1.setEnabled(false);  // Disable button after purchase
	             }
	
		     
		     s_exer2.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		             if (gyme.xp[0] >= 10) {
		                 gyme.xp[0] -= 10; 
		                 gyme.isPlankPurchased = true;
		                 s_total2.setText(String.valueOf(Integer.parseInt(s_total2.getText()) + 1)); 
		                 JOptionPane.showMessageDialog(f_store, "Plank skill purchased!");
		                 s_xp.setText("XP: " + gyme.xp[0]); 
		                 s_exer2.setEnabled(false);
		               
		                 
		             } else {
		            	 JOptionPane.showMessageDialog(f_store, "You don't have enough XP to buy this skill!");
		             }
		         }
		     });
		     if (gyme.isPlankPurchased) {
	                s_exer2.setEnabled(false);  // Disable button after purchase
	             }
	
		     
		     s_exer3.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		             if (gyme.xp[0] >= 10) {
		                 gyme.xp[0] -= 10; // Deduct XP
		                 gyme.isJumpingJacksPurchased = true;
		                 s_total3.setText(String.valueOf(Integer.parseInt(s_total3.getText()) + 1)); 
		                 JOptionPane.showMessageDialog(f_store, "Jumping Jack skill purchased!");
		                 s_xp.setText("XP: " + gyme.xp[0]);
		                 s_exer3.setEnabled(false);
		                
		             } else {
		            	 JOptionPane.showMessageDialog(f_store, "You don't have enough XP to buy this skill!");
		             }
		         }
		         
		     });
		     if (gyme.isJumpingJacksPurchased) {
	             s_exer3.setEnabled(false);  // Disable button after purchase
	          }
		 }
	}
