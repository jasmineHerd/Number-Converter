
package business;

import java.util.ArrayList;

/**
 *
 * @author jasmineherd
 */
public interface Conversion {
    public String getValue();//input value
    public String getResult();
    public boolean isValid();
    public ArrayList<String> getProcessLog(); 
    public String getErrorMsg();
    
}
