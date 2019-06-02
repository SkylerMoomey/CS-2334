public abstract class MesoAbstract 
{
	protected MesoStation ID;//Instance data for MesoStation associated with MesoInherit
	protected int[] averageCeilingAndFloor;
	protected char averageChar;
	
	/**
	 * Default constructor
	 */
	public MesoAbstract()
	{
		this.ID = null;
	}
	
	/**
	 * normal constructor
	 * encapsulates MesoStation station by creating an identical copy with the instance data from station
	 */
	public MesoAbstract(MesoStation station)
	{
		String ID = station.getStID();
		this.ID = new MesoStation(ID);
	}
	//abstract method to be implemented by MesoInherit
	public abstract int[] calAverage();
	
	//second abstract method to be implemented by MesoInherit
	public abstract char letterAverage();
}