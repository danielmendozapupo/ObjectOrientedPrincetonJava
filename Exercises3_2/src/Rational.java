

public class Rational {

    private int numerator, denominator;

    public Rational(int num, int denom) {
        numerator = num;
        denominator = denom;
        int g = gcd(numerator,denominator);
        numerator = num /g;
        denominator = denom /g;
        if (denominator < 0) { denominator = -denominator; numerator = -numerator; }

    }

    // return gcd(|m|, |n|)
    private static int gcd(int m, int n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (n == 0) return m;
        else return gcd(n, m % n);
    }

    // return lcm(|m|, |n|)
    private static int lcm(int m, int n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        return m * (n / gcd(m, n));    // parentheses important to avoid overflow
    }

    public Rational plus(Rational b) {
        int f = gcd(this.numerator, b.numerator);
        int g = gcd(this.denominator, b.denominator);
       Rational s = new Rational((this.numerator / f) * (b.denominator / g) + (b.numerator / f) * (this.denominator / g),
                lcm(this.denominator, b.denominator)) ;
       s.numerator *= f;
       return s;
       }
    public Rational negate(){
        return new Rational(this.numerator, -this.denominator);
    }


    public Rational minus(Rational b) {
        Rational a = this;
        return a.plus(b.negate());
    }

    public Rational times(Rational b) {
        Rational a = (new Rational(this.numerator,b.denominator));
        Rational c = (new Rational(b.numerator, this.denominator));
        return (new Rational(a.numerator* c.numerator, a.denominator*c.denominator));
       }

    public Rational reciprocal() { return new Rational(denominator, numerator);  }


    public Rational divides(Rational b) {

        return (this.times(b.reciprocal()));
    }

    public String toString() {
        if (denominator == 1) return numerator + "";
        else return numerator + "/" + denominator;
    }


    // test client
    public static void main(String[] args) {
        Rational x, y, z;
        // 1/2 + 1/3 = 5/6
        x = new Rational(1, 2);
        y = new Rational(1, 3);
        z = x.plus(y);
        StdOut.println(z);

        // 8/9 + 1/9 = 1
        x = new Rational(8, 9);
        y = new Rational(1, 9);
        z = x.plus(y);
        StdOut.println(z);

        // 1/200000000 + 1/300000000 = 1/120000000
        x = new Rational(1, 200000000);
        y = new Rational(1, 300000000);
        z = x.plus(y);
        StdOut.println(z);

        // 1073741789/20 + 1073741789/30 = 1073741789/12
        x = new Rational(1073741789, 20);
        y = new Rational(1073741789, 30);
        z = x.plus(y);
        StdOut.println(z);

        //  4/17 * 17/4 = 1
        x = new Rational(4, 17);
        y = new Rational(17, 4);
        z = x.times(y);
        StdOut.println(z);

        // 3037141/3247033 * 3037547/3246599 = 841/961
        x = new Rational(3037141, 3247033);
        y = new Rational(3037547, 3246599);
        z = x.times(y);
        StdOut.println(z);

        // 1/6 - -4/-8 = -1/3
        x = new Rational( 1,  6);
        y = new Rational(-4, -8);
        z = x.minus(y);
        StdOut.println(z);

    }
}



