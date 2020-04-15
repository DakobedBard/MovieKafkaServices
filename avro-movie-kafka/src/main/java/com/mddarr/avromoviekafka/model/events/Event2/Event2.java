/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.mddarr.avromoviekafka.model.events.Event2;  
@SuppressWarnings("all")
/** Schema for hr.ivlahek.showcase.event.dto.Event2 */
@org.apache.avro.specific.AvroGenerated
public class Event2 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Event2\",\"namespace\":\"com.mddarr.avromoviekafka.model.events.Event2\",\"doc\":\"Schema for hr.ivlahek.showcase.event.dto.Event2\",\"fields\":[{\"name\":\"hits\",\"type\":\"int\"},{\"name\":\"timestamp\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int hits;
  @Deprecated public long timestamp;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public Event2() {}

  /**
   * All-args constructor.
   */
  public Event2(java.lang.Integer hits, java.lang.Long timestamp) {
    this.hits = hits;
    this.timestamp = timestamp;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return hits;
    case 1: return timestamp;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: hits = (java.lang.Integer)value$; break;
    case 1: timestamp = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'hits' field.
   */
  public java.lang.Integer getHits() {
    return hits;
  }

  /**
   * Sets the value of the 'hits' field.
   * @param value the value to set.
   */
  public void setHits(java.lang.Integer value) {
    this.hits = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   */
  public java.lang.Long getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(java.lang.Long value) {
    this.timestamp = value;
  }

  /** Creates a new Event2 RecordBuilder */
  public static com.mddarr.avromoviekafka.model.events.Event2.Event2.Builder newBuilder() {
    return new com.mddarr.avromoviekafka.model.events.Event2.Event2.Builder();
  }
  
  /** Creates a new Event2 RecordBuilder by copying an existing Builder */
  public static com.mddarr.avromoviekafka.model.events.Event2.Event2.Builder newBuilder(com.mddarr.avromoviekafka.model.events.Event2.Event2.Builder other) {
    return new com.mddarr.avromoviekafka.model.events.Event2.Event2.Builder(other);
  }
  
  /** Creates a new Event2 RecordBuilder by copying an existing Event2 instance */
  public static com.mddarr.avromoviekafka.model.events.Event2.Event2.Builder newBuilder(com.mddarr.avromoviekafka.model.events.Event2.Event2 other) {
    return new com.mddarr.avromoviekafka.model.events.Event2.Event2.Builder(other);
  }
  
  /**
   * RecordBuilder for Event2 instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Event2>
    implements org.apache.avro.data.RecordBuilder<Event2> {

    private int hits;
    private long timestamp;

    /** Creates a new Builder */
    private Builder() {
      super(com.mddarr.avromoviekafka.model.events.Event2.Event2.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.mddarr.avromoviekafka.model.events.Event2.Event2.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.hits)) {
        this.hits = data().deepCopy(fields()[0].schema(), other.hits);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Event2 instance */
    private Builder(com.mddarr.avromoviekafka.model.events.Event2.Event2 other) {
            super(com.mddarr.avromoviekafka.model.events.Event2.Event2.SCHEMA$);
      if (isValidValue(fields()[0], other.hits)) {
        this.hits = data().deepCopy(fields()[0].schema(), other.hits);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'hits' field */
    public java.lang.Integer getHits() {
      return hits;
    }
    
    /** Sets the value of the 'hits' field */
    public com.mddarr.avromoviekafka.model.events.Event2.Event2.Builder setHits(int value) {
      validate(fields()[0], value);
      this.hits = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'hits' field has been set */
    public boolean hasHits() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'hits' field */
    public com.mddarr.avromoviekafka.model.events.Event2.Event2.Builder clearHits() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'timestamp' field */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }
    
    /** Sets the value of the 'timestamp' field */
    public com.mddarr.avromoviekafka.model.events.Event2.Event2.Builder setTimestamp(long value) {
      validate(fields()[1], value);
      this.timestamp = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'timestamp' field has been set */
    public boolean hasTimestamp() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'timestamp' field */
    public com.mddarr.avromoviekafka.model.events.Event2.Event2.Builder clearTimestamp() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public Event2 build() {
      try {
        Event2 record = new Event2();
        record.hits = fieldSetFlags()[0] ? this.hits : (java.lang.Integer) defaultValue(fields()[0]);
        record.timestamp = fieldSetFlags()[1] ? this.timestamp : (java.lang.Long) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
