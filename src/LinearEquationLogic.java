import java.util.Scanner;
public class LinearEquationLogic {
    Scanner scan = new Scanner(System.in);
    public void start(){
        getData();
    }

    private void getData(){
        System.out.println("Welcome user!");
        System.out.println("Enter coordinate 1: ");
        String coor1 = scan.nextLine();
        int coor1X = parse(coor1.substring(1,coor1.indexOf(",")));
        int coor1Y = parse(coor1.substring(coor1.indexOf(",")+1,coor1.length()-1));
        System.out.println("Enter coordinate 2: ");
        String coor2 = scan.nextLine();
        int coor2X = parse(coor2.substring(1,coor2.indexOf(",")));
        int coor2Y = parse(coor2.substring(coor2.indexOf(",")+1,coor2.length()-1));
        LinearEquation equation = new LinearEquation(coor1X,coor1Y,coor2X,coor2Y);
    }

    public static int parse(String num){

        return Integer.parseInt(num);
    }
    public void mainMenu(){
        System.out.println("Main Menu");

    }
}
