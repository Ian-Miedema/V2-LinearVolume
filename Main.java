package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        CalculateVolume Volume = new CalculateVolume();
        //initialize object

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        Scanner sc = new Scanner(System.in);
        //initialize scanner and readers to allow for user input

        boolean cont = true;
        String ans;
        //initialize variables needed for the main while

        boolean wrongQuadrant;
        //initialize variable to be used to check the domain values

        double gx;
        double d1;
        double d2;
        double m;
        double b;
        double slice;
        double zero;
        //initialize variables needed to for gathering user input


        System.out.println("This program calculates the volume of rotation of a linear function bound in the first quadrant");
        //describes the project to the user so that they have an understanding of how to properly use the program

        while (cont) {
            //while loop that continues until the user says that they want to stop

            do {
                System.out.println("Your function must pass through the first quadrant");

                System.out.println("For the function f(x) = mx + b please enter the m value");
                m = sc.nextDouble();
                //collects user input for the slope of the linear function

                //------------------------------------------------------------------------------------------------------
                System.out.println("For the function f(x) = mx + b please enter the b value");
                b = sc.nextDouble();
                //collects user input for the vertical shift of the linear function

            }while (m <= 0 && b <= 0);
            //This block of code below makes sure that if the slope is negative then the vertical shift is not negative
            //a negative slope and vertical shift would result in a function that completely misses the first quadrant

            //end do while loop


            //----------------------------------------------------------------------------------------------------------
            if (m != 0){
                zero = -b/m;
                //finds the zero (where of the equation if the slope is not zero

                if (m < 0){
                    System.out.println("Please have your domains less than or equal to: " + zero);
                    //if the slope is negative then the domain values must be less than or equal to the zero
                }
                else if (zero < 0){
                    System.out.println("Please have your domains greater than or equal to: 0");
                    //otherwise if the zero is negative then the domain values must be greater than or equal to 0
                }
                else {
                    System.out.println("Please have your domains greater than or equal to: " + zero);
                    //otherwise the domain values must be greater than or equal to zero

                }//end of if statement

            }
            else {
                zero = 0;
                System.out.println("Please have your domains greater than or equal to: 0");
                //if the slope is 0 then the domain values must be greater than or equal to 0

            }
            //This if statement determines if there are any restrictions on the domain based on the slope and v. shift

            //end of if statement


            //----------------------------------------------------------------------------------------------------------
            do {
                System.out.println("Your domain must correspond to values in the first quadrant");
                //a reminder to the user

                //------------------------------------------------------------------------------------------------------
                do {
                    System.out.println("Enter the lower domain value where the function is in the first quadrant");
                    d1 = sc.nextDouble();

                    System.out.println("Enter the higher domain value where the function is in the first quadrant");
                    d2 = sc.nextDouble();
                    //asks the user to input the domain values

                    wrongQuadrant = Volume.Check(d1,d2);

                }while (wrongQuadrant);
                //uses a method from the other class to check if the domain values are acceptable
                //if they aren't then re-asks the user for them until they enter proper values

                //end of do while loop

            }while ((m < 0 && (d1 >= zero || d2 > zero)) || (b < 0 && (d1 < zero || d2 <= zero)));
            //this do while loop makes sure that the user followed the instructions pertaining to the domain values

            //end of do while loop


            //----------------------------------------------------------------------------------------------------------
            System.out.println("For the function g(x) please enter the value");
            gx = sc.nextDouble();
            //collects user input for the g(x) function

            //----------------------------------------------------------------------------------------------------------
            if (gx < 0){
                gx = 0;

            }//end of if statement

            //this if statement causes any negative values for the g(x) function to be equal to zero so that they don't skew

            //----------------------------------------------------------------------------------------------------------
            System.out.println("Enter the number of iterations you would like");
            slice = sc.nextDouble();
            //collects user input for the number of iterations required

            //----------------------------------------------------------------------------------------------------------
            Volume.SetRestrictions(d1, d2, gx, slice);
            //sets these values in the CalculateVolume class

            //----------------------------------------------------------------------------------------------------------
            System.out.println("The volume of the function f(x) between " + d1 + " and " + d2 +
                    " with the function g(x) as a restriction is: " + Volume.CalcVolume(m, b) + "\n");
            //displays the calculated volume

            //----------------------------------------------------------------------------------------------------------
            System.out.println("Do you want to continue? (type 'no' to quit)");
            ans = br.readLine();
            //asks if the user wants to continue

            if (ans.equalsIgnoreCase("no")) {
                cont = false;

            }
            else{
                System.out.println("\n-------------------------------------------------------------------------------");

            }//end of if statement

            //if the user answers no then the main while loop breaks


            //----------------------------------------------------------------------------------------------------------
            Volume.ResetVolume();
            //this resets the volume in the CalculateVolume class so that it does not add onto the previous calculation

        }//end of while loop

    }//end of main

}//end of main class
