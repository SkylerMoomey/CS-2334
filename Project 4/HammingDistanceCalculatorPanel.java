import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Class representing the actual Calculator of the HammingDistance calculator, includes all buttons
 * and labels necessary for the HammingDistance calculator, and is organized using a GridBagLayout
 * @author skylermoomey
 *
 */
public class HammingDistanceCalculatorPanel extends JPanel{
	
	protected final int PANEL_WIDTH = MainFrame.FRAME_WIDTH / 2; //only take up half the frame
	protected final int PANEL_HEIGHT = MainFrame.FRAME_HEIGHT;
	
	protected GridBagConstraints c = new GridBagConstraints();
	
	protected JButton showStation = new JButton("Show Station");
	protected JButton calculateHD = new JButton("Calculate HD");
	protected JButton addStation = new JButton("Add Station");
	
	protected JSlider zeroThroughFour = new JSlider(JSlider.HORIZONTAL, 1, 4, 1);
	
	protected JComboBox<String> codes = new JComboBox<>();
	
	protected JLabel enterHD = new JLabel("Enter Hamming Distance: ");
	protected JLabel distance0 = new JLabel("Distance 0");
	protected JLabel distance1 = new JLabel("Distance 1");
	protected JLabel distance2 = new JLabel("Distance 2");
	protected JLabel distance3 = new JLabel("Distance 3");
	protected JLabel distance4 = new JLabel("Distance 4");
	protected JLabel compareWith = new JLabel("Compare with: ");
	
	protected JTextField hammingDistanceInput = new JTextField("1");
	protected JTextField zeroDistances = new JTextField("0");
	protected JTextField oneDistances = new JTextField("0");
	protected JTextField twoDistances = new JTextField("0");
	protected JTextField threeDistances = new JTextField("0");
	protected JTextField fourDistances = new JTextField("0");
	protected JTextField stationInput = new JTextField("STID");
	
	protected JTextArea codeList = new JTextArea();
	protected JScrollPane scroller = new JScrollPane(codeList);
	
	private TreeSet<String> stationCodesInDropDown = new TreeSet<>();
	
	/**
	 * Constructor for a ComponentsPanel containing three JButtons, one JComboBox, one JSlider,  
	 * seven JLabels, one JTextArea, and seven JTextFields
	 * Uses a GridBagLayout to structure the panel's contents
	 */
	public HammingDistanceCalculatorPanel()
	{
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setLayout(new GridBagLayout());
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weighty = 0.1;
		c.weightx = 0.1;
		
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 100;
		this.add(enterHD, c);
		
		c.gridx = 1;
		c.ipadx = 50;
		this.add(hammingDistanceInput, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.ipadx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		zeroThroughFour.setMajorTickSpacing(1);
		zeroThroughFour.setPaintTicks(true);
		zeroThroughFour.setPaintLabels(true);
		zeroThroughFour.addChangeListener(new ChangeListener() {
		
			public void stateChanged(ChangeEvent e)
			{
				JSlider slider = (JSlider)e.getSource();
				hammingDistanceInput.setText("" + slider.getValue());
			}
		}
		);
		this.add(zeroThroughFour, c);
		
		c.gridy = 2;
		c.fill = GridBagConstraints.NONE;
		showStation.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				codeList.setText("");
				try
				{
					int hammingDistance = zeroThroughFour.getValue();
					MesoStation station = new MesoStation((String)codes.getSelectedItem());
					ArrayList<String> stationIDs = FileHandler.findCodesWithHammingDistance(station, hammingDistance);
					
					for(String ID: stationIDs)
					{
						codeList.append(ID + "\n");
					}
				}
				catch(IOException e1)
				{
					e1.getMessage();
				}
			}
		});
			
		this.add(showStation, c);
		
		c.gridy = 3;
		c.ipady = 150;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(scroller, c);
		
		c.gridy = 4;
		c.ipady = 0;
		c.ipadx = 0;
		c.fill = GridBagConstraints.NONE;
		this.add(compareWith, c);
		
		c.gridx = 1;
		c.ipadx = 100;
		this.add(codes, c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.ipadx = 0;
		calculateHD.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					FileHandler handler = new FileHandler(new MesoStation((String)codes.getSelectedItem()));
					int [] distances = handler.getAllHammingDistances();
					
					zeroDistances.setText("" +distances[0]);
					oneDistances.setText("" + distances[1]);
					twoDistances.setText("" + distances[2]);
					threeDistances.setText("" + distances[3]);
					fourDistances.setText("" + distances[4]);
					
				} catch (IOException e1) {
					e1.getMessage();
				}
			}
		});
		this.add(calculateHD, c);
		
		c.gridy = 6;
		this.add(distance0, c);
		c.gridx = 1;
		c.ipadx = 100;
		this.add(zeroDistances, c);
		
		c.gridx = 0;
		c.gridy = 7;
		c.ipadx = 0;
		this.add(distance1, c);
		c.gridx = 1;
		c.ipadx = 100;
		this.add(oneDistances, c);
		
		c.gridx = 0;
		c.gridy = 8;
		c.ipadx = 0;
		this.add(distance2, c);
		
		c.gridx = 1;
		c.ipadx = 100;
		this.add(twoDistances, c);
		
		c.gridx = 0;
		c.gridy = 9;
		c.ipadx = 0;
		this.add(distance3, c);
		
		c.gridx = 1;
		c.ipadx = 100;
		this.add(threeDistances, c);
		
		c.gridx = 0;
		c.gridy = 10;
		c.ipadx = 0;
		this.add(distance4, c);
		
		c.gridx = 1;
		c.ipadx = 100;
		this.add(fourDistances, c);
		
		c.gridx = 0;
		c.gridy = 11;
		c.ipadx = 0;
		addStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				codes.removeAllItems();
				stationCodesInDropDown.add(stationInput.getText());
				
				Iterator<String> iterator = stationCodesInDropDown.iterator();
				
				while(iterator.hasNext())
				{
					codes.addItem(iterator.next());
				}
			}
		});
		this.add(addStation, c);
		
		c.gridx = 1;
		c.ipadx = 100;
		this.add(stationInput, c);

	}
}
