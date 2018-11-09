package business;

/**
 *
 * @author jasmineherd
 */
public class Dec2BinB extends Dec2Num {

    //implement abstract Result in Dec2Num
    public static final String VALUEDESC = "Deminal";
    public static final String RESULTDESC = "Binary";
    public static final int BASE = 2;

    public Dec2BinB(String value) {
        super(value, Dec2BinB.BASE);
    }

    @Override
    public String getResult() {
        String result = "";
        if (super.isValid()) {
            for (int i : super.getRemainders()) {
                result += String.valueOf(i);
            }
        }

        return result;
    }
}
