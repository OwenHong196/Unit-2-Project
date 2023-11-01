import java.util.Scanner;
public class LinearEquationLogic {
    Scanner scan = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome user!");
        boolean end = false;
        while (!end) {
            int option = 0;
            LinearEquation equation = getData();
            if (equation.getX1() == equation.getX2()){
                while (option != 6) {
                    mainMenuUndefined();
                    option = options(equation,true);
                }
                scan.nextLine();
                System.out.print("Would you like to rerun? (yes/no)");
                String rerun = scan.nextLine();
                if (rerun.equals("no")) {
                    end = true;
                }
            }else {
                while (option != 7) {
                    mainMenu();
                    option = options(equation);
                }
                scan.nextLine();
                System.out.print("Would you like to rerun? (yes/no)");
                String rerun = scan.nextLine();
                if (rerun.equals("no")) {
                    end = true;
                }
            }
        }
        System.out.println("Goodbye");
    }

    private LinearEquation getData(){
        System.out.print("Enter coordinate 1: ");
        String coor1 = scan.nextLine();
        int coor1X = parse(coor1.substring(1,coor1.indexOf(",")));
        int coor1Y = parse(coor1.substring(coor1.indexOf(" ")+1,coor1.length()-1));
        System.out.print("Enter coordinate 2: ");
        String coor2 = scan.nextLine();
        int coor2X = parse(coor2.substring(1,coor2.indexOf(",")));
        int coor2Y = parse(coor2.substring(coor2.indexOf(" ")+1,coor2.length()-1));
        if (coor1X == coor2X) {
            System.out.println("VERITCAL LINE!!!!!!");
            LinearEquation equation = new LinearEquation(coor1X,coor1Y,coor2X,coor2Y);
            return equation;
        } else {
            LinearEquation equation = new LinearEquation(coor1X,coor1Y,coor2X,coor2Y);
            return equation;
        }
    }

    public static int parse(String num){

        return Integer.parseInt(num);
    }
    private void mainMenu(){
        System.out.println("Main Menu");
        System.out.println("1. Get slope");
        System.out.println("2. Get distance");
        System.out.println("3. Get y-intercept");
        System.out.println("4. Get equation");
        System.out.println("5. Get y-coordinate for x");
        System.out.println("6. Get overall data");
        System.out.println("7. end");
    }
    private int options(LinearEquation equation){
        System.out.print("Select an option: ");
        int optionNum = scan.nextInt();
        if (optionNum == 1) {
            System.out.println("Slope: " + equation.slope());
        }else if (optionNum == 2) {
            System.out.println("Distance: " + equation.distance());
        }else if (optionNum == 3) {
            System.out.println("Y-intercept: " + equation.yIntercept());
        }else if (optionNum == 4) {
            System.out.println("Equation: " + equation.equation());
        }else if (optionNum == 5) {
            System.out.print("Enter x coordinate: ");
            double x = scan.nextDouble();
            System.out.println("The point on the like is: " + equation.coordinateForX(x));
        }else if (optionNum == 6) {
            System.out.println(equation.lineInfo());
        }else{
            return 7;
        }
        return 0;
    }
    private void mainMenuUndefined(){
        System.out.println("Main Menu");
        System.out.println("1. Get slope");
        System.out.println("2. Get distance");
        System.out.println("3. Get y-intercept");
        System.out.println("4. Get equation");
        System.out.println("5. Get overall data");
        System.out.println("6. end");
    }
    private int options(LinearEquation equation, boolean undefined){
        System.out.println("Select an option:");
        int optionNum = scan.nextInt();
        if (optionNum == 1) {
            System.out.println("Slope: UNDEFINED");
        }else if (optionNum == 2) {
            System.out.println("Distance: " + equation.distance());
        }else if (optionNum == 3) {
            System.out.println("Y-intercept: Not possible" );
        }else if (optionNum == 4) {
            System.out.println("Equation: x = " + equation.getX1());
        }else if (optionNum == 5) {
            System.out.println(equation.lineInfoUndefined());
        }else if (optionNum == 6){
            return 6;
        }else{
            System.out.println("Invalid option, try again;");
        }
        return 0;
    }
}
