

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
            if(rt.length()<3)
            {
                return "invalid arguments";
            }

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
            return "invalid arguments";
        
        }


        if(((functions.registerToBinary(rt).equals("$"))  || (functions.registerToBinary(rs).equals("$"))))
        {
            return "invalid arguments";
        }

        String retString = "";
        retString += "001000";

        retString+= " " + functions.registerToBinary(rs) + " " + functions.registerToBinary(rt) 
        + " " + bin;


        return retString;
    }


    public static String and(String rs, String rt, String rd){

        if (rt.indexOf("#")!= -1)
        {
            rt = rt.substring(0,(rt.indexOf("#")));
        }
        

        if((functions.registerToBinary(rs).equals("$")) || (functions.registerToBinary(rt).equals("$")) 
        || (functions.registerToBinary(rd).equals("$")))
        {
            return "invalid arguments";
        }


        String retString = "";
        retString += "000000";

        retString+= " " + functions.registerToBinary(rs) + " " + functions.registerToBinary(rd)
         + " " + functions.registerToBinary(rt) + " 00000 100100" ;
        return retString;

    }



    public static String sll(String rt, String shamt, String rd )
    {

        String bin;
        //parse shamt to bin
        if (shamt.indexOf("#") != -1)
        {
            shamt = shamt.substring(0,(shamt.indexOf("#")));
        }
        
        try
        {
            Integer temp = Integer.parseInt(shamt);
            bin = Integer.toBinaryString(0x20 | temp).substring(1);
        }
        catch(Exception e){
            return "invalid arguments";
        }

        if(((functions.registerToBinary(rt).equals("$"))  || (functions.registerToBinary(rd).equals("$"))))
        {
            return "invalid arguments";
        }


        String retString = "000000 00000 ";
        retString+= functions.registerToBinary(rt) + " " + functions.registerToBinary(rd) 
        + " " + bin + " 000000";
        return retString;
    }


    public static String sub(String rs, String rt, String rd)
    {

        if (rt.indexOf("#")!= -1)
        {
            rt = rt.substring(0,(rt.indexOf("#")));
        }
        

        if((functions.registerToBinary(rs).equals("$")) || (functions.registerToBinary(rt).equals("$")) 
        || (functions.registerToBinary(rd).equals("$")))
        {
            return "invalid arguments";
        }


        String retString = "000000 " + functions.registerToBinary(rs) + " " + functions.registerToBinary(rt) + " " + functions.registerToBinary(rd) + " 00000 100010";
        return retString;

    }


    public static String slt(String rs, String rt, String rd)
    {

        if (rt.indexOf("#")!= -1)
        {
            rt = rt.substring(0,(rt.indexOf("#")));
        }
        

        if((functions.registerToBinary(rs).equals("$")) || (functions.registerToBinary(rt).equals("$")) 
        || (functions.registerToBinary(rd).equals("$")))
        {
            return "invalid arguments";
        }



        String retString = "000000 " + functions.registerToBinary(rs) + " " + functions.registerToBinary(rt) + " " + functions.registerToBinary(rd) + " 00000 101010";
        return retString;
    }


}
