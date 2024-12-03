package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.util.Timer;
import java.util.TimerTask;

public class homepage extends gyme {
	 private static boolean canCompleteTask = true;  
	 private static boolean canCompleteExerciseTask = true;
	 private static Timer cooldownTimer; 
	 private static JLabel cooldown, cooldown2;
	 private static JButton reg_complete;
	 

	 static boolean isCooldownActive = false;
	 static boolean isExerciseCompleted = false;

	 public homepage() {
		 super();
	 }
	 public static void main(String[] args) {
		//Frame for homepage
	     JButton b_attack, b_inventory, b_store, b_skills, b_settings;
	     JButton b_complete;
	     JPanel p_task, p_exercise;
	     JLabel l_task, l_exercise;
	     JLabel l_exp, l_exp1, l_exp2, l_exp3, l_exp4;
	     JLabel l_cnt, l_cnt1, l_cnt2, l_cnt3, l_cnt4;
	     JLabel l_workout, l_workout1, l_workout2, l_workout3, l_workout4;
	     JCheckBox cb_task1, cb_task2, cb_task3;
	    
	    
	     f_homepage = new JFrame();
	     f_homepage.setTitle("HOMEPAGE");
	     f_homepage.setSize(800, 600);
	     f_homepage.setLayout(null);
	     f_homepage.setResizable(false);
	     f_homepage.getContentPane().setBackground(DARK_BACKGROUND);
	     
	     JPanel registerPanel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                Graphics2D g2d = (Graphics2D) g;
	                GradientPaint gradient = new GradientPaint(0, 0, DARK_BACKGROUND, 0, getHeight(), DARK_PURPLE);
	                g2d.setPaint(gradient);
	                g2d.fillRect(0, 0, getWidth(), getHeight());
	            }
	        };
	        registerPanel.setLayout(null);
	        registerPanel.setBounds(0, 0, 800, 600);
	        
	     //Add panel to frame
	     f_homepage.add(registerPanel);
	     f_homepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     f_homepage.setVisible(true);
	   
	     //Attack button
	     b_attack = new JButton("ATTACK");
	     b_attack.setBounds(400, 220, 100, 50);
	     b_attack.setBackground(VIBRANT_PURPLE);
	     b_attack.setForeground(Color.WHITE);
	     b_attack.setFont(new Font("Arial", Font.BOLD, 14));
	     b_attack.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     b_attack.setFocusPainted(false);
	   
	     //Inventory button
	     b_inventory = new JButton("INVENTORY");
	     b_inventory.setBounds(520, 220, 100, 50);
	     b_inventory.setBackground(VIBRANT_PURPLE);
	     b_inventory.setForeground(Color.WHITE);
	     b_inventory.setFont(new Font("Arial", Font.BOLD, 14));
	     b_inventory.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     b_inventory.setFocusPainted(false);
	   
	     //Store button
	     b_store = new JButton("STORE");
	     b_store.setBounds(400, 280, 100, 50);
	     b_store.setBackground(VIBRANT_PURPLE);
	     b_store.setForeground(Color.WHITE);
	     b_store.setFont(new Font("Arial", Font.BOLD, 14));
	     b_store.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     b_store.setFocusPainted(false);
	   	    
	     //Settings button
	     b_settings = new JButton("SETTINGS");
	     b_settings.setBounds(520, 280, 100, 50);
	     b_settings.setBackground(VIBRANT_PURPLE);
	     b_settings.setForeground(Color.WHITE);
	     b_settings.setFont(new Font("Arial", Font.BOLD, 14));
	     b_settings.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     b_settings.setFocusPainted(false);
	     
	     b_complete = new JButton("COMPLETE");
	     b_complete.setBounds(10, 90, 100, 30);
	     b_complete.setBackground(SOFT_PINK);
	     b_complete.setForeground(Color.WHITE);
	     b_complete.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     b_complete.setFocusPainted(false);
	     
	     cooldown = new JLabel("Cooldown: Ready"); 
	     cooldown.setBounds(10, 180, 250, 30);
	     cooldown.setForeground(SOFT_PINK);
	   
	    
	     p_task = new JPanel();
	     p_task.setBounds(10, 20, 250, 150);
	     p_task.setBorder(BorderFactory.createTitledBorder("Daily Tasks"));
	     p_task.setLayout(new BoxLayout(p_task, BoxLayout.Y_AXIS));
	     p_task.setBackground(DARK_PURPLE);
	    
	     //Panel for daily tasks with checkboxes
	     cb_task1 = new JCheckBox("Complete 10 Push-ups");
	     cb_task2 = new JCheckBox("Complete 10 Sit-ups");
	     cb_task3 = new JCheckBox("Run 1 KM");
	     
	     //Styling checkboxes
	     cb_task1.setBackground(DARK_PURPLE);
	     cb_task1.setForeground(Color.WHITE);
	     cb_task2.setBackground(DARK_PURPLE);
	     cb_task2.setForeground(Color.WHITE);
	     cb_task3.setBackground(DARK_PURPLE);
	     cb_task3.setForeground(Color.WHITE);
	     
	     p_task.add(cb_task1);
	     p_task.add(cb_task2);
	     p_task.add(cb_task3);
	     p_task.add(b_complete);
	     p_task.add(cooldown);
	   
	     //Panel for exercise section
	     p_exercise = new JPanel();
	     p_exercise.setBounds(10, 200, 250, 300);
	     p_exercise.setBorder(BorderFactory.createTitledBorder("Exercises"));
	     p_exercise.setLayout(null);
	     p_exercise.setBackground(DARK_PURPLE);
	     
	     //Variables for exercises
	     JLabel exer, exer1, exer2, exer3, exer4, exer5, exer6;
	     //Xp
	     JLabel ex1, ex2, ex3, ex4, ex5, ex6;
	     //Counter
	     JLabel count1, count2, count3, count4, count5, count6;
	     //Button
	     JButton b1, b2, b3, b4, b5, b6;
	     JCheckBox cb_exer1, cb_exer2, cb_exer3, cb_exer4, cb_exer5;
	   
	     
	     //Exercise labels and buttons
	     cb_exer1 = new JCheckBox("Push Up");
	     cb_exer2 = new JCheckBox("Pull Up");
	     cb_exer3 = new JCheckBox("Sit Up");
	     cb_exer4 = new JCheckBox("Plank");
	     cb_exer5 = new JCheckBox("Squat");
	     
	     //Styling exercise checkboxes
	     cb_exer1.setBackground(DARK_PURPLE);
	     cb_exer1.setForeground(Color.WHITE);
	     cb_exer2.setBackground(DARK_PURPLE);
	     cb_exer2.setForeground(Color.WHITE);
	     cb_exer3.setBackground(DARK_PURPLE);
	     cb_exer3.setForeground(Color.WHITE);
	     cb_exer4.setBackground(DARK_PURPLE);
	     cb_exer4.setForeground(Color.WHITE);
	     cb_exer5.setBackground(DARK_PURPLE);
	     cb_exer5.setForeground(Color.WHITE);
	     
	     cb_exer1.setEnabled(false);
	     cb_exer2.setEnabled(false);
	     cb_exer3.setEnabled(false);
	     cb_exer4.setEnabled(false);
	     cb_exer5.setEnabled(false);
	     cb_exer1.setBounds(10, 30, 80, 30);
	     cb_exer2.setBounds(10, 70, 80, 30);
	     cb_exer3.setBounds(10, 110, 80, 30);
	     cb_exer4.setBounds(10, 150, 80, 30);
	     cb_exer5.setBounds(10, 190, 80, 30);
	    
	     b1 = new JButton("+");
	     b1.setBounds(100, 30, 45, 30);
	     b1.setBackground(SOFT_PINK);
	     b1.setForeground(Color.WHITE);
	     count1 = new JLabel("0");
	     count1.setBounds(160, 30, 30, 30);
	     count1.setForeground(Color.WHITE);
	     ex1 = new JLabel("/ 100");
	     ex1.setBounds(190, 30, 30, 30);
	     ex1.setForeground(Color.WHITE);
	     
	     b2 = new JButton("+");
	     b2.setBounds(100, 70, 45, 30);
	     b2.setBackground(SOFT_PINK);
	     b2.setForeground(Color.WHITE);
	     count2 = new JLabel("0");
	     count2.setBounds(160, 70, 30, 30);
	     count2.setForeground(Color.WHITE);
	     ex2 = new JLabel("/ 100");
	     ex2.setBounds(190, 70, 30, 30);
	     ex2.setForeground(Color.WHITE);
	     
	     b3 = new JButton("+");
	     b3.setBounds(100, 110, 45, 30);
	     b3.setBackground(SOFT_PINK);
	     b3.setForeground(Color.WHITE);
	     count3 = new JLabel("0");
	     count3.setBounds(160, 110, 30, 30);
	     count3.setForeground(Color.WHITE);
	     ex3 = new JLabel("/ 100");
	     ex3.setBounds(190, 110, 30, 30);
	     ex3.setForeground(Color.WHITE);
	    
	     b4 = new JButton("+");
	     b4.setBounds(100, 150, 45, 30);
	     b4.setBackground(SOFT_PINK);
	     b4.setForeground(Color.WHITE);
	     count4 = new JLabel("0");
	     count4.setBounds(160, 150, 30, 30);
	     count4.setForeground(Color.WHITE);
	     ex4 = new JLabel("/ 100");
	     ex4.setBounds(190, 150, 30, 30);
	     ex4.setForeground(Color.WHITE);
	    
	     b5 = new JButton("+");
	     b5.setBounds(100, 190, 45, 30);
	     b5.setBackground(SOFT_PINK);
	     b5.setForeground(Color.WHITE);
	     count5 = new JLabel("0");
	     count5.setBounds(160, 190, 30, 30);
	     count5.setForeground(Color.WHITE);
	     ex5 = new JLabel("/ 100");
	     ex5.setBounds(190, 190, 30, 30);
	     ex5.setForeground(Color.WHITE);
	     
	     cooldown2 = new JLabel("Cooldown: Ready"); 
	     cooldown2.setBounds(10, 260, 250, 30);
	     cooldown2.setForeground(SOFT_PINK);
	     
	     reg_complete = new JButton("COMPLETE");
	     reg_complete.setBounds(10, 235, 100, 30);
	     reg_complete.setBackground(SOFT_PINK);
	     reg_complete.setForeground(Color.WHITE);
	     reg_complete.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     reg_complete.setFocusPainted(false);
	     	     
	     f_homepage.setVisible(true);
	   
	     p_exercise.add(cb_exer1);	    
	     p_exercise.add(cb_exer2);	    
	     p_exercise.add(cb_exer3);	    
	     p_exercise.add(cb_exer4);	     
	     p_exercise.add(cb_exer5);
	    	   
	     p_exercise.add(b1);
	     p_exercise.add(b2);
	     p_exercise.add(b3);
	     p_exercise.add(b4);
	     p_exercise.add(b5);

	     p_exercise.add(count1);
	     p_exercise.add(count2);
	     p_exercise.add(count3);
	     p_exercise.add(count4);
	     p_exercise.add(count5);
	  
	     p_exercise.add(ex1);
	     p_exercise.add(ex2);
	     p_exercise.add(ex3);
	     p_exercise.add(ex4);
	     p_exercise.add(ex5);
	     
	     p_exercise.add(cooldown2);
	     p_exercise.add(reg_complete);
	   
	     
	   
	     	  
	     
	     registerPanel.add(b_attack);
	     registerPanel.add(b_inventory);
	     registerPanel.add(b_store);
	     registerPanel.add(b_settings);
	     registerPanel.add(p_task);
	     registerPanel.add(p_exercise);
	     
	     
	     
	     
	     
	     //Button actionlistener
	     b_store.addActionListener(new ActionListener() {
	      	 public void actionPerformed(ActionEvent e) {
	      		 f_homepage.setVisible(false);
	      		 store.main(null);
	      		
	      	 }
	       });
	     
	     
	     b_attack.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 fight.main(null);;
	    		 f_homepage.setVisible(false);
	           
	         }
	     });    
	     
	     
	     b_inventory.addActionListener(new ActionListener() {
	      	  public void actionPerformed(ActionEvent e) {
	      	        //Call the inventory class to show the inventory screen
	      	        inventory.main(null);  
	      	        f_homepage.setVisible(false);  
	      	    }
	        });
	     
	     
	     b_settings.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 settings.main(null);
	    		 f_homepage.setVisible(false);           
	         }
	     });
	     
	     
	     //Action listeners for each exercise button (b1 to b5)
	     b1.addActionListener(e -> {
	         if (reps1 < goal) {
	             reps1++;
	             count1.setText(String.valueOf(reps1));
	           
	             if (reps1 >= goal) {
	                 b1.setEnabled(false);  
	                 cb_exer1.setSelected(true); 
	                 cb_exer1.setEnabled(false); 
	             }
	         }
	     });

	     b2.addActionListener(e -> {
	         if (reps2 < goal) {
	             reps2++;
	             count2.setText(String.valueOf(reps2));
	             
	             if (reps2 >= goal) {
	                 b2.setEnabled(false);  
	                 cb_exer2.setSelected(true); 
	                 cb_exer2.setEnabled(false); 
	             }
	         }
	     });

	     b3.addActionListener(e -> {
	         if (reps3 < goal) {
	             reps3++;
	             count3.setText(String.valueOf(reps3));
	             
	             if (reps3 >= goal) {
	                 b3.setEnabled(false);  
	                 cb_exer3.setSelected(true);  
	                 cb_exer3.setEnabled(false);  
	             }
	         }
	     });

	     b4.addActionListener(e -> {
	         if (reps4 < goal) {
	             reps4++;
	             count4.setText(String.valueOf(reps4));
	            
	             if (reps4 >= goal) {
	                 b4.setEnabled(false); 
	                 cb_exer4.setSelected(true);  
	                 cb_exer4.setEnabled(false);  
	             }
	         }
	     });

	     b5.addActionListener(e -> {
	         if (reps5 < goal) {
	             reps5++;
	             count5.setText(String.valueOf(reps5));
	           
	             if (reps5 >= goal) {
	                 b5.setEnabled(false);  
	                 cb_exer5.setSelected(true); 
	                 cb_exer5.setEnabled(false);  
	             }
	         }
	     });
	     
	     b_complete.addActionListener(e -> {
	            if (canCompleteTask) {
	                //Check if all tasks are selected
	                if (cb_task1.isSelected() && cb_task2.isSelected() && cb_task3.isSelected()) {
	                    gyme.xp[0] += 10; 
	                    JOptionPane.showMessageDialog(null, "Congratulations! You gained 10 XP!");

	                    //Reset tasks
	                    cb_task1.setSelected(false);
	                    cb_task2.setSelected(false);
	                    cb_task3.setSelected(false);

	                    //Start cooldown
	                    canCompleteTask = false;
	                    startCooldown();
	                } else {  
	                    JOptionPane.showMessageDialog(null, "You need to complete all daily tasks first!", "Warning", JOptionPane.WARNING_MESSAGE);
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Daily tasks are on cooldown. Please try again later.", "Info", JOptionPane.INFORMATION_MESSAGE);
	            }
	        });	     
	     
	     
	     reg_complete.addActionListener(e -> {
	    	 if (reps1 >= goal && reps2 >= goal && reps3 >= goal && reps4 >= goal && reps5 >= goal) {
	    		 if (!isCooldownActive) {
	    			 isExerciseCompleted = true;
	    			 reps1 = reps2 = reps3 = reps4 = reps5 = 0;
	    		 
	    		 	count1.setText("0");
	    	        count2.setText("0");
	    	        count3.setText("0");
	    	        count4.setText("0");
	    	        count5.setText("0");
	    	        
	    	        b1.setEnabled(true);
	    	        b2.setEnabled(true);
	    	        b3.setEnabled(true);
	    	        b4.setEnabled(true);
	    	        b5.setEnabled(true);
	    	        
	    	        
	    	        cb_exer1.setEnabled(false);
	    	        cb_exer2.setEnabled(false);
	    	        cb_exer3.setEnabled(false);
	    	        cb_exer4.setEnabled(false);
	    	        cb_exer5.setEnabled(false);
	    	        cb_exer1.setSelected(true);
	    	        cb_exer2.setSelected(true);
	    	        cb_exer3.setSelected(true);
	    	        cb_exer4.setSelected(true);
	    	        cb_exer5.setSelected(true);
	    	        
	    	        gyme.xp[0] += 25;
	    	       
	    	        
	    	        isCooldownActive = true;
	    	        reg_complete.setEnabled(false);
	    	        startExerciseCooldown();
	    	    }} else {
	    	        JOptionPane.showMessageDialog(null, "You need to complete all exercises first!", "Warning", JOptionPane.WARNING_MESSAGE);
	    	    }
	    	 
	    	 
	    	 
	    	 if (canCompleteExerciseTask) {
	    	        if (cb_exer1.isSelected() && cb_exer2.isSelected() && cb_exer3.isSelected() && cb_exer4.isSelected() && cb_exer5.isSelected()) {
	    	            JOptionPane.showMessageDialog(null, "Congratulations! You gained 10 XP!");

	    	            cb_exer1.setSelected(false);
	    	            cb_exer2.setSelected(false);
	    	            cb_exer3.setSelected(false);
	    	            cb_exer4.setSelected(false);
	    	            cb_exer5.setSelected(false);

	    	            canCompleteExerciseTask = false;
	    	            startExerciseCooldown();
	    	        } else {
	    	            JOptionPane.showMessageDialog(null, "You need to complete all exercises first!", "Warning", JOptionPane.WARNING_MESSAGE);
	    	        }
	    	    } else {
	    	        JOptionPane.showMessageDialog(null, "Exercises are on cooldown. Please try again later.", "Info", JOptionPane.INFORMATION_MESSAGE);
	    	    }
	    	});
	 }
	 
	
	 private static void startCooldown() {
	        int cooldownTime = 3 * 60 * 60; //3 hours in seconds
	        cooldown.setText("Cooldown: " + cooldownTime + "s"); //Set initial cooldown time

	        cooldownTimer = new Timer();
	        cooldownTimer.scheduleAtFixedRate(new TimerTask() {
	            int remainingTime = cooldownTime;

	            @Override
	            public void run() {
	                remainingTime--;

	                //Update the cooldown label safely on the EDT
	                SwingUtilities.invokeLater(() -> {
	                    if (cooldown != null) {
	                        cooldown.setText("Cooldown: " + remainingTime + "s");
	                    }
	                });

	                if (remainingTime <= 0) {
	                    canCompleteTask = true; //Reset the ability to complete tasks
	                    SwingUtilities.invokeLater(() -> {
	                        if (cooldown != null) {
	                            cooldown.setText("Cooldown: Ready");
	                        }
	                    });
	                    cooldownTimer.cancel(); 
	                }
	            }
	        }, 1000, 1000); //Update every 1 second
	    }
	

private static void startExerciseCooldown() {
    int cooldownTime = 1 * 60 * 60; 
    cooldown2.setText("Cooldown: " + cooldownTime + "s"); 

    cooldownTimer = new Timer();
    cooldownTimer.scheduleAtFixedRate(new TimerTask() {
        int remainingTime = cooldownTime;

        @Override
        public void run() {
            remainingTime--;
        
            SwingUtilities.invokeLater(() -> {
                if (cooldown2 != null) {
                    cooldown2.setText("Cooldown: " + remainingTime + "s");
                }
            });

            if (remainingTime <= 0) {
            	canCompleteExerciseTask = true;
            	isCooldownActive = false;
                SwingUtilities.invokeLater(() -> {
                    if (cooldown2 != null) {
                        cooldown2.setText("Cooldown: Ready");
                    }
                });
                
                SwingUtilities.invokeLater(() -> {
                    reg_complete.setEnabled(true);
                });
                cooldownTimer.cancel(); 
            }
        }
    }, 1000, 1000);
}
}
