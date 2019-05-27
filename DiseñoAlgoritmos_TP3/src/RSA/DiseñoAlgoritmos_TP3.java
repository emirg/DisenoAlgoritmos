/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author emiliano
 */
public class DiseñoAlgoritmos_TP3 {

    public static void main(String[] args) {

        Random r = new Random();
        BigInteger p = BigInteger.valueOf(61);
        BigInteger q = BigInteger.valueOf(53);
        //BigInteger p = BigInteger.probablePrime(5, r);
        //BigInteger q = BigInteger.probablePrime(5, r);
        BigInteger n = p.multiply(q);
        BigInteger euler = (p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE)));
        //BigInteger e = nextCoprime(euler);
        //BigInteger d = e.modInverse(euler);
        BigInteger e = BigInteger.valueOf(17);
        BigInteger d = BigInteger.valueOf(2753);
        //BigInteger d = nextCoprime(euler);

        System.out.println("p = " + p.doubleValue());
        System.out.println("q = " + q.doubleValue());
        System.out.println("n = " + n.doubleValue());
        System.out.println("euler = " + euler.doubleValue());
        System.out.println("e = " + e.doubleValue());
        System.out.println("d = " + d.doubleValue());
        System.out.println("");

        BigInteger potencia = expoDyV(5, 2);
        System.out.println(potencia.doubleValue());

        System.out.println("Resultado: " + expoDyV1(855,2753,3233));
        
        //System.out.println(Integer.toString(1, 36));
        coderBase("Hola mundo");
//        decoderBase();

    }

    public static BigInteger nextRandomBigInteger(BigInteger n) {
        Random rand = new Random();
        BigInteger result = new BigInteger(n.bitLength(), rand);
        while (result.compareTo(n) >= 0) {
            result = new BigInteger(n.bitLength(), rand);
        }
        return result;
    }

    public static BigInteger nextCoprime(BigInteger n) {
        BigInteger result = nextRandomBigInteger(n);
        while (n.gcd(result).compareTo(BigInteger.ONE) != 0) {
            result = nextRandomBigInteger(n);
        }
        return result;
    }

    static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return 1;
    }

    /*public static double expoDyV(int a, int n) {
        double res;
        if (n == 1) {
            res = a;
        } else {
            if (n % 2 == 0) {
                res = expoDyV(a, n / 2);
                res = res * res;
            } else {
                res = a * expoDyV(a, n - 1);
            }
        }
        return res;
    }*/
    public static BigInteger expoDyV(int a, int n) {
        BigInteger res;
        if (n == 1) {
            res = BigInteger.valueOf(a);
        } else {
            if (n % 2 == 0) {
                res = expoDyV(a, n / 2);
                res = res.multiply(res);
            } else {
                res = BigInteger.valueOf(a).multiply(expoDyV(a, n - 1));
            }
        }
        return res;
    }

    public static long expoDyV1(long a, long n, long z) {
        long res = 1;
        if (n > 0) {
            if (n % 2 == 0) {
                a = expoDyV1(a, n / 2, z);
                res = (a * a) % z;
            } else {
                a = expoDyV1(a, n - 1, z) * (a % z);
                res = a%z;
            }
        }
        return res;
    }

    public static void coderBase(String text) {
        //String text = "0vn4p9";
        String code = "0123456789abcdefghijklmnopqrstuvwxyz";
        int num = 0;
        int j = text.length();
        for (int i = 0; i < j; i++) {
            num += code.indexOf(text.charAt(0)) * Math.pow(code.length(), i);
            text = text.substring(1);
        }
        System.out.println("Codificado: " + num);
    }

    public static void decoderBase(int num) {
        //int num = 586403532;
        String code = "0123456789abcdefghijklmnopqrstuvwxyz";
        String text = "";
        int j = (int) Math.ceil(Math.log(num) / Math.log(code.length()));
        for (int i = 0; i < j; i++) {
            //i goes to log base code.length() of num (using change of base formula)
            text += code.charAt(num % code.length());
            num /= code.length();
        }
        System.out.println("Decodificado: " + text);
    }

}
