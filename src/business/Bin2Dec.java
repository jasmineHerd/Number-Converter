/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author
 */

public class Bin2Dec implements Conversion{
    public static final String VALUEDESC = "Binary";
    public static final String RESULTDESC = "Decimal";
    private String result, origval;
    private ArrayList<String> resultsteps;
    private String emsg;
    
    private boolean valid;
    
    public Bin2Dec(String value) {
        emsg = "";
        this.origval = value;
        if (isValid(value)) {
            this.valid = true;
            convert(value);
        } else {
            this.valid = false;
            emsg = "Illegal value binary value (must be only zeros and ones";
        }
    }
    private boolean isValid(String v) {
        for (int i=0; i< v.length(); i++) {
            if (v.charAt(i) != '1' && v.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
    public boolean isValid(){
        return this.valid;
    }
    private void convert(String v) {
        long r = 0;
        String reverse = new StringBuilder(v).reverse().toString();
        resultsteps = new ArrayList<>();
        for (int i=0; i < reverse.length(); i++) {
            if (reverse.charAt(i) == '1') {
                long p = (long) Math.pow(2,i);
                r += p;
                resultsteps.add("There is a(n) " + p + " in the number (2^" + i + ")" );
            }
        }
        this.result = String.valueOf(r);
    }
    
    @Override
    public String getResult() {
        return this.result;
    }
    @Override
    public ArrayList<String> getProcessLog() {
        return this.resultsteps;
    }
    @Override
    public String getErrorMsg() {
        return this.emsg;
    }
    
    @Override
    public String getValue(){
        return this.origval;
    }
   
}
