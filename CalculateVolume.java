package com.company;

/**
 * Created by Ian Miedema on 15/11/2017.
 */
public class CalculateVolume {

    //initialize the variables needed
    private double dom1;
    private double dom2;
    private double g;
    private double iterations;
    private double volume;

    public void SetRestrictions (double d1, double d2, double gx, double slice){
        dom1 = d1;
        dom2 = d2;
        g = gx;
        iterations = slice;

    }
    //sets values from the main class

    //------------------------------------------------------------------------------------------------------------------

    public boolean Check (double d1, double d2){

        //initialize local variable
        boolean wrongQuadrant;

        if (d1 < 0){
            System.out.println("The domain values must be in greater than or equal to zero");
            wrongQuadrant = true;
            //if the first domain value is negative then prints out what the user did wrong sets wrongQuadrant to true
        }
        else if (d2 <= d1){
            System.out.println("The first domain must be less than the second domain value");
            wrongQuadrant = true;
            //if the second domain value is less than the first corrects the user and sets wrongQuadrant to true
        }
        else {
            wrongQuadrant = false;
            //if there is nothing wrong with the domain values then sets wrongQuadrant to false

        }//end of if statement

        /*
        //initialize local variable
        DomainCheck f;


        if (d1 < 0){
            f = DomainCheck.NEGATIVE_D1;
        }
        else if (d2 <= d1){
            f = DomainCheck.WRONG_ORDER;
        }
        else {
            f = DomainCheck.OKAY;

        }//end of if else statement

        //sets the enumerated type based on the domain values

        switch (f){
            case NEGATIVE_D1:
                System.out.println("The domain values must be in the first quadrant");
                wrongQuadrant = true;
                break;
            //if the first domain value is negative then prints out what the user did wrong sets wrongQuadrant to true

            case WRONG_ORDER:
                System.out.println("The first domain must be before the second domain value");
                wrongQuadrant = true;
                break;
            //if the second domain value is less than the first corrects the user and sets wrongQuadrant to true

            case OKAY:
                wrongQuadrant = false;
                break;
            //if there is nothing wrong with the domain values then sets wrongQuadrant to false

        }//end of switch statement
*/
        return wrongQuadrant;
        //returns the boolean wrongQuadrant to the main class
    }
    //this method makes sure that the domain values are in the first quadrant

    //------------------------------------------------------------------------------------------------------------------

    public double CalcVolume (double m, double b){

        Volume(m, b);

        return volume;
    }
    //calls a private method within the class then returns the calculated volume

    //------------------------------------------------------------------------------------------------------------------

    private void Volume (double m, double b){

        //initializing local variables
        double height;
        double x;
        double thickness;

        for (int i = 0; i < iterations; i++){

            thickness = (dom2 - dom1)/iterations;
            //calculates the length of each iteration by finding the range of the domain
            //Then this range is divided by the number of iterations needed

            x = dom2 - thickness*i;
            //Allows current iteration to be accounted for in the overall calculated volume
            //Does so by finding the x value at that iteration (the second value of the domain minus the thickness of
            //Each iteration times which iteration is being calculated

            height = m*x + b - g;
            //calculates the height for the current x value using y = mx + b and subtracting the g(x) function

            volume += Math.abs(2*Math.PI*x*height*thickness);
            //Calculates the volume of each iteration by calculating the volume of a rectangular prism
            //The rectangular prism is created by "peeling" off a layer of the cylinder-like shape
                    //the base of the prism is the circumference of the cylinder at that iteration (2*Math.PI*x)
                    //the height of the prism is the y value at that iteration (height)
                    //the width of the prism is the width of each iteration (thickness)
            //This shape is what is created by the rotation of the linear function around the y axis
            //Then adds all the volumes of the iterations together to get the total

        }
        //this for loop runs the number of iterations wanted
    }
    //calculates the volume

    //------------------------------------------------------------------------------------------------------------------

    public void ResetVolume (){
        volume = 0;
    }
    //resets the volume so that if multiple calculations occur they do not accumulate and skew results

}//end of class
