package Utilizator;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ MainTest.class, MainTest2.class })
public class AllTests {

}
