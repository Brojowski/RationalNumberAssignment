public class RationalNumber extends Number implements Comparable<RationalNumber>
{
    private long numerator;
    private long denominator;

    public RationalNumber()
    {
        numerator = 1;
        denominator = 1;
    }

    public RationalNumber(long numerator, long denominator) throws IllegalArgumentException
    {
        if (denominator == 0)
        {
            throw new IllegalArgumentException("Zero cannot be the denominator.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public int intValue()
    {
        return (int) ((double) this.numerator / (double) this.denominator);
    }

    @Override
    public long longValue()
    {
        return (long) ((double) this.numerator / (double) this.denominator);
    }

    @Override
    public float floatValue()
    {
        return (float) ((double) this.numerator / (double) this.denominator);
    }

    @Override
    public double doubleValue()
    {
        return (double) this.numerator / (double) this.denominator;
    }

    public long getDenominator()
    {
        return denominator;
    }

    public long getNumerator()
    {
        return numerator;
    }

    public void setDenominator(long d)
    {
        this.denominator = d;
    }

    public void setNumerator(long n)
    {
        this.numerator = n;
    }

    public RationalNumber add(RationalNumber other)
    {
        long commonDenominator = this.denominator * other.getDenominator();
        long numeratorOne = this.numerator * other.getDenominator();
        long numeratorTwo = other.getNumerator() * this.denominator;
        RationalNumber number = new RationalNumber(numeratorOne + numeratorTwo, commonDenominator);
        number.reduce();
        return number;
    }

    public RationalNumber multiply(RationalNumber other)
    {
        long commonDenominator = this.denominator * other.getDenominator();
        RationalNumber number = new RationalNumber(this.numerator * other.getNumerator(), commonDenominator);
        number.reduce();
        return number;
    }

    public RationalNumber subtract(RationalNumber other)
    {
        long commonDenominator = this.denominator * other.getDenominator();
        long numeratorOne = this.numerator * other.getDenominator();
        long numeratorTwo = other.getNumerator() * this.denominator;
        RationalNumber number = new RationalNumber(numeratorOne - numeratorTwo, commonDenominator);
        number.reduce();
        return number;
    }

    public RationalNumber divide(RationalNumber other)
    {
        RationalNumber number = new RationalNumber(this.numerator * other.getDenominator(), this.denominator * other.getNumerator());
        number.reduce();
        return number;
    }

    public void reduce()
    {
        long gcd = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
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
        if (this.numerator * other.getDenominator() == other.getNumerator() * this.denominator)
        {
            return 0;
        } else if (this.numerator * other.getDenominator() > other.getNumerator() * this.denominator)
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
        return numerator + "/" + denominator;
    }
}