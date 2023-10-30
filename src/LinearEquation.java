public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    // PRECONDITION: x1 != x2
    public LinearEquation(int x1, int y1, int x2, int y2){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    }

    public int getX1(){
        return x1;
    }
    public int getX2(){
        return x2;
    }
    public double distance(){
        return roundedToHundredth(Math.sqrt(Math.pow((y2 - y1),2) + Math.pow((x2 - x1),2)));
    }
    public double slope(){
        return roundedToHundredth(((double) y2 - y1) / (x2 - x1));
    }
    public double yIntercept(){
        return (y1 - roundedToHundredth(((double) y2 - y1) / (x2 - x1)) * x1);
    }
    public String equation(){
        String slope = (y2 - y1) + "/" + (x2 - x1);
        double yIntercept = yIntercept();
        if (y1 == y2) {
            return "y = " + yIntercept;
        }
        if (((double)y2 - y1) / (x2 - x1) == 1){
            slope = "";
        }
        if ((x2 - x1) < 0){
            slope = (-1 * (y2 - y1)) + "/" + (-1 * (x2 - x1));
        }else if ((y2 - y1) < 0) {
            slope = (y2 - y1) + "/" + (x2 - x1);
        }
        if ((y2 - y1) % (x2 - x1) == 0){
            slope = ((y2 - y1) / (x2 - x1)) + "";
        }
        String equation = "y = " + slope + "x + " + yIntercept;
        if (yIntercept < 0){
            equation = equation.substring(0, equation.indexOf(" +")) + equation.substring(equation.indexOf("+") + 2);
        }
        if (yIntercept == 0){
            equation = equation.substring(0, equation.indexOf(" +"));
        }
        return equation;
    }
    public String coordinateForX(double x){
        double yIntercept = yIntercept();
        double slope = slope();
        double yCoord = roundedToHundredth(slope) * x + yIntercept;
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
    public String lineInfoUndefined(){
        String info = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 +")";
        info += "\nThe equation of the line between these points is: x = " + x1;
        info += "\nThe slope of this line is: UNDEFINED ";
        info += "\nThe y-intercept of this line is: Not possible";
        info += "\nThe distance between these points is " + distance();
        return info;
    }
    private double roundedToHundredth(double toRound){
        return Math.round(toRound * 100) / 100.0;
    }
}
