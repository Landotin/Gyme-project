package game;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class gyme extends JFrame {
    
	//Variables for exercise
    static int[] xp = {0};
    public static boolean isDipPurchased = false;
    public static boolean isPlankPurchased = false;
    public static boolean isJumpingJacksPurchased = false;
    static int[] totalPushUps = {0};
    static int[] totalSitUps = {0};
    static int[] totalPullUps = {0};
    static int[] totalSquats = {0};
    
    static int reps1 = 0;
	static int reps2 = 0;
	static int reps3 = 0;
	static int reps4 = 0;
	static int reps5 = 0;
	static int goal = 1; 
    
    //Default stats
    static int health = 100;
    static int damage = 5;
    static int armor = 3;
    static int agility = 0;
    static int luck = 0;
    
    //Color palette
    public static final Color DARK_BACKGROUND = Color.decode("#1A1A1D");
    public static final Color DARK_PURPLE = Color.decode("#3B1C32");
    public static final Color VIBRANT_PURPLE = Color.decode("#6A1E55");
    public static final Color SOFT_PINK = Color.decode("#A64D79");
    
    //Ginawa kong public para maccess ng lahat
    public static JFrame f_homepage;

    //Regex patterns
    public static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{3,20}$");
    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");

    
    
    
    public static void main(String[] args) throws IOException {
    	String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/gyme";
        String USER = "root";
        String PASS = "";

    	//Modern appearance
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        //Frame for login
        JFrame f_login = new JFrame();
        f_login.getContentPane().setBackground(DARK_BACKGROUND);
        f_login.setTitle("GYME - Fitness Tracker");
        f_login.setSize(800, 600);
        f_login.setLayout(null);
        f_login.setResizable(false);
        
        //Custom panel with gradient background
        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, DARK_BACKGROUND, 0, getHeight(), DARK_PURPLE);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        loginPanel.setLayout(null);
        loginPanel.setBounds(0, 0, 800, 600);

        //Logo 
        JLabel l_logo = new JLabel("GYME");
        l_logo.setFont(new Font("Orbitron", Font.BOLD, 50));
        l_logo.setForeground(SOFT_PINK);
        l_logo.setBounds(300, 50, 300, 100);
        
        //Username 
        JTextField tf_user = new JTextField();
        tf_user.setBounds(250, 230, 300, 40);
        tf_user.setBackground(VIBRANT_PURPLE);
        tf_user.setForeground(Color.WHITE);
        tf_user.setCaretColor(Color.WHITE);
        tf_user.setBorder(BorderFactory.createLineBorder(SOFT_PINK, 2, true));
        tf_user.setFont(new Font("Arial", Font.PLAIN, 16));
        
        JLabel l_user = new JLabel("USERNAME");
        l_user.setBounds(250, 200, 300, 30);
        l_user.setForeground(SOFT_PINK);
        l_user.setFont(new Font("Arial", Font.BOLD, 14));
        
        JLabel userErrorLabel = new JLabel("");
        userErrorLabel.setBounds(250, 270, 300, 20);
        userErrorLabel.setForeground(Color.RED);
        
        //Password field 
        JPasswordField pf_pass = new JPasswordField();
        pf_pass.setBounds(250, 310, 300, 40);
        pf_pass.setBackground(VIBRANT_PURPLE);
        pf_pass.setForeground(Color.WHITE);
        pf_pass.setCaretColor(Color.WHITE);
        pf_pass.setBorder(BorderFactory.createLineBorder(SOFT_PINK, 2, true));
        pf_pass.setFont(new Font("Arial", Font.PLAIN, 16));
        
        JLabel l_pass = new JLabel("PASSWORD");
        l_pass.setBounds(250, 280, 300, 30);
        l_pass.setForeground(SOFT_PINK);
        l_pass.setFont(new Font("Arial", Font.BOLD, 14));
        
        JLabel passErrorLabel = new JLabel("");
        passErrorLabel.setBounds(250, 350, 300, 20);
        passErrorLabel.setForeground(Color.RED);
        
        //Buttons 
        JButton b_login = new JButton("LOGIN");
        b_login.setBounds(250, 420, 140, 50);
        b_login.setBackground(SOFT_PINK);
        b_login.setForeground(Color.WHITE);
        b_login.setFont(new Font("Arial", Font.BOLD, 16));
        b_login.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        b_login.setFocusPainted(false);
        
        JButton b_register = new JButton("REGISTER");
        b_register.setBounds(410, 420, 140, 50);
        b_register.setBackground(VIBRANT_PURPLE);
        b_register.setForeground(Color.WHITE);
        b_register.setFont(new Font("Arial", Font.BOLD, 16));
        b_register.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        b_register.setFocusPainted(false);
        
        JButton b_view = new JButton("Show");
        b_view.setBounds(560, 310, 50, 40);
        b_view.setBackground(SOFT_PINK);
        b_view.setForeground(Color.WHITE);
        b_view.setFont(new Font("Arial", Font.BOLD, 14));
        b_view.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        b_view.setFocusPainted(false);
        
      
        loginPanel.add(l_logo);
        loginPanel.add(tf_user);
        loginPanel.add(pf_pass);
        loginPanel.add(l_user);
        loginPanel.add(l_pass);
        loginPanel.add(b_login);
        loginPanel.add(b_register);
        loginPanel.add(userErrorLabel);
        loginPanel.add(passErrorLabel);
        loginPanel.add(b_view);

        //Add panel to frame
        f_login.add(loginPanel);
        f_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_login.setVisible(true);
        
        //Frame for register
        JFrame f_register = new JFrame("GYME - Register");
        f_register.getContentPane().setBackground(DARK_BACKGROUND);
        f_register.setSize(800, 600);
        f_register.setLayout(null);
        f_register.setResizable(false);
        
        //Custom panel with gradient background
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
              
        //Register username 
        JTextField tf_user1 = new JTextField();
        tf_user1.setBounds(250, 230, 300, 40);
        tf_user1.setBackground(VIBRANT_PURPLE);
        tf_user1.setForeground(Color.WHITE);
        tf_user1.setCaretColor(Color.WHITE);
        tf_user1.setBorder(BorderFactory.createLineBorder(SOFT_PINK, 2, true));
        tf_user1.setFont(new Font("Arial", Font.PLAIN, 16));
        
        JLabel l_user1 = new JLabel("USERNAME");
        l_user1.setBounds(250, 200, 300, 30);
        l_user1.setForeground(SOFT_PINK);
        l_user1.setFont(new Font("Arial", Font.BOLD, 14));
        
        JLabel userRegErrorLabel = new JLabel("");
        userRegErrorLabel.setBounds(250, 270, 300, 20);
        userRegErrorLabel.setForeground(Color.RED);
                
        //Register password    
        JPasswordField pf_pass1 = new JPasswordField();
        pf_pass1.setBounds(250, 310, 300, 40);
        pf_pass1.setBackground(VIBRANT_PURPLE);
        pf_pass1.setForeground(Color.WHITE);
        pf_pass1.setCaretColor(Color.WHITE);
        pf_pass1.setBorder(BorderFactory.createLineBorder(SOFT_PINK, 2, true));
        pf_pass1.setFont(new Font("Arial", Font.PLAIN, 16));
        
        JLabel l_pass1 = new JLabel("PASSWORD");
        l_pass1.setBounds(250, 280, 300, 30);
        l_pass1.setForeground(SOFT_PINK);
        l_pass1.setFont(new Font("Arial", Font.BOLD, 14));
        
        JLabel passRegErrorLabel = new JLabel("");
        passRegErrorLabel.setBounds(250, 350, 300, 20);
        passRegErrorLabel.setForeground(Color.RED);
        
        //Register buttons
        JButton b_view1 = new JButton("Show");
        b_view1.setBounds(560, 310, 50, 40);
        b_view1.setBackground(SOFT_PINK);
        b_view1.setForeground(Color.WHITE);
        b_view1.setFont(new Font("Arial", Font.BOLD, 14));
        b_view1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        b_view1.setFocusPainted(false);
        
        JButton b_create = new JButton("REGISTER");
        b_create.setBounds(250, 420, 140, 50);
        b_create.setBackground(SOFT_PINK);
        b_create.setForeground(Color.WHITE);
        b_create.setFont(new Font("Arial", Font.BOLD, 16));
        b_create.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        b_create.setFocusPainted(false);
        
        JButton b_back = new JButton("GO BACK");
        b_back.setBounds(410, 420, 140, 50);
        b_back.setBackground(VIBRANT_PURPLE);
        b_back.setForeground(Color.WHITE);
        b_back.setFont(new Font("Arial", Font.BOLD, 16));
        b_back.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        b_back.setFocusPainted(false);
        
        f_login.setVisible(true);
        
        registerPanel.add(tf_user1);
        registerPanel.add(l_user1);
        registerPanel.add(pf_pass1);
        registerPanel.add(l_pass1);
        registerPanel.add(b_create);
        registerPanel.add(b_back);
        registerPanel.add(b_view1);
        registerPanel.add(userRegErrorLabel);
        registerPanel.add(passRegErrorLabel);
       
        //Add panel to frame
        f_register.add(registerPanel);
        f_register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Button action listeners
        b_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tf_user.getText();
                String password = new String(pf_pass.getPassword());

                userErrorLabel.setText("");
                passErrorLabel.setText("");

                if (!USERNAME_PATTERN.matcher(name).matches()) {
                    userErrorLabel.setText("Invalid username! 3-20 chars, alphanumeric & underscore only.");
                    return;
                }

                if (!PASSWORD_PATTERN.matcher(password).matches()) {
                    passErrorLabel.setText("Invalid password! Minimum 8 chars, 1 letter, 1 number, 1 special char.");
                    return;
                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gyme", "root", "");

                    String query = "SELECT * FROM account WHERE username = ? AND password = ?";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setString(1, name);
                    pstmt.setString(2, password);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(f_login, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        f_login.setVisible(false);
                        homepage.main(null);
                    } else {
                        JOptionPane.showMessageDialog(f_login, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    rs.close();
                    pstmt.close();
                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(f_login, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        //Register actionlistener
        b_create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userRegErrorLabel.setText("");
                passRegErrorLabel.setText("");

                String reguser = tf_user1.getText();
                String regpass = new String(pf_pass1.getPassword());
                boolean isValid = true;

                if (!USERNAME_PATTERN.matcher(reguser).matches()) {
                    userRegErrorLabel.setText("Invalid username! 3-20 chars, alphanumeric & underscore only.");
                    isValid = false;
                }

                if (!PASSWORD_PATTERN.matcher(regpass).matches()) {
                    passRegErrorLabel.setText("Invalid password! Minimum 8 chars, 1 letter, 1 number, 1 special char.");
                    isValid = false;
                }

                if (isValid) {
                    JOptionPane.showMessageDialog(f_register, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    f_register.setVisible(false);
                    f_login.setVisible(true);

                    try {
                        Date thisDate = new Date();
                        SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/Y");
                        String formattedDate = dateForm.format(thisDate);

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gyme", "root", "");

                        String insertQuery = "INSERT INTO account (username, password, registration_date) VALUES (?, ?, ?)";
                        PreparedStatement pstmt = con.prepareStatement(insertQuery);
                        pstmt.setString(1, reguser);
                        pstmt.setString(2, regpass);
                        pstmt.setString(3, formattedDate); 
                        pstmt.executeUpdate();

                        pstmt.close();
                        con.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(f_register, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
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
        
        
        b_view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                if(pf_pass.getEchoChar() == '\u2022') {
                    pf_pass.setEchoChar((char) 0); //Show password
                    b_view.setText("Hide");
                } else {
                    pf_pass.setEchoChar('\u2022'); //Hide password
                    b_view.setText("Show");
                }    
            }
        });
        
        
        b_view1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                if(pf_pass1.getEchoChar() == '\u2022') {
                    pf_pass1.setEchoChar((char) 0); //Show password
                    b_view1.setText("Hide");
                } else {
                    pf_pass1.setEchoChar('\u2022'); //Hide password
                    b_view1.setText("Show");
                }    
            }
        });
    }
}
