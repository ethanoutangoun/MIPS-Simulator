import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class assembler extends Instructions{

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
           data = data.trim();

           //Removes lines starting with #
           if(!data.startsWith("#"))
           {
            //System.out.println(data);
           }
            


           //System.out.println(data);
         }
         myReader.close();

   



         String data = "   add $v0, $v1, $v1#100";
         data = data.trim(); //Removes leading and trailing whitespace
         System.out.println(data);
      


         //Section to determine what instruction //Multiple if else statements with startsWith()
         data = data.replaceAll(",", "");
         String arg[] = data.split("\\s+");
         
         if (arg[0].equals("add"))
         {

            
            
            System.out.println(Instructions.add(arg[2],arg[3],arg[1]));
            

         }

         

















       } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       }

    }
 }