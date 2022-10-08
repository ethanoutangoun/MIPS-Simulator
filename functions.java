import java.util.HashMap;


public class functions {

    public static String registerToBinary(String reg){
       
        switch(reg){
            case "$0":
                return "00000";
            case "$zero":
                return "00000";
            
            case "$v0":
                return "00010";
            case "$v1":
                return "00011";


            case "$a0":
                return "00100";
            case "$a1":
                return "00101";
            case "$a2":
                return "00110";
            case "$a3":
                return "00111";


            case "$t0":
                return "01000";
            case "$t1":
                return "01001";
            case "$t2":
                return "01010";
            case "$t3":
                return "01011";
            case "$t4":
                return "01100";
            case "$t5":
                return "01101";
            case "$t6":
                return "01110";
            case "$t7":
                return "01111";


            case "$s0":
                return "10000";
            case "$s1":
                return "10001";
            case "$s2":
                return "10010";
            case "$s3":
                return "10011";
            case "$s4":
                return "10100";
            case "$s5":
                return "10101";
            case "$s6":
                return "10110";
            case "$s7":
                return "10111";

            case "$t8":
                return "11000";
            case "$t9":
                return "11001";

            case "$gp":
                return "11100";
            case "$sp":
                return "11101";
            case "$fp":
                return "11110";
            case "$ra":
                return "11111";
          
            

            
            






        }
        return "$";
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


    public static boolean processData(String data, HashMap<String,Integer> labels, Integer line)
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
         data = data.replaceAll("\\(", " ");
         data = data.replaceAll("\\)", " ");
         

        
         String arg[] = data.split("\\s+");
        
         //Deal with labels on second pass
        


         //Section to determine what instruction 
         //ADD
         if (arg[0].equals("add"))
         {
            if (arg.length >4 && !arg[4].startsWith("#")  && arg[3].indexOf("#") == -1){ //If there are more than 4 args, check if it is a comment
               System.out.println("invalid arguments");
                return false;


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
                return false;

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
                return false;
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
                return false;
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
                return false;
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
                return false;
            }
            else
            {
                System.out.println(Instructions.slt(arg[2],arg[3], arg[1]));
            }

         }


         //OR
         else if(arg[0].equals("or"))
         {

            if (arg.length >4 && !arg[4].startsWith("#") && arg[3].indexOf("#") == -1)
            { 
                System.out.println("invalid arguments");
                return false;
            }
            else
            {
                System.out.println(Instructions.or(arg[2],arg[3], arg[1]));
                
            }

         }


         //BNE
         else if(arg[0].equals("bne"))
         {

            if (arg.length >4 && !arg[4].startsWith("#") && arg[3].indexOf("#") == -1 )
            { 
                System.out.println("invalid arguments");
                return false;
            }
            else
            {

                
                //Compute offset here so less clunky
                if (labels.containsKey(arg[3]))
                {
                Integer targetLine = labels.get(arg[3]);
                String offset = Integer.toString(targetLine - (line+1));
                System.out.println(Instructions.bne(arg[1],arg[2], offset));
                }
                else
                {
                    System.out.println("invalid label: " + arg[3]);
                    return false;
                }
                
              
               
                
                
            }


         }


        //BEQ

         else if(arg[0].equals("beq"))
         {
            if (arg.length >4 && !arg[4].startsWith("#") && arg[3].indexOf("#") == -1 )
            { 
                System.out.println("invalid arguments");
                return false;
            }
            else
            {

                
                //Compute offset here so less clunky
                if (labels.containsKey(arg[3]))
                {
                Integer targetLine = labels.get(arg[3]);
                String offset = Integer.toString(targetLine - (line+1));


               

                System.out.println(Instructions.beq(arg[1],arg[2], offset));
                }
                else
                {
                    System.out.println("invalid label: " + arg[3]);
                    return false;
                }
                
                
            }



         }

         //JUMP
         else if(arg[0].equals("j"))
         {

            if (arg.length >2 && !arg[2].startsWith("#") && arg[1].indexOf("#") == -1 )
            { 
                System.out.println("invalid arguments");
                return false;
            }

            else
            {

                
                //Compute offset here so less clunky
                if (labels.containsKey(arg[1]))
                {
                Integer targetLine = labels.get(arg[1]);
                String offset = Integer.toString(targetLine - 1);


               
                   
                System.out.println(Instructions.j(offset));
                }
                else
                {
                    System.out.println("invalid label: " + arg[3]);
                    return false;
                }
                
                
            }


           


         }



         //JAl
         else if(arg[0].equals("jal"))
         {

            if (arg.length >2 && !arg[2].startsWith("#") && arg[1].indexOf("#") == -1 )
            { 
                System.out.println("invalid arguments");
                return false;
            }

            else
            {

                
                //Compute offset here so less clunky
                if (labels.containsKey(arg[1]))
                {
                Integer targetLine = labels.get(arg[1]);
                String offset = Integer.toString(targetLine - 1);


               
                   
                System.out.println(Instructions.jal(offset));
                }
                else
                {
                    System.out.println("invalid label: " + arg[3]);
                    return false;
                }
                
                
            }


           


         }



         //LW
         else if(arg[0].equals("lw"))
         {

            if (arg.length >4 && !arg[4].startsWith("#") && arg[3].indexOf("#") == -1 )
            { 
                System.out.println("invalid arguments");
                return false;
            }
            else{

                System.out.println(Instructions.lw(arg[3],arg[1], arg[2]));

            }

            


         }

         //SW
         else if(arg[0].equals("sw"))
         {

            if (arg.length >4 && !arg[4].startsWith("#") && arg[3].indexOf("#") == -1 )
            { 
                System.out.println("invalid arguments");
                return false;
            }
            else{

                System.out.println(Instructions.sw(arg[3],arg[1], arg[2]));

            }

            


         }

         //JR
         else if(arg[0].equals("jr"))
         {

            if (arg.length >2 && !arg[2].startsWith("#") && arg[1].indexOf("#") == -1 )
            { 
                System.out.println("invalid arguments");
                return false;
            }
            else
            {
                System.out.println(Instructions.jr(arg[1]));
            }



         }





         else if(arg.length == 1 && arg[0].equals(""))
         {
            //Do nothing with empty lines
         }


         else{
            
            System.out.println("invalid instruction: " + arg[0]);
            return false;
         }

         return true;
    }








    
    
}
