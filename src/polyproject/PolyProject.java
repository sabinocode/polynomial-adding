
package polyproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marcello
 */
public class PolyProject {

    /**
     * The main driver method.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Polynomial p1, p2;
        ArrayList<Term> terms = new ArrayList<>();
        ArrayList<Term> terms2 = new ArrayList<>();

        boolean end = false;
        while (!end) {
            System.out.println("Enter coefficient: ");
            int co = scan.nextInt();
            System.out.println("Enter exponent: ");
            int expo = scan.nextInt();
            
            if (scan.nextInt() == -1)
                end = true;
            
            terms.add(new Term(co, expo));
            
            if (end) {
                terms.add(new Term(0, 0));
                terms.add(new Term(0, 0));
            }
        }
        
        end = false;
        while (!end) {
            System.out.println("Enter coefficient for polynomial 2: ");
            int co = scan.nextInt();
            System.out.println("Enter exponent for polynomial 2: ");
            int expo = scan.nextInt();
            
            if (scan.nextInt() == -1)
                end = true;
            
            terms2.add(new Term(co, expo));
        }

        p1 = new Polynomial(terms);
        p2 = new Polynomial(terms2);
        
        System.out.println("\n\n\t" + p1);
        System.out.println(" + \t" + p2);
        System.out.println("_________________________");

        p1.add(p2);
        System.out.println("\t" + p1);
    }
    
}
