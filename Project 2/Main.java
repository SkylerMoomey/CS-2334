import java.io.IOException;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		String StID = "ABCD";
		MesoInherit mesoinherit = new MesoInherit(new MesoStation(StID));
		
		System.out.println("Ascii Ceiling is: " + mesoinherit.calAverage()[0]
			+ ", Ascii Floor is: " + mesoinherit.calAverage()[1]
				+ ", Ascii Average is: " + mesoinherit.calAverage()[2]
					+ ", and Letter Avg is: " + mesoinherit.letterAverage());
	}
}