package com.aico.aibayo.common;

public enum SidoInfoEnum {
    ALL("00","전국"),
    SEOUL("11","서울"),
    BUSAN("21","부산"),
    DAEGU("22","대구"),
    INCHEON("23","인천"),
    GWANGJU("24","광주"),
    DAEJEON("25","대전"),
    ULSAN("26","울산"),
    SEJONG("29","세종"),
    GYEONGGI("31","경기"),
    GANGWON("32","강원"),
    CHUNGBUK("33","충북"),
    CHUNGNAM("34","충남"),
    JEOLLABUK("35","전북"),
    JEOLLANAM("36","전남"),
    GYEONGBUK("37","경북"),
    GYEONGNAM("38","경남"),
    JEJU("39","제주");

    private final String sidoCode;
    private final String sidoName;

    SidoInfoEnum(String sidoCode, String sidoName) {
        this.sidoCode = sidoCode;
        this.sidoName = sidoName;
    }

    public static SidoInfoEnum findBySidoCode(String sidoCode) {
        for (SidoInfoEnum sidoInfo : SidoInfoEnum.values()) {
            if (sidoCode.equals(sidoInfo.sidoCode)) {
                return sidoInfo;
            }
        }

        throw new IllegalArgumentException("일치하는 값이 존재하지 않습니다.");
    }

    public static SidoInfoEnum findBySidoName(String sidoName) {
        for (SidoInfoEnum sidoInfo : SidoInfoEnum.values()) {
            if (sidoName.equals(sidoInfo.sidoName)) {
                return sidoInfo;
            }
        }

        throw new IllegalArgumentException("일치하는 값이 존재하지 않습니다.");
    }
}
