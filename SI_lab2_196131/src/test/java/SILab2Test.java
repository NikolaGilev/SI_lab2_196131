import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    private List<Time> timesList = new ArrayList<>();
    private List<Integer> result = new ArrayList<>();

    @Test
    void testEveryBranch(){
        RuntimeException ex;

        //The hours are smaller than the minimum
        this.timesList = new ArrayList<>();
        this.timesList.add(new Time(-1,1,30));
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(timesList));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        //The hours are grater than the maximum
        this.timesList = new ArrayList<>();
        this.timesList.add(new Time(25,1,30));
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(timesList));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        //The minutes are not valid
        this.timesList = new ArrayList<>();
        this.timesList.add(new Time(23,-1,30));
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(timesList));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));

        //The seconds are not valid
        this.timesList = new ArrayList<>();
        this.timesList.add(new Time(1,1,90));
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(timesList));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        //The time is greater than the maximum
        this.timesList = new ArrayList<>();
        this.timesList.add(new Time(24,1,0));
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(timesList));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        // timesList:{hours=1, minutes=1, seconds=30}
        this.timesList = new ArrayList<>();
        this.timesList.add(new Time(1,1,30));
        result.add(3690);
        assertEquals(result,SILab2.function(timesList));

        // timesList:{hours=1, minutes=1, seconds=30}, {hours=1, minutes=30, seconds=15},{hours=24, minutes=0, seconds=0}
        this.timesList.add(new Time(1,30,15));
        this.timesList.add(new Time(24,0,0));
        result.add(5415);
        result.add(86400);
        assertEquals(result,SILab2.function(timesList));

        result = new ArrayList<>();
        timesList = new ArrayList<>();
    }

    @Test
    void testMultipleCondition(){
        RuntimeException ex;

        //if (hr < 0 || hr > 24) //D
        // => T X
        // => F T
            //The hours are smaller than the minimum
        this.timesList = new ArrayList<>();
        this.timesList.add(new Time(-1,1,30));
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(timesList));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

            //The hours are grater than the maximum
        this.timesList = new ArrayList<>();
        this.timesList.add(new Time(25,1,30));
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(timesList));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        // => F F
            //if (min < 0 || min > 59)
            // => T X
            // => F T
                //The minutes are not valid
        this.timesList = new ArrayList<>();
        this.timesList.add(new Time(23,-1,30));
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(timesList));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));

            // => F F
                //if (sec >= 0 && sec <= 59)
                // => T T
                    // timesList:{hours=1, minutes=1, seconds=30}
        this.timesList = new ArrayList<>();
        this.timesList.add(new Time(1,1,30));
        result.add(3690);
        assertEquals(result,SILab2.function(timesList));

                // => F X
                // => T F
                    //The seconds are not valid
        this.timesList = new ArrayList<>();
        this.timesList.add(new Time(1,1,90));
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(timesList));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        //if (hr == 24 && min == 0 && sec == 0)
            // => T T T
        // timesList:{hours=24, minutes=0, seconds=0}
        this.timesList = new ArrayList<>();
        this.result = new ArrayList<>();
        this.timesList.add(new Time(24,0,0));
        result.add(86400);
        assertEquals(result,SILab2.function(timesList));

            // => F X X
            // => T F X
            // => T T F
                //The time is greater than the maximum
        this.timesList = new ArrayList<>();
        this.timesList.add(new Time(24,1,0));
        ex = assertThrows(RuntimeException.class, ()->SILab2.function(timesList));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        result = new ArrayList<>();
        timesList = new ArrayList<>();
    }

}
