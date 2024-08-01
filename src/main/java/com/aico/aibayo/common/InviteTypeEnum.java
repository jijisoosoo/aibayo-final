package com.aico.aibayo.common;

import lombok.Getter;

@Getter
public enum InviteTypeEnum {
    TEACHER(0),
    KID(1);

    private final int type;

    InviteTypeEnum(int type) {
        this.type = type;
    }

    static InviteTypeEnum findByType(int type) {
        for (InviteTypeEnum inviteTypeEnum : InviteTypeEnum.values()) {
            if (type == inviteTypeEnum.getType()) {
                return inviteTypeEnum;
            }
        }

        throw new IllegalArgumentException("일치하는 값이 존재하지 않습니다.");
    }
}
