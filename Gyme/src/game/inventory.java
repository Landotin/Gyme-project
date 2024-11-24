package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class inventory extends gyme {
	public inventory() {
        super(); // Calls the parent class constructor to initialize f_homepage
    }
    //Default stats
    static int health = 100;
    static int damage = 5;
    static int armor = 3;
    static int agility = 0;
    static int luck = 0;

    //HashMap to track equipped items for each slot
    static HashMap<String, String> equippedItems = new HashMap<>();

    public static void main(String[] args) {

        //Frame for inventory
        JFrame f_inventory = new JFrame();
        f_inventory.setTitle("Inventory");
        f_inventory.setSize(800, 600);
        f_inventory.setLayout(null);

        //Character Panel
        JPanel characterPanel = new JPanel();
        characterPanel.setBounds(20, 20, 200, 200);
        characterPanel.setBorder(BorderFactory.createTitledBorder("Character"));
        characterPanel.setLayout(new BorderLayout());
        JLabel characterAvatar = new JLabel("Avatar", SwingConstants.CENTER);
        characterAvatar.setFont(new Font("Arial", Font.BOLD, 16));
        characterPanel.add(characterAvatar, BorderLayout.CENTER);

        //Stats Labels
        JLabel healthLabel = new JLabel("Health: " + health);
        JLabel damageLabel = new JLabel("Damage: " + damage);
        JLabel armorLabel = new JLabel("Armor: " + armor);
        JLabel agilityLabel = new JLabel("Agility: " + agility);
        JLabel luckLabel = new JLabel("Luck: " + luck);

        healthLabel.setBounds(250, 20, 150, 30);
        damageLabel.setBounds(250, 50, 150, 30);
        armorLabel.setBounds(250, 80, 150, 30);
        agilityLabel.setBounds(250, 110, 150, 30);
        luckLabel.setBounds(250, 140, 150, 30);

        //Inventory Buttons with Dropdown Menus
        JButton head = createItemButton("Head", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Helmet", "Crown");
        JButton torso = createItemButton("Torso", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Armor", "Robes");
        JButton legs = createItemButton("Legs", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Pants", "Boots");
        JButton sword = createItemButton("Sword", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Longsword", "Dagger");
        JButton shield = createItemButton("Shield", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Iron Shield", "Wooden Shield");
        JButton relic = createItemButton("Relic", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Ancient Amulet", "Golden Ring");
        JButton rune = createItemButton("Rune", healthLabel, damageLabel, armorLabel, agilityLabel, luckLabel, "None", "Fire Rune", "Ice Rune");

        head.setBounds(400, 20, 150, 30);
        torso.setBounds(400, 60, 150, 30);
        legs.setBounds(400, 100, 150, 30);
        sword.setBounds(400, 140, 150, 30);
        shield.setBounds(400, 180, 150, 30);
        relic.setBounds(400, 220, 150, 30);
        rune.setBounds(400, 260, 150, 30);

        //Back Button
        JButton back = new JButton("Go Home");
        back.setBounds(650, 500, 100, 30);
        back.addActionListener(new ActionListener() {	 
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Close the inventory frame and show the homepage
		        f_inventory.setVisible(false);  // Hide the inventory frame
		        f_homepage.setVisible(true);  // Show the homepage frame
		        
		       
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

      
        f_inventory.add(characterPanel);
        f_inventory.add(healthLabel);
        f_inventory.add(damageLabel);
        f_inventory.add(armorLabel);
        f_inventory.add(agilityLabel);
        f_inventory.add(luckLabel);
        f_inventory.add(head);
        f_inventory.add(torso);
        f_inventory.add(legs);
        f_inventory.add(sword);
        f_inventory.add(shield);
        f_inventory.add(relic);
        f_inventory.add(rune);
        f_inventory.add(back);

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
                armor += 10;
                break;
            case "Crown":
                luck += 5;
                break;
            case "Armor":
                health += 50;
                break;
            case "Robes":
                health += 30;
                agility += 5;
                break;
            case "Pants":
                armor += 5;
                break;
            case "Boots":
                agility += 10;
                break;
            case "Longsword":
                damage += 20;
                break;
            case "Dagger":
                damage += 15;
                agility += 5;
                break;
            case "Iron Shield":
                armor += 15;
                break;
            case "Wooden Shield":
                armor += 10;
                break;
            case "Ancient Amulet":
                luck += 10;
                break;
            case "Golden Ring":
                damage += 5;
                luck += 5;
                break;
            case "Fire Rune":
                damage += 10;
                break;
            case "Ice Rune":
                luck += 10;
                break;
        }
    }

    public static void removeStats(String item) {
        switch (item) {
            case "Helmet":
                armor -= 10;
                break;
            case "Crown":
                luck -= 5;
                break;
            case "Armor":
                health -= 50;
                break;
            case "Robes":
                health -= 30;
                agility -= 5;
                break;
            case "Pants":
                armor -= 5;
                break;
            case "Boots":
                agility -= 10;
                break;
            case "Longsword":
                damage -= 20;
                break;
            case "Dagger":
                damage -= 15;
                agility -= 5;
                break;
            case "Iron Shield":
                armor -= 15;
                break;
            case "Wooden Shield":
                armor -= 10;
                break;
            case "Ancient Amulet":
                luck -= 10;
                break;
            case "Golden Ring":
                damage -= 5;
                luck -= 5;
                break;
            case "Fire Rune":
                damage -= 10;
                break;
            case "Ice Rune":
                luck -= 10;
                break;
        }
    }

    public static void updateStats(JLabel healthLabel, JLabel damageLabel, JLabel armorLabel, JLabel agilityLabel, JLabel luckLabel) {
        healthLabel.setText("Health: " + health);
        damageLabel.setText("Damage: " + damage);
        armorLabel.setText("Armor: " + armor);
        agilityLabel.setText("Agility: " + agility);
        luckLabel.setText("Luck: " + luck);
    }
}
