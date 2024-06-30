import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HigherThanTheThresholdTest {

    @Test
    void reduceGifts_stop_in_the_middle() {
        int actual = HigherThanTheThreshold.reduceGifts(Arrays.asList(9, 6, 7, 2, 7, 2), 2, 13);
        assertEquals(2, actual);
    }

    @Test
    void reduceGifts_stop_in_the_end() {
        int actual = HigherThanTheThreshold.reduceGifts(Arrays.asList(1, 1, 1, 1, 2, 3, 4), 1, 3);
        assertEquals(1, actual);
    }

    @Test
    void reduceGifts_all_elements_pass() {
        int actual = HigherThanTheThreshold.reduceGifts(Arrays.asList(1, 1, 1, 1, 2, 3, 4), 3, 10);
        assertEquals(0, actual);
    }
    @Test
    void reduceGifts_no_elements_pass() {
        int actual = HigherThanTheThreshold.reduceGifts(Arrays.asList(1, 1, 1, 1, 2, 3, 4), 3, 10);
        assertEquals(0, actual);
    }
    @Test
    void reduceGifts_k_greater_than_size_threshold_excludes() {
        int actual = HigherThanTheThreshold.reduceGifts(Arrays.asList(1, 1, 1, 1, 2, 3, 4), 8, 10);
        assertEquals(0, actual);
    }
    @Test
    void reduceGifts_k_greater_than_size_threshold_includes() {
        int actual = HigherThanTheThreshold.reduceGifts(Arrays.asList(1, 1, 1, 1, 2, 3, 4), 8, 13);
        assertEquals(0, actual);
    }
    @Test
    void reduceGifts_k_is_as_size_threshold_over() {
        int actual = HigherThanTheThreshold.reduceGifts(Arrays.asList(1), 1, 10);
        assertEquals(0, actual);
    }
    @Test
    void reduceGifts_k_is_as_size_threshold_in_boundary() {
        int actual = HigherThanTheThreshold.reduceGifts(Arrays.asList(1), 1, 1);
        assertEquals(0, actual);
    }
}