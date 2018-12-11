import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;


public class Rectangle {
    private double x,y;
    private double xmax, ymax;
    private double width;
    private double height;


    public Rectangle(double x0, double y0, double w, double h)
    {
        x      = x0;
        y      = y0;
        width  =  w;
        height =  h;

    }
    public Rectangle(double xm, double ym){

        xmax = xm;
        ymax = ym;
    }

    public void setInintCoords(double x0, double y0){
        this.x = x0;
        y = y0;

    }
    public double area(){
        return width * height;
    }
    public double perimeter()
    {
        return 2 *(width + height);
    }
    public boolean intersects(Rectangle b)
    {
        return (this.width > 0 && this.height >0 &&
                b.x < this.x + this.width && b.x + b.width > this.x &&
                b.y < this.y + this.height && b.y + b.height > this.y);
    }

    public boolean contains(Rectangle b){
       return this.width > 0 && this.height > 0 && b.width > 0 && b.height > 0
       && b.x >= this.x && b.x + b.width <= this.x + this.width &&
          b.y >= this.y && b.y + b.height <= this.y + this.height;
    }

    public void draw(Rectangle b){
    // Draw rectangle on standard drawing
        StdDraw.rectangle(b.x,b.y, b.width,b.height);
    }

    public static void main(String[] args){
        double n = Double.parseDouble(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);


        double width = StdRandom.uniform(min, max);
        double height = StdRandom.uniform(min,max);

        double x = StdRandom.uniform(min,max) ;
        double y = StdRandom.uniform(min,max);
        Rectangle Rect = new Rectangle(0.32, 0.45);
        Rect.setInintCoords(x,y);
        Rectangle rect = new Rectangle(x,y, width, height);

        double i = 0;
        while(i < n){
            Rectangle rect2 = new Rectangle(3,2.5, width/2, height/2);
            rect.draw(rect2);
            StdOut.println(rect.contains(rect2));
            StdOut.println(rect2.area());
            StdOut.println(rect2.perimeter());
            i++;
        }


    }
}
