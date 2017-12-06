/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.math.BigInteger;
import java.security.*;

/**
 *
 * @author Extreme pc
 */
public class MD5 {
    public String Clave_MD5(String clave) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(clave.getBytes());
            BigInteger numero = new BigInteger(1, messageDigest);
            String clave_encriptada = numero.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (clave_encriptada.length() < 32) {
                clave_encriptada = "0" + clave_encriptada;
            }
            return clave_encriptada;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
