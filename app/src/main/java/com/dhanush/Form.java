package com.dhanush;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Mon May 20 20:54:14 GMT 2024
 */

import com.dhanush.sql.DBWizard;
import com.dhanush.sql.Student;

/**
 * @author u0_a633
 */
public class Form extends JFrame {
	DBWizard dataBase;
	private boolean exists;

	public Form() {
		initComponents();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		dataBase = new DBWizard();
		dataBase.connect();
		reset();
	}

	private void searchResultsValueChanged(ListSelectionEvent e) {
		var student = dataBase.select(searchField.getText(), searchResults.getSelectedIndex());
		idLabel.setText(student.getId());
		nameField.setText(student.getName());
		phoneField.setText(student.getPhone());
		emailField.setText(student.getEmail());

		exists = true;
		addButton.setText("Update");
	}

	@SuppressWarnings("unchecked")
	private void searchFieldKeyReleased(KeyEvent e) {
		var target = searchField.getText();
		searchResults.setModel(dataBase.search(target));
	}

	private void addStudent(ActionEvent e) {
		var student = new Student(
				(exists) ? idLabel.getText() : "",
				nameField.getText(),
				phoneField.getText(),
				emailField.getText());

		if (exists)
			dataBase.update(student);
		else
			dataBase.insert(student);
		reset();
	}

	private void removeStudent(ActionEvent e) {
		var id = idLabel.getText();
		dataBase.delete(id);
		reset();
	}

	@SuppressWarnings("unchecked")
	public void reset() {
		idLabel.setText("ID:");
		nameField.setText("");
		phoneField.setText("");
		emailField.setText("");
		searchField.setText("");
		searchResults.setModel(dataBase.search(""));
		exists = false;
	}

	@SuppressWarnings({ "rawtypes" })
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Xiwoc
		leftPanel = new JPanel();
		searchField = new JTextField();
		listPanel = new JScrollPane();
		searchResults = new JList();
		rightPanel = new JPanel();
		nameLabel = new JLabel();
		phoneLabel = new JLabel();
		emailLabel = new JLabel();
		nameField = new JTextField();
		phoneField = new JTextField();
		emailField = new JTextField();
		idLabel = new JLabel();
		addButton = new JButton();
		removeButton = new JButton();

		//======== this ========
		Container contentPane = getContentPane();

		//======== leftPanel ========
		{
			leftPanel.setBorder(LineBorder.createBlackLineBorder());
			leftPanel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax .
			swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border
			. TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog"
			, java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,leftPanel. getBorder
			() ) ); leftPanel. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java
			. beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException
			( ) ;} } );

			//---- searchField ----
			searchField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					searchFieldKeyReleased(e);
				}
			});

			//======== listPanel ========
			{

				//---- searchResults ----
				searchResults.addListSelectionListener(e -> searchResultsValueChanged(e));
				listPanel.setViewportView(searchResults);
			}

			GroupLayout leftPanelLayout = new GroupLayout(leftPanel);
			leftPanel.setLayout(leftPanelLayout);
			leftPanelLayout.setHorizontalGroup(
				leftPanelLayout.createParallelGroup()
					.addGroup(leftPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(leftPanelLayout.createParallelGroup()
							.addComponent(searchField, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
							.addComponent(listPanel, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
						.addContainerGap())
			);
			leftPanelLayout.setVerticalGroup(
				leftPanelLayout.createParallelGroup()
					.addGroup(leftPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(searchField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(listPanel, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addContainerGap())
			);
		}

		//======== rightPanel ========
		{

			//---- nameLabel ----
			nameLabel.setText("Name:");

			//---- phoneLabel ----
			phoneLabel.setText("Phone:");

			//---- emailLabel ----
			emailLabel.setText("Email:");

			//---- idLabel ----
			idLabel.setText("ID");

			//---- addButton ----
			addButton.setText("Create");
			addButton.addActionListener(e -> addStudent(e));

			//---- removeButton ----
			removeButton.setText("Delete");
			removeButton.addActionListener(e -> removeStudent(e));

			GroupLayout rightPanelLayout = new GroupLayout(rightPanel);
			rightPanel.setLayout(rightPanelLayout);
			rightPanelLayout.setHorizontalGroup(
				rightPanelLayout.createParallelGroup()
					.addGroup(rightPanelLayout.createSequentialGroup()
						.addGroup(rightPanelLayout.createParallelGroup()
							.addGroup(GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
								.addContainerGap(282, Short.MAX_VALUE)
								.addComponent(idLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addGroup(rightPanelLayout.createSequentialGroup()
								.addGap(27, 27, 27)
								.addGroup(rightPanelLayout.createParallelGroup()
									.addGroup(rightPanelLayout.createSequentialGroup()
										.addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
									.addGroup(rightPanelLayout.createSequentialGroup()
										.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
									.addGroup(rightPanelLayout.createSequentialGroup()
										.addComponent(phoneLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)))
								.addGap(0, 8, Short.MAX_VALUE))
							.addGroup(rightPanelLayout.createSequentialGroup()
								.addGap(46, 46, 46)
								.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
								.addComponent(removeButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addGap(38, 38, 38)))
						.addContainerGap())
			);
			rightPanelLayout.setVerticalGroup(
				rightPanelLayout.createParallelGroup()
					.addGroup(rightPanelLayout.createSequentialGroup()
						.addGap(15, 15, 15)
						.addComponent(idLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGap(33, 33, 33)
						.addGroup(rightPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(44, 44, 44)
						.addGroup(rightPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(phoneLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(48, 48, 48)
						.addGroup(rightPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(31, 31, 31)
						.addGroup(rightPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(addButton)
							.addComponent(removeButton))
						.addContainerGap(30, Short.MAX_VALUE))
			);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(leftPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(rightPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(leftPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rightPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Xiwoc
	private JPanel leftPanel;
	private JTextField searchField;
	private JScrollPane listPanel;
	@SuppressWarnings("rawtypes")
	private JList searchResults;
	private JPanel rightPanel;
	private JLabel nameLabel;
	private JLabel phoneLabel;
	private JLabel emailLabel;
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField emailField;
	private JLabel idLabel;
	private JButton addButton;
	private JButton removeButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
