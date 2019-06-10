import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * Main window for the calculator
 * @author skylermoomey
 *
 */
public class MainFrame extends JFrame{

	protected static final int FRAME_WIDTH = 700;
	protected static final int FRAME_HEIGHT = 700;
	protected HammingDistanceCalculatorPanel hdPanel;
	protected AsciiAveragePanel aaPanel;
	
	/**
	 * Constructor for the JFrame of the Hamming calculator
	 * @param title title of the window
	 */
	public MainFrame(String title)
	{
		super(title);
		
		hdPanel = new HammingDistanceCalculatorPanel();
		aaPanel = new AsciiAveragePanel();
		
		this.add(hdPanel);
		this.add(aaPanel);
		
		
		this.setLayout(new GridLayout(0, 2));
		
		
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String [] args)
	{
		
		MainFrame myFrame = new MainFrame("Hamming Distance Calculator");
	}
}
