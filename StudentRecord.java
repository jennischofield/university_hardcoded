/**
 * Defines a record of a student, with marks for a certain module. Contains 
 * methods to calculate final scores for that module as well as if the student is 
 * above the class average
 * @author 700040999
 * @version 1.0 11/2/21
 */
public class StudentRecord {

    private Student student;
    
    private Module module;
    
    private double[] marks;
    
    private double finalScore;
    
    private Boolean isAboveAverage;
    
    public StudentRecord(Student s, Module m, double[] g){
       //Constructor for Student Record, takes in Student s, Module m, and double g for marks
        student =s;
       module = m;
       marks = g;
       }
    public double getFinalScore(){
        //adds up all the final scores of the module of mark *weight
        finalScore = 0;
        for(int i = 0; i < module.getDescriptor().getWeights().length; i++){
            finalScore +=module.getDescriptor().getWeights()[i] * marks[i];
        }
        //Rounds off numbers to 2 decimal places
        finalScore = (int)(finalScore*100.0 +.5)/100.0;
        return finalScore;
       }
    public Module getModule(){
        //returns module for this StudentRecord
        return module;
       }
    public Student getStudent(){
        //returns student for this StudentRecord
        return student;
       }
    public double[] getMarks(){
        //returns marks for this StudentRecord
        return marks;
    }
    public boolean getAboveAverage(){
        //returns whether or not the student is above the average in the class
        return isAboveAverage;
    }
    public void setAboveAverage(double classAverage){
        //sets the aboveaverage depending on the class average (calculated in the module)
        if(finalScore > classAverage)
        isAboveAverage =true;
        else
        isAboveAverage= false;
        
    }
    public String toString(){
        return "Module: "+ module + "\nStudent:" + student;
    }
}
