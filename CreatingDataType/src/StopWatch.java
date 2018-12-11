public class StopWatch{
    private long start;
    private boolean active = false;
    private long duration = 0;

    public StopWatch(){
        start = System.currentTimeMillis();
        this.active = true;
    }

    public long getStart() {
        return start;
    }

    public double elapsedTime(){
        long now = System.currentTimeMillis();
        if(this.active)
            return this.duration + (now - start) / 1000.0;
        else
            return this.duration/1000.0;
    }

    public void stop(){
        if(this.active)
            this.duration +=(System.currentTimeMillis() - this.start);
        this.active = false;
    }
    public  void restart(){
        this.duration = 0;
        this.start = 0;
        this.active = false;
    }
    public static void main(String[] args){
        // Compute and time computation using Math.sqrt()
        int n = Integer.parseInt(args[0]);
        StopWatch timer1 = new StopWatch();
        double sum1 = 0.0;
        for(int i = 1; i <= n; i++){
            sum1 += Math.sqrt(i);
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("%e(%.2f seconds)\n", sum1, time1);

        // Compute and time computation using Math.pow()
        StopWatch timer2 = new StopWatch();
        double sum2 = 0.0;
        for(int i = 1; i <=n; i++){
            sum2 += Math.pow(i,0.5);
        }
        timer1.stop();
        timer1.restart();
        double time2 = timer2.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum2, time2);
    }
}