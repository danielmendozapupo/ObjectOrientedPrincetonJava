public class Complex {
    private final double re;
    private final double im;

    public Complex(double real, double imag)
    {
        re = real; im = imag;
    }

    public Complex(double real){
        re = real;
        im = 0.0;
    }

    public Complex plus(Complex b){
        // Return the sum of this number and b
        double real = re + b.re;
        double imag = im + b.im;
        return new Complex(real,imag);

    }

    public Complex times(Complex b)
    {
        double real = re * b.re - im * b.im;
        double imag = re * b.im + im * b.re;
        return new Complex(real,imag);
    }

    public double abs()
    {
        return Math.sqrt(re*re + im*im);
    }
    public double re(){return re;}
    public double im(){return im;}

    public double theta(){
        return Math.atan2(im,re);
    }
    public Complex negative(Complex b){
        return  new Complex(-b.re, -b.im);
    }
    public Complex minus(Complex b)
    {
        return plus(negative(b));
    }
    public Complex conjugate(){
        return new Complex(re, -im);

    }

    public Complex reciprocal(){
        double scale = re * re + im * im;
        return new Complex(re /scale, -im/scale);
    }

    public Complex divides(Complex b)
    {
        return this.times(b.reciprocal());
    }

    public Complex power(int b)
    {

        double modulus = Math.sqrt(re*re + im*im);
        //double arg = this.theta();
        double log_re = Math.log(modulus);
        double log_im = this.theta();
        double b_log_re = b * log_re;
        double b_log_im = b * log_im;
        double modulus_ans = Math.exp(b_log_re);
        return new Complex(modulus_ans*Math.cos(b_log_im), modulus_ans*Math.sin(b_log_im));

    }


    public String toString()
    {
        if(re != 0.0 && im != 1.0 && im != 0.0)
            return re + " + " + im +"i";
        if(re == 0.0)
            return im +"i";

        else if(im == 1.0)
            return re + "+ i";
        else
            return re+"";
    }

    public static void main(String[] args){
        Complex a = new Complex(5.0, 6.0);
        Complex b = new Complex(-3.0, 4.0);
        Complex c = new Complex(1.0);
        StdOut.println("a            = " + a);
        StdOut.println("b            = " + b);
        StdOut.println("c            = " + c);
        StdOut.println("Re(a)        = " + a.re());
        StdOut.println("Im(a)        = " + a.im());
        StdOut.println("b + a        = " + b.plus(a));
        StdOut.println("a - b        = " + a.minus(b));
        StdOut.println("a * b        = " + a.times(b));
        StdOut.println("b * a        = " + b.times(a));
        StdOut.println("a / b        = " + a.divides(b));
        StdOut.println("(a / b) * b  = " + a.divides(b).times(b));
        StdOut.println("conj(a)      = " + a.conjugate());
        StdOut.println("|a|          = " + a.abs());
        //StdOut.println("tan(a)       = " + a.tan());
    }
}
