

public class Instructions {

   


    //Will return binary for add function
    public static String add(String rs, String rt, String rd){

        //Parse $zero to $0
        if(rt.startsWith("$zero"))
        {
            String temp = rt.substring(5);
            rt = "$0" + temp;
        }

        String retString = "";
        retString += "000000";

        //Checking for Invalid Arguments
        if((functions.registerToBinary(rs).equals("$")) || (functions.registerToBinary(rt).equals("$")) 
        || (functions.registerToBinary(rd).equals("$")))
        {
            String temp;
            if (!rt.startsWith("$0"))
            {
                temp = rt.substring(3);
                rt = rt.substring(0,3); //Make rt a valid argument
            }
            else
            {
                temp = rt.substring(2);
                rt = rt.substring(0,2); //Make rt a valid argument
            }
          
            if(!temp.startsWith("#")){
                return "invalid arguments";
            }
    

            if(functions.registerToBinary(rt).equals("$"))
            {
                return "invalid arguments";
            }

            
        }


        retString+= " " + functions.registerToBinary(rs) + " " + functions.registerToBinary(rt) + " " + 
        functions.registerToBinary(rd) + " 00000 " + "100000";


        return retString;
    }


    public static String addi(String rs, String rt, String imm){


        String bin;
        //parse imm to bin
        if (imm.indexOf("#") != -1)
        {
            imm = imm.substring(0,(imm.indexOf("#")));
        }
        
        try
        {
            
            
            Integer immediate = Integer.parseInt(imm);
            bin = Integer.toBinaryString(0x10000 | immediate).substring(1);
            
            
        }
        catch(Exception e){
            System.out.println("invalid arguments");
            return "";
        }


        


        String retString = "";
        retString += "001000";

        retString+= " " + functions.registerToBinary(rs) + " " + functions.registerToBinary(rt) 
        + " " + bin;


        return retString;
    }


}
