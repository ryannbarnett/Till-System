package till_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class main_class implements ActionListener {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    order currentOrder = new order();
    private String location = "";
    private String currentPanel = "";
    private JFrame frame;
    private JPanel homescreen;
    private JPanel drinks;
    private JPanel hot_drinks;
    private JPanel iced_drinks;
    private JPanel food;
    private JButton sit_in_button;
    private JButton take_away_button;
    private JButton receipts_button;
    private JButton change_location_button;
    private JButton change_panel_drinks;
    private JButton change_panel_food;
    private JButton change_panel_hot_drinks;
    private JButton change_panel_iced_drinks;
    private JButton latteSML;
    private JButton iced_latteSML;
    private JButton toast;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public main_class() {

        frame = new JFrame("Till System");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(128, 0, 0));

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        homescreen = new JPanel();
        homescreen.setLayout(null);
        homescreen.setBackground(new Color(128, 0, 0));

        drinks = new JPanel();
        drinks.setLayout(null);
        drinks.setBackground(new Color(128, 0, 0));

        food = new JPanel();
        food.setLayout(null);
        food.setBackground(new Color(128, 0, 0));
        
        hot_drinks = new JPanel();
        hot_drinks.setLayout(null);
        hot_drinks.setBackground(new Color(128, 0, 0));
        
        iced_drinks = new JPanel();
        iced_drinks.setLayout(null);
        iced_drinks.setBackground(new Color(128, 0, 0));

        sit_in_button = new JButton("Sit-In");
        sit_in_button.setBounds((screenSize.width / 2) - 225, (screenSize.height / 2) - 230, 450, 140);
        sit_in_button.addActionListener(this);

        take_away_button = new JButton("Take Away");
        take_away_button.setBounds((screenSize.width / 2) - 225, (screenSize.height / 2) - 70, 450, 140);
        take_away_button.addActionListener(this);

        receipts_button = new JButton("Receipts");
        receipts_button.setBounds((screenSize.width / 2) - 225, (screenSize.height / 2) + 90, 450, 140);
        receipts_button.addActionListener(this);

        change_location_button = new JButton("");
        change_location_button.setBounds(20, 20, 90, 90);
        change_location_button.addActionListener(this);

        change_panel_drinks = new JButton("Drinks");
        change_panel_drinks.setBounds(120, 20, 90, 90);
        change_panel_drinks.addActionListener(this);

        change_panel_food = new JButton("Food");
        change_panel_food.setBounds(220, 20, 90, 90);
        change_panel_food.addActionListener(this);
        
        change_panel_hot_drinks = new JButton("Hot Drinks");
        change_panel_hot_drinks.setBounds(20, 130, 110, 90);
        change_panel_hot_drinks.addActionListener(this);
        
        change_panel_iced_drinks = new JButton("Iced Drinks");
        change_panel_iced_drinks.setBounds(20, 240, 110, 90);
        change_panel_iced_drinks.addActionListener(this);
        
        latteSML = new JButton("Latte SML");
        latteSML.setBounds(220, 120, 100, 80);
        latteSML.addActionListener(this);
        
        iced_latteSML = new JButton("Iced Latte SML");
        iced_latteSML.setBounds(220, 120, 100, 80);
        iced_latteSML.addActionListener(this);
        
        toast = new JButton("Toast");
        toast.setBounds(220, 120, 100, 80);
        toast.addActionListener(this);

        // Non Shared Buttons
        homescreen.add(sit_in_button);
        homescreen.add(take_away_button);
        homescreen.add(receipts_button);
                
        cardPanel.add(homescreen, "Home");
        cardPanel.add(drinks, "Drinks");
        cardPanel.add(food, "Food");
        cardPanel.add(hot_drinks, "Hot Drinks");
        cardPanel.add(iced_drinks, "Iced Drinks");

        frame.add(cardPanel);
        cardLayout.show(cardPanel, "Home");
        frame.setVisible(true);
        currentPanel = "Home";
    }

    public static void main(String[] args) {
        new main_class();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == sit_in_button) {
            location = "Go to TA";
            currentPanel = "Hot Drinks";
            create_hot_drinks_panel();
        }
        
        if (e.getSource() == take_away_button) {
        	location = "Go to EI";
        	currentPanel = "Hot Drinks";
        	create_hot_drinks_panel();
        }
        
        if (e.getSource() == change_panel_drinks && currentPanel.equals("Hot Drinks") == false) {
        	currentPanel = "Hot Drinks";
        	create_hot_drinks_panel();
        }
        
        if (e.getSource() == change_panel_food && currentPanel.equals("Food") == false) {
        	currentPanel = "Food";
        	create_food_panel();
        }
        
        if (e.getSource() == change_panel_hot_drinks && currentPanel.equals("Hot Drinks") == false) {
        	currentPanel = "Hot Drinks";
        	create_hot_drinks_panel();
        }
        
        if (e.getSource() == change_panel_iced_drinks && currentPanel.equals("Iced Drinks") == false) {
        	currentPanel = "Iced Drinks";
        	create_iced_drinks_panel();
        }
    }
    
    // Panel creation methods
    
    public void create_drinks_base(JPanel panel) {
    	panel.add(change_location_button);
    	change_location_button.setText(location);
    	panel.add(change_panel_drinks);
    	panel.add(change_panel_food);
    	panel.add(change_panel_hot_drinks);
    	panel.add(change_panel_iced_drinks);
    }
            
    public void create_hot_drinks_panel() {
    	create_drinks_base(hot_drinks);
    	iced_drinks.add(latteSML);
    	cardLayout.show(cardPanel, "Hot Drinks");
    }
    
    public void create_iced_drinks_panel() {
    	create_drinks_base(iced_drinks);
    	hot_drinks.add(iced_latteSML);
    	cardLayout.show(cardPanel, "Iced Drinks");
    }
    
    public void create_food_panel() {
    	food.add(change_location_button);
    	change_location_button.setText(location);
    	food.add(change_panel_drinks);
    	food.add(change_panel_food);
    	food.add(toast);
    	cardLayout.show(cardPanel, "Food");
    }
}