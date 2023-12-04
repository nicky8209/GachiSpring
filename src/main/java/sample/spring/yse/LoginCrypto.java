package sample.spring.yse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class LoginCrypto {

	private final static Random rand = new Random();

	public static final String hexSha1(final String in) {
		try {
			MessageDigest Digester = MessageDigest.getInstance("SHA-1");
			Digester.update(in.getBytes());
			byte[] sha1Hash = Digester.digest();
			return toSimpleHexString(sha1Hash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Encoding the string failed", e);
		}
	}

	private static final String toSimpleHexString(final byte[] bytes) {
		return toString(bytes);
	}

	public static final String toString(final byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			System.out.println(String.format("%02x", b) + "/" + String.format("%02x", b & 0xff));
			sb.append(String.format("%02x", b));

		}
		return sb.toString();
	}

	public static final String makeSalt() {
		byte[] salt = new byte[16];
		rand.nextBytes(salt);
		return toSimpleHexString(salt);
	}

}
