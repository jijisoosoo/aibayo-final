package com.aico.aibayo.common;

import lombok.Getter;

@Getter
public enum AnnounceTypeEnum {
    TEACHER(0),
    NOTICE(1),
    SCHEDULE(2),
    EDUCATION(3),
    PAYMENT(4);

    private int num;

    AnnounceTypeEnum(int num) {
        this.num = num;
    }

    static AnnounceTypeEnum findByNumber (int num){
        for(AnnounceTypeEnum announceType : AnnounceTypeEnum.values()){{
            if(num == announceType.num){
                return announceType;
            }
        }}
        throw new IllegalArgumentException("일치하는 값이 존재하지 않습니다.");
    }
}
