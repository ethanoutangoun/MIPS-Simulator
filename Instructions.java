

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
          
            if(temp.startsWith("#")){
               //Do nothing
            }
            else
            {
            return "Invalid Arguments";
            }
        }


        retString+= " " + functions.registerToBinary(rs) + " " + functions.registerToBinary(rt) + " " + 
        functions.registerToBinary(rd) + " 00000 " + "100000";


        return retString;
    }


    
}
