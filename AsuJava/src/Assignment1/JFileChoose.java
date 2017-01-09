package Assignment1;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JFileChoose extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextArea outputArea;
	private final JScrollPane scrollPane;
	public File fileName = null;
	
	//GUI
	public JFileChoose() {
		super("Testing Class File");
		outputArea = new JTextArea();
		
		//Add output area to scrollPane
		scrollPane = new JScrollPane(outputArea);
		
		//add scrollPane to GUI
		add(scrollPane, BorderLayout.CENTER); 
		setSize(400, 400);	//GUI size
		setVisible(true); //display GUI
		analyzePath(); //create and analyze File object
	}
	
	public void set (File filenametemp) {
		fileName = filenametemp;
	}
	
	public File get() {
		return this.fileName;
	}
	
	//Allow user to specify file or directory name
	
	public void getFileOrDirectory() {
		/**
		 * Class JFileChooser displays a dialog that enables the user to easily
		 * select files or directories.
		 */
		JFileChooser fileChooser = new JFileChooser();
		
		/**
		 * Indicate that files and directories can be chosen. Other static
		 * constants include FILES_ONLY (default) and DIRECTORIES_ONLY.
		 */
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		/**
		 * Display the JFileChooser dialog
		 * 
		 * Argument this specifies the JFileDialog's parent window, which
		 * determines the position of the dialog on the screen. If null is
		 * passed, the dialog is displayed in the center of the screen.
		 * 
		 * A JFileChooser dialog is a model dialog that does not allow the user
		 * to interact with any other window until the user closes the
		 * JFileChooser by clicking the Open or Close buttons.
		 */
		int result = fileChooser.showOpenDialog(null);
		
		//if User clicked Cancel button on dialog, return
		if (result == JFileChooser.APPROVE_OPTION) {
			fileName = fileChooser.getSelectedFile();
			
			//Display error if invalid
			if ((fileName == null) || (fileName.equals(""))) {
				JOptionPane.showMessageDialog(this, "Invalid Name",
						"Invalid Name", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		}
		
		set(fileName);
		setVisible(false);
		
		/**
		 * Retrieve the file object.
		 */
	}
	
	//display information about file or directory user specifies.
	public void analyzePath() {
		//create File object based on User input
		getFileOrDirectory();
		File name = get();
		
		//if name exists output the information about it
		if (name.exists()) {
			outputArea.setText(String.format(
					"%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n",
					name.getName(), " exists",
					(name.isFile()) ? "Is a file." : "Is not a file.",
					(name.isDirectory()) ? "is a directory."
					: "is not a directory.",
					(name.isAbsolute()) ? "is absolute patch." :
					"is not an absolute patch.",
					"Length: ", name.length(),
					"Path: ", name.getPath(), "Absolute path: ", 
					name.getAbsolutePath(), "Parent: ", name.getParent()));
			
			//output directory listing
			if (name.isDirectory()) {
				String[] directory = name.list();
				outputArea.append("\n\nDirectory contents: \n");
				
				for (String directoryName : directory) {
					outputArea.append(directoryName + "\n");
				}
			}
		} else {
			//not a file or directory, output error message.
			JOptionPane.showMessageDialog(this, name + 
					" does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
