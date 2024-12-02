package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	   
	     //Back button
	     s_back = new JButton ("Go Home");
	     s_back.setBounds(650, 500, 100, 30);
	   
	     //Header
	     s_skills = new JLabel ("Currency: ");
	     s_skills.setBounds(10, 10, 100, 50);
	     s_xp = new JLabel("XP =" + gyme.xp[0]);
	     s_xp.setBounds(70, 10, 100, 50);
	     
	   
	     //Button for buying new set of exercise
	     s_exer1 = new JButton ("Dip");
	     s_exer1.setBounds(10, 50, 90, 40);
	    
	     
	     s_exer2 = new JButton ("Plank");
	     s_exer2.setBounds(10, 100, 90, 40);
	     
	     
	     s_exer3 = new JButton ("Jumping Jacks");
	     s_exer3.setBounds(10, 150, 130, 40);
	   
	     //Cost of exercise
	     s_xp1 = new JLabel ("10xp");
	     s_xp1.setBounds(110, 50, 100, 50);
	     
	     
	     s_xp2= new JLabel ("10xp");
	     s_xp2.setBounds(110, 100, 100, 50);
	    
	     
	     s_xp3= new JLabel ("10xp");
	     s_xp3.setBounds(150, 150, 100, 50);
	   
	     //Achievements
	     s_achieve = new JLabel ("Achievements: ");
	     s_achieve.setBounds(10, 300, 100, 50);
	     s_count = new JLabel ("0/60");
	     s_count.setBounds(110, 300, 100, 50);
	   
	     s_exer11= new JLabel ("Push Up: ");
	     s_exer11.setBounds(10, 350, 100, 50);
	     s_exer22= new JLabel ("Sit Up: ");
	     s_exer22.setBounds(10, 380, 100, 50);
	     s_exer33= new JLabel ("Pull Up: ");
	     s_exer33.setBounds(10, 410, 100, 50);  
	     s_total1= new JLabel ("0");
	     s_total1.setBounds(70, 350, 100, 50);
	     s_total2= new JLabel ("0");
	     s_total2.setBounds(70, 380, 100, 50);
	     s_total3= new JLabel ("0");
	     s_total3.setBounds(70, 410, 100, 50);
	   
	     f_store.setVisible(true);
	   
	     f_store.add(s_back);
	     f_store.add(s_skills);
	     f_store.add(s_xp);
	     f_store.add(s_exer1);
	     f_store.add(s_exer2);
	     f_store.add(s_exer3);
	     f_store.add(s_xp1);
	     f_store.add(s_xp2);
	     f_store.add(s_xp3);
	     f_store.add(s_achieve);
	     f_store.add(s_count);
	     f_store.add(s_exer11);
	     f_store.add(s_exer22);
	     f_store.add(s_exer33);
	     f_store.add(s_total1);
	     f_store.add(s_total2);
	     f_store.add(s_total3);
	     
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
