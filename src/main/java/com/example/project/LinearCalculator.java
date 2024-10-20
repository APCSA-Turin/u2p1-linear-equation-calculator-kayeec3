package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;



    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String num1, String num2){ // <--add 2 string parameters to this constructor
        //Finds the index of the comma and uses it to find the x then it turns x into an integer
        // String x1SubString = num1.substring(1, num1.indexOf(",")); 
        // x1 = Integer.parseInt(x1SubString(),4);
        x1 = Integer.parseInt(num1.substring(1, num1.indexOf(",")),10);
        x2 = Integer.parseInt(num2.substring(1, num2.indexOf(",")),10);
        //Finds the index of the comma and the total length of the string which is the subtracted by 1 to remove the ")" this then gets turned into an integer
        y1 = Integer.parseInt(num1.substring(num1.indexOf(",")+1, num1.length()-1),10);
        y2 = Integer.parseInt(num2.substring(num2.indexOf(",")+1, num2.length()-1),10);
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }
    public void setX1(int newX1) {
        this.x1 = newX1;
    }
    public void setY1(int newY1) {
        this.y1 = newY1;
    }
    public void setX2(int newX2) {
        this.x2 = newX2;
    }
    public void setY2(int newY2) {
        this.y2 = newY2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double distance = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
        return roundedToHundredth(distance);
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if (x1==0&&x2==0) {
            return -999.99;
        }
        if (x2 == 0) {
            return (double) y2;
        }
        else if (x1 == 0) {
            return (double) y1;
        }
        else {
            double yInt = (double)y1 - (slope() * x1);
            return roundedToHundredth(yInt);
        }
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope() {
        if(x2-x1==0) {
            return -999.99;
        }
        else {
            double slope = (double)(y2-y1)/(x2-x1);
            return roundedToHundredth(slope);
        }
    }
    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if (slope() == -999.99 ) {
            return "undefined";
        } 
        else if(slope()==0) {
            return "y=" +yInt();
        }
        else if (yInt()==0) {
            return "y=" + slope() + "x";
        }
        if (yInt()<0){
            return "y=" +slope() + "x" + yInt();
        }
        else {
            return "y=" + slope() + "x+" + yInt();
        }
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        double scale = Math.pow(10,2);
        return Math.round(x*scale)/scale;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + getX1() + "," + getY1() + ")";
        str += " and " + "(" + getX2() + "," + getY2() + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
 
        return str;
    }



}