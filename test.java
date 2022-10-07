public class test {
    public static void main(String args[]){



        String data = "sub $a0, $a0, $v1#test comment";


         data = data.trim(); //Removes leading and trailing whitespace
         System.out.println(data);
      


         //Section to determine what instruction 
         data = data.replaceAll(",", " ");
         String arg[] = data.split("\\s+");
        
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








         else{
            System.out.println("invalid instruction: " + arg[0]);
         }
         
    }
}
