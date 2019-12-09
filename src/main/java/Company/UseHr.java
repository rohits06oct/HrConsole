
package Company;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.InputMismatchException;

public class UseHr {
    final static Logger LOGGER = Logger.getLogger(UseHr.class);

    /**
     * HR SOLUTION - Console Application
     */
    public static void main(String[] args) throws IOException, ParseException {
        Hr hr = new Hr();
        System.out.println("\nHi Hr \n Welcome to Employee World \n What you want");
        try {
            hr.hrSolution();
        } catch (NullPointerException nul) {
            LOGGER.error("Your given employee id is not in database");
            hr.hrSolution();
        } catch (InputMismatchException e) {
            LOGGER.error("Enter a valid value");
            hr.hrSolution();
        } catch (IOException e) {
            LOGGER.error("You enter a wrong value");
            hr.hrSolution();
        } catch (ClassCastException cce) {
            LOGGER.error("Data should not be type casted");
            hr.hrSolution();
        } catch (IllegalArgumentException ia) {
            LOGGER.error("You enter invalid value: " + ia.getMessage());
            hr.hrSolution();
        } catch (ParseException e) {
            LOGGER.error("You are not hire any employee");
            hr.hrSolution();
        }
    }
}