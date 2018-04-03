package com.test.A;


//**********************************************************************
//Copyright (c) 2016 Ericsson AB, Sweden. All rights reserved.
//The copyright to the computer program or programs herein is the
//property of Ericsson AB, Sweden. The program or programs
//may be used and/or copied with the written permission
//from Ericsson AB or in accordance with the terms and conditions
//stipulated in the agreement/contract under which the
//program has been supplied.
//
//**********************************************************************



/**
* The Base64Util is used for encrypting and decrypting the password.
*/
public class Base64Util
{
 public Base64Util()
 {
 }

 // base64 encoding code
 private static char[] BASE64_ENCODETABLE =
 {
         'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
         'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
         'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
         'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
         'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
         'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
         'w', 'x', 'y', 'z', '0', '1', '2', '3',
         '4', '5', '6', '7', '8', '9', '+', '/'
 };

 // base64 decoding code
 private static int[] BASE64_DECODETABLE =
 {
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x3e, 0x80, 0x80, 0x80, 0x3f,
         0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x3a, 0x3b,
         0x3c, 0x3d, 0x80, 0x80, 0x80, 0x00, 0x80, 0x80,
         0x80, 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06,
         0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e,
         0x0f, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16,
         0x17, 0x18, 0x19, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f, 0x20,
         0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28,
         0x29, 0x2a, 0x2b, 0x2c, 0x2d, 0x2e, 0x2f, 0x30,
         0x31, 0x32, 0x33, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
         0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x00
 };

 /**
  * Function for decrypting the password: - base64decode the encrypted
  * password - get the key length from the zeropadded string - create a new
  * key given the key length - "xor" the encrypted password and key - the
  * password is returned
  * 
  * @param decryptionKey Decryption key
  * @param encryptPassword Encrypted password
  * @return password decrypted readable password
  * @throws StandardException
  */
 public static String decrypt(String decryptionKey, String encryptPassword) 
 {
     try
     {
         int keyOffset = 3;
         String decoded64Data = decodeBase64(encryptPassword.toCharArray());
         int keyLength = getIntKeyLength(decoded64Data, keyOffset);
         String newDecryptionKey = createNewKey(decryptionKey, keyLength);
         char[] decodedData = new char[keyLength + 1];
         for (int index = 0; index < keyLength; index++)
         {
             decodedData[index] = decoded64Data.toCharArray()[index + keyOffset];
         }
         char[] xorResult = xorCrypt(newDecryptionKey, new String(decodedData));
         return new String(xorResult);
     }
     catch (Exception e)
     {
       return e.getMessage();
     }
    
 }

 private static int getIntKeyLength(String decoded64Data, int keyOffset)
 {
     String keyLength = decoded64Data.substring(0, keyOffset);
     return Integer.parseInt(keyLength);
 }

 private static String encodeBase64(char[] encryptionKey, int passwordLength, boolean eofFlag)
 {
     String encodedPassword = "";
     int idx = 0;
     boolean passwordFlag = false;
     boolean nextLineFlag = false;
     int lineLen = 0;

     while (!passwordFlag)
     {
         int[] inputGroup = new int[3];
         char[] outputGroup = new char[4];
         int n;
         int c;

         inputGroup[0] = 0;
         inputGroup[1] = 0;
         inputGroup[2] = 0;
         for (n = 0; n < 3; n++)
         {
             if (idx >= passwordLength)
             {
                 passwordFlag = true;
                 break;
             }
             c = encryptionKey[idx++];
             inputGroup[n] = c;
         }
         if (n > 0)
         {
             outputGroup[0] = BASE64_ENCODETABLE[inputGroup[0] >> 2];
             outputGroup[1] = BASE64_ENCODETABLE[(inputGroup[0] & 3) << 4 | inputGroup[1] >> 4];
             outputGroup[2] = BASE64_ENCODETABLE[(inputGroup[1] & 0xF) << 2 | inputGroup[2] >> 6];
             outputGroup[3] = BASE64_ENCODETABLE[inputGroup[2] & 0x3F];

             // Replace characters in output stream with "=" pad
             // characters if fewer than three characters were
             // read from the end of the input stream.
             if (n < 3)
             {
                 outputGroup[3] = '=';
                 if (n < 2)
                 {
                     outputGroup[2] = '=';
                 }
             }
             nextLineFlag = false;
             for (int index = 0; index < 4; index++)
             {
                 encodedPassword += outputGroup[index];
                 if (++lineLen >= 72)
                 {
                     lineLen = 0;
                     nextLineFlag = true;
                     if (eofFlag)
                     {
                         encodedPassword += "\r\n";
                     }
                 }
             }
         }
     }
     if (!nextLineFlag && eofFlag)
     {
         encodedPassword += "\r\n";
     }
     return encodedPassword;
 }

 /**
  * Function for encrypting the password:
  * - create zero padded string with length key length
  * - create a new key with same length as password
  * - "xor" the password and key
  * - append the zero padded length to the xor result
  * - base64encode the appended string
  * - return the encrypted password
  * 
  * @param encryptionKey Encryption key
  * @param password Original password
  * @return encrypted password string
  * @throws StandardException
  */
 public static String encrypt(String encryptionKey, String password) 
 {
     try
     {
         int passwordLength = password.length();
         int keyOffset = 3;
         char[] result;
         result = new char[passwordLength + keyOffset];
         char[] results = String.format("%03d", passwordLength).toCharArray();

         int index = 0;
         for (char rs : results)
         {
             result[index] = rs;
             index++;
         }
         String newEncryptKey = createNewKey(encryptionKey, passwordLength);
         char[] xorResult = xorCrypt(newEncryptKey, password);

         // append the xor result to the char array
         for (int pos = 0; pos < passwordLength; pos++)
         {
             result[pos + keyOffset] = xorResult[pos];
         }
         // encode the result with encodeBase64
         int totalPasswordLength = keyOffset + passwordLength;
         String encodeBase64Data = encodeBase64(result, totalPasswordLength, false);
         return encodeBase64Data;
     }
     catch (Exception e)
     {
        return e.getMessage();
     }
 }

 private static char[] xorCrypt(String encryptKey, String password)
 {
     int keyLength = encryptKey.length();
     char[] encryptedData = new char[keyLength + 1];
     for (int index = 0; index < keyLength; index++)
     {
         encryptedData[index] = (char) (encryptKey.charAt(index) ^ password.charAt(index));
     }
     return encryptedData;
 }

 private static String createNewKey(String encryptionKey, int passwordLength)
 {
     String newKey = null;
     int theNumberOfLoops = passwordLength / encryptionKey.length();

     if (theNumberOfLoops > 0)
     {
         newKey = encryptionKey;

         for (int i = 1; i < theNumberOfLoops; i++)
         {
             newKey += encryptionKey;
         }
         newKey += encryptionKey.substring(0, passwordLength % encryptionKey.length());
     }
     else
     {
         newKey = encryptionKey.substring(0, passwordLength);
     }
     return newKey;
 }

 private static String decodeBase64(char[] encryptPassword)
 {
     String decodedPassword = "";
     int len = encryptPassword.length;
     int index = 0;
     while (true)
     {
         char[] a = new char[4];
         char[] b = new char[4];
         char[] o = new char[3];

         for (int j = 0; j < 4;)
         {
             if (index >= len)
             {
                 return decodedPassword;
             }
             int c = encryptPassword[index++];

             if (c != '\r' && c != '\n' && c != ' ')
             {
                 int value = BASE64_DECODETABLE[c] & 0x80;
                 if (value != 0)
                 {
                     j--;
                     continue;
                 }
                 a[j] = (char) c;
                 b[j] = (char) BASE64_DECODETABLE[c];
                 ++j;
             }
         }
         o[0] = (char) convertASCII(b[0] << 2 | b[1] >> 4);
         o[1] = (char) convertASCII(b[1] << 4 | b[2] >> 2);
         o[2] = (char) convertASCII(b[2] << 6 | b[3]);

         int i = a[2] == '=' ? 1 : a[3] == '=' ? 2 : 3;
         switch (i)
         {
             case 1:
                 decodedPassword += o[0];
                 break;

             case 2:
                 decodedPassword += o[0];
                 decodedPassword += o[1];
                 break;

             case 3:
                 decodedPassword += o[0];
                 decodedPassword += o[1];
                 decodedPassword += o[2];
                 break;
         }
         if (i < 3)
         {
             return decodedPassword;
         }
     }
 }

 private static int convertASCII(int ascii)
 {
     if (ascii > 256)
     {
         int mod = ascii / 256;
         ascii = ascii - 256 * mod;
     }
     return ascii;
 }

 public static void main(String[] args)
 {
     String a = "semwal";
     char s[] = a.toCharArray();
     String result = encodeBase64(s, a.length(), false);
     System.out.println(result);
   String nKey=  createNewKey("root", 2);
     System.out.println(nKey);

 }
}
