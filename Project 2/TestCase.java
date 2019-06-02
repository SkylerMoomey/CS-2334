import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TestCase {

	@Test
	void constructorTest() {
		MesoInherit station = new MesoInherit(new MesoStation("ABCD"));
		
		int actualCeiling = station.calAverage()[0];
		int actualFloor = station.calAverage()[1];
		int actualAverage = station.calAverage()[2];
		char averageLetter = station.letterAverage();
		
		Assert.assertEquals((int)'C', actualCeiling); //test first index for calculate average
		Assert.assertEquals((int)'B', actualFloor); //second
		Assert.assertEquals((int)'C', actualAverage); //third
		Assert.assertEquals('C', averageLetter); //test for letter average
	}

}
