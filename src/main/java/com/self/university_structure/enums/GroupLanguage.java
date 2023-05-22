package com.self.university_structure.enums;


import lombok.Getter;

@Getter
public enum GroupLanguage {
    UZBEK(1),
    ENGLISH(2),
    RUSSIAN(3);

    private final int code;

    GroupLanguage(int code) {
        this.code = code;
    }

    public static GroupLanguage getByCode(Integer code) {
        var values = GroupLanguage.values();
        for (GroupLanguage value  : values) {
            if (value.getCode() == code)
                return value;
        }

        return UZBEK;
    }
}
