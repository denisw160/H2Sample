package me.wirries.sample.h2sample.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * This is an entity for the table SAMPLE.
 *
 * @author denisw
 * @version 1.0
 * @since 17.03.2019
 */
@Entity(name = "SAMPLE")
public class Sample {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UUID", length = 36)
    private String uuid;

    @Column(name = "VALUE1", length = 250)
    private String value1;

    @Column(name = "VALUE2")
    private Integer value2;

    @Column(name = "VALUE3")
    private Date value3;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public Integer getValue2() {
        return value2;
    }

    public void setValue2(Integer value2) {
        this.value2 = value2;
    }

    public Date getValue3() {
        return value3;
    }

    public void setValue3(Date value3) {
        this.value3 = value3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Sample sample = (Sample) o;

        return new EqualsBuilder()
                .append(uuid, sample.uuid)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(uuid)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uuid", uuid)
                .append("value1", value1)
                .append("value2", value2)
                .append("value3", value3)
                .toString();
    }

}
