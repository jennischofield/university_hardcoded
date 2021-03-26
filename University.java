/**
 * Recreates a University with a database of students and modules, with methods to
 * calculate averages and get total number of students in the university
 * @author 700040999
 * @version 1.0 11/2/21
 */

public class University {

    private ModuleDescriptor[] moduleDescriptors;

    private Student[] students;

    private Module[] modules;

    boolean multipleStudentsBestGPA;
    boolean multipleModulesBestScore;

    /**
     * @return The number of students registered in the system.
     */
    public int getTotalNumberStudents() {
        //Counts up total students in the university
        int studentCount = 0;
        for(int i = 0; i <students.length; i++){
            if(students[i]!=null){
            studentCount++;
            }
        }
        return studentCount;
    }

    /**
     * @return The student with the highest GPA.
     */
    public Student getBestStudent() {
        //iterates throught the students arrays and finds the one with the best GPA, if there are 2 with the same highest GPA, the multipleStudentsBestGPA
        //variable is set to true
        Student bestStudent =students[0];
        double bestGPA =0;
        multipleStudentsBestGPA = false;
        for(int i = 0; i<students.length;i++){
            if(students[i].getGPA() > bestGPA){
                bestStudent = students[i];
                bestGPA = students[i].getGPA();
            }
        }
        //for safety's sake, in case there are multiple students with the best GPA
        for(int i = 0; i<students.length; i++){
            if(students[i] != bestStudent && students[i].getGPA() == bestGPA){
                multipleStudentsBestGPA = true;
                System.out.println("There are multiple students who have the best GPA");
            }
        }
        //returns the best Student
        return bestStudent;
    }

    /**
     * @return The module with the highest average score.
     */
    public Module getBestModule() {
        //iterates throught the modules arrays and finds the one with the best average score, if there are 2 with the same highest score, the multipleModulesBestScore
        //variable is set to true
        Module bestModule = modules[0];
        double bestAveScore = 0;
        multipleModulesBestScore = false;
        for(int i =0; i <modules.length;i++){
            if(modules[i].getFinalAverageGrade() > bestAveScore){
                bestModule = modules[i];
                bestAveScore = modules[i].getFinalAverageGrade();
            }
        }
        //In case there are multiple modules with the same highest score
        for(int i = 0; i<modules.length;i++){
            if(modules[i]!=bestModule && modules[i].getFinalAverageGrade() ==bestAveScore){
                multipleModulesBestScore = true;
                System.out.println("There are multiple modules which have the best average score.");
            }
        }
        //returns the best Module
        return bestModule;
    }
    
    public boolean arrayContains(Module[]arr,int year, int term, String code){
        //Checks to see if an array already exists in a module array
        for(int i = 0; i <arr.length; i++){
            if(arr[i]!=null && arr[i].getYear() == year &&arr[i].getTerm() == term && arr[i].getDescriptor().getCode() == code){
                return true;
            }
        }

        return false;
    }

    public boolean isInArray(Student [] arr, String c){
        //checks to see if a student already exists in an array of students
        String s = "";
        for(int i = 0; i <arr.length; i++){
            if(arr[i]!=null){  
                s = s.valueOf(arr[i].getId());
                if(s.equals(c)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInArray(ModuleDescriptor [] arr, String c){
        //checks to see if a moduleDescriptor already exists in an array of descriptors
        for(int i = 0; i <arr.length; i++){
            if(arr[i]!= null && arr[i].getCode().equals(c)){
                return true;
            }
        }
        return false;
    }
    public boolean isInArray(StudentRecord[] arr, Student s, Module m){
        //checks to see if a record already exists in an array of StudentRecords
        for(int i = 0; i <arr.length; i++){
            if(arr[i]!=null &&arr[i].getStudent().getId()==s.getId() &&(arr[i].getModule().getDescriptor().getCode().equals(m.getDescriptor().getCode()))&&(arr[i].getModule().getTerm()==m.getTerm()) && (arr[i].getModule().getYear() == m.getYear()))
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        //initialises university object
        University uOK = new University();
        //list of student data to hard code
        String [][] studentHardCode = {{"1000","Ana","F"},{"1001","Oliver","M"},{"1002","Mary","F"},{"1003","John","M"},{"1004","Noah","M"},{"1005","Chico","M"},{"1006","Maria","F"},{"1007","Mark","X"},{"1008","Lia","F"},{"1009","Rachel","F"}};
        //initialises students array to an array of Students with the liength of the hardcode
        uOK.students = new Student[studentHardCode.length];
        for(int i = 0; i<studentHardCode.length; i++){
            if(uOK.isInArray(uOK.students, studentHardCode[i][0]) ==false)
                //extracts int from the hardcode, as well as char for id and gender respectively
                uOK.students[i] = new Student(Integer.parseInt(studentHardCode[i][0]), studentHardCode[i][1], (studentHardCode[i][2]).charAt(0));
            else
                //throws exception if the ID isn't unique 
                throw new RuntimeException("ID must be unique");
        }
        //hard code for descriptor array
        String [] descriptorNameHardCode ={"Real World Mathematics", "Programming", "Data Structures", "Object-Oriented Programming", "Information Systems", "Thermal Physics"};
        String [] descriptorCodeHardCode = {"ECM0002","ECM1400", "ECM1406", "ECM1410","BEM2027","PHY2023"};
        double [][] descriptorWeightsHardCode ={{0.1,0.3,0.6},{0.25,0.25,0.25,0.25},{0.25,0.25,0.5},{0.2,0.3,0.5},{0.1,0.3,0.3,0.3},{0.4,0.6}};
        //initialises moduleDescriptors to an array of moduleDescriptors with the length of the hard code
        uOK.moduleDescriptors = new ModuleDescriptor[descriptorNameHardCode.length];
        for(int i = 0; i <descriptorNameHardCode.length; i++){
            if(uOK.isInArray(uOK.moduleDescriptors, descriptorCodeHardCode[i]) ==false)
                uOK.moduleDescriptors[i] = new ModuleDescriptor(descriptorNameHardCode[i],descriptorCodeHardCode[i],descriptorWeightsHardCode[i]);
            else
                //throws exception if the class code isn't unique
                throw new RuntimeException("Class code must be unique");
        }
        //hardcode for modules and studentRecords
        int [] moduleCSVStudentHardCode = {1000,1001,1002,1003,1004,1005,1006,1007,1008,1009,1000,1001,1002,1003,1004,1005,1006,1007,1008,1009,1000,1001,1002,1003,1004,1005,1006,1007,1008,1009,1000,1001,1002,1003,1004,1005,1006,1007,1008,1009};
        String [] moduleCSVCodeHardCode = {"ECM1400","ECM1400","ECM1400","ECM1400","ECM1400","PHY2023","PHY2023","PHY2023","PHY2023","PHY2023","BEM2027","BEM2027","BEM2027","BEM2027","BEM2027","ECM1400","ECM1400","ECM1400","ECM1400","ECM1400","ECM1406","ECM1406","ECM1406","ECM1406","ECM1406","ECM1406","ECM1406","ECM1406","ECM1406","ECM1406","ECM1410","ECM1410","ECM1410","ECM1410","ECM1410","ECM0002","ECM0002","ECM0002","ECM0002","ECM0002"};
        int [] moduleCSVYearHardCode = {2019,2019,2019,2019,2019,2019,2019,2019,2019,2019,2019,2019,2019,2019,2019,2019,2019,2019,2019,2019,2020,2020,2020,2020,2020,2020,2020,2020,2020,2020,2020,2020,2020,2020,2020,2020,2020,2020,2020,2020};
        double[][] moduleCSVMarksHardCode = {{9 ,10, 10, 10},{8, 8, 8, 9},{5,5,6,5},{6,4,7,9},{10,9,10,9},{9 ,9},{6, 9},{5, 6},{9, 7},{8, 5},{10 ,10, 9.5, 10},{7, 8.5, 8.2, 8},{6.5,7.0,5.5,8.5},{5.5,5,6.5,7},{7,5,8,6},{9 ,10, 10, 10},{8, 8, 8, 9},{5,5,6,5},{6,4,7,9},{10,9,8,9},{10 ,10, 10},{8, 7.5, 7.5},{9,7,7},{9,8,7},{2,7,7},{10 ,10, 10},{8, 7.5, 7.5},{10,10,10},{9,8,7},{8,9,10},{10 ,9, 10},{8.5,9,7.5},{10,10,5.5},{7,7,7},{5,6,10},{8 ,9, 8},{6.5,9,9.5},{8.5,10,8.5},{7.5,8,10},{10, 6, 10}};    
        byte [] moduleCSVTermHardCode = {1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2};
        //initialises modules to an array of Modules with length 7
        uOK.modules = new Module[7];
        //traverses module in the uni
        for(int k = 0; k < uOK.modules.length; k++){
            for(int i = 0; i< moduleCSVCodeHardCode.length; i++){//traverses hardcode
                if(uOK.arrayContains(uOK.modules, moduleCSVYearHardCode[i],moduleCSVTermHardCode[i],moduleCSVCodeHardCode[i]) == false){//checks if module already exists
                    for(int j = 0; j< uOK.moduleDescriptors.length; j++){//traverses module descriptors
                        if(uOK.moduleDescriptors[j].getCode().equals(moduleCSVCodeHardCode[i])){
                            uOK.modules[k] = new Module(moduleCSVYearHardCode[i],moduleCSVTermHardCode[i],uOK.moduleDescriptors[j]);
                        }
                    }
                }
            }
        }
        //modules, students, and descriptors initialised
        StudentRecord [] records = new StudentRecord[moduleCSVStudentHardCode.length];
        for( int i = 0; i <moduleCSVMarksHardCode.length; i++){
            for(int j = 0; j <uOK.students.length; j++){
                if(moduleCSVStudentHardCode[i] == uOK.students[j].getId()){//if the student matches
                    for(int k = 0; k < uOK.modules.length; k++){
                        if(uOK.isInArray(records,uOK.students[j],uOK.modules[k]) == false && moduleCSVCodeHardCode[i].equals(uOK.modules[k].getDescriptor().getCode())){
                            //and the module matches, then initialise the record at i to a new StudentRecord
                            records[i] = new StudentRecord(uOK.students[j],uOK.modules[k],moduleCSVMarksHardCode[i]);
                        }
                    }
                }
            }
        }
        //passes the StudentRecords to each of the Students in the students array
        for(int i = 0; i <uOK.students.length;i++){
            StudentRecord [] passedRecords = new StudentRecord[4];
            int counter = 0;
            for(int j = 0; j<records.length; j++){
                if(uOK.students[i].getId() == records[j].getStudent().getId()){
                    passedRecords[counter] = records[j];
                    counter ++;
                }
            }

            uOK.students[i].setRecords(passedRecords);
        }
        //passes the StudentRecords to each of the Modules in the modules array
        for(int i = 0; i < uOK.modules.length; i++){
            StudentRecord [] passedRecordsModules = new StudentRecord[20];
            int moduleCounter = 0;
            for(int j = 0; j <records.length; j++){
                if(uOK.modules[i].getDescriptor().getCode() == records[j].getModule().getDescriptor().getCode()){
                    passedRecordsModules[moduleCounter] = records[j];
                    moduleCounter++;
                }
            }

            uOK.modules[i].setRecords(passedRecordsModules);
        }
        
        //student records initialised to students and modules
        
        for(int i = 0; i <uOK.students.length;i++){
            uOK.students[i].setGPA();
        }
        //GPAs calculated and set
        for(int i = 0; i<uOK.modules.length;i++){
          uOK.modules[i].setFinalAverageGrade();
        }
        //average grades of the modules set

        for(int i = 0; i< uOK.students.length; i++){
            for(int j = 0; j<uOK.students[i].getRecords().length; j++){
                uOK.students[i].getRecords()[j].setAboveAverage(uOK.students[i].getRecords()[j].getModule().getFinalAverageGrade());
            }
        }
        //Above average set
        //Print reports of the university
        System.out.println("The UoK has " + uOK.getTotalNumberStudents() + " students.");
        //best module
        System.out.println("The best module is: " + uOK.getBestModule().toString());
        //best student
        System.out.println("The best student is:");
        System.out.println(uOK.getBestStudent().printTranscript());
    }
}
