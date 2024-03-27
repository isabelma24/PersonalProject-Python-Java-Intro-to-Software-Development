package fraction;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a fraction with methods allowing for operations on 
 * and with the fraction, and it's numerator and denominator.
 * @author Isabel Ma
 *
 */
public class Fraction {

	//instance var
	
	int numerator; 
	
	int denominator;
	
	//constructor
	
	/**
	 * Creates a Fraction with given numerator and denominator.
	 * properly formats negative fractions.
	 * @param numerator of fraction
	 * @param denominator of fraction
	 */
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator; 
		this.denominator = denominator; 
		
		//properly format negative fraction values
		this.formatNegativeFraction();
	}

	
	//methods
	
	/**
	 * Reduces the current fraction by eliminating common factors. 
	 * The convention is that negative fractions have the negatice in the numerator. 
	 * The reduced form of 0 is 0/1. The reduced form of 7 is 7/1.
	 */
	public void reduceToLowestForm() {
		if (this.numerator == 0) {
			this.numerator = 0; 
			this.denominator = 1; 
		} else if (this.numerator % this.denominator == 0) {
			this.numerator = this.numerator / this.denominator;
			this.denominator = 1;
		} else {
			//get divisors of numerator and denominator
			ArrayList<Integer> divisorsNum = this.findDivisors(this.numerator);
			ArrayList<Integer> divisorsDen = this.findDivisors(this.denominator);		
			
			//get greatest common factor within each list of divisors
			int gcf = findGreatestCommonFactor(divisorsNum, divisorsDen);
			
			//divide numerator and denominator by gcf
			this.numerator = this.numerator / gcf;
			this.denominator = this.denominator / gcf;
			
			//properly format negative fraction values
			this.formatNegativeFraction();  
		}
		
	}
	
    /**
     * Correctly formats a fraction so that negative fractions have the negative in the numerator
     * Fractions with a negative in both numerator and denominator are re-formatted to be positive
     */
	//helper function
	void formatNegativeFraction() {
		//fraction with negative in the denominator
		if (this.denominator < 0) {
			this.denominator *= -1; 
			
			//negative in the numerator
			//Or if both numerator and denominator are negative
			this.numerator *= -1;
		}
	}
	
	/**
	 * Finds all divisors of the given num.
	 * @param num to divide
	 * @return ArrayList containing divisors
	 */
	//helper function
	ArrayList<Integer> findDivisors(int num) {
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		
		//if necessary, convert num to a positive number
		if (num < 0) {
			num *= -1;
		}
		
		//divide by every number less <= num and find the ones that divide evently
		for (int i = num; i >= 1; i--) {
			if (num % i == 0 ) {
				divisors.add(i);
			}
		}
		
		return divisors; 
	}
	
	/**
	 * Finds the greatest common multiple of two given numbers.
	 * @param divisorsNum
	 * @param divisorsDen
	 * @return greatest common multiple
	 */
	//helper function
	int findGreatestCommonFactor(ArrayList<Integer> divisorsNum, ArrayList<Integer> divisorsDen) {
		int gcf = 0; 
		
		//Sort list of divisors in descending order (greatest values first)
		Collections.sort(divisorsNum, Collections.reverseOrder());
		Collections.sort(divisorsDen, Collections.reverseOrder());
		
		//Iterate through divisors of the numerator
		for (Integer divNum : divisorsNum) {
			//find a match in the divisors of the denominator
			if (divisorsDen.contains(divNum)) {
				gcf = divNum; 
				break; 
			}
		}		
		return gcf; 
	}
	
	/**
	 * Finds the least common multiple of two given numbers.
	 * @param num1 First number
	 * @param num2 Second number
	 * @return Least common multiple
	 */
	//helper function
	int findLeastCommonMultiple(int num1, int num2) {
		int lcm = 0; 
		
		//get absolute calue
		if (num1 < 0 ) {
			num1 *= -1; 
		}
		if (num2 < 0) {
			num2 *= -1; 
		}
		
		//first, confirm if one number can divide the other
		if ((num1 > num2) && (num1 % num2 == 0)) {
			lcm = num1; 
		} else if ((num2 > num1) && (num2 % num1 == 0)) {
			lcm = num2;
		//otherwise, the lcm is the product
		} else {
			lcm = num1 * num2; 
		}
		
		return lcm; 
	}
	
	/**
	 * Adds the current Fraction to the given otherFraction.
	 * Returns a new Fraction that is the sum of the two Fractions, must be in reduced/lowest form.
	 * @param otherFraction to add
	 * @return new Fraction that is the sum
	 */
	public Fraction add(Fraction otherFraction) {
		
		int sumNumerator; 
		int sumDenominator; 
		
		//denominators are the same
		if (this.denominator == otherFraction.denominator) {
			//Calculate new numerator of sum
			int newNumerator = this.numerator + otherFraction.numerator; 
			
			sumNumerator = newNumerator;
			sumDenominator = this.denominator; 
			
		} else {
			
			//Find least common multiple
			int lcm = findLeastCommonMultiple(this.denominator, otherFraction.denominator);
			
			//calculate each new numerator
			int thisNewNumerator = (lcm / this.denominator) * this.numerator; 
			int otherNewNumerator = (lcm / otherFraction.denominator) * otherFraction.numerator; 
			
			//calculate new nemerator of sum
			int newNumerator = thisNewNumerator + otherNewNumerator;
			
			sumNumerator = newNumerator; 
			sumDenominator = lcm; 
		}
		
		//create new fraction and reduce
		Fraction newFraction = new Fraction(sumNumerator, sumDenominator);
		newFraction.reduceToLowestForm();
		
		return newFraction;
	}
	

	/**
	 * Subtracts the given otherFraction from the current fraction.
	 * Returns a new fraction that is the difference of the two fractions, must be in reduced/lowest form. 
	 * @param otherFraction to subtract
	 * @return new Fraction that is the diff
	 */
	public Fraction subtract(Fraction otherFraction) {
		
		int diffNumerator; 
		int diffDenominator; 
		
		//denominators are the same
		if (this.denominator == otherFraction.denominator) {
			//Calculate new numerator of sum
			int newNumerator = this.numerator - otherFraction.numerator; 
			
			diffNumerator = newNumerator;
			diffDenominator = this.denominator; 
	} else {
		
		//Find least common multiple
		int lcm = findLeastCommonMultiple(this.denominator, otherFraction.denominator);
		
		//calculate each new numerator
		int thisNewNumerator = (lcm / this.denominator) * this.numerator; 
		int otherNewNumerator = (lcm / otherFraction.denominator) * otherFraction.numerator; 
		
		//calculate new numerator of sum
		int newNumerator = thisNewNumerator - otherNewNumerator;
		
		diffNumerator = newNumerator; 
		diffDenominator = lcm; 
	}
		
		//create new fraction and reduce
		Fraction newFraction = new Fraction(diffNumerator, diffDenominator);
		newFraction.reduceToLowestForm();
		
		return newFraction;
	}
	
	/**
	 * Multiplies the current fraction by the otherFraction.
	 * Returns a new Fraction that is the product of this fraction and the other fraction, must be in reduced/lowest form.
	 * @param otherFraction to multiply
	 * @return New Fraction that is the product
	 */
	public Fraction mul(Fraction otherFraction) {
		
		//reduce to lowest form
		this.reduceToLowestForm();
		otherFraction.reduceToLowestForm();
		
		int prodNumerator = this.numerator * otherFraction.numerator; 
		int prodDenominator = this.denominator * otherFraction.denominator;
		
		//create new fraction and reduce
		Fraction newFraction = new Fraction(prodNumerator, prodDenominator);
		newFraction.reduceToLowestForm();
		
		return newFraction;
	}
	
	/**
	 * Divides the current fraction by the otherFraction. 
	 * Returns a new Fraction that is the quotient of this fraction and the otherFraction, must be in reduced/lowest form.
	 * @param otherFraction to divide
	 * @return new Fraction that is the quotient.
	 */
	public Fraction div(Fraction otherFraction) {
		
		//reduce to lowest form
		this.reduceToLowestForm();
		otherFraction.reduceToLowestForm();
		
		//calculate reciprocal of divisor
		int otherNumerator = otherFraction.numerator; 
		int otherDenominator = otherFraction.denominator;
		otherFraction.numerator = otherDenominator; 
		otherFraction.denominator = otherNumerator; 
		
		//multiply by reciprocal
		Fraction newFraction = this.mul(otherFraction);
		newFraction.reduceToLowestForm();
		
		return newFraction;
	}

	/**
	 * Returns this fraction in decimal form.
	 * @return double value representing this fraction
	 */
	public double decimal() {
		
		//by default, division with int value will return an int
		//cast denominator to double
		double doubleDenominator = (double) this.denominator; 
		
		return this.numerator / doubleDenominator; 
	}
	
	/**
	 * Squares the current fraction.
	 */
	public void sqr() {
		Fraction otherFraction = new Fraction(this.numerator, this.denominator);
		
		Fraction newFraction = this.mul(otherFraction);
		
		this.numerator = newFraction.numerator; 
		this.denominator = newFraction.denominator; 
	}
	
	/**
	 * Averages the current fraction with the given otherFraction.
	 * Return a new Fraction that is the average of this fraction and the otherFraction, must be in reduced/lowest form.
	 * @param otherFraction to average with 
	 * @return new Fraction with the average
	 */
	public Fraction average(Fraction otherFraction) {
		
		//add the fractions
		Fraction sumFractions = this.add(otherFraction);
		
		//divide by the number of values
		Fraction twoFraction = new Fraction (2, 1);
		
		Fraction divFraction = sumFractions.div(twoFraction);
		divFraction.reduceToLowestForm();
		
		return divFraction; 
	}
	
	/**
	 * Averages all of the fractions in the array. 
	 * Do not include the current fraction in the average. 
	 * Return a new Fraction that is the average of the array, must be in reduced/lowest form.
	 * If the array is empty, return a new Fraction that equals 0, that is 0/1.
	 * @param fractions to average
	 * @return new Fraction with the average
	 */
	public static Fraction average(Fraction[] fractions) {
		
		Fraction divFraction = new Fraction(0, 1);
		
		//get total number of fractions
		int numFractions = fractions.length; 
		
		if (numFractions > 0) {
			//get first fraction
			Fraction sumFractions = fractions[0];
			
			//add each fraction
			for (int i = 1; i < numFractions; i++) {
				sumFractions = sumFractions.add(fractions[i]);
			}
			
			//divide by the number of values
			Fraction lenFraction = new Fraction(numFractions, 1);
			divFraction = sumFractions.div(lenFraction);
			
			//reduce to lowest form
			divFraction.reduceToLowestForm();
		}
		
		return divFraction;
	}
	
	/**
	 * Averages all the integers in the array. 
	 * Do not include the current fraction in the average.
	 * Returns the average of the array as a new Fraction, must be in reduced/lowest form.
	 * @param ints to average
	 * @return new Fraction with the average
	 */
	public static Fraction average(int[] ints) {
		
		Fraction divFraction = new Fraction(0, 1);
		
		//get total number of ints
		int numInts = ints.length; 
		
		if (numInts > 0) {
			//get first int
			int sumInts = ints[0];
			
			//add each int
			for (int i=1; i <numInts; i++) {
				sumInts += ints[i];
			}
			
			//divide by the number of values
			divFraction = new Fraction(sumInts, numInts);
			
			//reduce tolowest form
			divFraction.reduceToLowestForm();
		}
		
		return divFraction; 		
	}
	
	
	/**
	 * Compares the given object (as a Fraction) to the current fraction, for equality.
	 * Two fractions are considered equal if they have the same numerator and same denominator, after reducing to lowest form.
	 * This operation does not (permanently) reduce the current fraction to lowest form.
	 */
	@Override
	public boolean equals(Object object) {
		
		if (!(object instanceof Fraction)) {
			return false; 
		}
		
		//create fraction objecs and reduce to lowest form
		Fraction thisFraction = new Fraction(this.numerator, this.denominator);
		thisFraction.reduceToLowestForm();
		
		Fraction otherFraction = (Fraction)object; 
		otherFraction = new Fraction(otherFraction.numerator, otherFraction.denominator);
		otherFraction.reduceToLowestForm();
		
		//compare numerators and denominators
		return (thisFraction.numerator == otherFraction.numerator
				&& thisFraction.denominator == otherFraction.denominator);
	}
	
	/**
	 * Returns a string representation of the current fraction.
	 * There is a no whitespace in this string.
	 * take care of the negative
	 */
	@Override
	public String toString() {
		return this.numerator + "/" + this.denominator; 
	}
	
}
