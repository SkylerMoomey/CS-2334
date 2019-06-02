public class MesoInherit extends MesoAbstract
{
	/**
	 * Constructor that calls super constructor in MesoAbstract
	 * @param station a MesoStation object reference
	 */
	public MesoInherit(MesoStation station)
	{
		super(station);
		this.averageCeilingAndFloor = this.calAverage();
		this.averageChar = this.letterAverage();
	}
	/**
	 * @return an int array containing the average, ceiling, and floor of four char ASCII values
	 */
	public int[] calAverage()
	{
		int [] averageValues = new int[3];
		
		String code = this.ID.getStID();
		char [] IndivLetters = code.toCharArray();
		
		double runningAverage = 0;
		
		
		for(char i: IndivLetters) // add ASCII value of each letter up and divide by four
		{
			runningAverage += i;
		}
		runningAverage = runningAverage / 4.0; //average 

		int ceilingInteger = (int)Math.ceil(runningAverage); //round up
		averageValues[0] = ceilingInteger; //add rounded integer to first index in array
		
		int floorInteger = (int)Math.floor(runningAverage); //truncate to round down
		averageValues[1] = floorInteger; //add rounded integer to second index in array
		
		int average = (int) Math.round(runningAverage); //adds .5 and truncates
		averageValues[2] = average; //adds average to final spot in array
		
		
		return averageValues;
	}
	
	/**
	 * @return a char that has the ASCII value of the average of four chars
	 */
	public char letterAverage()
	{
		char averageCharacter = (char)this.averageCeilingAndFloor[2];
		
		return averageCharacter;
	}
}