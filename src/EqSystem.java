import java.util.ArrayList;
import java.util.Arrays;

public class EqSystem {
    private Equation[] equations;
    private Double[][] coefArray;
    public ArrayList<Stage> stages;
    public ArrayList<SolutionStage> solStages;

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
        stages = new ArrayList<Stage>();
        solStages = new ArrayList<SolutionStage>();
    }

    public Stage gauss(){
        Stage stage = new Stage(coefArray, (ArrayList<Double>[]) new ArrayList[0]);
        stages.add(stage);
        return gauss(stage);
    }

    public Stage gauss(Stage stage){
        Double[][] coefArr = stage.coefArr;
        ArrayList<Double>[] hist = stage.history;

        if (coefArr.length == 1){
            Double result = stage.coefArr[0][1] / stage.coefArr[0][0];
            stage = new Stage(result, stage.history);
            stages.add(stage);
            return stage;
        }

        Double[][] newCoefArr = new Double[coefArr.length - 1][coefArr[0].length - 1];
        ArrayList<Double>[] newHist = (ArrayList<Double>[]) new ArrayList[hist.length + 1];
        Double[] ref = coefArr[0];
        Double mult1 = ref[0];
        
        for (int i = 1; i < coefArr.length; i++){
            Double[] coefs = coefArr[i];
            Double mult2 = coefs[0];
            for (int j = 1; j < coefs.length; j++){
                newCoefArr[i-1][j-1] = (ref[j] * mult2) - (coefs[j] * mult1);
            }  
        }

        for (int i = 0; i < hist.length; i++){
            newHist[i] = hist[i];
        }
        ArrayList<Double> refList = new ArrayList<Double>();
        for (int i = 0; i < ref.length; i++){
           refList.add(ref[i]);
        }
        newHist[newHist.length-1] = refList;

        Stage newStage = new Stage(newCoefArr, newHist);
        stages.add(newStage);

        return gauss(newStage);
    }

    public SolutionStage ladderSolve(){
        return ladderSolve(stages.get(stages.size() - 1));
    }

    public SolutionStage ladderSolve(Stage stage){
        return ladderSolve(new SolutionStage(stage.result, Utilities.reverseArray(stage.history)));
    }

    public SolutionStage ladderSolve(SolutionStage solStage){
        if (solStage.hist.length == 0){
            return solStage;
        }
        ArrayList<Double> equation = solStage.hist[0];
        Double sum = 0.0;
        for (int i = 1; i < equation.size() - 1; i++){
            sum += equation.get(i) * solStage.results[i-1];
        }
        Double newresult = (equation.get(equation.size() - 1) - sum) / equation.get(0);
        Double[] resultArr = new Double[solStage.results.length + 1];
        resultArr[0] = newresult;
        for (int i = 1; i < resultArr.length; i++){
            resultArr[i] = solStage.results[i-1];
        }
        ArrayList<Double>[] newHist = Arrays.copyOfRange(solStage.hist, 1, solStage.hist.length);

        SolutionStage outputStage = new SolutionStage(resultArr, newHist);
        solStages.add(outputStage);
        return ladderSolve(outputStage);
    }



    public Double[][] getCoefArray(){
        return coefArray;
    }

    public void printStages(){
        for (Stage stage : stages){
            try {
                Utilities.printArray(stage.coefArr);
                System.out.println();
                Utilities.printArray(stage.history);
            }
            catch (Exception e){
                System.out.println(stage.result);
                System.out.println();
                Utilities.printArray(stage.history);
            }
            System.out.println("---------------");
        }
    }
}
