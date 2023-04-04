import java.awt.Color;

import javax.print.attribute.standard.MediaSize.Other;
/*
 * The MandelbrotTools class represents the GUI of the Mandelbrot 
 */
public class MandelbrotTools {

	/*  STUDENTS:  Put your "isBig" and "divergence" methods here. */
	/*
	 * isBig method takes in one ComplexNumber parameter and returns a boolean
	 * statement. Like the norm method in the ComplexNumber class, this method
	 * takes the real and imaginary portion of a complex number and squares them
	 * and adds the two values together.
	 * It then compares the sum of that value to a static variable called
	 * Controller.DIVERGENCE_BOUNDARY.
	 * If a2 + b2 is greater than the value of the variable named 
	 * DIVERGENCE_BOUNDARY, then the method returns true.  
	 * Otherwise it returns false.
	 */
	public static boolean isBig (ComplexNumber parameter) {
		MyDouble complexNum = new MyDouble (parameter.getReal().multiply(
				parameter.getReal()).add(parameter.getImag().multiply(
						parameter.getImag())));
		if (complexNum.compareTo(Controller.DIVERGENCE_BOUNDARY) > 0) {
			return true;
		} else {
			return false;
		}

	}
	/*
	 * Divergence method takes in one ComplexNumber parameter and returns type
	 * int. The method calculates a sequence of complex number and after each
	 * calculation it then tests if the term in the sequence isBig.
	 */
	public static int divergence (ComplexNumber parameter) {
		if (!isBig(parameter)) {
			ComplexNumber z0 = new ComplexNumber(parameter);
			for(int i=0; i <= Controller.LIMIT; i++) {
				parameter= parameter.multiply(parameter).add(z0);
				if (isBig(parameter)) {
					return i; 
					/*returning the index of the value that 
					made the condition big*/
				}
			}
		}return -1;
	}







	/* This method selects a non-black color for a point which DIVERGED when tested with the Mandelbrot
	 * recurrence, based on how many terms in the sequence were computed before the terms got "too big".
	 * 
	 * The parameter represents the index of the term in the sequence which was first to be "too big".  
	 * This value could be anything from 0 to Controller.LIMIT.  The return value is the Color to be used 
	 * to color in the point.
	 * 
	 * STUDENTS:  IF you want to have some fun, write code for the else-if clause below which says
	 * "modify this block to create your own color scheme".  When someone runs the program and selects 
	 * "Student Color Scheme", the code you have written below will determine the colors.
	 */
	public static Color getColor(int divergence) {
		Color returnValue;

		if (Controller.colorScheme == Controller.RED_AND_WHITE_BANDS) {
			returnValue = (divergence  % 2 == 0)? Color.WHITE : Color.RED;
		}

		else if (Controller.colorScheme == Controller.CRAZY_COLORS) {
			int value = divergence * 2;
			int redAmount = (value % 5) * (255/5);
			int greenAmount = (value % 7) * (255/7);
			int blueAmount = (value % 9) * (255/9);
			returnValue = new Color(redAmount, greenAmount, blueAmount); 
		}

		else if (Controller.colorScheme == Controller.STUDENT_DEFINED){


			/***************************************************************
			 * Modify this block to create your own color scheme!          *
			 ***************************************************************/
			returnValue = Color.WHITE;  // take this out and return something useful


		}
		else
			throw new RuntimeException("Unknown color scheme selected!");
		return returnValue;
	}



}
