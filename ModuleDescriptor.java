/**
 * Defines a module's code, name, and the weights of the assignments.
 * @author 700040999
 * @version 1.0 11/2/21
 */
public class ModuleDescriptor {
    
    private String code;
    
    private String name;
    
    private double[] continuousAssignmentWeights;
    public ModuleDescriptor(String n, String c, double[] caW){
        //Constructor that takes in a name, code and weights of assignments. Name and code must not be null, and the weights must be valid
        if(c == null || n == null){
            throw new RuntimeException("Module name and code must not be null");
        }else{
            code = c;
            name = n;
        }
        if(checkValidWeights(caW) == false){
            throw new RuntimeException("Module weights must be non-negative and add up to 1");
        }else{
            continuousAssignmentWeights = caW;
        }
    }
    public void setCode(String c){
        //In case the code for the class changes
        code = c;
    }
    public String getCode(){
        //returns the module code
        return code;
    }
    public void setName(String n){
        //In case the name for the class changes
        name = n;
    }
    public String getName(){
        // returns the module name
        return name;
    }
    public void setWeights(double[] w){
        //sets the weights, in case a weight needs to be adjusted
        continuousAssignmentWeights = w;
    }
    public String getWeightString(){
        //for testing purposes only, assembles the weights of the module in the [x,y,z] format
        String retString = "[";
        for(int i = 0; i <continuousAssignmentWeights.length-1; i++){
            retString += continuousAssignmentWeights[i] + ",";
        }
        retString += continuousAssignmentWeights[continuousAssignmentWeights.length-1];
        return retString + "]";
    }
    public double[] getWeights(){
        //gets weights of the modules
        return continuousAssignmentWeights;
    }
    public boolean checkValidWeights(double[]w){
        //checks to see if the weights add up to 1 and are nonnegative
        double counter = 0.0;
        for(int i = 0; i <=w.length-1; i++){
            if(w[i] < 0){
                return false;
            }
            counter += w[i];
        }
        if(counter != 1){
            return false;
        }else{
            return true;
        }
    }
    public String toString(){
        //toString, has name, code, weights and if those weights are valid.
        return "Name: " + name + "\nCode:" + code +"\nWeights: " +getWeightString() +"\nValid Weights?: " +checkValidWeights(continuousAssignmentWeights);
    }
    
}
