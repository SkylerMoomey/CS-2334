
public class MesoAscii extends MesoAsciiAbstract{

	
	private String StID;
	
	/**
	 * MesoAscii constructor, takes a MesoStation object and uses its station ID value
	 * @param station MesoStation object
	 */
	public MesoAscii(MesoStation station)
	{
		StID = station.getStID();
	}
	
	/**
	 * Method that calculates the ASCII average value of the Station ID characters
	 */
	public int calAverage()
	{
		double runningAverage = 0;
		
		char [] indivLetters = this.StID.toCharArray();
		
		for(char i: indivLetters) // add ASCII value of each letter up and divide by four
		{
			runningAverage += (int)i;
		}
		runningAverage = runningAverage / 4.0;
		
		int avg = (int)Math.round(runningAverage); //round and cast runningAverage to int and return
		
		return avg;
	}
}
