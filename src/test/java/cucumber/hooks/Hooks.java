package cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

public class Hooks  {

    @Before(value = "@ui and not @criticalPath", order = Integer.MIN_VALUE)
    public  void beforeClass() {

    }

    @After(order = Integer.MAX_VALUE)
    public void afterClass() {
    }
}
