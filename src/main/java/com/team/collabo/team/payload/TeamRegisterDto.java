package com.team.collabo.team.payload;

import lombok.NoArgsConstructor;

public class TeamRegisterDto {
    private String name;
    private String desc;

    public TeamRegisterDto() {}

    public TeamRegisterDto(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }


    public String getDesc() {
        return desc;
    }
}
