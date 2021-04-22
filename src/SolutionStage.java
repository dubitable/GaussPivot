import java.util.ArrayList;

public class SolutionStage {
    public Double[] results;
    public ArrayList<Double>[] hist;

    public SolutionStage(Double result, ArrayList<Double>[] h){
        results = new Double[1];
        results[0] = result;
        hist = h;
    }

    public SolutionStage(Double[] r, ArrayList<Double>[] h){
        results = r;
        hist = h;
    }
}
