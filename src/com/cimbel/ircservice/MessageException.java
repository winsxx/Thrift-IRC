/**
 * Autogenerated by Thrift Compiler (0.9.2)
 * <p>
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package com.cimbel.ircservice;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

import javax.annotation.Generated;
import java.util.*;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-9-17")
public class MessageException extends TException implements org.apache.thrift.TBase<MessageException, MessageException._Fields>, java.io.Serializable, Cloneable, Comparable<MessageException> {
    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MessageException");
    private static final org.apache.thrift.protocol.TField ERROR_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("errorType", org.apache.thrift.protocol.TType.I32, (short) 1);
    private static final org.apache.thrift.protocol.TField MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("message", org.apache.thrift.protocol.TType.STRING, (short) 2);
    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();

    static {
        schemes.put(StandardScheme.class, new MessageExceptionStandardSchemeFactory());
        schemes.put(TupleScheme.class, new MessageExceptionTupleSchemeFactory());
    }

    static {
        Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.ERROR_TYPE, new org.apache.thrift.meta_data.FieldMetaData("errorType", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, MessageErrorType.class)));
        tmpMap.put(_Fields.MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("message", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        metaDataMap = Collections.unmodifiableMap(tmpMap);
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MessageException.class, metaDataMap);
    }

    /**
     * @see MessageErrorType
     */
    public MessageErrorType errorType; // required
    public String message; // required

    public MessageException() {
    }

    public MessageException(
            MessageErrorType errorType,
            String message) {
        this();
        this.errorType = errorType;
        this.message = message;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public MessageException(MessageException other) {
        if (other.isSetErrorType()) {
            this.errorType = other.errorType;
        }
        if (other.isSetMessage()) {
            this.message = other.message;
        }
    }

    public MessageException deepCopy() {
        return new MessageException(this);
    }

    @Override
    public void clear() {
        this.errorType = null;
        this.message = null;
    }

    /**
     * @see MessageErrorType
     */
    public MessageErrorType getErrorType() {
        return this.errorType;
    }

    /**
     * @see MessageErrorType
     */
    public MessageException setErrorType(MessageErrorType errorType) {
        this.errorType = errorType;
        return this;
    }

    public void unsetErrorType() {
        this.errorType = null;
    }

    /**
     * Returns true if field errorType is set (has been assigned a value) and false otherwise
     */
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

    public MessageException setMessage(String message) {
        this.message = message;
        return this;
    }

    public void unsetMessage() {
        this.message = null;
    }

    /**
     * Returns true if field message is set (has been assigned a value) and false otherwise
     */
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
                    setErrorType((MessageErrorType) value);
                }
                break;

            case MESSAGE:
                if (value == null) {
                    unsetMessage();
                } else {
                    setMessage((String) value);
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

    /**
     * Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise
     */
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
        if (that instanceof MessageException)
            return this.equals((MessageException) that);
        return false;
    }

    public boolean equals(MessageException that) {
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
    public int compareTo(MessageException other) {
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

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MessageException(");
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

    public void validate() throws org.apache.thrift.TException {
        // check for required fields
        // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        try {
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
        try {
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    /**
     * The set of fields this struct contains, along with convenience methods for finding and manipulating them.
     */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        /**
         * @see MessageErrorType
         */
        ERROR_TYPE((short) 1, "errorType"),
        MESSAGE((short) 2, "message");

        private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

        static {
            for (_Fields field : EnumSet.allOf(_Fields.class)) {
                byName.put(field.getFieldName(), field);
            }
        }

        private final short _thriftId;
        private final String _fieldName;

        _Fields(short thriftId, String fieldName) {
            _thriftId = thriftId;
            _fieldName = fieldName;
        }

        /**
         * Find the _Fields constant that matches fieldId, or null if its not found.
         */
        public static _Fields findByThriftId(int fieldId) {
            switch (fieldId) {
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

        public short getThriftFieldId() {
            return _thriftId;
        }

        public String getFieldName() {
            return _fieldName;
        }
    }

    private static class MessageExceptionStandardSchemeFactory implements SchemeFactory {
        public MessageExceptionStandardScheme getScheme() {
            return new MessageExceptionStandardScheme();
        }
    }

    private static class MessageExceptionStandardScheme extends StandardScheme<MessageException> {

        public void read(org.apache.thrift.protocol.TProtocol iprot, MessageException struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();
            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    case 1: // ERROR_TYPE
                        if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                            struct.errorType = MessageErrorType.findByValue(iprot.readI32());
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

        public void write(org.apache.thrift.protocol.TProtocol oprot, MessageException struct) throws org.apache.thrift.TException {
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

    private static class MessageExceptionTupleSchemeFactory implements SchemeFactory {
        public MessageExceptionTupleScheme getScheme() {
            return new MessageExceptionTupleScheme();
        }
    }

    private static class MessageExceptionTupleScheme extends TupleScheme<MessageException> {

        @Override
        public void write(org.apache.thrift.protocol.TProtocol prot, MessageException struct) throws org.apache.thrift.TException {
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
        public void read(org.apache.thrift.protocol.TProtocol prot, MessageException struct) throws org.apache.thrift.TException {
            TTupleProtocol iprot = (TTupleProtocol) prot;
            BitSet incoming = iprot.readBitSet(2);
            if (incoming.get(0)) {
                struct.errorType = MessageErrorType.findByValue(iprot.readI32());
                struct.setErrorTypeIsSet(true);
            }
            if (incoming.get(1)) {
                struct.message = iprot.readString();
                struct.setMessageIsSet(true);
            }
        }
    }

}

