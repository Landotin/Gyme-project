package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
public class inventory extends gyme {
	public inventory() {
       super(); //Calls the parent class constructor to initialize f_homepage
   }
   
   //HashMap to track equipped items for each slot
   static HashMap<String, String> equippedItems = new HashMap<>();
   public static void main(String[] args) {
       //Frame for inventory
       JFrame f_inventory = new JFrame();
       f_inventory.setTitle("Inventory");
       f_inventory.setSize(800, 600);
       f_inventory.setLayout(null);
       f_inventory.setResizable(false);
       f_inventory.getContentPane().setBackground(DARK_BACKGROUND);
       JPanel inventoryPanel = new JPanel() {
           @Override
           protected void paintComponent(Graphics g) {
               Graphics2D g2d = (Graphics2D) g;
               GradientPaint gradient = new GradientPaint(0, 0, DARK_BACKGROUND, 0, getHeight(), DARK_PURPLE);
               g2d.setPaint(gradient);
               g2d.fillRect(0, 0, getWidth(), getHeight());
           }
       };
       inventoryPanel.setLayout(null);
       inventoryPanel.setBounds(0, 0, 800, 600);
       
       //Add panel to frame
       f_inventory.add(inventoryPanel);
       f_inventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f_inventory.setVisible(true);
       
       //Character Panel
       JPanel characterPanel = new JPanel();
       characterPanel.setBounds(20, 20, 200, 200);
       characterPanel.setBorder(BorderFactory.createTitledBorder("Character"));
       characterPanel.setLayout(new BorderLayout());
       JLabel characterAvatar = new JLabel("Avatar", SwingConstants.CENTER);
       characterAvatar.setFont(new Font("Arial", Font.BOLD, 16));
       characterPanel.add(characterAvatar, BorderLayout.CENTER);
       //Stats Labels
       JLabel healthLabel = new JLabel("Health: " + gyme.health);
       healthLabel.setBackground(DARK_PURPLE);
       healthLabel.setForeground(Color.MAGENTA);
       
       JLabel damageLabel = new JLabel("Damage: " + gyme.damage);
       damageLabel.setBackground(DARK_PURPLE);
       damageLabel.setForeground(Color.MAGENTA);
       
       JLabel armorLabel = new JLabel("Armor: " + gyme.armor);
       armorLabel.setBackground(DARK_PURPLE);
       armorLabel.setForeground(Color.MAGENTA);
       
       JLabel agilityLabel = new JLabel("Agility: " + gyme.agility);
       agilityLabel.setBackground(DARK_PURPLE);
       agilityLabel.setForeground(Color.MAGENTA);
	     
       JLabel luckLabel = new JLabel("Luck: " + gyme.luck);
       luckLabel.setBackground(DARK_PURPLE);
       luckLabel.setForeground(Color.MAGENTA);
	     
       healthLabel.setBounds(250, 20, 150, 30);
       damageLabel.setBounds(250, 50, 150, 30);
       armorLabel.setBounds(250, 80, 150, 30);
       agilityLabel.setBounds(250, 110, 150, 30);
       luckLabel.setBounds(250, 140, 150, 30);
       
       
       //Inventory Buttons with Dropdown Menus
       JButton head = createItemButton("Head", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Helmet", "Crown");
       head.setBounds(400, 20, 150, 30);
       head.setBackground(VIBRANT_PURPLE);
       head.setForeground(Color.WHITE);
       head.setFont(new Font("Arial", Font.BOLD, 14));
       head.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
       head.setFocusPainted(false);
       
       
       JButton torso = createItemButton("Torso", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Armor", "Robes");
       torso.setBounds(400, 60, 150, 30);
       torso.setBackground(VIBRANT_PURPLE);
       torso.setForeground(Color.WHITE);
       torso.setFont(new Font("Arial", Font.BOLD, 14));
       torso.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
       torso.setFocusPainted(false);
       
       
       JButton legs = createItemButton("Legs", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Pants", "Boots");
       legs.setBounds(400, 100, 150, 30);
       legs.setBackground(VIBRANT_PURPLE);
       legs.setForeground(Color.WHITE);
       legs.setFont(new Font("Arial", Font.BOLD, 14));
       legs.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
       legs.setFocusPainted(false);
       
       
       JButton sword = createItemButton("Sword", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Longsword", "Dagger");
       sword.setBounds(400, 140, 150, 30);
       sword.setBackground(VIBRANT_PURPLE);
       sword.setForeground(Color.WHITE);
       sword.setFont(new Font("Arial", Font.BOLD, 14));
       sword.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
       sword.setFocusPainted(false);
       
       
       JButton shield = createItemButton("Shield", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Iron Shield", "Wooden Shield");
       shield.setBounds(400, 180, 150, 30);
       shield.setBackground(VIBRANT_PURPLE);
       shield.setForeground(Color.WHITE);
       shield.setFont(new Font("Arial", Font.BOLD, 14));
       shield.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
       shield.setFocusPainted(false);
       
       
       JButton relic = createItemButton("Relic", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Ancient Amulet", "Golden Ring");
       relic.setBounds(400, 220, 150, 30);
       relic.setBackground(VIBRANT_PURPLE);
       relic.setForeground(Color.WHITE);
       relic.setFont(new Font("Arial", Font.BOLD, 14));
       relic.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
       relic.setFocusPainted(false);
       
       
       JButton rune = createItemButton("Rune", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Fire Rune", "Ice Rune");
       rune.setBounds(400, 260, 150, 30);
       rune.setBackground(VIBRANT_PURPLE);
       rune.setForeground(Color.WHITE);
       rune.setFont(new Font("Arial", Font.BOLD, 14));
       rune.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
       rune.setFocusPainted(false);
       
       
       
      
       //Back Button
       JButton back = new JButton("Go Home");
       back.setBounds(650, 500, 100, 30);
       back.setBackground(VIBRANT_PURPLE);
       back.setForeground(Color.WHITE);
       back.setFont(new Font("Arial", Font.BOLD, 14));
       back.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
       back.setFocusPainted(false);
       back.addActionListener(new ActionListener() {	
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        //Close the inventory frame and show the homepage
		        f_inventory.setVisible(false); 
		        f_homepage.setVisible(true); 
		       
		      
		    }
		   
   });
       //Default equipped items
       equippedItems.put("Head", "None");
       equippedItems.put("Torso", "None");
       equippedItems.put("Legs", "None");
       equippedItems.put("Sword", "None");
       equippedItems.put("Shield", "None");
       equippedItems.put("Relic", "None");
       equippedItems.put("Rune", "None");
    
      
       inventoryPanel.add(characterPanel);
       inventoryPanel.add(healthLabel);
       inventoryPanel.add(damageLabel);
       inventoryPanel.add(armorLabel);
       inventoryPanel.add(agilityLabel);
       inventoryPanel.add(luckLabel);
       inventoryPanel.add(head);
       inventoryPanel.add(torso);
       inventoryPanel.add(legs);
       inventoryPanel.add(sword);
       inventoryPanel.add(shield);
       inventoryPanel.add(relic);
       inventoryPanel.add(rune);
       inventoryPanel.add(back);
       f_inventory.setVisible(true);
       
   
   }
   public static JButton createItemButton(String label, JLabel healthLabel, JLabel damageLabel, JLabel armorLabel, JLabel agilityLabel, JLabel luckLabel, String... options) {
       JButton button = new JButton(label);
       button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //Dropdown menu to select items
               String selectedItem = (String) JOptionPane.showInputDialog(
                       null,
                       "Choose an item for " + label + ":",
                       "Equip " + label,
                       JOptionPane.QUESTION_MESSAGE,
                       null,
                       options,
                       options[0]);
               //Check if the item is already equipped
               if (selectedItem != null) {
                   if (equippedItems.containsKey(label) && equippedItems.get(label).equals(selectedItem)) {
                       JOptionPane.showMessageDialog(null, "This item is already equipped!");
                       return;
                   }
                   //Remove previous item stats
                   if (equippedItems.containsKey(label)) {
                       removeStats(equippedItems.get(label));
                   }
                   //Equip new item and update stats
                   equippedItems.put(label, selectedItem);
                   addStats(selectedItem);
                   updateStats(healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel);
                   JOptionPane.showMessageDialog(null, label + " equipped: " + selectedItem);
               }
           }
       });
       return button;
   }
   public static void addStats(String item) {
       switch (item) {
           case "Helmet":
        	   gyme.armor += 10;
               break;
           case "Crown":
        	   gyme.luck += 5;
               break;
           case "Armor":
        	   gyme.health += 50;
               break;
           case "Robes":
        	   gyme.health += 30;
               gyme.agility += 5;
               break;
           case "Pants":
        	   gyme.armor += 5;
               break;
           case "Boots":
        	   gyme.agility += 10;
               break;
           case "Longsword":
        	   gyme.damage += 20;
               break;
           case "Dagger":
        	   gyme.damage += 15;
               gyme.agility += 5;
               break;
           case "Iron Shield":
        	   gyme.armor += 15;
               break;
           case "Wooden Shield":
        	   gyme.armor += 10;
               break;
           case "Ancient Amulet":
        	   gyme.luck += 10;
               break;
           case "Golden Ring":
        	   gyme.damage += 5;
               luck += 5;
               break;
           case "Fire Rune":
        	   gyme.damage += 10;
               break;
           case "Ice Rune":
        	   gyme.luck += 10;
               break;
       }
   }
   public static void removeStats(String item) {
       switch (item) {
           case "Helmet":
        	   gyme.armor -= 10;
               break;
           case "Crown":
        	   gyme.luck -= 5;
               break;
           case "Armor":
        	   gyme.health -= 50;
               break;
           case "Robes":
        	   gyme.health -= 30;
               gyme.agility -= 5;
               break;
           case "Pants":
        	   gyme.armor -= 5;
               break;
           case "Boots":
        	   gyme.agility -= 10;
               break;
           case "Longsword":
        	   gyme.damage -= 20;
               break;
           case "Dagger":
        	   gyme.damage -= 15;
               gyme.agility -= 5;
               break;
           case "Iron Shield":
        	   gyme.armor -= 15;
               break;
           case "Wooden Shield":
        	   gyme.armor -= 10;
               break;
           case "Ancient Amulet":
        	   gyme.luck -= 10;
               break;
           case "Golden Ring":
        	   gyme.damage -= 5;
               gyme.luck -= 5;
               break;
           case "Fire Rune":
        	   gyme.damage -= 10;
               break;
           case "Ice Rune":
        	   gyme.luck -= 10;
               break;
       }
   }
   public static void updateStats(JLabel healthLabel, JLabel damageLabel, JLabel armorLabel, JLabel agilityLabel, JLabel luckLabel) {
       healthLabel.setText("Health: " + gyme.health);
       damageLabel.setText("Damage: " + gyme.damage);
       armorLabel.setText("Armor: " + gyme.armor);
       agilityLabel.setText("Agility: " + gyme.agility);
       luckLabel.setText("Luck: " + gyme.luck);
   }
}
