import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;

/**
 * @author Amer Sisic -.-
 *
 */
public class List_GUI extends JFrame implements ActionListener {
	JRadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9, rb10, rb11;
	JButton btnDo, btnPrintList;
	JTextField txtElement, txtBefAft;

	JPanel pTextArea, pRadioButtons, pButton, pLabInfo, pLabButtons;
	JTextArea txtList;
	JLabel labInfo;
	String textEl, textBefAft;
	JScrollPane txtListScrollBar;
	SingleLinkedList myList;

	List_GUI() {
		txtElement = new JTextField(5);
		txtBefAft = new JTextField(5);
		txtBefAft.setEditable(false);
		txtBefAft.addActionListener(this);
		pTextArea = new JPanel(new FlowLayout());
		pTextArea.add(new JLabel("Number value"));
		pTextArea.add(txtElement);
		pTextArea.add(new JLabel("Before/After"));
		pTextArea.add(txtBefAft);

		rb1 = new JRadioButton();
		rb2 = new JRadioButton();
		rb3 = new JRadioButton();
		rb4 = new JRadioButton();
		rb5 = new JRadioButton();
		rb6 = new JRadioButton();
		rb7 = new JRadioButton();
		rb8 = new JRadioButton();
		rb9 = new JRadioButton();
		rb10 = new JRadioButton();
		rb11 = new JRadioButton();

		pRadioButtons = new JPanel(new GridLayout(11, 2, 80, 0));
		pRadioButtons.add(new JLabel("Insert first number"));
		pRadioButtons.add(rb1);
		pRadioButtons.add(new JLabel("Insert last number"));
		pRadioButtons.add(rb2);
		pRadioButtons.add(new JLabel("Delete first number"));
		pRadioButtons.add(rb3);
		pRadioButtons.add(new JLabel("Delete last number"));
		pRadioButtons.add(rb4);
		pRadioButtons.add(new JLabel("Delete a number with specific value"));
		pRadioButtons.add(rb5);
		pRadioButtons.add(new JLabel("Delete numbers with specific value"));
		pRadioButtons.add(rb6);
		pRadioButtons.add(new JLabel("Insert a number before number"));
		pRadioButtons.add(rb7);
		pRadioButtons.add(new JLabel("Insert a number after number"));
		pRadioButtons.add(rb8);
		pRadioButtons.add(new JLabel("Count the numbers with given value"));
		pRadioButtons.add(rb9);
		pRadioButtons.add(new JLabel("Show the length of the list"));
		pRadioButtons.add(rb10);
		pRadioButtons.add(new JLabel("Delete entire list"));
		pRadioButtons.add(rb11);
		pRadioButtons.setBorder(new TitledBorder(""));
		// group for radiobuttons
		ButtonGroup group1 = new ButtonGroup();
		group1.add(rb1);
		group1.add(rb2);
		group1.add(rb3);
		group1.add(rb4);
		group1.add(rb5);
		group1.add(rb6);
		group1.add(rb7);
		group1.add(rb8);
		group1.add(rb9);
		group1.add(rb10);
		group1.add(rb11);

		rb1.addActionListener(this);
		rb2.addActionListener(this);
		rb3.addActionListener(this);
		rb4.addActionListener(this);
		rb5.addActionListener(this);
		rb6.addActionListener(this);
		rb7.addActionListener(this);
		rb8.addActionListener(this);
		rb9.addActionListener(this);
		rb10.addActionListener(this);
		rb11.addActionListener(this);

		btnDo = new JButton("Do it");
		btnPrintList = new JButton("Print List");
		pButton = new JPanel(new FlowLayout());
		pButton.add(btnDo);
		pButton.add(btnPrintList);

		btnPrintList.addActionListener(this);
		btnDo.addActionListener(this);

		labInfo = new JLabel();
		pLabInfo = new JPanel(new FlowLayout());
		pLabInfo.add(labInfo);

		pLabButtons = new JPanel(new GridLayout(2, 1));
		pLabButtons.add(pButton);
		pLabButtons.add(pLabInfo);

		add(pTextArea, BorderLayout.NORTH);
		add(pRadioButtons, BorderLayout.WEST);

		add(pLabButtons, BorderLayout.SOUTH);

		myList = new SingleLinkedList();

	}

	public static void main(String[] args) {

		List_GUI frame = new List_GUI();
		frame.setSize(350, 350);
		frame.setTitle("Single Linked List");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		labInfo.setFont(new Font("Serif", Font.PLAIN, 14));

		if (e.getSource() == rb7 || e.getSource() == rb8)
			txtBefAft.setEditable(true);
		else if (e.getSource() == rb2 || e.getSource() == rb3
				|| e.getSource() == rb4 || e.getSource() == rb5
				|| e.getSource() == rb6 || e.getSource() == rb9
				|| e.getSource() == rb10 || e.getSource() == rb11)
			txtBefAft.setEditable(false);
		else if (e.getSource() == btnDo) {
			try {
				if (txtElement.getText().equals("") && !rb10.isSelected()
						&& !rb11.isSelected() && !rb3.isSelected()
						&& !rb4.isSelected()) {
					labInfo.setText("Please enter a value in the textbox(s)");
					labInfo.setForeground(Color.red);

				} else if (rb1.isSelected()) {
					myList.addInFront(Integer.parseInt(txtElement.getText()));
					labInfo.setText("Number " + txtElement.getText()
							+ " is added in front");
					labInfo.setForeground(Color.black);
				} else if (rb2.isSelected()) {
					myList.addEnd(Integer.parseInt(txtElement.getText()));
					labInfo.setText("Number " + txtElement.getText()
							+ " is added at the end");
					labInfo.setForeground(Color.black);
				} else if (rb3.isSelected()) {
					if (myList.isEmpty()) {
						labInfo.setText("The list is empty, could not delete first number in the list");
						labInfo.setForeground(Color.red);
					} else {
						myList.deleteFront();
						labInfo.setText("First number in the list is deleted!");
						labInfo.setForeground(Color.black);
					}
				} else if (rb4.isSelected()) {
					if (myList.isEmpty()) {
						labInfo.setText("The list is empty, could not delete last number in the list");
						labInfo.setForeground(Color.red);
					} else {
						myList.deleteEnd();
						labInfo.setText("Last number in the list is deleted!");
						labInfo.setForeground(Color.black);
					}
				} else if (rb5.isSelected()) {
					if (myList.countElementsOfSpecificValue(Integer
							.parseInt(txtElement.getText())) == 0) {
						labInfo.setText("Could not delete "
								+ txtElement.getText()
								+ " because number is not in the list");
						labInfo.setForeground(Color.red);
					} else {
						myList.deleteElement(Integer.parseInt(txtElement
								.getText()));
						labInfo.setText("First occurrence of number "
								+ txtElement.getText() + " is deleted");
						labInfo.setForeground(Color.black);
					}
				} else if (rb6.isSelected()) {
					if (myList.countElementsOfSpecificValue(Integer
							.parseInt(txtElement.getText())) == 0) {
						labInfo.setText("Could not delete "
								+ txtElement.getText()
								+ " because number(s) is not in the list");
						labInfo.setForeground(Color.red);
					} else {
						myList.deleteElements(Integer.parseInt(txtElement
								.getText()));
						labInfo.setText("All elements with number "
								+ txtElement.getText() + " are deleted");
						labInfo.setForeground(Color.black);
					}

				} else if (rb7.isSelected()) {
					if (txtBefAft.getText().equals("")) {
						labInfo.setText("Before/After text field is empty, enter a value then retry!");
						labInfo.setForeground(Color.red);
					} else {
						myList.addElementBefore(
								Integer.parseInt(txtBefAft.getText()),
								Integer.parseInt(txtElement.getText()));
						labInfo.setText("Added number " + txtElement.getText()
								+ ", before number " + txtBefAft.getText());
						labInfo.setForeground(Color.black);
					}

				} else if (rb8.isSelected()) {// if add after is selected
					if (txtBefAft.getText().equals("")) {
						labInfo.setText("Before/After text field is empty, enter a value then retry!");
						labInfo.setForeground(Color.red);
					} else {
						myList.addElementAfter(
								Integer.parseInt(txtBefAft.getText()),
								Integer.parseInt(txtElement.getText()));
						labInfo.setText("Added number " + txtElement.getText()
								+ ", after number " + txtBefAft.getText());
						labInfo.setForeground(Color.black);
					}

				} else if (rb9.isSelected()) {
					if (myList.countElementsOfSpecificValue(Integer
							.parseInt(txtElement.getText())) == 0) {
						labInfo.setText("Number " + txtElement.getText()
								+ " does not exist in the list");
						labInfo.setForeground(Color.red);
					} else {
						labInfo.setText("The list has "
								+ myList.countElementsOfSpecificValue(Integer
										.parseInt(txtElement.getText()))
								+ " element(s) of number "
								+ Integer.parseInt(txtElement.getText()));
						labInfo.setForeground(Color.black);
					}

				} else if (rb10.isSelected()) {
					labInfo.setText("The list contains "
							+ myList.getElementCount() + " number(s)");
					labInfo.setForeground(Color.black);
				} else if (rb11.isSelected()) {
					if(myList.isEmpty())
					{
						labInfo.setText("List is allready empty!");
						labInfo.setForeground(Color.red);
					}
					else
					{
					labInfo.setText("List is deleted, (total elements that has been deleted: "+myList.deleteList()+")");
					labInfo.setForeground(Color.black);
					}
				} else {
					labInfo.setText("Please select an option, then retry");
					labInfo.setForeground(Color.red);
				}
			} catch (NumberFormatException a) {
				labInfo.setText("Only use integers in text fields please!");
				labInfo.setForeground(Color.red);
			} catch (NullPointerException a) {
				labInfo.setText("Number " + txtBefAft.getText()
						+ " is not in the list, could not add "
						+ txtElement.getText());
				labInfo.setForeground(Color.red);
			}
		} else if (e.getSource() == btnPrintList) {
			txtList = new JTextArea(3, 20);
			txtListScrollBar = new JScrollPane(txtList);
			txtListScrollBar
					.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			txtListScrollBar.setPreferredSize(new Dimension(250, 250));
			JFrame newFram = new JFrame();
			newFram.setLocationRelativeTo(null);
			newFram.setSize(300, 200);
			newFram.setVisible(true);
			newFram.add(txtListScrollBar);
			newFram.setResizable(false);
			newFram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			txtList.setText(myList.toString());
			txtList.setEditable(false);

		}

	}
}
