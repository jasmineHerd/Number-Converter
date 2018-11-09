
package business;

import java.util.ArrayList;

/**
 *
 * @author: 
 */
public class Dec2Bin implements Conversion {
    private String binaryresult, value;
    private ArrayList<String> resultsteps;
    private ArrayList<Integer> remainders;
    private String emsg;
    private boolean valid;
    
    public Dec2Bin(String value) {
        emsg = "";
        this.valid = false;
        this.value = value;
        try {
           long n = Long.parseLong(value);
           if (n < 0 ) {
               emsg = "Bad decimal value: must be positive.";
           } else {
              resultsteps = new ArrayList<>();
              remainders = new ArrayList<>();
              this.binaryresult = "";
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
        
        r = (int)(n % 2);
        long newval = n / 2;
        resultsteps.add(n + " divided by 2 = " + newval + " w/remainder of: "  +r);
        
        if (newval > 0) {
            convertByRecur(newval);
        } 
        remainders.add(r);
    }
    
    @Override
    public String getResult() {
        for(Integer i : remainders) {
            this.binaryresult += String.valueOf(i);
        }
        return this.binaryresult;
    }
    @Override
    public ArrayList<String> getProcessLog() {
        return this.resultsteps;
    }
    @Override
    public String getErrorMsg() {
        return this.emsg;
    }
}
