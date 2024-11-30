package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener{
    /*
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons.
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list.
     */
	
	HashMap<Integer, String> idCard = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b1 = new JButton("Add Entry");
	JButton b2 = new JButton("Search By ID");
	JButton b3 = new JButton("View List");
	
	
	public static void main(String[] args) {
		_02_LogSearch logSearch = new _02_LogSearch();
		logSearch.setup();
	}
	
	
	public void setup() {
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);
	panel.add(b1);
	panel.add(b2);
	panel.add(b3);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	frame.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(b1)) {
			String number = JOptionPane.showInputDialog("Enter an ID number");
			String name = JOptionPane.showInputDialog("Enter a name");
			int num = Integer.parseInt(number);
			idCard.put(num, name);
		}
		
		if(e.getSource().equals(b2)) {
			String search = JOptionPane.showInputDialog("Search an ID number");
			int id = Integer.parseInt(search);
			
			if(idCard.containsKey(id)) {
				System.out.println("Name: " + idCard.get(id));
			}else {
				JOptionPane.showMessageDialog(null, "Entry doesn't exist...");
			}
			
		}
		
		if(e.getSource().equals(b3)) {
			for(Integer i : idCard.keySet()) {
				System.out.println("ID: " + i + " Name: " + idCard.get(i));
				
			}
			}
		}
	}
