# VendingMachine
Vending Machine Implementation in Java 
Created by KiruSureshkumar
This is a sample functional java implementation of a vending machine. The main features are 
 * Accepts coins of 1,5,10,25 Cents i.e. penny, nickel, dime, and quarter.
 * Allow user to select products Coke(25), Pepsi(35), Soda(45)
 * Allow user to take refund by canceling the request.
 * Collect selected product and remaining change if any
 * Allow reset operation for vending machine supplier.
VendingMachineFramework is an interface that provides public APIs to the above features
VendingMachineInAction implements VendingMachineFramework and provides the implementation of all the methods 
Stock is a generic class to represent both Cash Stock and Product Stock 
TestNG tests are implemented to test the features
Exceptions are captured graciously by implementing seperate methods
It is created as a Maven project to manage dependencies and build
