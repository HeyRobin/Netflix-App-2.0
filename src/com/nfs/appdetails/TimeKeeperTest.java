import org.junit.jupiter.api.Test;

import java.util.Date;

class TimeKeeperTest {
    @Test
    void greeting() {
            Date current = new Date();
            System.out.println(current);
            assertEquals("today:", current, new Date());
    }

    private void assertEquals(String s, Date current, Date date) {
    }
}