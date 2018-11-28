
package business;

/**
 *
 * @author jasmineherd
 */
public class Dec2Hex extends Dec2Num{
    
    public static final String VALUEDESC = "Decimal";
    public static final String RESULTDESC = "Hexadecimal";
    public static final int BASE = 16;
    private static final String hexvals = "0123456789ABCDEF";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public Dec2Hex() {
        super(null, 0);
    }
    
    
    public Dec2Hex(String value){
        super(value, Dec2Hex.BASE);
    }
    
    @Override
    public String getResult(){
        String result = "";
        if(isValid()){
            for(int i: super.getRemainders()){
                
                result += hexvals.substring(i,i+1);
            }
        }
        return result;
    }
    
}
