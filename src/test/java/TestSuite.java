import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({PersonTest.class, StudentTest.class})
public class TestSuite {
    // This class remains empty, it is used only as a holder for the above annotations
}