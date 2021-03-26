/**
 * Defines a student within the university with a name, gender, id and GPA, with 
 * records for each class they're in.
 * @author 700040999
 * @version 1.0 11/2/21
 */
public class Student {
    
    private int id;
    
    private String name;
    
    private char gender;
    
    private double gpa;
    
    private StudentRecord[] records;
    public Student(int i, String n, char g){
        //Constructor, takes in ID, name and gender. ID and name cannot equal null, and gender must either be F,M,X or empty
        if(i == 0 || n == null)
            throw new RuntimeException("ID and Name cannot equal null.");
        else{
            id = i;
            name = n;
        }
        if(g != 'F' &&g!= 'M' &&g != 'X' && g != '\0'){
            throw new RuntimeException("Invalid gender. Gender must be either F, M, X or empty");
        }else{
            gender = g;
        }       
    }
    public void setId(int i){
        //In the case that a student drops out and needs to be reassigned an ID for that year
        id = i;
    }
    public int getId(){
        //returns ID
        return id;
    }
    public void setName(String n){
        //In the case that someone changes their name
        name = n;
       }
    public String getName(){
        //returns name
        return name;
       }
    public void setGender(char g){
        //In the case that someone changes their gender
        gender = g;
       }
    public char getGender(){
        //returns gender
        return gender;
       }
    public void setRecords(StudentRecord[] r){
        //sets the records of a student.
        records = r;
       }
    public StudentRecord[] getRecords(){
        //returns the records of a student.
        return records;
       }
    public void setGPA(){
       //calculates GPA in the sense of average of all modules's grades, not as the USA's 4.0 system.
        double gpaCalc = 0.0;
       for(int i = 0; i < records.length; i++){
          gpaCalc +=records[i].getFinalScore();
       }
       gpaCalc/=records.length;
       //rounds GPA to 2 decimal places, all GPAs are under 10.
       String s  = String.format("%.2f", gpaCalc);
       gpaCalc = Double.parseDouble(s);
       gpa = gpaCalc;
       }
    public double getGPA(){
        //ensures that setGPA is called before trying to return GPA.
        setGPA();
        return gpa;
       }
    public String toString(){
        //toString for Student
        return "Name: " +name+ "\nId:" + id + "\nGender"+gender;
       }
    public String printTranscript() {
        //Transcript String 
        String retString = "\t\t\tUniversity of Knowledge - Official Transcript";
        retString += "\n\n\nID: " + id;
        retString += "\nName: " + name;
        retString += "\nGPA: " + gpa + "\n\n";
        for(int i = 0; i< records.length;i++){
            
            retString += "|" +records[i].getModule().getYear();
            retString += "|" + records[i].getModule().getTerm();
            retString += "|" + records[i].getModule().getDescriptor().getCode();
            retString += "|" + records[i].getFinalScore() +"|\n";
            //separates by year and term
            if((i != records.length-1 && i!=records.length) && (records[i].getModule().getTerm() != records[i+1].getModule().getTerm() ||records[i].getModule().getYear() != records[i+1].getModule().getYear()))
                retString += "\n";
            }
        return retString;
        
    }
}
