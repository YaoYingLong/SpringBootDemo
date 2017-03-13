package com.nokia.example.Entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * Created by YLongYao on 2016/10/5.
 */
public class UTEntity implements Comparable<UTEntity> , Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String type;

    public UTEntity(){}

    public UTEntity(Integer id , String type){
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        UTEntity utEntity = (UTEntity) o;

        return new EqualsBuilder()
                .append(id , utEntity.id)
                .append(type , utEntity.type).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17 , 37)
                .append(id).append(type)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "UTEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public int compareTo(UTEntity o) {
        if(id > o.id){
            return 1;
        }else if(id < o.id){
            return -1;
        }else if(id == o.id){
            if(type.compareTo(o.type) == 0) {
                return 0;
            } else {
                return type.compareTo(o.type);
            }
        }
        return 0;
    }
}
