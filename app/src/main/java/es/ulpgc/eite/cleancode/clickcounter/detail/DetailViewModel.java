package es.ulpgc.eite.cleancode.clickcounter.detail;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

public class DetailViewModel {

  // put the view state here
  public Long id;
  public Integer counter;

  public DetailViewModel() {
    id = generateUniqueId();
    counter = 0;
  }

  /**
   * Genereate unique ID from UUID in positive space
   * Reference: http://www.gregbugaj.com/?p=587
   *
   * @return long value representing UUID
   */
  private Long generateUniqueId() {
    long val = -1;

    do {

      final UUID uid = UUID.randomUUID();
      final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
      buffer.putLong(uid.getLeastSignificantBits());
      buffer.putLong(uid.getMostSignificantBits());
      final BigInteger bi = new BigInteger(buffer.array());
      val = bi.longValue();
    }

    // We also make sure that the ID is in positive space,
    // if its not we simply repeat the process
    while (val < 0);
    return val;
  }
}
