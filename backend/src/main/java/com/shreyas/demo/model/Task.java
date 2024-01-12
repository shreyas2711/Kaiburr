package com.shreyas.demo.model;


import java.security.SecureRandom;
import java.time.LocalDateTime;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Task {
    
    @Id
    private String id;                  
    private String candidateName;
    private String name;           //             //
    private String assignee;        //
    private String project;         
    private LocalDateTime startTime;   //
    private String candidateNameProperty;

    
    public void setname(String name){  
        this.name= name;
    }
    public String getname(){
        return name;
    }

                                                                    //name

    public String getid(){

        return id;
    }
    public void setid(String id){ 
        this.id= id;
    }


                                                                         
                                                                         //Id


    public String getassignee(){        
        return assignee;
    }                                                       
                                                                       

    public void setassignee(String assignee){

        this.assignee = assignee;
    }

                                                                         // Taskassignee

    public String getproject(){        
        return project;
    }                                                       

    public void setproject(String project){          

        this.project = project;
    }

                                                                            // PROJECT NAME

    public LocalDateTime getstartTime(){        
        return startTime;
    }                                               


    public void setStartTime(LocalDateTime startTime){          

        this.startTime = startTime;
    }

                                                                        // TaskStartDate

   public void setcandidateName(String candidateName) {
    this.candidateName = candidateName;
    this.candidateNameProperty = generatecandidateNameProperty(candidateName);
     }


     
    public Task() {
        // Generate a unique ID when a new Task object is created
        this.id = generateUniqueId();
    }
    
     public String getcandidateName(){
        return candidateName;
     }

    
         public String getcandidateNameProperty() {
            
            return candidateNameProperty;
        
        
    }


     
    
    private String generateUniqueId() {
        // Logic to generate a unique ID, you can use UUID or any other strategy
        // For simplicity, let's use a simple timestamp-based ID
        return Long.toString(System.currentTimeMillis());
    }

    // public void setCandidateNameProperty(String candidateNameProperty) {
    //     this.candidateNameProperty = candidateNameProperty;
    // }




    private String generatecandidateNameProperty(String candidateName) {
        SecureRandom random = new SecureRandom();
        int candidateNameLength = candidateName.length();

        // Ensure the length of the generated property is 5 or less
        int propertyLength = Math.min(candidateNameLength, 5);



        StringBuilder propertyBuilder = new StringBuilder();
        // propertyBuilder.append(first);
        for (int i = 0; i < propertyLength; i++) {
            int randomIndex = random.nextInt(candidateNameLength);
            propertyBuilder.append(candidateName.charAt(randomIndex));
        }
        // propertyBuilder.append(last);

        return propertyBuilder.toString();
    }

                                                                     

}
