import com.RedLi.utils.WriteUtils;
import org.junit.Test;

import java.io.IOException;

public class WriteUtilsTest {

    @Test
    public void writeExercisesTest() {
        String[] str = new String[5];
        str[0] = "3 × 9 × (3 + 10)";
        str[1] = "6 × (7 - 5)";
        str[2] = "(3 + 5) × 2 × 10";
        str[3] = "(9 + 4) × 1 × 7";
        str[4] = "0 + 5 - (8 - 7)";
        WriteUtils wu = new WriteUtils();
        try {
            wu.writeExercises(str,"Exercises.txt", 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeAnswersTest() {
        String[] str = new String[5];
        str[0] = "351";
        str[1] = "12";
        str[2] = "160";
        str[3] = "91";
        str[4] = "4";
        WriteUtils wu = new WriteUtils();
        try {
            wu.writeAnswers(str,"Answers.txt", 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
