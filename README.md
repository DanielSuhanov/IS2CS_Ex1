Ex1 – Polynomial Functions and JUnit
Introduction to Computer Science 2026
Ariel University

Student: Daniel Suhanov
ID: 207636481

This exercise focuses on implementing numerical and algebraic operations on polynomial functions represented as arrays of doubles.
For example, the array:
{0.1, 0, -3, 0.2}
represents the polynomial:
0.2x^3 - 3x^2 + 0.1

The assignment includes:
Implementing static functions to manipulate and evaluate polynomials.
Implementing algorithms such as bisection (root finding), arc-length approximation, and area between functions.
Parsing polynomial strings into array representations.
Creating unit tests (JUnit) for every implemented function.
Running and documenting the GUI output provided with Ex1_GUI.java.
Implemented Functions
double f(double[] poly, double x)
Evaluates the polynomial at a given value of x.
double root_rec(double[] p, double x1, double x2, double eps)
Computes a root of the polynomial in the range [x1, x2] using a recursive bisection method.
double[] PolynomFromPoints(double[] xx, double[] yy)
Computes a polynomial passing through 2 or 3 given points.
Supports linear and quadratic interpolation.
boolean equals(double[] p1, double[] p2)
Checks whether two polynomials represent the same function up to an epsilon threshold.
String poly(double[] poly)
Converts a polynomial array into a human-readable string.
double sameValue(double[] p1, double[] p2, double x1, double x2, double eps)
Finds an x-value in [x1, x2] where the two polynomials have approximately the same value.
double length(double[] p, double x1, double x2, int numberOfSegments)
Approximates the arc-length of a polynomial function between x1 and x2.
double area(double[] p1, double[] p2, double x1, double x2, int numberOfTrapezoid)
Approximates the area between two polynomial functions within the given range.
double[] getPolynomFromString(String p)
Parses a polynomial in string form (e.g., "3.1x^2 +2.3x -1.1") back into polynomial array form.
double[] add(double[] p1, double[] p2)
Computes the sum of two polynomials.
double[] mul(double[] p1, double[] p2)
Computes the multiplication of two polynomials.
double[] derivative(double[] p)
Computes the derivative polynomial.

JUnit Tests
The file Ex1Test.java contains:

Tests for value evaluation (f)
Tests for addition and multiplication of polynomials
Tests for symmetry and mathematical correctness of functions such as sameValue, area
Tests for derivative correctness
Tests verifying the string parser (getPolynomFromString)
Additional tests written specifically to verify edge cases and correctness of each function
All required functions in Ex1.java are covered by dedicated unit tests.
GUI Output
The GUI provided (Ex1_GUI.java) displays a visual representation of the polynomials and uses the implemented methods internally.
Below is the required screenshot of the GUI output:

[image]

How to Run:
Running the GUI
Open the project in IntelliJ.
Run the file Ex1_GUI.java.
Running the Tests
Open Ex1Test.java.
Right-click inside the file and select Run 'Ex1Test'.

Repository Structure
/src/assignments/Ex1/Ex1.java
/src/assignments/Ex1/Ex1_GUI.java
/src/assignments/Ex1/Ex1Test.java
/src/assignments/Ex1/StdDraw.java
/images/gui.png
README.md
