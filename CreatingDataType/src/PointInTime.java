/*
* // Measuring elapsed time
long startTime = System.currentTimeMillis();
// The code being measured
  .......
long estimatedTime = System.currentTimeMillis() - startTime;
*
*
* */


public class PointInTime {
/*    private final long start;
    private long duration = 0;

    public PointInTime(){
        start = System.currentTimeMillis();
    }

    public long getStart(){
        return this.start;
    }*/

    public static void main(String[] args)
    {
        StopWatch p_time = new StopWatch();

        //PointInTime p_time = new PointInTime();
        long time = p_time.getStart();
        //long time = p_time.getStart();
        StdOut.println(time);

    }
}
