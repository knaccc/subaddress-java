package knaccc.monero.crypto;

import com.joemelsha.crypto.hash.Keccak;
import org.nem.core.crypto.ed25519.arithmetic.*;

import java.math.BigInteger;

import static knaccc.monero.address.ByteUtil.*;

public class CryptoUtil {

  public static final Ed25519GroupElement G = Ed25519Group.BASE_POINT;

  public static Scalar hashToScalar(byte[] a) {
    return new Scalar(scReduce32(fastHash(a)));
  }

  public static Scalar hashToScalar(Ed25519GroupElement a) {
    return new Scalar(scReduce32(fastHash(a.encode().getRaw())));
  }

  private static Keccak keccak = new Keccak(256);
  public static byte[] fastHash(byte[] a) {
    try {
      keccak.reset();
      keccak.update(a);
      return keccak.digestArray();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static BigInteger l = BigInteger.valueOf(2).pow(252).add(new BigInteger("27742317777372353535851937790883648493"));

  public static byte[] scReduce32(byte[] a) {
    byte[] r = getBigIntegerFromUnsignedLittleEndianByteArray(a).mod(l).toByteArray();
    return ensure32BytesAndConvertToLittleEndian(r);
  }

  public static byte[] ensure32BytesAndConvertToLittleEndian(byte[] r) {
    byte[] s = new byte[32];
    if(r.length>32) System.arraycopy(r, 1, s, 0, s.length);
    else System.arraycopy(r, 0, s, 32 - r.length, r.length);
    reverseByteArrayInPlace(s);
    return s;
  }

}
