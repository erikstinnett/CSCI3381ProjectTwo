/* 
 * Erik Stinnett
 * OO Development in Java
 */


package Project2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class PushCounterPanel extends JPanel{
	private int count;
	private JButton push;
	private JLabel label;
	private JButton reset;
	private Shows allData;
	private JLabel enterWeek;
	private JTextField dateOfMovie;
	private JButton getShowsButton;
	private JLabel ProjectTitle;
	private JLabel viewWeekLabel;
	private JLabel editShowLabel;
	private JTextField editShowTitle;
	private JTextField showToAddRemove;
	private ShowWeek editShowWeek;
	private JTextField showToEdit;
	private JButton editButton;
	private ArrayList<ShowWeek> moviesInWeek;
	private ArrayList<ShowWeek> showWeeks;


	public PushCounterPanel() {
		allData = new Shows("allData","./Project2/netflixAllWeeksGlobalProcessed.txt");

		setBackground(new Color(128, 128, 255));
		setPreferredSize(new Dimension(1025, 600));

		moviesInWeek = allData.getOneWeek("2022-09-04");

		String[] data = new String[moviesInWeek.size()];
		int index = 0;		
		for (ShowWeek sw : moviesInWeek) {
			data[index] = sw.getShowTitle();
			index++;
		}
		setLayout(null);


		// Creates combobox that will list movies 
		JComboBox movies = new JComboBox();
		movies.setBackground(new Color(255, 255, 255));
		movies.setModel(new DefaultComboBoxModel(data));
		movies.setBounds(315, 329, 134, 20);
		add(movies);
		movies.setToolTipText(allData.toString());

		// J label for Enter Week 
		enterWeek = new JLabel("Enter Week:");
		enterWeek.setForeground(new Color(255, 255, 255));
		enterWeek.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enterWeek.setBounds(315, 209, 86, 32);
		add(enterWeek);

		// Text field asking for date of movie
		dateOfMovie = new JTextField("2022-09-04");
		dateOfMovie.setBounds(315, 239, 97, 20);
		add(dateOfMovie);
		dateOfMovie.setColumns(10);

		// Movies label that dsecribes what week is being displayed
		JLabel moviesLabel = new JLabel("Shows in week: 2022-09-04");
		moviesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		moviesLabel.setForeground(new Color(255, 255, 255));
		moviesLabel.setBounds(315, 304, 173, 14);
		add(moviesLabel);

		// Button to grab shows
		getShowsButton = new JButton("Get Shows");
		getShowsButton.setBackground(new Color(243, 208, 12));
		getShowsButton.setBounds(315, 270, 97, 23);
		add(getShowsButton);

		// Project title label
		ProjectTitle = new JLabel("Java Project II GUI");
		ProjectTitle.setForeground(new Color(255, 255, 255));
		ProjectTitle.setFont(new Font("Modern No. 20", Font.BOLD, 40));
		ProjectTitle.setBounds(359, 11, 355, 73);
		add(ProjectTitle);

		// View week module label
		viewWeekLabel = new JLabel("View Week:");
		viewWeekLabel.setForeground(new Color(243, 208, 12));
		viewWeekLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		viewWeekLabel.setBounds(315, 180, 125, 31);
		add(viewWeekLabel);

		// Edit Show label
		editShowLabel = new JLabel("Edit Show:");
		editShowLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		editShowLabel.setForeground(new Color(253, 223, 11));
		editShowLabel.setBounds(580, 180, 110, 32);
		add(editShowLabel);

		//Text field for show addition or removal
		showToAddRemove = new JTextField();
		showToAddRemove.setBounds(773, 329, 240, 20);
		add(showToAddRemove);
		showToAddRemove.setColumns(10);

		// Add show checkbox
		JCheckBox addShowCheckBox = new JCheckBox("Add Show");
		addShowCheckBox.setBackground(new Color(243, 208, 12));
		addShowCheckBox.setBounds(835, 238, 97, 23);
		add(addShowCheckBox);

		// Remove show checkbox
		JCheckBox removeShowCheckBox = new JCheckBox("Remove Show");
		removeShowCheckBox.setBackground(new Color(243, 208, 12));
		removeShowCheckBox.setBounds(835, 270, 97, 23);
		add(removeShowCheckBox);

		// Unpurge show checkbox
		JCheckBox unpurgeShowCheckBox = new JCheckBox("Unpurge Show");
		unpurgeShowCheckBox.setBackground(new Color(243, 208, 12));
		unpurgeShowCheckBox.setBounds(835, 302, 97, 23);
		add(unpurgeShowCheckBox);

		//Edit the show text field
		editShowTitle = new JTextField("Title of show to edit");
		editShowTitle.setBounds(580, 239, 110, 20);
		add(editShowTitle);
		editShowTitle.setColumns(10);

		// Submit button
		JButton editShowButton = new JButton("Submit");
		editShowButton.setBackground(new Color(243, 208, 12));
		editShowButton.setBounds(580, 270, 110, 23);
		add(editShowButton);

		// Submit button v2
		JButton editBoxButton = new JButton("Submit");
		editBoxButton.setBackground(new Color(243, 208, 12));

		editBoxButton.setBounds(924, 360, 89, 23);
		add(editBoxButton);

		//Add, remove, or purge show label
		JLabel addRemoveLabel = new JLabel("Add/Remove/Unpurge Show:");
		addRemoveLabel.setForeground(new Color(253, 223, 11));
		addRemoveLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		addRemoveLabel.setBounds(776, 180, 214, 32);
		add(addRemoveLabel);

		// Text field for the show to be edited
		showToEdit = new JTextField();
		showToEdit.setBounds(519, 329, 240, 20);
		add(showToEdit);
		showToEdit.setColumns(10);

		// Edit show button
		editButton = new JButton("Edit Show");
		editButton.setBackground(new Color(243, 208, 12));
		editButton.setBounds(670, 360, 89, 23);
		add(editButton);
		
		// Scroll pane!
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 272, 418);
		add(scrollPane);
		
		// Populates text area with all shows
		JTextArea allShows = new JTextArea();
		scrollPane.setViewportView(allShows);
		allShows.setText(allData.toString());
		allShows.setEditable(false);

		// Instructions radio button
		JRadioButton instructionsRadio = new JRadioButton("See Instructions");
		instructionsRadio.setBackground(new Color(243, 208, 12));
		instructionsRadio.setBounds(315, 356, 134, 23);
		add(instructionsRadio);
		
		// Animation label
		JLabel animationLabel = new JLabel("Animation");
		animationLabel.setVisible(false);
		animationLabel.setIcon(new ImageIcon(PushCounterPanel.class.getResource("/Project2/CLIPLY_372109170_FREE_FIREWORKS_400.gif")));
		animationLabel.setBounds(437, -8, 443, 579);
		add(animationLabel);
		
		// Scrollpane v2!
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(315, 456, 617, 133);
		add(scrollPane_1);
		

		// String detailing the instructions on how to use this GUI application
		String instructions = "View Week Module: \n1. Enter week as yyyy-mm-dd. \n2. Hit 'Get Shows' button."
				+ "\n\nEdit Show Module: \n1. Enter show title in textfield (Case/whitespace-sensitive). Enter the correct week in the 'View Week Module'.\n2. Hit 'submit'. Show information will display in textbox below. \n"
				+ "3. Edit information as you please (Case/whitespace-sensitive). \n4. Hit 'Edit Show' button when finished."
				+ "\n\nAdd/Remove Show Module: \n1. Check the desired checkbox. \n2. If you want to add a show: enter correctly-formatted show. \n2. If you want to delete a show: "
				+ "enter show title (case/whitespace-sensitive). \n2. If you want to unpurge a show: enter show title (case/whitespace-sensitive). No need to include *."
				+ "\n3. Hit 'Submit' button.";
		// New text area
		JTextArea instructionsText = new JTextArea();
		scrollPane_1.setViewportView(instructionsText);		
		// The instruction text area populated by String instructions
		instructionsText.setText(instructions);
		// Instruction text area default visibility = false
		instructionsText.setVisible(false);
		instructionsText.setEditable(false);
		
		// Title label
		JLabel titleLabel = new JLabel("Enter Title:");
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleLabel.setBounds(580, 220, 109, 14);
		add(titleLabel);
		scrollPane_1.setVisible(false);

		// ACTION LISTENERS:
		// Get Shows button action listener
		getShowsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Arraylist for movies in a given week
				ArrayList<ShowWeek> moviesInWeek = allData.getOneWeek(dateOfMovie.getText());
				// If the movies exist
				if(moviesInWeek != null && moviesInWeek.size() > 0) {
					// Adds movies to string array
					String[] data = new String[moviesInWeek.size()];
					moviesLabel.setText("Shows in week " + dateOfMovie.getText());

					int index = 0;		
					// Iterates over movies in week and grabs titles
					for (ShowWeek sw : moviesInWeek) {
						if (allData.purgeCheck(sw.getShowTitle()) == false) {
							data[index] = sw.getShowTitle();
							index++;
						}
					}			
					movies.setModel(new DefaultComboBoxModel(data));

				}

			}
		});

		// Edit show button action listener
		editShowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Finds show with the given TITLE and DATE 
				editShowWeek = allData.find(editShowTitle.getText(), dateOfMovie.getText());
				// If show exists
				if (editShowWeek != null) {
					String found = editShowWeek.toString();
					// displays show
					showToEdit.setText(found);					
				}
				// If show could not be found, display dialog box & set text to say erorr
				else {
					JOptionPane.showMessageDialog(null, "Error: Could not find Movie Title (case-sensitive).", "ERROR", JOptionPane.ERROR_MESSAGE);

					showToEdit.setText("Error: Invalid Movie Title");
					}
			}

		});

		// Add, remove, purge show action listener
		editBoxButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Finds the show with given TITLE and DATE
				editShowWeek = allData.find(editShowTitle.getText(), dateOfMovie.getText());

				// Splits the show object into a string. Split the object by each COMMA, which denotes different variables of show.
				String[] splitShow = showToAddRemove.getText().split(",");
				// Creates new show
				ShowWeek show = new ShowWeek();

				// If the 'add show' checkbox is selected, set the variables of the show to the array. If anything was changed, the array will pick it up.
				// .trim() because including spaces screwed up the text file.
				if (addShowCheckBox.isSelected()) {
					show.setWeek(splitShow[0].trim());
					show.setCategory(splitShow[1].trim());
					show.setRank(splitShow[2].trim());
					show.setShowTitle(splitShow[3].trim());
					show.setSeasonTitle(splitShow[4].trim());
					show.setHrsViewed(splitShow[5].trim());
					show.setWeeksTop10(splitShow[6].trim());
					allData.addShowWeek(show);
					// Play the fireworks animation!
					animationLabel.setVisible(true);
				}
				// If the 'remove show' checkbox is selected, call PURGE
				if (removeShowCheckBox.isSelected()) {
					allData.purgeShow(showToAddRemove.getText());

				}
				// If 'unpurge show' is selected, unpurge show
				if(unpurgeShowCheckBox.isSelected()) {
					allData.unPurgeShow(showToAddRemove.getText());
				}
				allData.writeFile("./Project2/netflixAllWeeksGlobalProcessed.txt");
				allShows.setText(allData.toString());

			}
		});

		// Unpurge show action listener
		// Displays dialog box with instructions when 'unpurge show' checkbox is ticked
		unpurgeShowCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (unpurgeShowCheckBox.isSelected()) {
					JOptionPane.showMessageDialog(null, "Enter TITLE of show to unpurge.");
					allShows.setText(allData.toString());
					}
				}
			
		});
		
		// Action listener for 'add show' checkbox
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Get user-entered show from textfield
				editShowWeek = allData.find(editShowTitle.getText(), dateOfMovie.getText());
				// Split the user-entered show into string array, split by comma
				String[] splitShow = showToEdit.getText().split(",");

				// Set show based on array position
				editShowWeek.setWeek(splitShow[0].trim());
				editShowWeek.setCategory(splitShow[1].trim());
				editShowWeek.setRank(splitShow[2].trim());
				editShowWeek.setShowTitle(splitShow[3].trim());
				editShowWeek.setSeasonTitle(splitShow[4].trim());
				editShowWeek.setHrsViewed(splitShow[5].trim());
				editShowWeek.setWeeksTop10(splitShow[6].trim());
				// Display "Show edited!" in textfield if successful
				showToEdit.setText("Show edited!");
				// Write file
				allData.writeFile("./Project2/netflixAllWeeksGlobalProcessed.txt");
				allShows.setText(allData.toString());


			}
		});
		
		// Instruction radio box action listener
		instructionsRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If ticked, set visibility to true
				if (instructionsRadio.isSelected()) {
					instructionsText.setVisible(true);
					scrollPane_1.setVisible(true);
				}
				// If unticked, set visibility to false
				if (!instructionsRadio.isSelected()) {
					instructionsText.setVisible(false);
					scrollPane_1.setVisible(false);
				}
			}
		
		});
	}
}