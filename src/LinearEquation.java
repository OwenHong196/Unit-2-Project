public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    public LinearEquation(int x1, int y1, int x2, int y2){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    }
    public double distance(){
        return roundedToHundredth(Math.sqrt(Math.pow((y2 - y1),2) + Math.pow((x2 - x1),2)));
    }
    public String slope(){
        if (x1 == x2){
            return "x= " + x1;
        }
        return "" + roundedToHundredth(((double) y2 - y1) / (x2 - x1));
    }
    public double yIntercept(){
        if (x1 == x2){
            return 0;
        }
        return y1 - roundedToHundredth(((double) y2 - y1) / (x2 - x1)) * x1;
    }
    public String equation(){
        if (y1 == y2){
            return "y = " + yIntercept();
        }
        if (x1 == x2){
            return ("undefined");
        }
        if ((y2 - y1) < 0 || (x2 - x1) < 0){
            return "y = " + (-1 * (y2 - y1)) + "/" + (-1 * (x2 - x1)) + "x + " + yIntercept();
        }
        return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x + " + yIntercept();
    }
    public String coordinateForX(double x){
        double yCoord = roundedToHundredth(roundedToHundredth(((double) y2 - y1) / (x2 - x1)) * x + yIntercept());
        return "(" + x + ", " + yCoord + ")";
    }
    public String lineInfo(){
        String info = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 +")";
        info += "\nThe equation of the line between these points is: " + equation();
        info += "\nThe slope of this line is: " + slope();
        info += "\nThe y-intercept of this line is: " + yIntercept();
        info += "\nThe distance between these points is " + distance();
        return info;
    }
    private double roundedToHundredth(double toRound){
        return Math.round(toRound * 100) / 100.0;
    }
}
