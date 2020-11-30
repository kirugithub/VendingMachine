# VendingMachine
Project Name: Vending Machine Implementation in Java
Purpose: is to showcase my level of knowledge in java and TestNG
Description: This is a sample functional java implementation of a vending machine. The main features are 
 * Accepts coins of 1,5,10,25 Cents i.e. penny, nickel, dime, and quarter.
 * Allow user to select products Coke(25), Pepsi(35), Soda(45)
 * Allow user to take refund by canceling the request.
 * Collect selected product and remaining change if any
 * Allow reset operation for vending machine supplier.
Various Classes implemented:
VendingMachineFramework is an interface that provides public APIs to the above features
VendingMachineInAction implements VendingMachineFramework and provides the implementation of all the methods 
Stock is a generic class to represent both Cash Stock and Product Stock 
TestNGTests is a TestNG class to provide tests for the above features
Exceptions are captured graciously by implementing seperate methods
It is created as a Maven project to manage dependencies and build
Versions used:
Java: JDK 1.8, IntelliJ 2020.2, Maven, TestNG, Git and Github
Usage: Download to an IDE and run TestNGTests.java. There are 2 scenarios tested currently- Test with exact change and test with more coins
Future: More tests will be added
