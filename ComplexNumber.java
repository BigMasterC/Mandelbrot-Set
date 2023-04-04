/*
 * The ComplexNumber class establishes the different possible operations for
 * complex numbers
 */
public class ComplexNumber { //"ComplexNumber" type of the class

	/* STUDENTS:  You may NOT add any further instance or static variables! */
	private final MyDouble real;   // "real" part of a complex number
	private final MyDouble imag;   // "imaginary" part of a complex number

	/*
	 * Standard constructor that takes two MyDouble parameters, real and imag
	 */
	public ComplexNumber (MyDouble real, MyDouble imag) {
		this.real= real; //setting the current object equal to the parameter
		this.imag = imag; //setting the current object equal to the parameter
	}
	//constructor that takes one parameter
	public ComplexNumber (MyDouble real) {
		this.real = real; 
		this.imag = new MyDouble(0);//initializing current object "imag" to zero
	}
	//copy constructor
	public ComplexNumber(ComplexNumber other) {
		real = other.real;
		imag = other.imag;
	}
	//getter that gets the value of the "real" data member
	public MyDouble getReal() {
		return real; //"real" is an instance variable
	}
	//getter that gets the value of the "imag" data member
	public MyDouble getImag() {
		return imag; //"imag" in an instance variable
	}
	/*
	 * Add method takes of parameter and returns a ComplexNumber that is  
	 * equal to the sum of the current object and the parameter.
	 */
	public ComplexNumber add(ComplexNumber parameter) {
		/*
		 * creates a new ComplexNumber object that adds the complex number of
		 * the current object to the complex number of the parameter. (below)
		 */
		ComplexNumber complexNum = new ComplexNumber(
				real.add(parameter.getReal()), 
				(imag.add(parameter.getImag())) );
		return  complexNum;
	}
	/*
	 *  Subtract method takes one parameter and returns a ComplexNumber that is
	 *  computed by subtracting the value of parameter from the current object
	 */
	public ComplexNumber subtract(ComplexNumber parameter) {
		/*
		 * Creates a complex number object that subtracts the complex number of
		 * the parameter from the complex number of the current object.(below)
		 */
		ComplexNumber complexNum = new ComplexNumber(
				real.subtract(parameter.getReal()),
				(imag.subtract(parameter.getImag())) );
		return complexNum;
	}
	/*
	 * Multiply method takes one parameter and returns a ComplexNumber that 
	 * represents the product of the current object and the parameter.
	 */
	public ComplexNumber multiply(ComplexNumber parameter) {
		/*
		 * (below) creating two MyDouble objects that takes the product of the
		 * like terms of a two complex numbers and adds them together.
		 * I separated the two like terms and assigned them to two different 
		 * variables so that I could then create a new ComplexNumber object
		 * (line 81) to then return a ComplexNumber
		 */
		MyDouble likeTermImag =	real.multiply(parameter.getImag()).add(
				imag.multiply(parameter.getReal()));
		MyDouble likeTermReal = real.multiply(parameter.getReal()).add(
				imag.multiply(parameter.getImag().multiply(new MyDouble(-1))));

		ComplexNumber complexNum = new ComplexNumber(likeTermReal,likeTermImag);
		return complexNum;
	}
	/*
	 * Divide method takes one parameter and returns the quotient computed by 
	 * dividing the current object by the parameter.
	 */
	public ComplexNumber divide(ComplexNumber parameter) {
		/*
		 * I separated the two complex numbers into two different fractions
		 * (one fraction represents the real portion of a complex number and the
		 * 2nd fraction represents the imaginary portion of a complex number)
		 * I then added the products of their individual numerators. When you
		 * divide complex numbers the denominators remain the same so I 
		 * divided the different numerators by the same denominator value. 
		 */
		MyDouble numerator1 = real.multiply(parameter.getReal()).add(
				imag.multiply(parameter.getImag()));
		MyDouble numerator2 = imag.multiply(parameter.getReal()).subtract(
				real.multiply(parameter.getImag()));
		MyDouble denominator = parameter.getReal().multiply(parameter.getReal())
				.add(parameter.getImag().multiply(parameter.getImag()));
		/*
		 * "realFrac" the fraction that represents the real number
		 * "imagFrac" the fraction that represents the imaginary number
		 */
		MyDouble realFrac = numerator1.divide(denominator);
		MyDouble imagFrac = numerator2.divide(denominator);

		ComplexNumber complexNum = new ComplexNumber(realFrac,imagFrac);
		return complexNum;
	}
	/*
	 * Equals method takes in one ComplexNumber parameter and returns a 
	 * boolean statement--which is true if both fields match
	 */
	public boolean equals(ComplexNumber parameter) {
		return real.equals(parameter.getReal()) 
				&& imag.equals(parameter.getImag());
	}
	/*
	 * CompareTo method takes in one ComplexNumber parameter and returns an 
	 * integer by comparing the norm of the current object to the 
	 * norm of the parameter
	 */
	public int compareTo (ComplexNumber parameter) {
		MyDouble normOfCurrObj = norm(this);//Norm of current object
		MyDouble normOfParameter = norm(parameter);//Norm of parameter
		/*
		 * If the norm of the current object is equal to the norm of the
		 * parameter, the method will return 0.
		 * Else if the norm of the current object is less than the norm of the
		 * parameter, the method returns -1.
		 * Otherwise, the method returns -1.
		 */
		if (normOfCurrObj.equals(normOfParameter)) {
			return 0; 
		}else if (normOfCurrObj.compareTo(normOfParameter)< 0) {
			return -1;
		}else {
			return 1;		
		}
	}
	/*
	 * Returns a string representing the four possible cases a ComplexNumber
	 * could have
	 */
	public String toString() {
		if (real.compareTo(new MyDouble (0)) > 0 && imag.compareTo(
				new MyDouble(0)) >= 0) {
			return "" + real + "+" + imag + "i"; //output: 6.7+2.3i
		}else if (real.compareTo(new MyDouble (0)) > 0 && imag.compareTo(
				new MyDouble (0)) <= 0) {
			return "" + real + imag + "i"; //output: 6.7-2.3i 
		}else if (real.compareTo(new MyDouble (0)) < 0 && imag.compareTo(
				new MyDouble(0)) >= 0) {
			return "" + real + "+" + imag + "i"; //output: -6.7+2.3i
		}else {
			return "" + real + imag + "i"; //output: -6.7-2.3i
		}
	}
	/*
	 * Norm method takes one ComplexNumber parameter 
	 * and returns a MyDouble object
	 * that represents the norm of the complex number. 
	 */
	public static MyDouble norm(ComplexNumber parameter) {
		/*
		 * to find the norm of a complex number, I squared both the real and
		 * imaginary portion of the complex number and then found the 
		 * square root of the complex number.
		 */
		MyDouble complexNum = new MyDouble (
				parameter.getReal().multiply(parameter.getReal()).
				add(parameter.getImag().multiply(parameter.getImag())));
		return complexNum.sqrt();//returning the square root of a complex number
	}
	/*
	 * ParseComplexNumber method takes in one String parameter and returns a 
	 * ComplexNumber. It accomplishes this my parsing (or "extracting" the 
	 * real and imaginary portions of a complex number from the String.
	 */
	public static ComplexNumber parseComplexNumber (String parameter) {
		parameter = parameter.replaceAll("\\s", "");
		//removes all the space in a string 
		int indexer = parameter.indexOf('+');
		/*
		 * "indexer" separates the complex number into two parts depending on 
		 * the assign index of the symbol.
		 */
		
		if (indexer == -1) {// indexer returns "-1" if the "+" does not exist
			indexer = parameter.lastIndexOf('-'); 
			/*if the above symbol does not exist,set this value into the new y 
			and hence I don't need "z" <--[NOTE TO SELF]*/
		}

		String realPart = parameter.substring(0,indexer); //first part (real)
		String imagPart = parameter.substring(indexer,parameter.length()-1); 
		//second part (imaginary)
		/*
		 * (below) parses the "real" and "imaginary" parts of a complex
		 * number string
		 */
		double parseReal = Double.parseDouble(realPart);
		double parseImag = Double.parseDouble(imagPart);
		ComplexNumber complexNum = new ComplexNumber (new MyDouble(parseReal), 
				new MyDouble(parseImag));
		return complexNum;
	}
//end of ComplexNumber class -fin
}
