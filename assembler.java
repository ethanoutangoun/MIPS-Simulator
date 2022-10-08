import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.HashMap;
import java.util.Scanner; // Import the Scanner class to read text files





public class assembler extends Instructions{

   
    public static void main(String []args) {

      /* 
      if (args.length == 0){
         System.out.println("Please enter argument in command line");
         return;
      }
      */


      HashMap<String,Integer> labels = new HashMap<>();

      int line = 1;

      try {
         //File myObj = new File(args[0]);
         File myObj = new File("test3.asm");
         Scanner myReader = new Scanner(myObj);


         //First Iteration
         while (myReader.hasNextLine()) {


           String data = myReader.nextLine();
           data = data.trim();

           //Removes lines starting with #
           if(!data.startsWith("#") && !(data.length()==1) && !(data.equals("")) )
           {
               
               test.processLabels(data, line, labels);

               if (!(data.endsWith(":")))
               {
                  line+=1;
               }
           }
          
           
         }
         myReader.close();





         
         //Second Iteration
         line = 1;
         myReader = new Scanner(myObj);
         while (myReader.hasNextLine()) 
         {
            String data = myReader.nextLine();
            data = data.trim();
            //Removes lines starting with #, empty lines and labels
           if(!data.startsWith("#") && !(data.length()==1) && !(data.equals("")) && !(data.endsWith(":")))
           {
               
               boolean exit = test.processData(data,labels,line);
               if(!exit)
               {
                  //break;
               }


               //System.out.println(line);
               line+=1;
               
           }
            


         }
         myReader.close();

         




   


         //System.out.println(labels.containsKey("testa"));
         
















       } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       }

    }
 }