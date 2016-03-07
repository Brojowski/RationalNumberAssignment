public class Main
{
    public static void main(String[] args)
    {
        RationalNumber one = new RationalNumber(1,2);
        RationalNumber two = new RationalNumber(2,3);
        System.out.println(one);
        System.out.println(two);
        System.out.println(one.add(two));
        System.out.println(one.multiply(two));
        System.out.println(one.subtract(two));
        System.out.println(one.divide(two));
        System.out.println(one.compareTo(two));
        System.out.println(two.compareTo(one));
        one.setNumerator(2);
        one.setDenominator(3);
        System.out.println(one.compareTo(two));
    }
}
