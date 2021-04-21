public class EqSystem {
    private Equation[] equations;
    private Double[][] coefArray;

    public EqSystem(String[] stringEqs){
        int l = stringEqs.length;
        equations = new Equation[l];
        coefArray = new Double[l] [(int) (Math.pow(l, 2) + l) / l];
        for (int i = 0; i < stringEqs.length; i++){
            Equation equation = new Equation(stringEqs[i]);
            equations[i] = equation;
            for (int j = 0; j < equation.coefs.size(); j++){
                coefArray[i][j] = equation.coefs.get(j);
            }
        }
    }

    public void gauss(){
        return;
    }

    public Double[][] getCoefArray(){
        return coefArray;
    }
    
}
