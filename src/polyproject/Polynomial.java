
package polyproject;

/**
 *
 * @author Marcello
 */
import java.util.ArrayList;
import java.util.Iterator;

public class Polynomial {

    private ArrayList<Term> terms = new ArrayList<>();

    /**
     * Creates a new Polynomial with the given Terms.
     * @param terms
     */
    public Polynomial(ArrayList terms) {
        this.terms = terms;
    }

    /**
     * Returns the terms of the Polynomial.
     * @return terms
     */
    public ArrayList<Term> getTerms() {
        return terms;
    }
    
    /**
     * Adds the given polynomial to this polynomial.
     * @param poly 
     */
    public void add(Polynomial poly) {
        // Add the terms from the other polynomial to this polynomial.
        Iterator<Term> it = terms.iterator();
        Iterator<Term> nit = poly.getTerms().iterator();
        
        ArrayList<Term> temp = new ArrayList<>();   // Temporary ArrayList.
        
        Term compare = it.next();
        Term comparing = nit.next();
        while (it.hasNext()) {
            if (compare.compareTo(comparing) == Term.SAME) {
                temp.add(new Term(compare.getCoefficient() + comparing.getCoefficient(), compare.getExponent()));
                if (nit.hasNext()) {
                    comparing = nit.next();
                    compare = it.next();
                }
                else {
                    comparing = new Term(0, 0);
                    compare = it.next();
                }
            } else if (compare.compareTo(comparing) == Term.LESS_THAN) {
                temp.add(new Term(compare.getCoefficient(), compare.getExponent()));
                compare = it.next();
            } else {
                temp.add(new Term(comparing.getCoefficient(), comparing.getExponent()));
                if (nit.hasNext())
                    comparing = nit.next();
                else {
                    comparing = new Term(0, 0); // Otherwise it will compare to the previous higher term
                }
            }
        }
        terms = temp;
    }

    @Override
    public String toString() {
        String print = "";
        for (Term t : terms)
                print += t.toString() + " + ";
        return print.substring(0, print.length() - 2);
    }
}
