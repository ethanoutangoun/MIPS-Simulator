import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import javax.security.auth.callback.LanguageCallback;


public class test {
    

    public static void main(String args[]){


        HashMap<String,Integer> labels = new HashMap<>();
        String data = "addi $a0, $a0, 100";
        int line = 18;

        processLabels(data, line, labels);

        System.out.println(data);
        processData(data);

       


        //processData(data);

         
         
    }

    public static boolean processLabels(String data, Integer line, HashMap<String,Integer> labels)
    {
         //Adds space between instruction and first argument
         if(data.indexOf("$") !=-1)
         {
             String temp = data.substring(0, data.indexOf("$"));
             String temp2 = data.substring(data.indexOf("$"));
             data = temp + " " + temp2;
 
         }
 
    
 
         //Format Data into array
         data = data.replaceAll(",", " ");
         data = data.replaceAll(":", ": ");
         String arg[] = data.split("\\s+");
 
         if(arg[0].endsWith(":"))
         {
             String labelName = arg[0].substring(0,arg[0].length()-1);
             if (labelName.length()>0 && !labels.containsKey(labelName)){
                 labels.put(labelName, line);
             }
             else if(labelName.length() == 0)
             {
                System.out.println("invalid label: \"" + arg[0] + "\"");
                return false;
             }
             else
             {
                System.out.println("Label already exists: \"" + arg[0] + "\"");
                return false;
             }
 
            
             
 
 
         }
        
         

         return true;
 
    }


    public static void processData(String data)
    {
        data = data.substring(data.indexOf(":")+1);
        data = data.trim(); //Removes leading and trailing whitespace
         //System.out.println(data);
      


         

         //Adds space between instruction and first argument
        if(data.indexOf("$") !=-1)
        {
            String temp = data.substring(0, data.indexOf("$"));
            String temp2 = data.substring(data.indexOf("$"));
            data = temp + " " + temp2;

        }

        //Format Data into array
        data = data.replaceAll(":", ": ");
         data = data.replaceAll(",", " ");
         
         String arg[] = data.split("\\s+");
        
         //Deal with labels on second pass
        


         //Section to determine what instruction 
         //ADD
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

         //ADDI
         else if (arg[0].equals("addi"))
         {
            if (arg.length >4 && !arg[4].startsWith("#") && arg[3].indexOf("#") == -1){ //If there are more than 4 args, check if it is a comment
               System.out.println("invalid arguments");
            }
            else{

            
            System.out.println(Instructions.addi(arg[2],arg[1], arg[3]));
            }
         }


         //AND
         else if(arg[0].equals("and"))
         {

            if (arg.length >4 && !arg[4].startsWith("#") && arg[3].indexOf("#") == -1)
            { 
                System.out.println("invalid arguments");
            }
            else
            {
                System.out.println(Instructions.and(arg[2],arg[3], arg[1]));
            }

         }


         //SLL
         else if(arg[0].equals("sll"))
         {
            if (arg.length >4 && !arg[4].startsWith("#") && arg[3].indexOf("#") == -1)
            { 
                System.out.println("invalid arguments");
            }
            else
            {
                System.out.println(Instructions.sll(arg[2],arg[3], arg[1]));
            }
            
         }


         //SUB
         else if(arg[0].equals("sub"))
         {
            if (arg.length >4 && !arg[4].startsWith("#") && arg[3].indexOf("#") == -1)
            { 
                System.out.println("invalid arguments");
            }
            else
            {
                System.out.println(Instructions.sub(arg[2],arg[3], arg[1]));
            }


         }

         //SLT
         else if(arg[0].equals("slt"))
         {
            if (arg.length >4 && !arg[4].startsWith("#") && arg[3].indexOf("#") == -1)
            { 
                System.out.println("invalid arguments");
            }
            else
            {
                System.out.println(Instructions.slt(arg[2],arg[3], arg[1]));
            }




         }





        


         else if(arg.length == 1 && arg[0].equals(""))
         {
            //Do nothing with empty lines
         }


         else{
            
            System.out.println("invalid instruction: " + arg[0]);
         }

    }



}
