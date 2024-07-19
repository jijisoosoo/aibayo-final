package com.aico.aibayo.common;

import lombok.Getter;

@Getter
public enum KinderEnum {
    announce_on(0),announce_off(1),
    notepad_on(0),notepad_off(1),
    meal_on(0),meal_off(1),
    medication_on(0),medication_off(1),
    home_on(0),home_off(1),
    attendance_on(0),attendance_off(1),
    schedule_on(0),schedule_off(1),
    pick_drop_on(0),pick_drop_off(1),
    life_record_on(0),life_record_off(1),
    chat_on(0),chat_off(0);

    private int num;

    KinderEnum(int num) {
        this.num = num;
    }
    static KinderEnum findByNumber ( int num ) {
        for (KinderEnum function : KinderEnum.values()) {
            {
                if (num == function.num) {
                    return function;
                }
            }
        }
        throw new IllegalArgumentException("일치하는 값이 존재하지 않습니다.");
    }
}
