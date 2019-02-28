
package utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Obtiene cadena hash para guardar passwords y autentificarlos ante un token ingresado
 */
public final class PasswordAuthentication
{

  /**
   * Cada token creado por esta clase tiene este prefijo.
   */
  public static final String ID = "$31$";

  /**
   * El costo mínimo recomendado utilizado por default.
   */
  public static final int DEFAULT_COST = 16;

  private static final String ALGORITHM = "PBKDF2WithHmacSHA1";

  private static final int SIZE = 128;

  private static final Pattern layout = Pattern.compile("\\$31\\$(\\d\\d?)\\$(.{43})");

  private final SecureRandom random;

  private final int cost;

  public PasswordAuthentication()
  {
    this(DEFAULT_COST);
  }

  /**
   * Crea un administrador de passwords con el costo especificado
   * 
   * @param cost el costo computacional para realizar el hash de un password, de 0 a 30
   */
  public PasswordAuthentication(int cost)
  {
    iterations(cost); /* Validate cost */
    this.cost = cost;
    this.random = new SecureRandom();
  }

  private static int iterations(int cost)
  {
    if ((cost & ~0x1F) != 0)
      throw new IllegalArgumentException("cost: " + cost);
    return 1 << cost;
  }

  /**
   * Hash a password for storage.
   * @param password cadena de caracteres que identifica al password del cual se obtendrá su hash.
   * 
   * @return un token seguro de autentificación para ser guardado y posteriormente identificado. 
   */
  public String hash(char[] password)
  {
    byte[] salt = new byte[SIZE / 8];
    random.nextBytes(salt);
    byte[] dk = pbkdf2(password, salt, 1 << cost);
    byte[] hash = new byte[salt.length + dk.length];
    System.arraycopy(salt, 0, hash, 0, salt.length);
    System.arraycopy(dk, 0, hash, salt.length, dk.length);
    Base64.Encoder enc = Base64.getUrlEncoder().withoutPadding();
    return ID + cost + '$' + enc.encodeToString(hash);
  }

  /**
   * Autentifica si un password corresponde con su token guardado.
   * @param password password ingresado por un usuario.
   * @param token token seguro previamente generado a partir de un password.
   * @return true si el password y el token coinciden.
   */
  public boolean authenticate(char[] password, String token)
  {
    Matcher m = layout.matcher(token);
    if (!m.matches())
      throw new IllegalArgumentException("Invalid token format");
    int iterations = iterations(Integer.parseInt(m.group(1)));
    byte[] hash = Base64.getUrlDecoder().decode(m.group(2));
    byte[] salt = Arrays.copyOfRange(hash, 0, SIZE / 8);
    byte[] check = pbkdf2(password, salt, iterations);
    int zero = 0;
    for (int idx = 0; idx < check.length; ++idx)
      zero |= hash[salt.length + idx] ^ check[idx];
    return zero == 0;
  }
  
  /*
  *Implemetnación de el algoritmo pbkdf2 para generación de tokens
  */

  private static byte[] pbkdf2(char[] password, byte[] salt, int iterations)
  {
    KeySpec spec = new PBEKeySpec(password, salt, iterations, SIZE);
    try {
      SecretKeyFactory f = SecretKeyFactory.getInstance(ALGORITHM);
      return f.generateSecret(spec).getEncoded();
    }
    catch (NoSuchAlgorithmException ex) {
      throw new IllegalStateException("Missing algorithm: " + ALGORITHM, ex);
    }
    catch (InvalidKeySpecException ex) {
      throw new IllegalStateException("Invalid SecretKeyFactory", ex);
    }
  }


}

