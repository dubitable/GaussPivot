public class App {
    static String[] one = {"3x=8"};
    static String[] two = {"2x+y=3", "3x-3y=9"};
    static String[] three = {"3x+3y+z=-3", "2x-3y-4z=-5", "5x+4y-z=10"};
    static String[] four = {"x-3y+z+a=2","3x-4y+z-5a=0", "0x+2y-z+a=1", "2x+0y+0z+a=12"};
    public static void main(String[] args) throws Exception {
        EqSystemTester();
    }
    public static void EquationTester(){
        Equation equation1 = new Equation("3x+3y+z=-3");
        System.out.println(equation1.coefs);
        Equation equation2 = new Equation("3x+y-z=-3.5");
        System.out.println(equation2.coefs);
    }
    public static void EqSystemTester(){
        EqSystem system = new EqSystem(four);
        for (Double[] eq : system.getCoefArray()){
            System.out.print("[ ");
            for (Double coef : eq){
                System.out.print(coef + " ");
            }
            System.out.println("]");
        }
    }
}
