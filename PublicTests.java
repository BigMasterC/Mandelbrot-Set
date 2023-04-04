import static org.junit.Assert.*;

import org.junit.Test;

/*
 * "PublicTest" class is used to create tests used to test the methods in the 
 * ComplexNumber class.
 */
public class PublicTests {

	@Test //testing the basic constructors and getters in ComplexNumber class.
	public void testBasicConstructorsAndGetters() {//works
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);//1st Constructor
		MyDouble d = new MyDouble(555.729);
		
		ComplexNumber x = new ComplexNumber(a, b);
		assertTrue(x.getReal().compareTo(a) == 0 
				&& x.getImag().compareTo(b) == 0);
		
		ComplexNumber z = new ComplexNumber(d); //2nd Constructor 
		assertTrue(z.getReal().compareTo(d) == 0 
				&& z.getImag().compareTo(new MyDouble(0)) == 0);
	}
	
	@Test //testing the copy constructor in ComplexNumber class
	public void testCopyConstructor() {//works
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(x);
		assertTrue(x != y);     // Check to be sure they are not aliased!
		assertTrue(y.getReal().compareTo(a) == 0 
				&& y.getImag().compareTo(b) == 0);
	}
	@Test //testing the add method in ComplexNumber class.
	public void testAdd() {//works
		
		MyDouble a = new MyDouble(-2), b = new MyDouble(7);
		MyDouble d = new MyDouble(1); MyDouble e= new MyDouble(5);
		
		MyDouble f = new MyDouble(-1);
		MyDouble h = new MyDouble(12);
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber z = new ComplexNumber(d,e);
		ComplexNumber g = new ComplexNumber(f,h);
		assertTrue(x.add(z).compareTo(g) == 0);
	}
	@Test //testing the subtract method in ComplexNumber class
	public void testSubtract() {//works
		
		MyDouble a = new MyDouble(9), b = new MyDouble(-4);
		MyDouble d = new MyDouble(-2); MyDouble e= new MyDouble(7);
		
		MyDouble f = new MyDouble(11);
		MyDouble h = new MyDouble(-11);
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber z = new ComplexNumber(d,e);
		ComplexNumber g = new ComplexNumber(f,h);
		assertTrue(x.subtract(z).compareTo(g) == 0);
	}
	@Test //testing the multiply method in ComplexNumber class
	public void testMult() {//works
		
		MyDouble a = new MyDouble(4), b = new MyDouble(2);
		MyDouble c = new MyDouble(3), d = new MyDouble(2);
		
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber z = new ComplexNumber(c,d);
		
		MyDouble f = new MyDouble(8);
		MyDouble h = new MyDouble(14);
		ComplexNumber g = new ComplexNumber(f,h);
		assertTrue(x.multiply(z).compareTo(g)== 0 );
	}
	@Test //testing the divide method in ComplexNumber class
	public void testDiv() {//works
		
		MyDouble a = new MyDouble(16), b = new MyDouble(-2);
		MyDouble c = new MyDouble(3), d = new MyDouble(-2);
		
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber z = new ComplexNumber(c,d);
		
		MyDouble f = new MyDouble(4);
		MyDouble h = new MyDouble(2);
		ComplexNumber g = new ComplexNumber(f,h);
		assertTrue(x.divide(z).compareTo(g)== 0 );
	}
	@Test //testing the Equals and compareTo methods in ComplexNumber class
	public void testEqComp() {//works
		MyDouble a = new MyDouble(1), b = new MyDouble(2);
		MyDouble c = new MyDouble(1), d = new MyDouble(2);
		
		ComplexNumber num = new ComplexNumber(a,b);
		ComplexNumber num2 = new ComplexNumber(c,d);
		assertTrue(num.equals(num2));
		assertTrue(num.compareTo(num2)==0);
	}
	@Test //testing the toString method in ComplexNumber class.
	public void testToString() {//works
		MyDouble a = new MyDouble(6.7), b = new MyDouble(2.3);
		MyDouble c = new MyDouble(-6.7), d = new MyDouble(-2.3);
		
		ComplexNumber num = new ComplexNumber(a,b);
		ComplexNumber num2 = new ComplexNumber(c,b);
		ComplexNumber num3 = new ComplexNumber(a,d);
		ComplexNumber num4 = new ComplexNumber(c,d);
		
		assertTrue(num.toString().equals("6.7+2.3i")); 
		//complex number object, call to method, .equals(expected value)
		assertTrue(num2.toString().equals("-6.7+2.3i"));
		assertTrue(num3.toString().equals("6.7-2.3i"));
		assertTrue(num4.toString().equals("-6.7-2.3i"));
		
	}
	@Test //testing the norm method in ComplexNumber class
	public void testNorm() {//works
		MyDouble a = new MyDouble(3), b = new MyDouble (4);
		ComplexNumber num = new ComplexNumber(a,b);
		
		MyDouble e = new MyDouble(5);
		assertTrue(ComplexNumber.norm(num).equals(e));
	}
	@Test //testing the parse method in ComplexNumber class
	public void testParse() { //what's wrong??
		MyDouble a = new MyDouble(6.7), b = new MyDouble(2.3);
		MyDouble c = new MyDouble(-6.7), d = new MyDouble(-2.3);
		
		ComplexNumber num = new ComplexNumber(a,b); // 6.7, 2.3
		ComplexNumber num2 = new ComplexNumber(c,b); // -6.7, 2.3
		ComplexNumber num3 = new ComplexNumber(a,d); // 6.7, -2.3
		ComplexNumber num4 = new ComplexNumber(c,d); // -6.7, -2.3
		
		assertTrue(ComplexNumber.parseComplexNumber("6.7+2.3i").equals(num)); 
		//complex number object, call to method, .equals(expected value)
		assertTrue(ComplexNumber.parseComplexNumber("-6.7+2.3i").equals(num2)); 
		//removed the "i" because it only parses the #s
		assertTrue(ComplexNumber.parseComplexNumber("6.7-2.3i").equals(num3));
		assertTrue(ComplexNumber.parseComplexNumber("-6.7-2.3i").equals(num4));
		
	}
}
