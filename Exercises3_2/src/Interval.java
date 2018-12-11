public class Interval {
    private final double Min, Max;

    public Interval(double min, double max){
        Min = min;
        Max = max;
    }

    public boolean contains(double x)
    {
        return (x >= this.Min || x <= this.Max);
    }

    public boolean intersects(Interval b){
         return (b.Min > 0 && b.Max > 0 && b.Min > this.Min && b.Max < this.Max);
    }

    public String toString(){
        return ("\nThe interval: ( "+this.Min+", "+this.Max+")");
    }

    public static void main(String[] args){
        double min = Double.parseDouble(args[0]);
        double max = Double.parseDouble(args[1]);

        Interval interval = new Interval(min, max);
        StdOut.println(interval.contains(2.5));
        Interval b = new Interval(0.5, 1.0);
        StdOut.println(interval.intersects(b));
        StdOut.println(interval.toString());
    }
}
