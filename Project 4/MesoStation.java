
/**
 * Class that holds information on a MesoStation
 * @author skylermoomey
 *
 */
public class MesoStation {

	private String ID;
	
	public MesoStation(String stID)
	{
		ID = stID;
	}
	
	/**
	 * calculates the Ascii average of the station's ID
	 * @return the Ascii average of the station's ID round to nearest Integer
	 */
	public int calAsciiAverage()
	{
		char [] iDArray = this.ID.toCharArray();
		
		double sum = 0;
		for(char c: iDArray)
		{
			
			sum += (int)c;
		}
		
		return (int)Math.round(sum / 4);
	}
	
	/**
	 * computes the hammingDistance between this. and a supplied MesoStation object
	 */
	public int calculateHammingDistance(MesoStation station)
	{
		char [] thisID = this.ID.toCharArray();
		char [] currentFileLine = station.getStID().toCharArray();
		int hammingDistance = 0;
		
		for(int i = 0; i < thisID.length; ++i)
		{
			if(thisID[i] != currentFileLine[i])
			{
				++hammingDistance;
			}
		}
		return hammingDistance;
	}
	/**
	 * method to get StID
	 * @return String station id
	 */
	public String getStID()
	{
		return this.ID;
	}
}
