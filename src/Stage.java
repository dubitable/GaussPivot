import java.util.ArrayList;

public class Stage {
    public Double[][] coefArr;
    public ArrayList<Double>[] history;
    public Double result;

    public Stage(Double [][] coefArray, ArrayList<Double>[] hist){
        coefArr = coefArray;
        history = hist;
        result = null;
    }

    public Stage(Double r, ArrayList<Double>[] hist){
        result = r;
        history = hist;
        coefArr = null;
    }
}
