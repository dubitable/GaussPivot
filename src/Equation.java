import java.util.ArrayList;

public class Equation { 
    private String equation;
    public ArrayList<Double> coefs;

    public Equation(String eq){
        equation = eq;
        coefs = getCoefs(eq);
    }

    public String getEquation(){
        return equation;
    }

    public static ArrayList<Double> getCoefs(String eq){
        ArrayList<Double> coefs = new ArrayList<Double>();
        int x = 0;
        for (int i = 0; i < eq.length(); i++){
            if (Character.isAlphabetic(eq.charAt(i))){
                String sub = eq.substring(x, i);
                try { coefs.add(Double.valueOf(sub)); }
                catch (Exception e){ coefs.add(Double.valueOf(sub + 1)); }
                x = i+1;
            }      
        }
        coefs.add(Double.valueOf(eq.substring(x+1, eq.length())));
        return coefs;
    }
}
