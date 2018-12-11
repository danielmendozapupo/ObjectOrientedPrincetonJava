import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class HistoImplement {
    public static void main(String[] args){

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        Counter[] hits = new Counter[n];

        for(int i = 0; i < n;i++){
            hits[i] = new Counter(i + "",trials);
        }


        for(int t = 0; t < trials; t++){
            hits[StdRandom.uniform(n)].increment();
        }

        Histogram histogram = new Histogram(n+1);

        StdDraw.setCanvasSize(500, 200);
        for(int t = 0;t < hits.length; t++)
            histogram.addDataPoint(Bernoulli.binomial(n));
        histogram.draw();
        for(int i = 0; i < n; i++)
            StdOut.println(hits[i].value());

    }
}
