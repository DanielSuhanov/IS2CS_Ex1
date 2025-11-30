# Ex1 – Polynomial Functions and JUnit  
### Introduction to Computer Science 2026  
### Ariel University  

**Student:** Daniel Suhanov  
**ID:** 207636481  

---

## Overview
This exercise focuses on implementing numerical and algebraic operations on polynomial functions represented as arrays of doubles.  
For example, the array:

{0.1, 0, -3, 0.2}


represents the polynomial:

0.2x^3 - 3x^2 + 0.1


The assignment includes:
- Implementing static methods to manipulate and evaluate polynomials
- Root-finding using the bisection method (recursive)
- Arc-length approximation and area computation between functions
- String parsing of polynomial expressions
- Writing JUnit tests for each implemented function
- Running and documenting the GUI provided (Ex1_GUI.java)

---

## Implemented Functions

### `double f(double[] poly, double x)`
Evaluates the polynomial at a given value of x.

### `double root_rec(double[] p, double x1, double x2, double eps)`
Finds a root of the polynomial using a recursive bisection method.

### `double[] PolynomFromPoints(double[] xx, double[] yy)`
Constructs a polynomial (degree 1 or 2) from 2 or 3 given points.

### `boolean equals(double[] p1, double[] p2)`
Checks whether two polynomials are equal up to a numerical epsilon threshold.

### `String poly(double[] poly)`
Returns a formatted, human-readable string representation of a polynomial.

### `double sameValue(double[] p1, double[] p2, double x1, double x2, double eps)`
Computes a value x in the interval `[x1, x2]` where the two polynomials have (approximately) the same value.

### `double length(double[] p, double x1, double x2, int numberOfSegments)`
Approximates the arc-length of a polynomial function over the interval.

### `double area(double[] p1, double[] p2, double x1, double x2, int numberOfTrapezoid)`
Approximates the area between two functions using trapezoidal integration.

### `double[] getPolynomFromString(String p)`
Parses a polynomial from a string format (e.g., `"3.1x^2 +2.3x -1.1"`) into a double array representation.

### `double[] add(double[] p1, double[] p2)`
Computes the sum of two polynomials.

### `double[] mul(double[] p1, double[] p2)`
Computes the multiplication of two polynomials.

### `double[] derivative(double[] p)`
Computes the derivative polynomial.

---

## JUnit Tests
The file `Ex1Test.java` includes:
- Tests for polynomial evaluation (`f`)
- Tests for addition, multiplication, and derivative correctness
- Tests for symmetry of methods such as `sameValue` and `area`
- Tests ensuring string parsing correctness (`getPolynomFromString`)
- Tests validating behavior with zero and constant polynomials
- Additional custom tests to verify correctness for edge cases

All required functions in `Ex1.java` are covered by unit tests.

---

## GUI Output (Ex1_GUI)
The GUI displays the polynomial functions visually and invokes the implemented methods.

<img width="661" height="371" alt="576734e621fa9252508262acc95a820e" src="https://github.com/user-attachments/assets/c3ca76d6-a72c-410c-8be8-7bc87012bf42" />

---

## How to Run

### Running the GUI
1. Open the project in IntelliJ
2. Run `Ex1_GUI.java`

### Running the Tests
1. Open `Ex1Test.java`
2. Right-click anywhere in the file → **Run 'Ex1Test'**

---

## Repository Structure

src/
assignments/
Ex1/
Ex1.java
Ex1_GUI.java
Ex1Test.java
StdDraw.java
images/
gui.png
README.md

