package fraction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionTest {

	double delta;

	@BeforeEach
	public void setUp() {
		this.delta = 0.000001;
	}

	@Test
	void testFraction() {
		
//		String[] strings = String[2];
//		boolean[] b = new boolean[2];
		
		Fraction fraction = new Fraction(4, 16);
		assertEquals(4, fraction.numerator);
		assertEquals(16, fraction.denominator);
		
		fraction = new Fraction(4, -16);
		assertEquals(-4, fraction.numerator);
		assertEquals(16, fraction.denominator);
		
		//new
		fraction = new Fraction(-1, -2);
		assertEquals(1, fraction.numerator);
		assertEquals(2, fraction.denominator);		
		
		fraction = new Fraction(-1, -1);
		assertEquals(1, fraction.numerator);
		assertEquals(1, fraction.denominator);		
	}

	@Test
	void testReduceToLowestForm() {
		
		Fraction fraction = new Fraction(4, 16);
		fraction.reduceToLowestForm();
		
		assertEquals(1, fraction.numerator);
		assertEquals(4, fraction.denominator);
		
		fraction = new Fraction(0, 4);
		fraction.reduceToLowestForm();
		
		assertEquals(0, fraction.numerator);
		assertEquals(1, fraction.denominator);
		
		//new
		fraction = new Fraction(10, -15);
		fraction.reduceToLowestForm();
		
		assertEquals(-2, fraction.numerator);
		assertEquals(3, fraction.denominator);
		
		fraction = new Fraction(-10, 15);
		fraction.reduceToLowestForm();
		
		assertEquals(-2, fraction.numerator);
		assertEquals(3, fraction.denominator);
		
		fraction = new Fraction(-10, -15);
		fraction.reduceToLowestForm();
		
		assertEquals(2, fraction.numerator);
		assertEquals(3, fraction.denominator);
		
	}
	
	@Test
	void testAdd() {
		Fraction fraction1 = new Fraction(4, 16);
		Fraction fraction2 = new Fraction(5, 16);
		Fraction newFraction = fraction1.add(fraction2);
		assertEquals(9, newFraction.numerator);
		assertEquals(16, newFraction.denominator);
		assertNotSame(newFraction, fraction1);
		assertNotSame(newFraction, fraction2);
		
		fraction1 = new Fraction(3, 7);
		fraction2 = new Fraction(2, 7);
		newFraction = fraction1.add(fraction2);
		assertEquals(5, newFraction.numerator);
		assertEquals(7, newFraction.denominator);
		assertNotSame(newFraction, fraction1);
		assertNotSame(newFraction, fraction2);
		
		fraction1 = new Fraction(3, 5);
		fraction2 = new Fraction(1, 4);
		newFraction = fraction1.add(fraction2);
		assertEquals(17, newFraction.numerator);
		assertEquals(20, newFraction.denominator);
		assertNotSame(newFraction, fraction1);
		assertNotSame(newFraction, fraction2);
		
		fraction1 = new Fraction(1, 2);
		fraction2 = new Fraction(2, 3);
		Fraction fraction3 = fraction1.add(fraction2);
		assertEquals(7, fraction3.numerator);
		assertEquals(6, fraction3.denominator);
		
		Fraction fraction4 = new Fraction(5, 4);
		Fraction fraction5 = fraction3.add(fraction4);
		assertEquals(29, fraction5.numerator);
		assertEquals(12, fraction5.denominator);
		assertNotSame(fraction3, fraction4);

		//new
		fraction1 = new Fraction(-1, 2);
		fraction2 = new Fraction(2, 3);
		newFraction = fraction1.add(fraction2);
		assertEquals(1, newFraction.numerator);
		assertEquals(6, newFraction.denominator);
		
		fraction1 = new Fraction(-1, 2);
		fraction2 = new Fraction(2, -3);
		newFraction = fraction1.add(fraction2);
		assertEquals(-7, newFraction.numerator);
		assertEquals(6, newFraction.denominator);
		
		fraction1 = new Fraction(0, 2);
		fraction2 = new Fraction(2, 3);
		newFraction = fraction1.add(fraction2);
		assertEquals(2, newFraction.numerator);
		assertEquals(3, newFraction.denominator);
		
		fraction1 = new Fraction(1, 5);
		fraction2 = new Fraction(9, 10);
		newFraction = fraction1.add(fraction2);
		System.out.println(newFraction);
				
	}

	@Test
	void testSubtract() {
		
		Fraction fraction1 = new Fraction(4, 16);
		Fraction fraction2 = new Fraction(5, 16);
		Fraction newFraction = fraction1.subtract(fraction2);
		assertEquals(-1, newFraction.numerator);
		assertEquals(16, newFraction.denominator);
		
		fraction1 = new Fraction(5, 9);
		fraction2 = new Fraction(3, 9);
		newFraction = fraction1.subtract(fraction2);
		assertEquals(2, newFraction.numerator);
		assertEquals(9, newFraction.denominator);
		
		//new
		fraction1 = new Fraction(3, 5);
		fraction2 = new Fraction(1, 4);
		newFraction = fraction1.subtract(fraction2);
		assertEquals(7, newFraction.numerator);
		assertEquals(20, newFraction.denominator);		
		
		fraction1 = new Fraction(1, 2);
		fraction2 = new Fraction(2, 3);
		newFraction = fraction1.subtract(fraction2);
		assertEquals(-1, newFraction.numerator);
		assertEquals(6, newFraction.denominator);	
		
		fraction1 = new Fraction(-1, 2);
		fraction2 = new Fraction(2, 3);
		newFraction = fraction1.subtract(fraction2);
		assertEquals(-7, newFraction.numerator);
		assertEquals(6, newFraction.denominator);
		
		fraction1 = new Fraction(-1, 2);
		fraction2 = new Fraction(2, -3);
		newFraction = fraction1.subtract(fraction2);
		assertEquals(1, newFraction.numerator);
		assertEquals(6, newFraction.denominator);
		
		fraction1 = new Fraction(0, 2);
		fraction2 = new Fraction(2, 3);
		newFraction = fraction1.subtract(fraction2);
		assertEquals(-2, newFraction.numerator);
		assertEquals(3, newFraction.denominator);
		
	}

	@Test
	void testMul() {
		
		Fraction fraction1 = new Fraction(4, 16);
		Fraction fraction2 = new Fraction(5, 16);
		Fraction newFraction = fraction1.mul(fraction2);
		assertEquals(5, newFraction.numerator);
		assertEquals(64, newFraction.denominator);
		
		fraction1 = new Fraction(5, 9);
		fraction2 = new Fraction(3, 9);
		newFraction = fraction1.mul(fraction2);
		assertEquals(5, newFraction.numerator);
		assertEquals(27, newFraction.denominator);
		
		//new
		fraction1 = new Fraction(3, 5);
		fraction2 = new Fraction(1, 4);
		newFraction = fraction1.mul(fraction2);
		assertEquals(3, newFraction.numerator);
		assertEquals(20, newFraction.denominator);		
		
		fraction1 = new Fraction(1, 2);
		fraction2 = new Fraction(2, 3);
		Fraction fraction3 = fraction1.mul(fraction2);
		assertEquals(1, fraction3.numerator);
		assertEquals(3, fraction3.denominator);		
		
		Fraction fraction4 = new Fraction(5, 4);
		Fraction fraction5 = fraction3.mul(fraction4);
		assertEquals(5, fraction5.numerator);
		assertEquals(12, fraction5.denominator);		
		assertNotSame(fraction3, fraction5);
		assertNotSame(fraction4, fraction5);
		
	}

	@Test
	void testDiv() {
		Fraction fraction1 = new Fraction(4, 16);
		Fraction fraction2 = new Fraction(5, 16);
		Fraction newFraction = fraction1.div(fraction2);
		assertEquals(4, newFraction.numerator);
		assertEquals(5, newFraction.denominator);
		
		fraction1 = new Fraction(5, 9);
		fraction2 = new Fraction(3, 9);
		newFraction = fraction1.div(fraction2);
		assertEquals(5, newFraction.numerator);
		assertEquals(3, newFraction.denominator);
		
		//new
		fraction1 = new Fraction(3, 5);
		fraction2 = new Fraction(1, 4);
		newFraction = fraction1.div(fraction2);
		assertEquals(12, newFraction.numerator);
		assertEquals(5, newFraction.denominator);		
		
		fraction1 = new Fraction(1, 2);
		fraction2 = new Fraction(2, 3);
		newFraction = fraction1.div(fraction2);
		assertEquals(3, newFraction.numerator);
		assertEquals(4, newFraction.denominator);			
		
		fraction1 = new Fraction(-1, 2);
		fraction2 = new Fraction(2, 3);
		newFraction = fraction1.div(fraction2);
		assertEquals(-3, newFraction.numerator);
		assertEquals(4, newFraction.denominator);			
		
		fraction1 = new Fraction(-1, 2);
		fraction2 = new Fraction(2, -3);
		newFraction = fraction1.div(fraction2);
		assertEquals(3, newFraction.numerator);
		assertEquals(4, newFraction.denominator);	
		
		fraction1 = new Fraction(0, 2);
		fraction2 = new Fraction(2, 3);
		newFraction = fraction1.div(fraction2);
		assertEquals(0, newFraction.numerator);
		assertEquals(1, newFraction.denominator);	
		
	}

	@Test
	void testDecimal() {
		Fraction fraction1 = new Fraction(4, 16);
		double dec = fraction1.decimal();
		assertEquals(.25, dec, this.delta);
		
		fraction1 = new Fraction(5, 16);
		dec = fraction1.decimal();
		assertEquals(.3125, dec, this.delta);
		
		//new
		fraction1 = new Fraction(1, 3);
		dec = fraction1.decimal();
		assertEquals(.333333, dec, this.delta);
		
		fraction1 = new Fraction(5, 9);
		dec = fraction1.decimal();
		assertEquals(.555555555, dec, this.delta);		
				
		fraction1 = new Fraction(1, 2);
		dec = fraction1.decimal();
		assertEquals(.50000, dec, this.delta);
		
		fraction1 = new Fraction(5, 4);
		dec = fraction1.decimal();
		assertEquals(1.25, dec, this.delta);
		
		fraction1 = new Fraction(-1, 2);
		dec = fraction1.decimal();
		assertEquals(-.5, dec, this.delta);	
		
		fraction1 = new Fraction(2, -3);
		dec = fraction1.decimal();
		assertEquals(-.666666, dec, this.delta);
		
		fraction1 = new Fraction(0, 2);
		dec = fraction1.decimal();
		assertEquals(0.0, dec, this.delta);
		
		fraction1 = new Fraction(0, -4);
		dec = fraction1.decimal();
		assertEquals(0.0, dec, this.delta);
		
	}

	@Test
	void testSqr() {
		Fraction fraction1 = new Fraction(2, 3);
		fraction1.sqr();
		assertEquals(4, fraction1.numerator);
		assertEquals(9, fraction1.denominator);
		
		fraction1 = new Fraction(4, 16);
		fraction1.sqr();
		assertEquals(1, fraction1.numerator);
		assertEquals(16, fraction1.denominator);
		
		//new
		fraction1 = new Fraction(5, 16);
		fraction1.sqr();
		assertEquals(25, fraction1.numerator);
		assertEquals(256, fraction1.denominator);
		
		fraction1 = new Fraction(1, 2);
		fraction1.sqr();
		assertEquals(1, fraction1.numerator);
		assertEquals(4, fraction1.denominator);		
		
		fraction1 = new Fraction(-1, 2);
		fraction1.sqr();
		assertEquals(1, fraction1.numerator);
		assertEquals(4, fraction1.denominator);		
			
		fraction1 = new Fraction(2, -3);
		fraction1.sqr();
		assertEquals(4, fraction1.numerator);
		assertEquals(9, fraction1.denominator);		
		
		fraction1 = new Fraction(0, 2);
		fraction1.sqr();
		assertEquals(0, fraction1.numerator);
		assertEquals(1, fraction1.denominator);		
		
	}

	@Test
	void testEquals() {
		Fraction fraction1 = new Fraction(2, 3);
		Fraction fraction2 = new Fraction(2, 3);
		assertEquals(fraction1, fraction2);
		
		fraction1 = new Fraction(4, 16);
		fraction2 = new Fraction(1, 4);
		assertEquals(fraction1, fraction2);
		
		//confirm the fractions were not (permanently) reduced to lowest form
		assertEquals(4, fraction1.numerator);
		assertEquals(16, fraction1.denominator);
		assertEquals(1, fraction2.numerator);
		assertEquals(4, fraction2.denominator);
		
		//new
		fraction1 = new Fraction(1, -2);
		fraction2 = new Fraction(-1, 2);
		assertEquals(fraction1, fraction2);
		
		fraction1 = new Fraction(-7, 2);
		fraction2 = new Fraction(14, -4);
		assertEquals(fraction1, fraction2);	
		
		fraction1 = new Fraction(-16, 20);
		fraction2 = new Fraction(-4, 5);
		assertEquals(fraction1, fraction2);
		
		assertEquals(-16, fraction1.numerator);
		assertEquals(20, fraction1.denominator);
		assertEquals(-4, fraction2.numerator);
		assertEquals(5, fraction2.denominator);
		
	}
	
	@Test
	void testToString() {
		Fraction fraction1 = new Fraction(2, 3);
		String str = fraction1.toString();
		assertEquals("2/3", str);
		
		//new
		fraction1 = new Fraction(2, -3);
		str = fraction1.toString();
		assertEquals("-2/3", str);
		
		fraction1 = new Fraction(-1, 2);
		str = fraction1.toString();
		assertEquals("-1/2", str);		
		
		fraction1 = new Fraction(-2, -8);
		str = fraction1.toString();
		assertEquals("2/8", str);
		
		fraction1 = new Fraction(0, -3);
		str = fraction1.toString();
		assertEquals("0/3", str);
		fraction1.reduceToLowestForm();
		str = fraction1.toString();
		assertEquals("0/1", str);
	}

	@Test
	void testAverageFraction() {
		Fraction fraction1 = new Fraction(1, 2);
		Fraction otherFraction = new Fraction(3, 4);
		Fraction avgFraction = fraction1.average(otherFraction);
		
		assertEquals(5, avgFraction.numerator);
		assertEquals(8, avgFraction.denominator);
		
		fraction1 = new Fraction(3, 4);
		otherFraction = new Fraction(1, 2);
		avgFraction = fraction1.average(otherFraction);
		
		assertEquals(5, avgFraction.numerator);
		assertEquals(8, avgFraction.denominator);
		
		fraction1 = new Fraction(5, 8);
		otherFraction = new Fraction(-12, 16);
		avgFraction = fraction1.average(otherFraction);
		
		assertEquals(-1, avgFraction.numerator);
		assertEquals(16, avgFraction.denominator);
		
		fraction1 = new Fraction(5, 8);
		otherFraction = new Fraction(-12, -16);
		avgFraction = fraction1.average(otherFraction);
		
		assertEquals(11, avgFraction.numerator);
		assertEquals(16, avgFraction.denominator);
		
	}

	@Test
	void testAverageFractionArray() {

		Fraction fraction1 = new Fraction(3, 4);
		Fraction fraction2 = new Fraction(3, 5);
		Fraction fraction3 = new Fraction(3, 6);
		
		Fraction[] fractions = new Fraction[] {fraction1, fraction2, fraction3};
		Fraction avgFraction = Fraction.average(fractions);
		
		assertEquals(37, avgFraction.numerator);
		assertEquals(60, avgFraction.denominator);
		
		//new
		fraction1 = new Fraction(0, 1);
		fraction2 = new Fraction(1, 1);
		fraction3 = new Fraction(-3, -6);
		Fraction fraction4 = new Fraction(333, -9);
		
		fractions = new Fraction[] {fraction1, fraction2, fraction3, fraction4};
		avgFraction = Fraction.average(fractions);
		
		assertEquals(-71, avgFraction.numerator);
		assertEquals(8, avgFraction.denominator);
		
		fraction1 = new Fraction(5, 16);
		fractions = new Fraction[] {fraction1};
		avgFraction = Fraction.average(fractions);
		
		assertEquals(5, avgFraction.numerator);
		assertEquals(16, avgFraction.denominator);
		
		fractions = new Fraction[] {};
		avgFraction = Fraction.average(fractions);
		assertEquals(0, avgFraction.numerator);
		assertEquals(1, avgFraction.denominator);
				
	}

	@Test
	void testAverageIntArray() {

		int[] ints = new int[] {1, 2, 3, 4};
		Fraction avgFraction = Fraction.average(ints);
		
		assertEquals(5, avgFraction.numerator);
		assertEquals(2, avgFraction.denominator);
		
		//new
		ints = new int[] {1, 2, 3, 4, 500, -1, 12};
		avgFraction = Fraction.average(ints);
		
		assertEquals(521, avgFraction.numerator);
		assertEquals(7, avgFraction.denominator);
		
		ints = new int[] {};
		avgFraction = Fraction.average(ints);
		
		assertEquals(0, avgFraction.numerator);
		assertEquals(1, avgFraction.denominator);
		
		ints = new int[] {1, 2, 3, 4, -500, -1, -12};
		avgFraction = Fraction.average(ints);
		
		assertEquals(-503, avgFraction.numerator);
		assertEquals(7, avgFraction.denominator);
		
	}

}
