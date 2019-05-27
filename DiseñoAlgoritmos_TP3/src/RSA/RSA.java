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
public class RSA {

    private long mensajeParsed;
    public long mensajeParsedEncriptado;
    public String mensajeEncriptado;
    public ClavePublica publicKey;
    private ClavePrivada privateKey;
    private BigInteger p, q, euler;

    public RSA() {
        mensajeParsed = 0;
        mensajeParsedEncriptado = 0;
        mensajeEncriptado = "";
        publicKey = null;
        privateKey = null;
        p = null;
        q = null;
        euler = null;
    }

    public void generarClaves() {
        Random r = new Random();
        p = BigInteger.probablePrime(30, r);
        q = BigInteger.probablePrime(30, r);
        euler = (p.subtract(BigInteger.ONE)).multiply((q.subtract(BigInteger.ONE)));
        publicKey = new ClavePublica();
        privateKey = new ClavePrivada();

    }

    public class ClavePublica {

        BigInteger e;
        BigInteger n;

        public ClavePublica() {
            e = nextCoprime(euler);
            n = p.multiply(q);
        }

    }

    public class ClavePrivada {

        BigInteger d;
        BigInteger n;

        public ClavePrivada() {
            d = publicKey.e.modInverse(euler);
            n = publicKey.n;
        }

    }

    public static BigInteger expoDyV(long a, long n) {
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

    public static BigInteger expoModDyV(long a, long n, long z) {
        BigInteger res = BigInteger.ONE;
        BigInteger temp;
        if (n > 0) {
            if (n % 2 == 0) {
                temp = expoModDyV(a, n / 2, z);
                res = temp.multiply(temp).mod(BigInteger.valueOf(z));
            } else {
                temp = expoModDyV(a, n - 1, z).multiply(BigInteger.valueOf(a).mod(BigInteger.valueOf(z)));
                res = temp.mod(BigInteger.valueOf(z));
            }
        }
        return res;
    }

    public BigInteger nextCoprime(BigInteger n) {
        BigInteger result = nextRandomBigInteger(n);
        while (n.gcd(result).compareTo(BigInteger.ONE) != 0) {
            result = nextRandomBigInteger(n);
        }
        return result;
    }

    public BigInteger nextRandomBigInteger(BigInteger n) {
        Random rand = new Random();
        BigInteger result = new BigInteger(n.bitLength(), rand);
        while (result.compareTo(n) >= 0) {
            result = new BigInteger(n.bitLength(), rand);
        }
        return result;
    }

    public long cargarMsj(String msg) throws Exception {
        long temp = coderBase(msg);
        if (temp > publicKey.n.doubleValue()) {
            throw new Exception();
        }
        mensajeParsed = coderBase(msg);
        return mensajeParsed;
    }

    public String encriptar() {
        //mensajeParsedEncriptado = expoDyV(mensajeParsed, publicKey.e.longValue()).mod(publicKey.n).longValueExact();
        mensajeParsedEncriptado = expoModDyV(mensajeParsed, publicKey.e.longValue(),publicKey.n.longValue()).longValueExact();
        mensajeEncriptado = decoderBase(mensajeParsedEncriptado);
        return mensajeEncriptado;
    }

    public String desencriptar() {
      //  return decoderBase(expoDyV(mensajeParsedEncriptado, privateKey.d.longValue()).mod(privateKey.n).longValueExact());
        return decoderBase(expoModDyV(mensajeParsedEncriptado, privateKey.d.longValue(), privateKey.n.longValue()).longValueExact());
    }

    public void setMsjNull() {
        this.mensajeParsed = 0;
    }

    private static long coderBase(String text) {
        //String text = "0vn4p9";
        String code = "0123456789abcdefghijklmnopqrstuvwxyz";
        long num = 0;
        int j = text.length();
        for (int i = 0; i < j; i++) {
            num += code.indexOf(text.charAt(0)) * Math.pow(code.length(), i);
            text = text.substring(1);
        }
        //System.out.println("Codificado: " + num);
        return num;
    }

    private static String decoderBase(long num) {
        //int num = 586403532;
        String code = "0123456789abcdefghijklmnopqrstuvwxyz";
        String text = "";
        int j = (int) Math.ceil(Math.log(num) / Math.log(code.length()));
        for (int i = 0; i < j; i++) {
            //i goes to log base code.length() of num (using change of base formula)
            text += code.charAt((int) (num % code.length()));
            num /= code.length();
        }
        //System.out.println("Decodificado: " + text);
        return text;
    }
//    static int modInverse(int a, int m) {
//        a = a % m;
//        for (int x = 1; x < m; x++) {
//            if ((a * x) % m == 1) {
//                return x;
//            }
//        }
//        return 1;
//    }
}
