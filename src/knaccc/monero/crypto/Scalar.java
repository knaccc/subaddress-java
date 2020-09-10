package knaccc.monero.crypto;

import knaccc.monero.address.ByteUtil;

import java.util.Arrays;

import static knaccc.monero.address.ByteUtil.*;
import static knaccc.monero.crypto.CryptoUtil.*;

public class Scalar {

  public byte[] bytes;
  public Scalar(byte[] bytes) {
    this.bytes = bytes;
  }
  public Scalar(String hex) {
    this.bytes = ByteUtil.hexToBytes(hex);
  }

  @Override
  public String toString() {
    return bytesToHex(bytes);
  }

  @Override
  public boolean equals(Object obj) {
    return Arrays.equals(this.bytes, ((Scalar)obj).bytes);
  }

  public Scalar add(Scalar a) { return new Scalar(ensure32BytesAndConvertToLittleEndian(getBigIntegerFromUnsignedLittleEndianByteArray(this.bytes).add(getBigIntegerFromUnsignedLittleEndianByteArray(a.bytes)).mod(l).toByteArray())); }

}
