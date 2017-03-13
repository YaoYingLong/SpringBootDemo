package com.nokia.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String kecheng;

    @Column
    private String fenshu;

    @Column
    private String student_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKecheng() {
        return kecheng;
    }

    public void setKecheng(String kecheng) {
        this.kecheng = kecheng;
    }

    public String getFenshu() {
        return fenshu;
    }

    public void setFenshu(String fenshu) {
        this.fenshu = fenshu;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kecheng='" + kecheng + '\'' +
                ", fenshu='" + fenshu + '\'' +
                ", student_id='" + student_id + '\'' +
                '}';
    }
}
