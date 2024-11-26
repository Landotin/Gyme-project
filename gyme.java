package game;
import java.awt.event.*; 
import javax.swing.*; 
import java.util.*;
import java.util.Timer;
import java.awt.*;
public class gyme extends JFrame {
	
	static int[] xp = {0}; 
	int[] totalPushUps = {0}; 
	int[] totalSitUps = {0}; 
	int[] totalPullUps = {0}; 
	int[] totalSquats = {0}; 
	
//Ginawa kong public para maccess ng lahat
public static JFrame f_homepage;
 public static void main(String[] args) {
 	JFrame f_login;
 	JLabel l_user, l_pass;
 	JButton b_login, b_register;
 	JTextField tf_user, tf_pass;
 	JPasswordField pf_pass;
 	


 	
 	  //Frame for login
 	  f_login = new JFrame();
      f_login.setBounds(0, 0, 0, 0);
      f_login.setTitle("GYME");
      f_login.setSize(800, 600);
      f_login.setLayout(null);
      f_login.setResizable(true);
     
     
      //This is for the username and password
      tf_user = new JTextField();
      tf_user.setBounds(200, 440, 200, 30);
      l_user = new JLabel("NAME");
      l_user.setBounds(280, 400, 200, 50);
     
     
      //Password field makes the password censored for extra security
      pf_pass = new JPasswordField();
      pf_pass.setBounds(200, 510, 200, 30);
      l_pass = new JLabel("PASSWORD");
      l_pass.setBounds(265, 470, 200, 50);
     
      //Buttons
      b_login = new JButton("LOGIN");       
      b_login.setBounds(310, 565, 90, 50);
      b_register = new JButton("REGISTER");
      b_register.setBounds(200, 565, 90, 50);
     
      f_login.add(tf_user);
      f_login.add(pf_pass);
      f_login.add(l_user);
      f_login.add(l_pass);
      f_login.add(b_login);
      f_login.add(b_register);
 	
     
      //Frame for register
      JFrame f_register;
      JButton b_create, b_back, b_view;
      JTextField tf_user1, tf_pass1;
      JPasswordField pf_pass1;
      JLabel l_user1, l_pass1;
     
     
      //Naka false yung visible para pag nag run yung program hindi mag overlay yung frame ng register pag pinindot lang yung button dun lang sya makikita
      f_register = new JFrame();
      f_register.setTitle("REGISTER");
      f_register.setSize(800, 600);
      f_register.setVisible(false);
      f_register.setLayout(null);
      f_register.setResizable(true);
     
     
      tf_user1 = new JTextField();
      tf_user1.setBounds(200, 440, 200, 30);
      l_user1 = new JLabel("NAME");
      l_user1.setBounds(280, 400, 200, 50);
     
      //This is for the uncensored password to show to the user what their password is
      tf_pass1 = new JTextField();
      tf_pass1.setBounds(200,510,200,30);
     
     
      pf_pass1 = new JPasswordField();
      pf_pass1.setBounds(200, 510, 200, 30);
      l_pass1 = new JLabel("PASSWORD");
      l_pass1.setBounds(265, 470, 200, 50);
     
      b_create = new JButton("REGISTER");       
      b_create.setBounds(200, 565, 90, 50);
      b_back = new JButton("GO BACK");
      b_back.setBounds(310, 565, 90, 50);
     
      b_view = new JButton("👀");
      b_view.setBounds(400, 510, 50, 30);
      
      f_login.setVisible(true);
     
    
      f_register.add(tf_user1);
      f_register.add(l_user1);
      f_register.add(pf_pass1);
      f_register.add(l_pass1);
      f_register.add(b_create);
      f_register.add(b_back);
      f_register.add(b_view);
      f_register.add(tf_pass1);
      
      
     
     
     
      //Frame for homepage
      JButton b_attack, b_inventory, b_store, b_skills, b_settings;
      JButton b_check1, b_check2, b_check3, b_check4, b_check5, b_check6;
      JPanel p_task, p_exercise;
      JLabel l_task, l_exercise;
      JLabel l_exp, l_exp1, l_exp2, l_exp3, l_exp4;
      JLabel l_cnt, l_cnt1, l_cnt2, l_cnt3, l_cnt4;
      JLabel l_workout, l_workout1, l_workout2, l_workout3, l_workout4;
      JCheckBox cb_task1, cb_task2, cb_task3;
      
      f_homepage = new JFrame();
      f_homepage.setTitle("HOMEPAGE");
      f_homepage.setSize(800, 600);
      f_homepage.setVisible(false);
      f_homepage.setLayout(null);
      f_homepage.setResizable(true);
     
     
      b_attack = new JButton("ATTACK");
      b_attack.setBounds(300, 80, 100, 50);
     
      b_inventory = new JButton("INVENTORY");
      b_inventory.setBounds(420, 80, 100, 50);
     
      b_store = new JButton("STORE");
      b_store.setBounds(300, 140, 100, 50);
     
      b_skills = new JButton("SKILLS");
      b_skills.setBounds(420, 140, 100, 50);
     
      b_settings = new JButton("SETTINGS");
      b_settings.setBounds(360, 200, 100, 50);
      
      p_task = new JPanel();
      p_task.setBounds(10, 20, 250, 150); 
      p_task.setBorder(BorderFactory.createTitledBorder("Daily Tasks"));
      p_task.setLayout(new BoxLayout(p_task, BoxLayout.Y_AXIS));
      
      //Panel for daily tasks with checkboxes
      cb_task1 = new JCheckBox("Complete 10 Push-ups");
      cb_task2 = new JCheckBox("Complete 10 Sit-ups");
      cb_task3 = new JCheckBox("Run 1 KM");
      p_task.add(cb_task1);
      p_task.add(cb_task2);
      p_task.add(cb_task3);
     
      //Panel for exercise section
      p_exercise = new JPanel();
      p_exercise.setBounds(10, 200, 250, 300);
      p_exercise.setBorder(BorderFactory.createTitledBorder("Exercises"));
      p_exercise.setLayout(null);
      //Variables for exercises
      JLabel exer, exer1, exer2, exer3, exer4, exer5, exer6;
      //Xp
      JLabel ex1, ex2, ex3, ex4, ex5, ex6;
      //Counter
      JLabel count1, count2, count3, count4, count5, count6;
      //Button
      JButton b1, b2, b3, b4, b5, b6;
     
      //Exercise labels and buttons
      exer1 = new JLabel("Push Up");
      exer1.setBounds(10, 30, 100, 30); 
      b_check1 = new JButton("✔");
      b_check1.setBounds(120, 30, 50, 30);
      b1 = new JButton("+");
      b1.setBounds(180, 30, 45, 30); 
      count1 = new JLabel("0");
      count1.setBounds(230, 30, 30, 30);
      ex1 = new JLabel("Xp");
      ex1.setBounds(260, 30, 30, 30);


      exer2 = new JLabel("Pull Up");
      exer2.setBounds(10, 70, 100, 30);
      b_check2 = new JButton("✔");
      b_check2.setBounds(120, 70, 50, 30);
      b2 = new JButton("+");
      b2.setBounds(180, 70, 45, 30);
      count2 = new JLabel("0");
      count2.setBounds(230, 70, 30, 30);
      ex2 = new JLabel("Xp");
      ex2.setBounds(260, 70, 30, 30);


      exer3 = new JLabel("Sit Up");
      exer3.setBounds(10, 110, 100, 30);
      b_check3 = new JButton("✔");
      b_check3.setBounds(120, 110, 50, 30);
      b3 = new JButton("+");
      b3.setBounds(180, 110, 45, 30);
      count3 = new JLabel("0");
      count3.setBounds(230, 110, 30, 30);
      ex3 = new JLabel("Xp");
      ex3.setBounds(260, 110, 30, 30);


      exer4 = new JLabel("Dip");
      exer4.setBounds(10, 150, 100, 30);
      b_check4 = new JButton("✔");
      b_check4.setBounds(120, 150, 50, 30);
      b4 = new JButton("+");
      b4.setBounds(180, 150, 45, 30);
      count4 = new JLabel("0");
      count4.setBounds(230, 150, 30, 30);
      ex4 = new JLabel("Xp");
      ex4.setBounds(260, 150, 30, 30);


      exer5 = new JLabel("Plank");
      exer5.setBounds(10, 190, 100, 30);
      b_check5 = new JButton("✔");
      b_check5.setBounds(120, 190, 50, 30);
      b5 = new JButton("+");
      b5.setBounds(180, 190, 45, 30);
      count5 = new JLabel("0");
      count5.setBounds(230, 190, 30, 30);
      ex5 = new JLabel("Xp");
      ex5.setBounds(260, 190, 30, 30);


      exer6 = new JLabel("Squat");
      exer6.setBounds(10, 230, 100, 30);
      b_check6 = new JButton("✔");
      b_check6.setBounds(120, 230, 50, 30);
      b6 = new JButton("+");
      b6.setBounds(180, 230, 45, 30);
      count6 = new JLabel("0");
      count6.setBounds(230, 230, 30, 30);
      ex6 = new JLabel("Xp");
      ex6.setBounds(260, 230, 30, 30);
     
      p_exercise.add(exer1);
      p_exercise.add(b_check1);
      p_exercise.add(exer2);
      p_exercise.add(b_check2);
      p_exercise.add(exer3);
      p_exercise.add(b_check3);
      p_exercise.add(exer4);
      p_exercise.add(b_check4);
      p_exercise.add(exer5);
      p_exercise.add(b_check5);
      p_exercise.add(exer6);
      p_exercise.add(b_check6); 
      p_exercise.add(b1);
      p_exercise.add(b2);
      p_exercise.add(b3);
      p_exercise.add(b4);
      p_exercise.add(b5);
      p_exercise.add(b6);
      p_exercise.add(count1);
      p_exercise.add(count2);
      p_exercise.add(count3);
      p_exercise.add(count4);
      p_exercise.add(count5);
      p_exercise.add(count6);
      p_exercise.add(ex1);
      p_exercise.add(ex2);
      p_exercise.add(ex3);
      p_exercise.add(ex4);
      p_exercise.add(ex5);
      p_exercise.add(ex6);
     
      f_homepage.add(b_attack);
      f_homepage.add(b_inventory);
      f_homepage.add(b_store);
      f_homepage.add(b_skills);
      f_homepage.add(b_settings);
      f_homepage.add(p_task);
      f_homepage.add(p_exercise);
      
      
    
     
     
     
     
     
      //Frame for the battle
      JFrame f_battle;
      f_battle = new JFrame();
      f_battle.setTitle("Fighthing Arena");
      f_battle.setSize(800, 600);
      f_battle.setVisible(false);
      f_battle.setLayout(null); 


      //Player Components
      JLabel player1Label = new JLabel("You");
      player1Label.setBounds(50, 35, 100, 30);


      JProgressBar player1Health = new JProgressBar(0, 100);
      player1Health.setValue(100);
      player1Health.setBounds(50, 60, 300, 30);


      JButton player1Attack = new JButton("Attack");
      player1Attack.setBounds(100, 120, 200, 50);


      JLabel player2Label = new JLabel("Enemy");
      player2Label.setBounds(450, 35, 100, 30);


      JProgressBar player2Health = new JProgressBar(0, 100);
      player2Health.setValue(100);
      player2Health.setBounds(450, 60, 300, 30);


      JButton player2Attack = new JButton("Attack");
      player2Attack.setBounds(500, 120, 200, 50);


      //Skill Buttons
      JButton skillPushUp = new JButton("Push-Up");
      skillPushUp.setBounds(50, 200, 100, 40);


      JButton skillPullUp = new JButton("Pull-Up");
      skillPullUp.setBounds(160, 200, 100, 40);


      JButton skillSquat = new JButton("Squat");
      skillSquat.setBounds(50, 250, 100, 40);


      JButton skillSitUp = new JButton("Sit-Up");
      skillSitUp.setBounds(160, 250, 100, 40);


      //Decorative Title
      JLabel battleTitle = new JLabel("Battle Arena", SwingConstants.CENTER);
      battleTitle.setBounds(300, 10, 200, 40);
      battleTitle.setFont(new Font("Arial", Font.BOLD, 20));


      //Feedback Section
      JLabel feedback = new JLabel("", SwingConstants.CENTER);
      feedback.setBounds(300, 300, 200, 30);
      feedback.setFont(new Font("Arial", Font.ITALIC, 16));
      feedback.setForeground(Color.RED);


      //Exercise Progress
      JLabel xpLabel = new JLabel("Experience: 0");
      xpLabel.setBounds(50, 310, 150, 30);
      
      JLabel pushUpProgress = new JLabel("Push-Ups: 0");
      pushUpProgress.setBounds(50, 340, 150, 30);


      JLabel pullUpProgress = new JLabel("Pull-Ups: 0");
      pullUpProgress.setBounds(50, 370, 150, 30);


      JLabel squatProgress = new JLabel("Squats: 0");
      squatProgress.setBounds(50, 400, 150, 30);


      JLabel sitUpProgress = new JLabel("Sit-Ups: 0");
      sitUpProgress.setBounds(50, 430, 150, 30);


      //Restart Button
      JButton restartButton = new JButton("Restart");
      restartButton.setBounds(300, 400, 200, 50);
      restartButton.setVisible(false);
      
      JButton battle_back = new JButton ("Go Home");
      battle_back.setBounds(650, 500, 100, 30);


      //Add components to the frame
      f_battle.add(player1Label);
      f_battle.add(player1Health);
      f_battle.add(player1Attack);
      f_battle.add(player2Label);
      f_battle.add(player2Health);
      f_battle.add(skillPushUp);
      f_battle.add(skillPullUp);
      f_battle.add(skillSquat);
      f_battle.add(skillSitUp);
      f_battle.add(battleTitle);
      f_battle.add(feedback);
      f_battle.add(pushUpProgress);
      f_battle.add(pullUpProgress);
      f_battle.add(squatProgress);
      f_battle.add(sitUpProgress);
      f_battle.add(restartButton);
      f_battle.add(battle_back);
      f_battle.add(xpLabel);


      //Skill Effects
      final int[] pushUpCounter = {0};
      final int[] pullUpCounter = {0};
      final int[] squatCounter = {0};
      final int[] sitUpCounter = {0};
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
                  int currentHealth = player1Health.getValue();
                  player1Health.setValue(Math.min(currentHealth + 10, 100)); 
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


      //Attack logic
      player1Attack.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              int damage = 25 + (pushUpCounter[0] / 5) * 2 + (pullUpCounter[0] / 5) * 5; 
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
              int damage = 25; 


              if (blockNext[0]) { 
                  feedback.setText("Player 1 Blocked the Attack!");
                  blockNext[0] = false; 
                  return;
              }


              int currentHealth = player1Health.getValue();
              if (currentHealth > 0) {
                  player1Health.setValue(Math.max(currentHealth - damage, 0));
                  feedback.setText("Player 2 dealt " + damage + " damage!");
              }


              if (player1Health.getValue() <= 0) {
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
              player1Health.setValue(100);
              player2Health.setValue(100);
              player1Attack.setEnabled(true);
              player2Attack.setEnabled(true);
              feedback.setText("");
              pushUpCounter[0] = 0;
              pullUpCounter[0] = 0;
              squatCounter[0] = 0;
              sitUpCounter[0] = 0;
              blockNext[0] = false;
              restartButton.setVisible(false);
              pushUpProgress.setText("Push-Ups: 0");
              pullUpProgress.setText("Pull-Ups: 0");
              squatProgress.setText("Squats: 0");
              sitUpProgress.setText("Sit-Ups: 0");
          }
      });




    
     
  
      //Store Frame
      JFrame f_store;
      JLabel s_skills, s_xp;
      JLabel s_xp1, s_xp2, s_xp3;
      JButton s_back, s_exer1, s_exer2, s_exer3;
      JLabel s_achieve, s_count, s_exer11, s_exer22, s_exer33,s_total1, s_total2, s_total3;
     
      f_store = new JFrame();
      f_store.setTitle("Store");
      f_store.setSize(600, 1000);
      f_store.setVisible(false);
      f_store.setLayout(null);
     
      //Back button
      s_back = new JButton ("Go Back");
      s_back.setBounds(470, 300, 100, 50);
     
      //Header
      s_skills = new JLabel ("Skills: ");
      s_skills.setBounds(10, 10, 100, 50);
      s_xp = new JLabel ("Xp");
      s_xp.setBounds(50, 10, 100, 50);
     
      //Button for buying new set of exercise
      s_exer1 = new JButton ("Push Up");
      s_exer1.setBounds(10, 50, 90, 40);
      s_exer2 = new JButton ("Sit Up");
      s_exer2.setBounds(10, 100, 90, 40);
      s_exer3 = new JButton ("Pull Up");
      s_exer3.setBounds(10, 150, 90, 40);
     
      //Cost of exercise
      s_xp1 = new JLabel ("10xp");
      s_xp1.setBounds(110, 50, 100, 50);
      s_xp2= new JLabel ("10xp");
      s_xp2.setBounds(110, 100, 100, 50);
      s_xp3= new JLabel ("10xp");
      s_xp3.setBounds(110, 150, 100, 50);
     
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
     
     
     
      //Settings Frame
      JFrame f_settings;
      JLabel app_name, name;
      JLabel created, tamount, unlocks, unlocka, difficulty;
      JButton set_back, easy, medium, hard;
     
      f_settings = new JFrame();
      f_settings.setTitle("Settings");
      f_settings.setSize(800, 600);
      f_settings.setVisible(false);
      f_settings.setLayout(null);
     
      //Back button
      set_back = new JButton ("Go Back");
      set_back.setBounds(470, 300, 100, 50);
     
      //Name beside the logo
      app_name = new JLabel ("GYME");
      app_name.setBounds(250, 30, 100, 50);
      name = new JLabel ("Taneda");
      name.setBounds(250, 50, 100, 50);
     
      //Informations about accounts
      created = new JLabel ("Account created: ");
      created.setBounds(10,300, 100, 50);
     
      tamount = new JLabel ("Total Amount of Exercise: ");
      tamount.setBounds(10,350, 150, 50);
     
      unlocks = new JLabel ("Unlock Skills: ");
      unlocks.setBounds(10,400, 100, 50);
     
      unlocka = new JLabel ("Unlock Achievements: ");
      unlocka.setBounds(10,450, 150, 50);
     
      difficulty = new JLabel ("Difficulty: ");
      difficulty.setBounds(10,500, 100, 50);
     
      //Button for difficulty and it will change the type of exercises
      //Easy calisthenics
      //Medium calisthenics with some dumbells
      //Hard required gym equipments
      /*user can buy set of exercises even if it was different difficulty
        cause they have their choice, di naman sila bibili kung wala silang equipment diba*/
      easy = new JButton ("Easy");
      easy.setBounds(10, 550, 80, 50);
     
      medium = new JButton ("Medium");
      medium.setBounds(100, 550, 80, 50);
     
      hard = new JButton ("Hard");
      hard.setBounds(190, 550, 80, 50);
     
     
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
     
     
     
     
     
     
     
      //ActionListener for button
      b_login.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {          
              String name = tf_user.getText();
              String password = new String(pf_pass.getText());
              if (name.equals("") && password.equals("")) {
                  f_login.setVisible(false);
                  f_homepage.setVisible(true);
              }
          }
      });
     
     
      b_register.addActionListener(new ActionListener() {
     	 public void actionPerformed(ActionEvent e) {
     		 f_register.setVisible(true);
     		 f_login.setVisible(false);
     		
     	 }
      });
     
     
      b_back.addActionListener(new ActionListener() {
     	 public void actionPerformed(ActionEvent e) {
     		 f_register.setVisible(false);
     		 f_login.setVisible(true);
     		
     	 }
      });
     
      b_store.addActionListener(new ActionListener() {
       	 public void actionPerformed(ActionEvent e) {
       		 f_homepage.setVisible(false);
       		 f_store.setVisible(true);
       		
       	 }
        });
     
      //back button for store
      s_back.addActionListener(new ActionListener() {
     	 public void actionPerformed(ActionEvent e) {
     		 f_store.setVisible(false);
     		 f_homepage.setVisible(true);
     		
     	 }
      });
     
     
      b_view.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent e) {      
             String data =  new String(pf_pass1.getPassword());  
             tf_pass1.setText(data);         
          } 
       }); 
     
     
      b_attack.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
         	 f_battle.setVisible(true);
     		 f_homepage.setVisible(false);
             
          }
      });     
     
     //Inventory action button
      b_inventory.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	        //Call the inventory class to show the inventory screen
    	        inventory.main(null);  //This will invoke the main method in the inventory class
    	        f_homepage.setVisible(false);  //Hide the homepage frame
    	    }
      }); 
      
     
      b_settings.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
         	 f_settings.setVisible(true);
     		 f_homepage.setVisible(false);            
          }
      }); 
     
      
      set_back.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
         	 f_homepage.setVisible(true);
     		 f_settings.setVisible(false);
          }
      });   
      
      battle_back.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
         	 f_homepage.setVisible(true);
     		 f_battle.setVisible(false);
             
          }
      });   
 }
}






