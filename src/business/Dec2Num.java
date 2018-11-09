
package business;

import java.util.ArrayList;

/**
 *
 * @author jasmineherd
 */
public abstract class Dec2Num implements Conversion{
    private String result, value;
    private ArrayList<String> resultsteps;
    private ArrayList<Integer> remainders;
    private String emsg;
    private boolean valid;
    private int base;
    
    
    public Dec2Num(String value,int base){
                 emsg = "";
        this.valid = false;
        this.value = value;
        this.base = base;
        try {
           long n = Long.parseLong(value);
           if (n < 0 ) {
               emsg = "Bad decimal value: must be positive.";
           } else {
              resultsteps = new ArrayList<>();
              remainders = new ArrayList<>();
              this.result = "";
              convertByRecur(n);
           }
        } catch (NumberFormatException e) {
           emsg = "Illegal value: not a decimal integer";
        }
        if(emsg.isEmpty()){
            this.valid=true;
        }
    }
    @Override
    public boolean isValid(){
        return this.valid;
    }
    @Override
    public String getValue(){
        return this.value;
    }
    private void convertByRecur(long n) {
        int r = 0;
        
        r = (int)(n % this.base);
        long newval = n / this.base;
        resultsteps.add(n + " divided by" + this.base +"="+  
                newval + 
                " w/remainder of: "  
                +r);
        
        if (newval > 0) {
            convertByRecur(newval);
        } 
        remainders.add(r);
    }
    @Override
    public ArrayList<String> getProcessLog() {
        return this.resultsteps;
    }
    @Override
    public String getErrorMsg() {
        return this.emsg;
    }
    protected ArrayList<Integer> getRemainders(){
        return this.remainders;
    }
    
    @Override
    public abstract String getResult();
}
