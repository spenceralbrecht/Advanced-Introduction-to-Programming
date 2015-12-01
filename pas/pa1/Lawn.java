//-----------------------------------------------------------
// Lawn.java
// Spencer Albrecht
// 1488178
// Programming Assignment 1
// Tells a user how long it will take them to mow their lawn
//-----------------------------------------------------------

import java.util.Scanner;

class Lawn{
    public static void main( String[] args) {

	double lot_length;
	double lot_width;
	double house_length;
	double house_width;
	double lawn_size;
	double mowing_rate;
	double mowing_time;	
	
	int mowing_hours;
	int mowing_minutes;
	int mowing_seconds;
	
	//Gets the size of the lawn and lot from user 
        Scanner input = new Scanner(System.in);
	System.out.print("Enter the length and width of the lot, in feet: ");
	lot_length = input.nextDouble();
	//System.out.print("Enter the width of the lot, in feet: ");
	lot_width = input.nextDouble();

	System.out.print("Enter the length and width of the house, in feet: ");
	house_length = input.nextDouble();
	//System.out.print("Enter the width of the house, in feet: ");
	house_width = input.nextDouble();
	
	//Calculates the lawn size and displays it to the user
	lawn_size = (lot_length*lot_width)-(house_length*house_width);	
 	System.out.println("The lawn area is " + lawn_size + " square feet.");

	//Gets the mowing rate from the user and calculates the mowing time
	//Mowing rate is in square feet per second
	System.out.print("Enter the mowing rate, in square feet per second: ");
	mowing_rate = Double.parseDouble(input.next());
	
	mowing_time = lawn_size/mowing_rate;

	mowing_seconds = (int) Math.round(mowing_time);
	mowing_minutes = mowing_seconds/60;
	mowing_seconds %= 60;
	mowing_hours = mowing_minutes/60;
	mowing_minutes %= 60; 	

	//mowing_hours = (int) Math.floor((mowing_time/3600));
	//mowing_time -= (mowing_hours*3600);
	
	//mowing_minutes = (int) Math.floor((mowing_time/60));
	//mowing_time -= (mowing_minutes*60);
	
	//mowing_seconds = (int) Math.round(mowing_time);
		
	System.out.print("The mowing time is " + mowing_hours);

	if (mowing_hours == 1) {
	    System.out.print(" hour ");
	}
	else { 
	    System.out.print(" hours ");
	}

	System.out.print(mowing_minutes);

	if (mowing_minutes == 1) {
	    System.out.print(" minute ");
	}
	else {
	    System.out.print(" minutes ");
	}
	
	System.out.print(mowing_seconds);		

	if (mowing_seconds == 1) {
            System.out.println(" second.");
        }
        else {
            System.out.println(" seconds.");
        }

	}
}
