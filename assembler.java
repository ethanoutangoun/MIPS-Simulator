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
            //Insert Code here
            




           }
            
           //System.out.println(data);
         }
         myReader.close();

   



         String data = "     addi $t0, $t0, 100#test comment";
         data = data.trim(); //Removes leading and trailing whitespace
         System.out.println(data);
      


         //Section to determine what instruction //Multiple if else statements with startsWith()
         data = data.replaceAll(",", "");
         String arg[] = data.split("\\s+");
         
         if (arg[0].equals("add"))
         {
            if (arg.length >4 && !arg[4].startsWith("#")  && arg[3].indexOf("#") == -1){ //If there are more than 4 args, check if it is a comment
               System.out.println("invalid arguments");
            }
            else
            {
            System.out.println(Instructions.add(arg[2],arg[3],arg[1]));
            }
            

         }


         else if (arg[0].equals("addi"))
         {
            if (arg.length >4 && !arg[4].startsWith("#") && arg[3].indexOf("#") == -1){ //If there are more than 4 args, check if it is a comment
               System.out.println("invalid arguments");
            }
            else{
            System.out.println(Instructions.addi(arg[2],arg[1], arg[3]));
            }
         }
         

         
















       } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       }

    }
 }