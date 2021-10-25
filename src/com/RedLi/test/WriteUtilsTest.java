import com.RedLi.utils.WriteUtils;
import org.junit.Test;

import java.io.IOException;

public class WriteUtilsTest {

    @Test
    public void writeUtilsTest() {
        StringBuffer writeFile_s = new StringBuffer("1、9 + 9'1/5 + 5 - 3 = " + "\n" + "2、1/2 + 7'6/13 = ");
        WriteUtils wu = new WriteUtils();
        try {
            wu.writeUtils(writeFile_s, "Exercises.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
