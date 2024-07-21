package com.aico.aibayo.common;

public enum MemberRoleEnum {
    ADMIN(0),
    PRINCIPAL(1),
    TEACHER(2),
    PARENT(3);

    private final int role;

    MemberRoleEnum(int role) {
        this.role = role;
    }

    static MemberRoleEnum findByType(int role) {
        for (MemberRoleEnum memberRole : MemberRoleEnum.values()) {
            if (role == memberRole.role) {
                return memberRole;
            }
        }

        throw new IllegalArgumentException("일치하는 값이 존재하지 않습니다.");
    }
}
