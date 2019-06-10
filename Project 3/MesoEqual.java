import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class MesoEqual {

	private String StID;
	
	/**
	 * MesoEqual constructor, takes MesoStation as parameter to calculate Station ID
	 * @param station MesoStation object
	 */
	public MesoEqual(String StID)
	{
		this.StID = StID;
	}
	
	/**
	 * method to read through Mesonet.txt and add stations that are equal to StID to a HashMap
	 * @return a HashMap containing Integers that are equal to the Ascii average of this.StID
	 */
	public HashMap<String, Integer> calAsciiEqual() throws IOException
	{
		HashMap<String, Integer> stationsAreEqual = new HashMap<>();
		MesoAscii equals = new MesoAscii(new MesoStation(this.StID)); //MesoAscii with STID from this.StID
		int equalsAverage = equals.calAverage();
		BufferedReader reader = new BufferedReader(new FileReader("Mesonet.txt"));
		
		reader.readLine();
		reader.readLine();
		reader.readLine();
		reader.readLine();
		// read in first four lines of junk
		String currentLine = reader.readLine();
		
		while(currentLine != null)
		{
		
		/*
		 * turns currentLine into a char array and then adds only the 1st through 5th elements to a String object
		 * in order to create a MesoStation object from the station ID gathered
		 */
		char [] thisLine = currentLine.toCharArray();
		String StIDFromFile = "";
		
		for(int i = 2; i < 6; ++i)
		{
			StIDFromFile += thisLine[i];
		}
		
		MesoAscii currentStation = new MesoAscii(new MesoStation(StIDFromFile));
		
		int currentStationAvg = currentStation.calAverage(); //average of the currentLine StID
		
		if(currentStationAvg == equalsAverage)
		{
			stationsAreEqual.put(StIDFromFile, currentStationAvg);
		}
		
		currentLine = reader.readLine(); //Sentinel controlled loop update
		
		}
		reader.close();
		return stationsAreEqual;
	}
}
