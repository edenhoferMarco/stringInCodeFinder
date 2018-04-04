package stringInCodeFinder;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JFrame {
	private JLabel filePathLabel = new JLabel();
	private JLabel codePathLabel = new JLabel();
	private JTextField filePath = new JTextField();
	private JTextField codePath = new JTextField();
	private JButton browseButton = new JButton("Browse...");
	private CodeFindManager codeFindMan = new CodeFindManager();
	
	public GUI() {
		setLayout(null);
		setTitle("Text in Code finder v0.1");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(480, 200);
		
		filePathLabel.setText("Select File with words");
		filePathLabel.setBounds(10, 10, 200, 20);
		add(filePathLabel);
		
		filePath.setBounds(10, 30, 300, 30);
		add(filePath);
		browseButton.setBounds(320, 30, 120, 30);
		browseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileDialog fd = new FileDialog(GUI.this, "Choose a file", FileDialog.LOAD);
				String directory;
				String file;
				
				fd.setDirectory(".");
				fd.setVisible(true);
				
				directory = fd.getDirectory();
				file = fd.getFile();
				if (!(directory == null || file == null)) {
					filePath.setText(directory + file);
				}
			}
		});
		add(browseButton);
		
		codePathLabel.setText("Code to check");
		codePathLabel.setBounds(10, 60, 200, 20);
		add(codePathLabel);
		
		codePath.setBounds(10, 80, 300, 30);
		add(codePath);
		
		browseButton = new JButton("Browse...");
		browseButton.setBounds(320, 80, 120, 30);
		browseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileDialog fd = new FileDialog(GUI.this, "Choose a file", FileDialog.LOAD);
				String directory;
				String file;
				
				fd.setDirectory(".");
				fd.setVisible(true);
				
				directory = fd.getDirectory();
				file = fd.getFile();
				if (!(directory == null || file == null)) {
					codePath.setText(directory + file);
				}
			}
		});
		add(browseButton);
		
		browseButton = new JButton("Start");
		browseButton.setBounds(320, 130, 120, 30);
		browseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				codeFindMan.setWorkingFilesPaths(filePath.getText(), codePath.getText());
				codeFindMan.run();
				
			}
			
		});
		add(browseButton);
		
		setVisible(true);
	}
	
	public String getPathToCodeFile() {
		return codePath.getText();
	}
}
