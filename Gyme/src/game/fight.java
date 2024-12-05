package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class fight extends gyme {
	private inventory inventory;
	
	
	public fight() {   
		super();
	
		inventory = new inventory();
	}
	//Method para pagnabili na dip maeenable na yung button
	public void updateDipButton(JButton dipButton) {
	    if (isDipPurchased) {
	        dipButton.setEnabled(true);
	    } else {
	        dipButton.setEnabled(false);
	    }
	}
	//Method para maupdate kung napipindot plank button kung nabili na
	public void updatePlankButton(JButton plankButton) {
	    if (isPlankPurchased) {
	        plankButton.setEnabled(true);
	    } else {
	        plankButton.setEnabled(false);
	    }
	}
	//Method para maupdate kung napipindot plank button kung nabili na
	public void updateJumpingJackButton(JButton jumpingButton) {
	    if (isJumpingJacksPurchased) {
	        jumpingButton.setEnabled(true);
	    } else {
	        jumpingButton.setEnabled(false);
	    }
	}
	 public static void main(String[] args) {
		 fight fightInitialize = new fight();
		//By initiating this it sets the health according to the items equipped from inventory
		 int initialHealth = gyme.health; 

		//Frame for the battle
	     JFrame f_battle;
	     f_battle = new JFrame();
	     f_battle.setTitle("Fighthing Arena");
	     f_battle.setSize(800, 600);    
	     f_battle.setLayout(null);
	     f_battle.setResizable(false);
	     f_battle.getContentPane().setBackground(DARK_BACKGROUND);
	     
	     JPanel battlePanel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                Graphics2D g2d = (Graphics2D) g;
	                GradientPaint gradient = new GradientPaint(0, 0, DARK_BACKGROUND, 0, getHeight(), DARK_PURPLE);
	                g2d.setPaint(gradient);
	                g2d.fillRect(0, 0, getWidth(), getHeight());
	            }
	        };
	        battlePanel.setLayout(null);
	        battlePanel.setBounds(0, 0, 800, 600);
	        
	     //Add panel to frame
	     f_battle.add(battlePanel);
	     f_battle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     f_battle.setVisible(true);
	     
	     
	     //Player Components
	     JLabel player1Label = new JLabel("You");
	     player1Label.setBounds(50, 35, 100, 30);
	     player1Label.setBackground(DARK_PURPLE);
	     player1Label.setForeground(Color.MAGENTA);
	     
	     JProgressBar player1Health = new JProgressBar(0, gyme.health);
	     player1Health.setValue(gyme.health);
	     player1Health.setBounds(50, 60, 300, 30);
	     JButton player1Attack = new JButton("Attack");
	     player1Attack.setBounds(100, 120, 200, 50);
	     player1Attack.setBackground(VIBRANT_PURPLE);
	     player1Attack.setForeground(Color.WHITE);
	     player1Attack.setFont(new Font("Arial", Font.BOLD, 14));
	     player1Attack.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     player1Attack.setFocusPainted(false);
	     
	     JLabel player2Label = new JLabel("Enemy");
	     player2Label.setBounds(450, 35, 100, 30);
	     player2Label.setBackground(DARK_PURPLE);
	     player2Label.setForeground(Color.MAGENTA);
	     JProgressBar player2Health = new JProgressBar(0, 100);
	     player2Health.setValue(100);
	     player2Health.setBounds(450, 60, 300, 30);
	     JButton player2Attack = new JButton("Attack");
	     player2Attack.setBounds(500, 120, 200, 50);
	    
	     
	     //Just to make the user understand what to click
	     JLabel skills = new JLabel("Skills: ");
	     skills.setBounds(100, 200, 100, 30);
	     skills.setBackground(DARK_PURPLE);
	     skills.setForeground(Color.MAGENTA);
	     
	     JLabel stats = new JLabel("Stats: ");
	     stats.setBounds(450, 200, 100, 30);
	     stats.setBackground(DARK_PURPLE);
	     stats.setForeground(Color.MAGENTA);
	     
	     

	     //Skill Buttons
	     JButton skillPushUp = new JButton("Push-Up");
	     skillPushUp.setBounds(95, 230, 100, 40);
	     skillPushUp.setBackground(VIBRANT_PURPLE);
	     skillPushUp.setForeground(Color.WHITE);
	     skillPushUp.setFont(new Font("Arial", Font.BOLD, 14));
	     skillPushUp.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     skillPushUp.setFocusPainted(false);
	     
	     
	     JButton skillPullUp = new JButton("Pull-Up");
	     skillPullUp.setBounds(205, 230, 100, 40);
	     skillPullUp.setBackground(VIBRANT_PURPLE);
	     skillPullUp.setForeground(Color.WHITE);
	     skillPullUp.setFont(new Font("Arial", Font.BOLD, 14));
	     skillPullUp.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     skillPullUp.setFocusPainted(false);
	     
	     
	     JButton skillSquat = new JButton("Squat");
	     skillSquat.setBounds(95, 275, 100, 40);
	     skillSquat.setBackground(VIBRANT_PURPLE);
	     skillSquat.setForeground(Color.WHITE);
	     skillSquat.setFont(new Font("Arial", Font.BOLD, 14));
	     skillSquat.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     skillSquat.setFocusPainted(false);
	     
	     
	     JButton skillSitUp = new JButton("Sit-Up");
	     skillSitUp.setBounds(205, 275, 100, 40);
	     skillSitUp.setBackground(VIBRANT_PURPLE);
	     skillSitUp.setForeground(Color.WHITE);
	     skillSitUp.setFont(new Font("Arial", Font.BOLD, 14));
	     skillSitUp.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     skillSitUp.setFocusPainted(false);
	     
	     //dip exercise mageenable pag nabili na sa store
	     JButton skilldip = new JButton("Dip");
	     
	     skilldip.setBounds(95, 320, 100, 40);
	     skilldip.setBackground(VIBRANT_PURPLE);
	     skilldip.setForeground(Color.WHITE);
	     skilldip.setFont(new Font("Arial", Font.BOLD, 14));
	     skilldip.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     skilldip.setFocusPainted(false);
	     fightInitialize.updateDipButton(skilldip);
	    
	    
	     //plank skill exercise
	     
	     JButton skillplanks = new JButton("Plank");
	     skillplanks.setBounds(205, 320, 100, 40);
	     skillplanks.setBackground(VIBRANT_PURPLE);
	     skillplanks.setForeground(Color.WHITE);
	     skillplanks.setFont(new Font("Arial", Font.BOLD, 14));
	     skillplanks.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     skillplanks.setFocusPainted(false);
	     fightInitialize.updatePlankButton(skillplanks);
	    
	     
	     //Jumping jack skill exercise
	     JButton skilljumpjacks = new JButton("Jumping Jacks");
	     skilljumpjacks.setBounds(140, 365, 120, 40);
	     skilljumpjacks.setBackground(VIBRANT_PURPLE);
	     skilljumpjacks.setForeground(Color.WHITE);
	     skilljumpjacks.setFont(new Font("Arial", Font.BOLD, 14));
	     skilljumpjacks.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     skilljumpjacks.setFocusPainted(false);
	     fightInitialize.updateJumpingJackButton(skilljumpjacks);
	  
	     	     
	     
	     //Decorative Title
	     JLabel battleTitle = new JLabel("Battle Arena", SwingConstants.CENTER);
	     battleTitle.setBounds(300, 5, 200, 40);
	     battleTitle.setFont(new Font("Arial", Font.BOLD, 20));
	     battleTitle.setBackground(DARK_PURPLE);
	     battleTitle.setForeground(Color.MAGENTA);
	     
	     //Feedback Section
	     JLabel feedback = new JLabel("", SwingConstants.CENTER);
	     feedback.setBounds(300, 90, 200, 30);
	     feedback.setFont(new Font("Arial", Font.ITALIC, 16));
	     feedback.setForeground(Color.RED);
	     
	     
	     
	     //Exercise Progress
	     JLabel xpLabel = new JLabel("Experience: 0");
	     xpLabel.setBounds(450, 225, 150, 30);
	     xpLabel.setBackground(DARK_PURPLE);
	     xpLabel.setForeground(Color.MAGENTA);
	    
	     JLabel pushUpProgress = new JLabel("Push-Ups: 0");
	     pushUpProgress.setBounds(450, 245, 150, 30);
	     pushUpProgress.setBackground(DARK_PURPLE);
	     pushUpProgress.setForeground(Color.MAGENTA);
	     
	     JLabel pullUpProgress = new JLabel("Pull-Ups: 0");
	     pullUpProgress.setBounds(450, 265, 150, 30);
	     pullUpProgress.setBackground(DARK_PURPLE);
	     pullUpProgress.setForeground(Color.MAGENTA);
	     
	     JLabel squatProgress = new JLabel("Squats: 0");
	     squatProgress.setBounds(450, 285, 150, 30);
	     squatProgress.setBackground(DARK_PURPLE);
	     squatProgress.setForeground(Color.MAGENTA);
	     
	     JLabel sitUpProgress = new JLabel("Sit-Ups: 0");
	     sitUpProgress.setBounds(450, 305, 150, 30);
	     sitUpProgress.setBackground(DARK_PURPLE);
	     sitUpProgress.setForeground(Color.MAGENTA);
	     
	     JLabel dipProgress = new JLabel("Sit-Ups: 0");
	     sitUpProgress.setBounds(450, 305, 150, 30);
	     sitUpProgress.setBackground(DARK_PURPLE);
	     sitUpProgress.setForeground(Color.MAGENTA);
	     
	     JLabel jumjacksProgress = new JLabel("Sit-Ups: 0");
	     sitUpProgress.setBounds(450, 305, 150, 30);
	     sitUpProgress.setBackground(DARK_PURPLE);
	     sitUpProgress.setForeground(Color.MAGENTA);
	     
	     JLabel planksProgress = new JLabel("Sit-Ups: 0");
	     sitUpProgress.setBounds(450, 305, 150, 30);
	     sitUpProgress.setBackground(DARK_PURPLE);
	     sitUpProgress.setForeground(Color.MAGENTA);
	     
	     //Restart Button
	     JButton restartButton = new JButton("Restart");
	     restartButton.setBounds(300, 500, 200, 50);
	     restartButton.setVisible(false);
	     restartButton.setBackground(VIBRANT_PURPLE);
	     restartButton.setForeground(Color.WHITE);
	     restartButton.setFont(new Font("Arial", Font.BOLD, 14));
	     restartButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     restartButton.setFocusPainted(false);
	     
	    
	     JButton battle_back = new JButton ("Go Home");
	     battle_back.setBounds(650, 500, 100, 30);
	     battle_back.setBackground(VIBRANT_PURPLE);
	     battle_back.setForeground(Color.WHITE);
	     battle_back.setFont(new Font("Arial", Font.BOLD, 14));
	     battle_back.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	     battle_back.setFocusPainted(false);
	     
	     
	     JLabel health, damage, armor, agility, luck;
	     
	     health = new JLabel("Health: " + gyme.health);
	     health.setBounds(570, 225, 150, 30);
	     health.setBackground(DARK_PURPLE);
	     health.setForeground(Color.MAGENTA);
	 
	     
	     damage = new JLabel("Damage: " + gyme.damage);
	     damage.setBounds(570, 245, 150, 30);
	     damage.setBackground(DARK_PURPLE);
	     damage.setForeground(Color.MAGENTA);
	    
	     
	     armor = new JLabel("Armor: " + gyme.armor);
	     armor.setBounds(570, 265, 150, 30);
	     armor.setBackground(DARK_PURPLE);
	     armor.setForeground(Color.MAGENTA);
	       
	     
	     agility = new JLabel("Agility: " + gyme.agility);
	     agility.setBounds(570, 285, 150, 30);
	     agility.setBackground(DARK_PURPLE);
	     agility.setForeground(Color.MAGENTA);
	     
	     
	     luck = new JLabel("Luck: " + gyme.luck);
	     luck.setBounds(570, 3055, 150, 30);
	     luck.setBackground(DARK_PURPLE);
	     luck.setForeground(Color.MAGENTA);
	     
	   
	     f_battle.setVisible(true);
	   
	     
	     
	     
	     battlePanel.add(player1Label);
	     battlePanel.add(player1Health);
	     battlePanel.add(player1Attack);
	     battlePanel.add(player2Label);
	     battlePanel.add(player2Health);
	     battlePanel.add(skillPushUp);
	     battlePanel.add(skillPullUp);
	     battlePanel.add(skillSquat);
	     battlePanel.add(skillSitUp);
	     battlePanel.add(skilldip);
	     battlePanel.add(skilljumpjacks);
	     battlePanel.add(skillplanks);
	     battlePanel.add(battleTitle);
	     battlePanel.add(feedback);
	     battlePanel.add(pushUpProgress);
	     battlePanel.add(pullUpProgress);
	     battlePanel.add(squatProgress);
	     battlePanel.add(sitUpProgress);
	     battlePanel.add(dipProgress);
	     battlePanel.add(jumjacksProgress);
	     battlePanel.add(planksProgress);
	     battlePanel.add(restartButton);
	     battlePanel.add(battle_back);
	     battlePanel.add(xpLabel);
	     battlePanel.add(health);
	     battlePanel.add(damage);
	     battlePanel.add(armor);
	     battlePanel.add(agility);
	     battlePanel.add(luck);
	     battlePanel.add(skills);
	     battlePanel.add(stats);
	     
	     //Skill Effects
	     final int[] pushUpCounter = {0};
	     final int[] pullUpCounter = {0};
	     final int[] squatCounter = {0};
	     final int[] sitUpCounter = {0};
	     final int[] dipCounter = {0};
	     final int[] jumjacksCounter = {0};
	     final int[] planksCounter = {0};
	     final boolean[] blockNext = {false};
	    
	     
	     //Push-Up Skill
	     skillPushUp.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             pushUpCounter[0]++;
	             pushUpProgress.setText("Push-Ups: " + pushUpCounter[0]);
	             if (pushUpCounter[0] % 5 == 0) {
	                 feedback.setText("Push-Up Bonus: +2 Damage!");
	             }
	         }
	     });
	     
	    
	     //Pull-Up Skill
	     skillPullUp.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             pullUpCounter[0]++;
	             pullUpProgress.setText("Pull-Ups: " + pullUpCounter[0]);
	             if (pullUpCounter[0] % 5 == 0) {
	                 feedback.setText("Pull-Up Bonus: +5 Damage!");
	             }
	         }
	     });
	     
	     //Squat Skill
	     skillSquat.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             squatCounter[0]++;
	             squatProgress.setText("Squats: " + squatCounter[0]);
	             if (squatCounter[0] % 10 == 0) {
	            	 gyme.health = Math.min(gyme.health + 10, 100); 
	                 player1Health.setValue(gyme.health);          
	                 feedback.setText("Squat Heal: +10 Health!");
	             }
	         }
	     });
	    
	     //Sit-Up Skill
	     skillSitUp.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             sitUpCounter[0]++;
	             sitUpProgress.setText("Sit-Ups: " + sitUpCounter[0]);
	             if (sitUpCounter[0] % 10 == 0) {
	                 blockNext[0] = true;
	                 feedback.setText("Player 1: Block Next Attack!");
	             }
	         }
	     });
	     
	  // Dip Skill
	     skilldip.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             dipCounter[0]++;
	             dipProgress.setText("Dips: " + dipCounter[0]); 
	             if (dipCounter[0] % 5 == 0) {
	                 feedback.setText("Dip Bonus: +5 Damage!");
	             }
	         }
	     });

	     // Jumping Jack Skill
	     skilljumpjacks.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             jumjacksCounter[0]++;
	             jumjacksProgress.setText("Jumping Jacks: " + jumjacksCounter[0]); 
	             if (jumjacksCounter[0] % 5 == 0) {
	                 feedback.setText("Jumping Jacks Bonus: +5 Health!");
	             }
	         }
	     });

	     // Planks Skill
	     skillplanks.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             planksCounter[0]++;
	             planksProgress.setText("Planks: " + planksCounter[0]); 
	             if (planksCounter[0] % 5 == 0) {
	                 feedback.setText("Planks Bonus: +7 Damage!");
	             }
	         }
	     });
	     
	     
	    
	     //Attack logic
	     player1Attack.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             int damage = gyme.damage + (pushUpCounter[0] / 5) * 2 + (pullUpCounter[0] / 5) * 5;
	             int currentHealth = player2Health.getValue();
	             if (currentHealth > 0) {
	                 player2Health.setValue(Math.max(currentHealth - damage, 0));
	                 feedback.setText("Player 1 dealt " + damage + " damage!");
	             }
	             if (player2Health.getValue() <= 0) {
	           	  xp[0] += 10;
	           	  xpLabel.setText("Experience: " + xp[0]);
	                 JOptionPane.showMessageDialog(f_battle, "Player 1 Wins!");
	                 player1Attack.setEnabled(false);
	                 player2Attack.setEnabled(false);
	                 restartButton.setVisible(true);
	             } else {
	                 //Trigger player 2 attack automatically
	                 new Timer().schedule(new TimerTask() {
	                     public void run() {
	                         player2Attack.doClick();
	                     }
	                 }, 1000); //1second delay for automatic attack
	             }
	         }
	     });
	     
	     
	     player2Attack.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             int damage = 20;
	             if (blockNext[0]) {
	                 feedback.setText("Player 1 Blocked the Attack!");
	                 blockNext[0] = false;
	                 return;
	             }
	             
	             //Update user health
	             gyme.health = Math.max(gyme.health - damage, 0); 
	             player1Health.setValue(gyme.health);            
	             feedback.setText("Player 2 dealt " + damage + " damage!");
	             
	            
	             if (gyme.health <= 0) {
	                 JOptionPane.showMessageDialog(f_battle, "Player 2 Wins!");
	                 player1Attack.setEnabled(false);
	                 player2Attack.setEnabled(false);
	                 restartButton.setVisible(true);
	             }
	         }
	     });
	     
	     
	     //Restart logic
	     restartButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 /*Pag hindi na initiate yung variable nato sa pinakataas kanina, hindi mareset
	        	   yung health. Kaya need mo gumawa ng panibagong variable kung saan naka set sya
	        	   as items equip sa inventory then pag namatay yung user which is yung player 1
	        	   yung healthbar marereset. Kasi If you look at the player2attack action listener 
	        	   makikita mona binabawasan yung gyme.health diba, so pag wala tong variable nato
	        	   pag click mo ng reset 0 parin buhay mo kasi nga bawas na ng player2 action listener
	        	   parang ito talga yung default static nato fix ganon.  */
	        	 gyme.health = initialHealth;
	        	 
	        	 player1Health.setValue(gyme.health);
	             player2Health.setValue(100);
	             player1Attack.setEnabled(true);
	             player2Attack.setEnabled(true);
	             feedback.setText("");
	             
	             pushUpCounter[0] = 0;
	             pullUpCounter[0] = 0;
	             squatCounter[0] = 0;
	             sitUpCounter[0] = 0;
	             dipCounter[0] = 0;
	             jumjacksCounter[0] = 0;
	             planksCounter[0] = 0;
	             blockNext[0] = false;
	             restartButton.setVisible(false);
	             
	             pushUpProgress.setText("Push-Ups: 0");
	             pullUpProgress.setText("Pull-Ups: 0");
	             squatProgress.setText("Squats: 0");
	             sitUpProgress.setText("Sit-Ups: 0");
	             dipProgress.setText("Dips: 0");
	             jumjacksProgress.setText("Jumping Jacks: 0");
	             planksProgress.setText("Planks: 0");
	         }
	     });
	     
	     battle_back.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 gyme.health = initialHealth;
	        	 f_homepage.setVisible(true);
	    		 f_battle.setVisible(false);
	    		 player1Health.setValue(initialHealth);
	    		 
	         }
	     });  
	}

}
