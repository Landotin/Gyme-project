package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class settings extends gyme {
	public settings() {
		super();
	}	
	public static void main(String[] args) {
		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/gyme";
		String USER = "root";
		String PASS = "";
		
		//SETTINGS Frame
	    JFrame f_settings;
	    JLabel app_name, name;
	    JLabel created, difficulty;
	    JButton set_back, easy, medium, hard, tutorial, about;
	   
	    f_settings = new JFrame();
	    f_settings.setTitle("Settings");
	    f_settings.setSize(800, 600);
	    f_settings.setLayout(null);
	    f_settings.setResizable(false);
	    f_settings.getContentPane().setBackground(DARK_BACKGROUND);
	     
	     JPanel settingsPanel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                Graphics2D g2d = (Graphics2D) g;
	                GradientPaint gradient = new GradientPaint(0, 0, DARK_BACKGROUND, 0, getHeight(), DARK_PURPLE);
	                g2d.setPaint(gradient);
	                g2d.fillRect(0, 0, getWidth(), getHeight());
	            }
	        };
	        settingsPanel.setLayout(null);
	        settingsPanel.setBounds(0, 0, 800, 600);
	        
	     //Add panel to frame
	        f_settings.add(settingsPanel);
	        f_settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f_settings.setVisible(true);
	   
	    //back button
	    set_back = new JButton ("Go Home");
	    set_back.setBounds(650, 500, 100, 30);
	    set_back.setBackground(VIBRANT_PURPLE);
	    set_back.setForeground(Color.WHITE);
	    set_back.setFont(new Font("Arial", Font.BOLD, 14));
	    set_back.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	    set_back.setFocusPainted(false);
	   
	    //name beside the logo
	    app_name = new JLabel ("GYME");
	    app_name.setBounds(450, 30, 100, 50);
	    app_name.setBackground(DARK_PURPLE);
	    app_name.setForeground(Color.MAGENTA);
	    
	    name = new JLabel ("User");
	    name.setBounds(450, 50, 100, 50);
	    name.setBackground(DARK_PURPLE);
	    name.setForeground(Color.MAGENTA);
	   
	    //informations about accounts
	    created = new JLabel ("Account created: ");
	    created.setBounds(10,200, 200, 50);
	    created.setBackground(DARK_PURPLE);
	    created.setForeground(Color.MAGENTA);
	    
	    about = new JButton ("About Us");
	    about.setBounds(100, 250, 90, 50);
	    about.setBackground(VIBRANT_PURPLE);
	    about.setForeground(Color.WHITE);
	    about.setFont(new Font("Arial", Font.BOLD, 14));
	    about.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	    about.setFocusPainted(false);
	    
	    tutorial = new JButton ("Tutorial");
	    tutorial.setBounds(10, 250, 80, 50);
	    tutorial.setBackground(VIBRANT_PURPLE);
	    tutorial.setForeground(Color.WHITE);
	    tutorial.setFont(new Font("Arial", Font.BOLD, 14));
	    tutorial.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
	    tutorial.setFocusPainted(false);
	    
	    f_settings.setVisible(true);
	   
	   
	    settingsPanel.add(app_name);
	    settingsPanel.add(name);
	    settingsPanel.add(created);
	    settingsPanel.add(set_back);
	    settingsPanel.add(about);
	    settingsPanel.add(tutorial);
	    
	    
	    
	    try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM account WHERE ID = 1"; 
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                
                String userName = rs.getString("username");
                String accountCreated = rs.getString("registration_date"); 
                
                name.setText(userName);
                created.setText("Account created: " + accountCreated);
               
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	    
	    
	    set_back.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 f_homepage.setVisible(true);
	    		 f_settings.setVisible(false);
	         }
	     });  
	    
	    tutorial.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String message = "<html><body style='width: 300px;'>" +
	                    "<h2>Welcome to GYME! Here’s how the game works:</h2>" +
	                    "<h3>Exercise to Gain Experience (XP):</h3>" +
	                    "<p>You need to perform various exercises like push-ups, sit-ups, and squats. Each time you complete a set amount of repetitions, you earn experience points (XP).</p>" +
	                    "<h3>Level Up Your Character:</h3>" +
	                    "<p>As you accumulate XP, your character becomes stronger. Leveling up increases your character's stats, such as health, damage, armor, agility, and luck.</p>" +
	                    "<h3>Equip Items for Boosts:</h3>" +
	                    "<p>You can equip different items (like helmets, armor, and weapons) to enhance your character's abilities. Each item provides specific bonuses to your stats, making your character more powerful in battles.</p>" +
	                    "<h3>Engage in Battles:</h3>" +
	                    "<p>Use your character in battles against enemies. Your stats and equipped items determine your effectiveness in combat.</p>" +
	                    "<h3>Complete Daily Tasks:</h3>" +
	                    "<p>Completing daily tasks earns you additional XP and rewards. Make sure to check off tasks to maximize your gains!</p>" +
	                    "<h3>Cooldowns:</h3>" +
	                    "<p>After completing tasks or exercises, there may be cooldown periods before you can perform them again. Be strategic about when to exercise and complete tasks to optimize your progress.</p>" +
	                    "<h3>Track Your Progress:</h3>" +
	                    "<p>Keep an eye on your character’s stats and XP to see how much you’ve improved over time. Use this information to decide which exercises to focus on for the best results.</p>" +
	                    "<p>By following these mechanics, you can effectively progress in GYME, making your character stronger and more capable of facing challenges. Enjoy your fitness journey!</p>" +
	                    "</body></html>";

	            JOptionPane.showMessageDialog(null, message, "GYME Tutorial", JOptionPane.INFORMATION_MESSAGE);
	        }
	    });
	    
	    about.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String message = "<html><body style='width: 300px;'>" +
	                    "<h2>Welcome to GYME Quest!</h2>" +
	                    "<p>At GYME Quest, we believe that fitness should be fun and engaging. Our mission is to revolutionize the way individuals, especially gamers, " +
	                    "approach physical health by merging the excitement of gaming with effective workout routines.</p>" +
	                    "<h3>Our Vision</h3>" +
	                    "<p>In today’s fast-paced digital world, many people struggle to maintain a consistent workout routine due to a lack of motivation and engagement in " +
	                    "traditional fitness programs. We envision a future where exercise is no longer seen as a chore, but as an enjoyable and rewarding experience that seamlessly integrates with daily life.</p>" +
	                    "<h3>What We Do</h3>" +
	                    "<p>Our innovative application combines the elements of role-playing games (RPGs) with real-world fitness challenges. Users can create personalized " +
	                    "workout plans and earn in-game rewards for their achievements, transforming their fitness journey into an interactive adventure. With features designed to motivate and engage, GYME Quest empowers users to build sustainable fitness habits while having fun.</p>" +
	                    "<h3>Our Team</h3>" +
	                    "<p>We are a passionate group of developers and fitness enthusiasts dedicated to creating a unique platform that inspires users to prioritize their " +
	                    "health. Our team is committed to applying the principles of Object-Oriented Programming and user-centered design to deliver a high-quality experience that meets the needs of our users.</p>" +
	                    "<h3>Join Us on This Journey</h3>" +
	                    "<p>Whether you’re a seasoned gamer or just starting your fitness journey, GYME Quest invites you to join us in redefining the relationship between " +
	                    "gaming and health. Together, we can create a healthier, more active community—one workout at a time!</p>" +
	                    "</body></html>";

	            JOptionPane.showMessageDialog(null, message, "About GYME Quest", JOptionPane.INFORMATION_MESSAGE);
	        }
	    });

	}
   

}
