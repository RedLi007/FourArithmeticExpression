import com.RedLi.utils.Compare;
import org.junit.Test;

import java.io.IOException;

public class CompareTest {

    @Test
    public void compareTest() {
        Compare cp = new Compare();
        try {
            cp.compare("Exercises.txt", "Answers.txt", "Grade.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
