import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class to handle file reading for the HammingDistanceCalculator
 * @author skylermoomey
 *
 */
public class FileHandler {

	private static final String FILE_NAME = "Mesonet.txt";
	private ArrayList<String> codesWithIdenticalAverages;
	private int [] amountOfStations;
	private String [] allCodes;
	
	/**
	 * FileHandler constructor, implicitly calls findSimilarStations
	 * @param comparator MesoStation to compare
	 * @throws IOException
	 */
	public FileHandler(MesoStation comparator) throws IOException 
	{
		codesWithIdenticalAverages = findSimilarStations(comparator);
		amountOfStations = findAllHammingDistances(comparator);
	}
	/**
	 * Reads through Mesonet.txt to find stations with identical ascii values to the parameter
	 * @param station a MesoStation object
	 * @return an ArrayList of all stations with identical ascii averages
	 */
	public static ArrayList<String> findSimilarStations(MesoStation station) throws IOException
	{
		ArrayList<String> codes = new ArrayList<>(50);
		
		BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
		
		int stationAverage = station.calAsciiAverage();
		
		String currentLine = br.readLine();
		
		while(currentLine != null)
		{
			MesoStation current = new MesoStation(currentLine);
			int currentAverage = current.calAsciiAverage();
			
			if(currentAverage == stationAverage)
			{
				codes.add(current.getStID());
			}
			
			currentLine = br.readLine();
		}
		br.close();
		return codes;
	}

	/**
	 * computes the hamming distances between the supplied MesoStation and all other stations in Mesonet.txt
	 * @param station The Station from which all distances are calculated
	 * @return an array containing the hammingDistances
	 * @throws IOException
	 */
	public int[] findAllHammingDistances(MesoStation station) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
		int [] distances = new int[5];
		
		String currentLine = br.readLine();
		
		while(currentLine != null)
		{
			int currentHammingDistance = station.calculateHammingDistance(new MesoStation(currentLine));
			
			switch(currentHammingDistance)
			{
			case 0:
				distances[0]++;
				break;
			case 1: 
				distances[1]++;
				break;
			case 2: 
				distances[2]++;
				break;
			case 3:
				distances[3]++;
				break;
			case 4:
				distances[4]++;
			default:
				break;
			}
			
			currentLine = br.readLine();
		}
		br.close();
		return distances;
	}
	
	/**
	 * generates a list of all Station IDs with hamming distance from the given station equal to that of the supplied integer
	 * @param station Station to calculate distance from
	 * @param distance distance desired
	 * @return an ArrayList
	 * @throws IOException
	 */
	public static ArrayList<String> findCodesWithHammingDistance(MesoStation station, int distance) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
		ArrayList<String> stationsWithSpecificDistance = new ArrayList<String>(100);
		
		String currentLine = br.readLine();
		
		while(currentLine != null)
		{
			int currentHammingDistance = station.calculateHammingDistance(new MesoStation(currentLine));
			if(currentHammingDistance == distance)
			{
				stationsWithSpecificDistance.add(currentLine);
			}
			
			currentLine = br.readLine();
		}
		br.close();
		return stationsWithSpecificDistance;
	}
	/**
	 * returns a copy of the ArrayList within the file handler
	 */
	public ArrayList<String> getSimilarStations()
	{
		ArrayList<String> allCodes = new ArrayList<>(50);
		allCodes.addAll(codesWithIdenticalAverages);
		
		return allCodes;
	}
	/**
	 * returns a copy of the array housing the amounts of hamming distances
	 * @return int array containing hamming distance values of 1, 2, 3, 4
	 */
	public int [] getAllHammingDistances()
	{
		return Arrays.copyOf(amountOfStations, amountOfStations.length);
	}
	
}
