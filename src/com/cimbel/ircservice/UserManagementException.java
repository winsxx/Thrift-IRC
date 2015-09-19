/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.cimbel.ircservice;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import javax.annotation.Generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-9-18")
public class UserManagementException extends TException implements org.apache.thrift.TBase<UserManagementException, UserManagementException._Fields>, java.io.Serializable, Cloneable, Comparable<UserManagementException> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UserManagementException");

  private static final org.apache.thrift.protocol.TField ERROR_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("errorType", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("message", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UserManagementExceptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UserManagementExceptionTupleSchemeFactory());
  }

  /**
   * 
   * @see UserManagementErrorType
   */
  public UserManagementErrorType errorType; // required
  public String message; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see UserManagementErrorType
     */
    ERROR_TYPE((short)1, "errorType"),
    MESSAGE((short)2, "message");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ERROR_TYPE
          return ERROR_TYPE;
        case 2: // MESSAGE
          return MESSAGE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ERROR_TYPE, new org.apache.thrift.meta_data.FieldMetaData("errorType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, UserManagementErrorType.class)));
    tmpMap.put(_Fields.MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("message", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UserManagementException.class, metaDataMap);
  }

  public UserManagementException() {
  }

  public UserManagementException(
    UserManagementErrorType errorType,
    String message)
  {
    this();
    this.errorType = errorType;
    this.message = message;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UserManagementException(UserManagementException other) {
    if (other.isSetErrorType()) {
      this.errorType = other.errorType;
    }
    if (other.isSetMessage()) {
      this.message = other.message;
    }
  }

  public UserManagementException deepCopy() {
    return new UserManagementException(this);
  }

  @Override
  public void clear() {
    this.errorType = null;
    this.message = null;
  }

  /**
   * 
   * @see UserManagementErrorType
   */
  public UserManagementErrorType getErrorType() {
    return this.errorType;
  }

  /**
   * 
   * @see UserManagementErrorType
   */
  public UserManagementException setErrorType(UserManagementErrorType errorType) {
    this.errorType = errorType;
    return this;
  }

  public void unsetErrorType() {
    this.errorType = null;
  }

  /** Returns true if field errorType is set (has been assigned a value) and false otherwise */
  public boolean isSetErrorType() {
    return this.errorType != null;
  }

  public void setErrorTypeIsSet(boolean value) {
    if (!value) {
      this.errorType = null;
    }
  }

  public String getMessage() {
    return this.message;
  }

  public UserManagementException setMessage(String message) {
    this.message = message;
    return this;
  }

  public void unsetMessage() {
    this.message = null;
  }

  /** Returns true if field message is set (has been assigned a value) and false otherwise */
  public boolean isSetMessage() {
    return this.message != null;
  }

  public void setMessageIsSet(boolean value) {
    if (!value) {
      this.message = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ERROR_TYPE:
      if (value == null) {
        unsetErrorType();
      } else {
        setErrorType((UserManagementErrorType)value);
      }
      break;

    case MESSAGE:
      if (value == null) {
        unsetMessage();
      } else {
        setMessage((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ERROR_TYPE:
      return getErrorType();

    case MESSAGE:
      return getMessage();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ERROR_TYPE:
      return isSetErrorType();
    case MESSAGE:
      return isSetMessage();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UserManagementException)
      return this.equals((UserManagementException)that);
    return false;
  }

  public boolean equals(UserManagementException that) {
    if (that == null)
      return false;

    boolean this_present_errorType = true && this.isSetErrorType();
    boolean that_present_errorType = true && that.isSetErrorType();
    if (this_present_errorType || that_present_errorType) {
      if (!(this_present_errorType && that_present_errorType))
        return false;
      if (!this.errorType.equals(that.errorType))
        return false;
    }

    boolean this_present_message = true && this.isSetMessage();
    boolean that_present_message = true && that.isSetMessage();
    if (this_present_message || that_present_message) {
      if (!(this_present_message && that_present_message))
        return false;
      if (!this.message.equals(that.message))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_errorType = true && (isSetErrorType());
    list.add(present_errorType);
    if (present_errorType)
      list.add(errorType.getValue());

    boolean present_message = true && (isSetMessage());
    list.add(present_message);
    if (present_message)
      list.add(message);

    return list.hashCode();
  }

  @Override
  public int compareTo(UserManagementException other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetErrorType()).compareTo(other.isSetErrorType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrorType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errorType, other.errorType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMessage()).compareTo(other.isSetMessage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMessage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.message, other.message);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("UserManagementException(");
    boolean first = true;

    sb.append("errorType:");
    if (this.errorType == null) {
      sb.append("null");
    } else {
      sb.append(this.errorType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("message:");
    if (this.message == null) {
      sb.append("null");
    } else {
      sb.append(this.message);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class UserManagementExceptionStandardSchemeFactory implements SchemeFactory {
    public UserManagementExceptionStandardScheme getScheme() {
      return new UserManagementExceptionStandardScheme();
    }
  }

  private static class UserManagementExceptionStandardScheme extends StandardScheme<UserManagementException> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UserManagementException struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ERROR_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.errorType = com.cimbel.ircservice.UserManagementErrorType.findByValue(iprot.readI32());
              struct.setErrorTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MESSAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.message = iprot.readString();
              struct.setMessageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, UserManagementException struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.errorType != null) {
        oprot.writeFieldBegin(ERROR_TYPE_FIELD_DESC);
        oprot.writeI32(struct.errorType.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.message != null) {
        oprot.writeFieldBegin(MESSAGE_FIELD_DESC);
        oprot.writeString(struct.message);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UserManagementExceptionTupleSchemeFactory implements SchemeFactory {
    public UserManagementExceptionTupleScheme getScheme() {
      return new UserManagementExceptionTupleScheme();
    }
  }

  private static class UserManagementExceptionTupleScheme extends TupleScheme<UserManagementException> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UserManagementException struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetErrorType()) {
        optionals.set(0);
      }
      if (struct.isSetMessage()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetErrorType()) {
        oprot.writeI32(struct.errorType.getValue());
      }
      if (struct.isSetMessage()) {
        oprot.writeString(struct.message);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UserManagementException struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.errorType = com.cimbel.ircservice.UserManagementErrorType.findByValue(iprot.readI32());
        struct.setErrorTypeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.message = iprot.readString();
        struct.setMessageIsSet(true);
      }
    }
  }

}

