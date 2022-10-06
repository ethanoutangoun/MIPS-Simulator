import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class assembler {

    public static void main(String []args) {

      /* 
      if (args.length == 0){
         System.out.println("Please enter argument in command line");
         return;
      }
      */

      try {
         //File myObj = new File(args[0]);
         File myObj = new File("test1.asm");
         Scanner myReader = new Scanner(myObj);
         while (myReader.hasNextLine()) {
           String data = myReader.nextLine();
            


           //System.out.println(data);
         }
         myReader.close();

   
         System.out.println(functions.registerToBinary("$s1"));

         String test = "   add $v0, $v1, $v1";
         test = test.replaceAll("\\s+","");
        
         System.out.println(test);
         System.out.println(test.startsWith("add"));




       } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       }

    }
 }