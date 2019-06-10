import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * Class for a JPanel child whose purpose is to organize information about ASCII averages in Mesonet.txt
 * @author skylermoomey
 *
 */
public class AsciiAveragePanel extends JPanel
{
	protected final int PANEL_WIDTH = MainFrame.FRAME_WIDTH / 2; //only take up half the frame
	protected final int PANEL_HEIGHT = MainFrame.FRAME_HEIGHT;
	
	protected GridBagConstraints c = new GridBagConstraints();
	protected JTextField codeField = new JTextField("CODE");
	protected JTextArea codeList = new JTextArea();
	protected JScrollPane scroller = new JScrollPane(codeList);
	protected JButton calculate = new JButton("Find Equal Ascii Averages");
	protected JLabel enterCode = new JLabel("Enter Code: ");
	
	/**
	 * Constructor for a panel responsible for holding UI for an Ascii Average calculator
	 */
	public AsciiAveragePanel()
	{
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setLayout(new GridBagLayout());
		
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weighty = 0.1;
		c.weightx = 0.1;
		
		c.insets = new Insets(100, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		this.add(enterCode, c);
		
		c.gridx = 1;
		c.ipadx = 50;
		this.add(codeField, c);
		
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 200;
		c.ipadx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(scroller, c);
		
		c.gridy = 2;
		c.ipady = 0;
		c.fill = GridBagConstraints.NONE;
		calculate.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try
					{
					MesoStation station = new MesoStation(codeField.getText());
					ArrayList<String> similarCodes = FileHandler.findSimilarStations(station);
					
					for(String code: similarCodes)
					{
						codeList.append(code + "\n");
					}
					}
					catch(IOException e1)
					{
						e1.getMessage();
					}
				}
			}
		);
		this.add(calculate, c);
		
	}
}
