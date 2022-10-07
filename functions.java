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

    public static void processData(String data)
    {
        data = data.trim(); //Removes leading and trailing whitespace
         System.out.println(data);
      


         

         //Adds space between instruction and first argument
        if(data.indexOf("$") !=-1)
        {
            String temp = data.substring(0, data.indexOf("$"));
            String temp2 = data.substring(data.indexOf("$"));
            data = temp + " " + temp2;

        }

        //Format Data into array
         data = data.replaceAll(",", " ");
         String arg[] = data.split("\\s+");
        

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








         else{
            System.out.println("invalid instruction: " + arg[0]);
         }

    }





    
    
}
