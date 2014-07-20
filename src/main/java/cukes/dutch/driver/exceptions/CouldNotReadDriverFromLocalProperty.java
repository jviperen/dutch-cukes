package cukes.dutch.driver.exceptions;

import java.io.IOException;

public class CouldNotReadDriverFromLocalProperty extends Throwable {
    public CouldNotReadDriverFromLocalProperty(String s, IOException e) {
        System.out.println("Something horribly went wrong!!");
    }
}
