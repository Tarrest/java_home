import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPoint {

    @Test
    public void testDistanceCalculating() {
        Point p = new Point(10, -20, 15, 40);
        Assert.assertEquals(p.distance(), 60.207972893961475);
    }

}
