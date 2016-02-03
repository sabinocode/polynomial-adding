
package polyproject;

public class Term implements Comparable {

    public static final int SAME = 5, LESS_THAN = 6, GREATER_THAN = 7;
    private int coefficient;
    private final int exponent;

    /**
     * Creates a new Term with the given coefficient and exponent.
     * @param coefficient
     * @param exponent
     */
    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    /**
     * Gets the coefficient.
     * @return coefficient
     */
    public int getCoefficient() {
        return coefficient;
    }
    
    /**
     * Sets the coefficient equal to the one given.
     * @param co 
     */
    public void setCoefficient(int co) {
        coefficient = co;
    }

    /**
     * Gets the exponent.
     * @return exponent
     */
    public int getExponent() {
        return exponent;
    }

    /**
     * Gets the unicode value of the exponent.
     * @param exponent
     * @return unicode value
     */
    public String getUnicodeChar(int exponent) {
        switch (exponent) {
            case 2:
                return "\u00B2";
            case 3:
                return "\u00B3";
            case 4:
                return "\u2074";
            case 5:
                return "\u2075";
            default:
                return "";
        }
    }


    @Override
    public int compareTo(Object term) {
        Term t = (Term) term;
        if (t.getExponent() == exponent)
            return SAME;
        else if (t.getExponent() < exponent) 
            return LESS_THAN;
        else if (t.getExponent() > exponent) 
            return GREATER_THAN;
        else
            return 0;
    }

    @Override
    public String toString() {
        if (exponent != 0)
            return coefficient + "x" + getUnicodeChar(exponent);
        else if (exponent == 0 && coefficient == 0)
            return "\b\b\b";    // Removes the addition sign.
        else
            return "" + coefficient;
    }

}
