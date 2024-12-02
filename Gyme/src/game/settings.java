package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class settings extends gyme {
	public settings() {
		super();
	}
	
	  public static int getTotalExercises() {
	        int totalExercises = 0;
	        
	        // Add array values and individual reps
	        totalExercises += totalPushUps[0];
	        totalExercises += totalSitUps[0];
	        totalExercises += totalPullUps[0];
	        totalExercises += totalSquats[0];
	        
	        // Add individual reps for each exercise
	        totalExercises += reps1 + reps2 + reps3 + reps4 + reps5;
	        
	        return totalExercises;
	    }
	
	
	public static void main(String[] args) {
		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/gyme";
		String USER = "root";
		String PASS = "";
		
		//SETTINGS Frame
	    JFrame f_settings;
	    JLabel app_name, name;
	    JLabel created, tamount, unlocks, unlocka, difficulty;
	    JButton set_back, easy, medium, hard;
	   
	    f_settings = new JFrame();
	    f_settings.setTitle("Settings");
	    f_settings.setSize(800, 600);
	    f_settings.setResizable(false);
	    f_settings.setLayout(null);
	   
	    //back button
	    set_back = new JButton ("Go Home");
	    set_back.setBounds(650, 500, 100, 30);
	   
	    //name beside the logo
	    app_name = new JLabel ("GYME");
	    app_name.setBounds(450, 30, 100, 50);
	    name = new JLabel ("User");
	    name.setBounds(450, 50, 100, 50);
	   
	    //informations about accounts
	    created = new JLabel ("Account created: ");
	    created.setBounds(10,200, 200, 50);
	   
	    tamount = new JLabel ("Total Amount of Exercise: ");
	    tamount.setBounds(10,230, 250, 50);
	   
	    unlocks = new JLabel ("Unlock Skills: ");
	    unlocks.setBounds(10,260, 100, 50);
	   
	    unlocka = new JLabel ("Unlock Achievements: ");
	    unlocka.setBounds(10,290, 150, 50);
	   
	    difficulty = new JLabel ("Difficulty: ");
	    difficulty.setBounds(10,400, 100, 50);
	   
	    //button for difficulty and it will change the type of exercises
	    //easy calisthenics
	    //medium calisthenics with some dumbells
	    //hard required gym equipments
	    /*user can buy set of exercises even if it was different difficulty
	      cause they have their choice, di naman sila bibili kung wala silang equipment diba*/
	    easy = new JButton ("Easy");
	    easy.setBounds(10, 450, 80, 50);
	   
	    medium = new JButton ("Medium");
	    medium.setBounds(100, 450, 80, 50);
	   
	    hard = new JButton ("Hard");
	    hard.setBounds(190, 450, 80, 50);
	    
	    f_settings.setVisible(true);
	   
	   
	    f_settings.add(app_name);
	    f_settings.add(name);
	    f_settings.add(created);
	    f_settings.add(set_back);
	    f_settings.add(tamount);
	    f_settings.add(unlocks);
	    f_settings.add(unlocka);
	    f_settings.add(difficulty);
	    f_settings.add(easy);
	    f_settings.add(medium);
	    f_settings.add(hard);
	    
	    int totalExercises = getTotalExercises();
        tamount.setText("Total Amount of Exercise: " + totalExercises);
	    
	    
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
	}
   

}
