package com.programmers.cat_picture_search.config;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

class JasyptConfigTest {

  @Test
  void jasypt(){
    String url = "jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC&characterEncoding=UTF-8";
    String username = "root";
    String password = "1234";

    String encryptUrl = jasyptEncrypt(url);
    String encryptUsername = jasyptEncrypt(username);
    String encryptPassword = jasyptEncrypt(password);

    System.out.println("encryptUrl : " + encryptUrl);
    System.out.println("encryptUsername : " + encryptUsername);
    System.out.println("encryptPassword : " + encryptPassword);

    Assertions.assertThat(url).isEqualTo(jasyptDecrypt(encryptUrl));
  }

  private String jasyptEncrypt(String input) {
    String key = "5678";
    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    encryptor.setAlgorithm("PBEWithMD5AndDES");
    encryptor.setPassword(key);
    return encryptor.encrypt(input);
  }

  private String jasyptDecrypt(String input){
    String key = "5678";
    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    encryptor.setAlgorithm("PBEWithMD5AndDES");
    encryptor.setPassword(key);
    return encryptor.decrypt(input);
  }

}