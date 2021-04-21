import java.util.ArrayList;

public class EqSystem {
    private Equation[] equations;
    private ArrayList<Double>[] coefArray;

    public EqSystem(String[] stringEqs){
        equations = new Equation[stringEqs.length];
        coefArray =  (ArrayList<Double>[]) new ArrayList[stringEqs.length];

        for (int i = 0; i < stringEqs.length; i++){
            Equation equation = new Equation(stringEqs[i]);
            equations[i] = equation;
            coefArray[i] = equation.coefs;
        }
    }

    public ArrayList<Double>[] getCoefArray(){
        return coefArray;
    }
    
}
