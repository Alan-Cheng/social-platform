package backend;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class PasswordUtil {
    // Generate a salt
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    // Hash the password with the salt
    private static byte[] hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        return md.digest(password.getBytes());
    }

    // Encode salt and hashed password for storage
    public static String encodePassword(String password) throws NoSuchAlgorithmException {
        byte[] salt = generateSalt();
        byte[] hashedPassword = hashPassword(password, salt);
        byte[] combined = new byte[salt.length + hashedPassword.length];
        System.arraycopy(salt, 0, combined, 0, salt.length);
        System.arraycopy(hashedPassword, 0, combined, salt.length, hashedPassword.length);
        return Base64.getEncoder().encodeToString(combined);
    }

    // Validate a password
    public static boolean validatePassword(String password, String encodedPassword) throws NoSuchAlgorithmException {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
        byte[] salt = Arrays.copyOfRange(decodedBytes, 0, 16);
        byte[] storedHash = Arrays.copyOfRange(decodedBytes, 16, decodedBytes.length);
        byte[] testHash = hashPassword(password, salt);
        return Arrays.equals(storedHash, testHash);
    }
}

