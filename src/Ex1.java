/**
 * Introduction to Computer Science 2026, Ariel University,
 * Ex1: arrays, static functions and JUnit
 * https://docs.google.com/document/d/1GcNQht9rsVVSt153Y8pFPqXJVju56CY4/edit?usp=sharing&ouid=113711744349547563645&rtpof=true&sd=true
 *
 * This class represents a set of static methods on a polynomial functions - represented as an array of doubles.
 * The array {0.1, 0, -3, 0.2} represents the following polynomial function: 0.2x^3-3x^2+0.1
 * This is the main Class you should implement (see "add your code below")
 *
 * @author boaz.benmoshe
* ID: 207636481
 */
public class Ex1 {
	/** Epsilon value for numerical computation, it serves as a "close enough" threshold. */
	public static final double EPS = 0.001; // the epsilon to be used for the root approximation.
	/** The zero polynomial function is represented as an array with a single (0) entry. */
	public static final double[] ZERO = {0};
	/**
	 * Computes the f(x) value of the polynomial function at x.
	 * @param poly - polynomial function
	 * @param x
	 * @return f(x) - the polynomial function value at x.
	 */
	public static double f(double[] poly, double x) {
		double ans = 0;
		for(int i=0;i<poly.length;i++) {
			double c = Math.pow(x, i);
			ans += c*poly[i];
		}
		return ans;
	}
	/** Given a polynomial function (p), a range [x1,x2] and an epsilon eps.
	 * This function computes an x value (x1<=x<=x2) for which |p(x)| < eps, 
	 * assuming p(x1)*p(x2) <= 0.
	 * This function should be implemented recursively.
	 * @param p - the polynomial function
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param eps - epsilon (positive small value (often 10^-3, or 10^-6).
	 * @return an x value (x1<=x<=x2) for which |p(x)| < eps.
	 */
	public static double root_rec(double[] p, double x1, double x2, double eps) {
		double f1 = f(p,x1);
		double x12 = (x1+x2)/2;
		double f12 = f(p,x12);
		if (Math.abs(f12)<eps) {return x12;}
		if(f12*f1<=0) {return root_rec(p, x1, x12, eps);}
		else {return root_rec(p, x12, x2, eps);}
	}
	/**
	 * This function computes a polynomial representation from a set of 2D points on the polynom.
	 * The solution is based on: //	http://stackoverflow.com/questions/717762/how-to-calculate-the-vertex-of-a-parabola-given-three-points
	 * Note: this function only works for a set of points containing up to 3 points, else returns null.
	 * @param xx
	 * @param yy
	 * @return an array of doubles representing the coefficients of the polynom.
	 */
	public static double[] PolynomFromPoints(double[] xx, double[] yy) {
		double[] ans = null;
		int lx = xx.length;
		int ly = yy.length;
		if (xx != null && yy != null && lx == ly && lx > 1 && lx < 4) {

			if (lx == 2) {
				double x1 = xx[0], y1 = yy[0];
				double x2 = xx[1], y2 = yy[1];

				double a = (y2 - y1) / (x2 - x1);
				double b = y1 - a * x1;
				ans = new double[]{b, a};
			}
			else if (lx == 3) {
				double x1 = xx[0], y1 = yy[0];
				double x2 = xx[1], y2 = yy[1];
				double x3 = xx[2], y3 = yy[2];

				double denom = (x1 - x2) * (x1 - x3) * (x2 - x3);

				double a = ((y1 * (x2 - x3)) + (y2 * (x3 - x1)) + (y3 * (x1 - x2))) / denom;

				double bnum = (y1 * (Math.pow(x3, 2) - Math.pow(x2, 2))) +
						(y2 * (Math.pow(x1, 2) - Math.pow(x3, 2))) +
						(y3 * (Math.pow(x2, 2) - Math.pow(x1, 2)));
				double b = bnum / denom;

				double c = ((y1 * (x2 * x3 * (x2 - x3))) +
						(y2 * (x3 * x1 * (x3 - x1))) +
						(y3 * (x1 * x2 * (x1 - x2)))) / denom;

				ans = new double[]{c, b, a};
			}
		}
		return ans;
	}

	/** Two polynomials functions are equal if and only if they have the same values f(x) for n+1 values of x,
	 * where n is the max degree (over p1, p2) - up to an epsilon (aka EPS) value.
	 * @param p1 first polynomial function
	 * @param p2 second polynomial function
	 * @return true iff p1 represents the same polynomial function as p2.
	 */
	public static boolean equals(double[] p1, double[] p2) {
		boolean ans = true;
        if (p1 == null) p1 = ZERO;
		if (p2 == null) p2 = ZERO;
		int d1 = -1;
		for (int i = p1.length - 1; i >= 0; i--) {
			if (Math.abs(p1[i]) > EPS && d1 == -1) {
				d1 = i;
			}
		}
		int d2 = -1;
		for (int i = p2.length - 1; i >= 0; i--) {
			if (Math.abs(p2[i]) > EPS && d2 == -1) {
				d2 = i;
			}
		}

		return ans;
	}

	/** 
	 * Computes a String representing the polynomial function.
	 * For example the array {2,0,3.1,-1.2} will be presented as the following String  "-1.2x^3 +3.1x^2 +2.0"
	 * @param poly the polynomial function represented as an array of doubles
	 * @return String representing the polynomial function:
	 */
	public static String poly(double[] poly) {
		String ans = "";
		if(poly.length==0) {ans="0";}
		else {
			boolean first = true;
			for (int i = poly.length - 1; i >= 0; i--) {
				double coef = poly[i];
				if (Math.abs(coef) < EPS) continue;
				if (first) {
					if (coef < 0) ans += "-";
					first = false;
				} else {
					if (coef < 0) ans += " -";
					else ans += " +";
				}
				double absCoef = Math.abs(coef);
				if (i == 0) {
					ans += absCoef;
				} else if (i == 1) {
					ans += absCoef + "x";
				}
				else{
					ans += absCoef + "x^" + i;
				}
			}
			if (first) ans = "0";
		}
		return ans;
	}
	/**
	 * Given two polynomial functions (p1,p2), a range [x1,x2] and an epsilon eps. This function computes an x value (x1<=x<=x2)
	 * for which |p1(x) -p2(x)| < eps, assuming (p1(x1)-p2(x1)) * (p1(x2)-p2(x2)) <= 0.
	 * @param p1 - first polynomial function
	 * @param p2 - second polynomial function
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param eps - epsilon (positive small value (often 10^-3, or 10^-6).
	 * @return an x value (x1<=x<=x2) for which |p1(x) - p2(x)| < eps.
	 */
	public static double sameValue(double[] p1, double[] p2, double x1, double x2, double eps) {
		double ans = x1;

		double a = x1;
		double b = x2;
		double fa = f(p1, a) - f(p2, a);
		double fb = f(p1, b) - f(p2, b);

		while ((b - a) > EPS) {
			double mid = (a + b) / 2.0;
			double fm = f(p1, mid) - f(p2, mid);
			ans = mid;

			if (fa * fm <= 0) {
				b = mid;
				fb = fm;
			}
			else {
				a = mid;
				fa = fm;
			}
		}
		return ans;
	}
	/**
	 * Given a polynomial function (p), a range [x1,x2] and an integer with the number (n) of sample points.
	 * This function computes an approximation of the length of the function between f(x1) and f(x2) 
	 * using n inner sample points and computing the segment-path between them.
	 * assuming x1 < x2. 
	 * This function should be implemented iteratively (none recursive).
	 * @param p - the polynomial function
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param numberOfSegments - (A positive integer value (1,2,...).
	 * @return the length approximation of the function between f(x1) and f(x2).
	 */
	public static double length(double[] p, double x1, double x2, int numberOfSegments) {
		double ans = x1;
		ans = 0;
		double dx = (x2 - x1) / numberOfSegments;
		double prevX = x1;
		double prevY = f(p, prevX);

		for (int i = 1; i <= numberOfSegments; i++) {
			double currX = x1 + i * dx;
			double currY = f(p, currX);
			double diffX = currX - prevX;
			double diffY = currY - prevY;

			double segmentLength = Math.sqrt(diffX * diffX + diffY * diffY);
			ans += segmentLength;
			prevX = currX;
			prevY = currY;
		}
		return ans;
	}
	
	/**
	 * Given two polynomial functions (p1,p2), a range [x1,x2] and an integer representing the number of Trapezoids between the functions (number of samples in on each polynom).
	 * This function computes an approximation of the area between the polynomial functions within the x-range.
	 * The area is computed using Riemann's like integral (https://en.wikipedia.org/wiki/Riemann_integral)
	 * @param p1 - first polynomial function
	 * @param p2 - second polynomial function
	 * @param x1 - minimal value of the range
	 * @param x2 - maximal value of the range
	 * @param numberOfTrapezoid - a natural number representing the number of Trapezoids between x1 and x2.
	 * @return the approximated area between the two polynomial functions within the [x1,x2] range.
	 */
	public static double area(double[] p1,double[]p2, double x1, double x2, int numberOfTrapezoid) {
		double ans = 0;

		int n = Math.max(numberOfTrapezoid * 10, 100);

		double dx = (x2 - x1) / n;
		double prevX = x1;
		double prevY = Math.abs(f(p1, prevX) - f(p2, prevX));
		for (int i = 0; i < n; i++) {
			double currX = x1 + i * dx;
			double currY = Math.abs(f(p1, currX) - f(p2, currX));

			double trapezoidArea = (prevY + currY) * dx / 2.0;
			ans += trapezoidArea;

			prevY = currY;
		}
		return ans;
	}
	/**
	 * This function computes the array representation of a polynomial function from a String
	 * representation. Note:given a polynomial function represented as a double array,
	 * getPolynomFromString(poly(p)) should return an array equals to p.
	 * 
	 * @param p - a String representing polynomial function.
	 * @return
	 */
	public static double[] getPolynomFromString(String p) {
		double [] ans = ZERO;//  -1.0x^2 +3.0x +2.0
        /** add you code below

         /////////////////// */
		return ans;
	}
	/**
	 * This function computes the polynomial function which is the sum of two polynomial functions (p1,p2)
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static double[] add(double[] p1, double[] p2) {
		double [] ans = ZERO; //

		int max = Math.max(p1.length, p2.length);
		ans = new double[max];

		for (int i = 0; i < max; i++) {
			double c1 = (i < p1.length) ? p1[i] : 0;
			double c2 = (i < p2.length) ? p2[i] : 0;
			ans[i] = c1 + c2;
		}

		int last = ans.length - 1;
		while (last > 0 && Math.abs(ans[last]) > EPS) {
			last--;
		}
		double [] trimmed = new double [last + 1];
		for (int i = 0; i <= last; i++) {
			trimmed[i] = ans[i];
		}
		return trimmed;
	}
	/**
	 * This function computes the polynomial function which is the multiplication of two polynoms (p1,p2)
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static double[] mul(double[] p1, double[] p2) {
		double [] ans = ZERO;//
        /** add you code below

         /////////////////// */
		return ans;
	}
	/**
	 * This function computes the derivative of the p0 polynomial function.
	 * @param po
	 * @return
	 */
	public static double[] derivative (double[] po) {
		double [] ans = ZERO;//
        /** add you code below

         /////////////////// */
		return ans;
	}
}
