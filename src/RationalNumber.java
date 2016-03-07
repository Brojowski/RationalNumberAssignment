public class RationalNumber extends Number implements Comparable<RationalNumber>
{
    private long n;
    private long d;

    public RationalNumber()
    {
        n = 1;
        d = 1;
    }

    public RationalNumber(long numerator, long denominator) throws IllegalArgumentException
    {
        if (denominator == 0)
        {
            throw new IllegalArgumentException("Zero cannot be the denominator.");
        }
        n = numerator;
        d = denominator;
    }

    @Override
    public int intValue()
    {
        return (int) ((double) this.n / (double) this.d);
    }

    @Override
    public long longValue()
    {
        return (long) ((double) this.n / (double) this.d);
    }

    @Override
    public float floatValue()
    {
        return (float) ((double) this.n / (double) this.d);
    }

    @Override
    public double doubleValue()
    {
        return (double) this.n / (double) this.d;
    }

    public long getDenominator()
    {
        return d;
    }

    public long getNumerator()
    {
        return n;
    }

    public void setDenominator(long d)
    {
        this.d = d;
    }

    public void setNumerator(long n)
    {
        this.n = n;
    }

    public RationalNumber add(RationalNumber other)
    {
        long commonDenominator = this.d * other.getDenominator();
        long numeratorOne = this.n * other.getDenominator();
        long numeratorTwo = other.getNumerator() * this.d;
        RationalNumber number = new RationalNumber(numeratorOne + numeratorTwo, commonDenominator);
        number.reduce();
        return number;
    }

    public RationalNumber multiply(RationalNumber other)
    {
        long commonDenominator = this.d * other.getDenominator();
        RationalNumber number = new RationalNumber(this.n * other.getNumerator(), commonDenominator);
        number.reduce();
        return number;
    }

    public RationalNumber subtract(RationalNumber other)
    {
        long commonDenominator = this.d * other.getDenominator();
        long numeratorOne = this.n * other.getDenominator();
        long numeratorTwo = other.getNumerator() * this.d;
        RationalNumber number = new RationalNumber(numeratorOne - numeratorTwo, commonDenominator);
        number.reduce();
        return number;
    }

    public RationalNumber divide(RationalNumber other)
    {
        RationalNumber number = new RationalNumber(this.n * other.getDenominator(), this.d * other.getNumerator());
        number.reduce();
        return number;
    }

    public void reduce()
    {
        long gcd = gcd(this.n, this.d);
        this.n = this.n / gcd;
        this.d = this.d / gcd;
    }

    private long gcd(long n, long d)
    {
        if (n == 0 || d == 0)
        {
            return n + d;
        }
        return gcd(d, n % d);
    }

    @Override
    public int compareTo(RationalNumber other)
    {
        this.reduce();
        other.reduce();
        if (this.n * other.getDenominator() == other.getNumerator() * this.d)
        {
            return 0;
        } else if (this.n * other.getDenominator() > other.getNumerator() * this.d)
        {
            return 1;
        } else
        {
            return -1;
        }
    }

    @Override
    public String toString()
    {
        return n + "/" + d;
    }
}