import java.util.Arrays;

public class HexByteMain {
    
    public static void main(String[] args) {
        byte[] message =
        { 0x02, 0x10, 0x02, 0x0A, 0x10, 0x10, 0x07, 0x08, 0x03, 0x14 };
    System.out.println("Message is valid: " + isHexByteSuccess(message));

    }
    
    public static boolean isValidLRC(byte[] dataWithLRC) {
        if (dataWithLRC == null || dataWithLRC.length < 2) {
            return false; // Need at least one data byte and one LRC byte.
        }

        byte receivedLRC = dataWithLRC[dataWithLRC.length - 1];
          
          // byte data should exclude STX upon LRC Calculation
          byte[] newArray = Arrays.copyOfRange(dataWithLRC, 1, dataWithLRC.length-1);
        byte calculatedLRC = calculateLRC(newArray);

        return calculatedLRC == receivedLRC;
    }

    public static byte calculateLRC(byte[] data) {
        byte lrc = 0;
        for (byte b : data) {
            lrc ^= b;
        }
      System.out.println("Calculated LRC is: " + lrc);
        return lrc;
    }
        
        public static String escapeString(byte[] data) {
            StringBuilder escapedString = new StringBuilder();
        for (byte b : data) {
          escapedString.append(String.format("\\x%02X", b));
        }
        // System.out.println("Escaped Hex String: " + escapedString.toString());
        return escapedString.toString();
        }
      
  
  public static boolean isHexByteSuccess(byte[] message) {
    
    boolean prefixValid = false;
    boolean suffixValid = false;
    boolean lrcValid = false;
      String escapedString = "";
    
    // STX Check
    if (message[0] == 2) {
      prefixValid = true;
    }
      System.out.println("Is Prefix Valid: " + prefixValid);
    
    // ETX Check
    int endIndex = message.length - 2;
    if (message[endIndex] == 3) {
      suffixValid = true;
    }
      System.out.println("Is Suffix Valid: " + suffixValid);
    
    // LRC Check
    lrcValid = isValidLRC(message);
    System.out.println("Is LRC Valid: " + lrcValid);
      
      // escape String
      escapedString = escapeString(message);
      System.out.println("Escaped String = " + escapedString);
      
    if (prefixValid && suffixValid && lrcValid && (escapedString != "")) {
      return true;
    }
    
    return false;
    
  }
    
}