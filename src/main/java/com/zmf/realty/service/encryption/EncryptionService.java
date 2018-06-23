package com.zmf.realty.service.encryption;

/**
 * @author zmf
 * @description the encryption data.
 * @timestamp 2018-06-14 16:48
 */
public interface EncryptionService {
    /**
     * to encrypt a data string
     *
     * @param data the data to be encrypted
     * @return the data encrypted
     */
    String encrypt(String data);

    /**
     * to decrypt a data string that had been encrypted
     *
     * @param data the data encrypted
     * @return the origin data
     */
    String decrypt(String data);
}
