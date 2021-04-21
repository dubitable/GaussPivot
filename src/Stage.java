import java.util.ArrayList;

public class Stage {
    public Double[][] coefArr;
    public ArrayList<Double>[] history;

    public Stage(Double [][] coefArray, ArrayList<Double>[] hist){
        coefArr = coefArray;
        history = hist;
    }
}
