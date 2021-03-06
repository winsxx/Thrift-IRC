/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.cimbel.ircservice;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum UserManagementErrorType implements TEnum {
  USER_ID_NOT_FOUND(0),
  CHANNEL_NOT_FOUND(1),
  UNKNOWN_FAILURE(2);

  private final int value;

  private UserManagementErrorType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static UserManagementErrorType findByValue(int value) { 
    switch (value) {
      case 0:
        return USER_ID_NOT_FOUND;
      case 1:
        return CHANNEL_NOT_FOUND;
      case 2:
        return UNKNOWN_FAILURE;
      default:
        return null;
    }
  }
}
