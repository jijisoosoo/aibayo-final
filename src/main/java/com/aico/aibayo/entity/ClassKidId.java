package com.aico.aibayo.entity;

import java.io.Serializable;
import java.util.Objects;

public class ClassKidId implements Serializable {
    private int classNo;
    private int kidNo;

    // 기본 생성자
    public ClassKidId() {}

    // 생성자
    public ClassKidId(int classNo, int kidNo) {
        this.classNo = classNo;
        this.kidNo = kidNo;
    }

    // equals 및 hashCode 메서드 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassKidId that = (ClassKidId) o;
        return classNo == that.classNo && kidNo == that.kidNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classNo, kidNo);
    }
}