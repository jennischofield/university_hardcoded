/**
 * Defines a module within the University, with a year and term, and a module 
 * general descriptor to get the name and the code and weights of the assignments.
 * @author 700040999
 * @version 1.0 11/2/21
 */
public class Module {
            	
    private int year;
            	
    private byte term;
            	
    private ModuleDescriptor module;
            	
    private StudentRecord[] records;
            	
    private double finalAverageGrade;
    public Module(int y, byte t, ModuleDescriptor m){
        //Constructor for Module. Takes in year, term and module descriptor. In the University class, it is ensured that there are no duplicate modules
        year = y;
        term = t;
        module = m;
    }
    public void setRecords(StudentRecord[] r){
        //sets records for this module
        records = r;
    }
    public int getYear(){
        //gets the year for this module
        return year;
    }
    public byte getTerm(){
        //gets term for this module
        return term;
    }
    public ModuleDescriptor getDescriptor(){
        //gets the ModuleDescriptor for this module
        return module;
    }
    public void setFinalAverageGrade(){
        //Calculates the average of all students in this module
        double grade =0;
        int counter = 0;
        for(int i = 0; i <records.length; i++){
          if(records[i] !=null){ //as array sizes are constant, there's a chance that in the loop of initialising it, there will be null students
              grade += records[i].getFinalScore();
              counter++;
        }
        }
        grade /= counter;
        //rounds off to 2 decimal places, average is under 10.
        String s  = String.format("%.2f", grade);
        grade = Double.parseDouble(s);
        finalAverageGrade = grade;
    }
    public double getFinalAverageGrade(){
        //ensures that the finalaverage is called before trying to return it
        setFinalAverageGrade();
        return finalAverageGrade;
    }
    public String toString(){
        //toString for Module, calls the toString from the moduleDescriptor
        return module.getCode() + ", Term " +term + " in the year " + year + " with a final average grade of "+ finalAverageGrade;
    }
}
