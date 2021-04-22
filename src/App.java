import java.util.ArrayList;

public class App {
    static String[] one = {"3x=8"};
    static String[] two = {"2x+y=3", "3x-3y=9"};
    static String[] three = {"3x+3y+z=-3", "2x-3y-4z=-5", "5x+4y-z=10"};
    static String[] four = {"x-3y+z+a=2","3x-4y+z-5a=0", "0x+2y-z+a=1", "2x+0y+0z+a=12"};
    public static void main(String[] args) throws Exception {
        EqSystemTester();
    }

    public static void EqSystemTester(){

        EqSystem system1 = new EqSystem(one);
        Utilities.printArray(system1.ladderSolve(system1.gauss()).results);

        EqSystem system2 = new EqSystem(two);
        Utilities.printArray(system2.ladderSolve(system2.gauss()).results);

        EqSystem system3 = new EqSystem(three);
        Utilities.printArray(system3.ladderSolve(system3.gauss()).results);

        EqSystem system4 = new EqSystem(four);
        Utilities.printArray(system4.ladderSolve(system4.gauss()).results);
    }
}
