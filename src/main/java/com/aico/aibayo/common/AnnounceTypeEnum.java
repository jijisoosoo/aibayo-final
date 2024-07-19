package com.aico.aibayo.common;

import lombok.Getter;

@Getter
public enum AnnounceTypeEnum {
    teacher(0),
    kinderInfo(1),
    notice(2),
    schedule(3),
    education(4),
    payment(5);

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
