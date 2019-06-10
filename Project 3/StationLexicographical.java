import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
public class StationLexicographical extends MesoSortedAbstract{

	private Map<String, Integer> sortedStations;
	
	
	/**
	 * Constructor for StationLexicographical object, contains a Map of sorted Station IDs from an unsorted HashMap
	 * @param unsortedStations
	 */
	public StationLexicographical(HashMap<String, Integer> unsortedStations)
	{
		sortedStations = sortedMap(unsortedStations);
		
		for (String stid : sortedStations.keySet()) 
		{
		    System.out.println(stid + " " + sortedStations.get(stid));		    
		}
	}
	
	
	/**
	 * sorts a given HashMap lexicographically and returns it in the form of a Map
	 * @return a sorted Map of String keys, Integer values
	 */
	public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted)
	{
		/**
		 * TreeMaps are sorted Maps that sort Map values by the natural ordering of their keys,
		 * by putting all of the unsorted values in a TreeMap, they become sorted, and then we can just
		 * cast to a normal map and return.
		 */
		TreeMap<String, Integer> sorted = new TreeMap<>();
		
		sorted.putAll(unsorted);
		
		return (Map<String, Integer>)sorted;
	}
}
