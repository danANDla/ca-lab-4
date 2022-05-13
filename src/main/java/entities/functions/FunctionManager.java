package entities.functions;

import java.util.ArrayList;

public class FunctionManager {
    ArrayList<Function> allFunctions;

    public FunctionManager() {
        allFunctions = new ArrayList<>();
        allFunctions.add(new func1());
    }

    public ArrayList<Function> getAllFunctions() {
        return allFunctions;
    }

    public Function getFunc(int v){
        return allFunctions.get(v);
    }
}
