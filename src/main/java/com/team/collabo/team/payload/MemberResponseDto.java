package com.team.collabo.team.payload;

import com.team.collabo.team.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String nickname;

    public MemberResponseDto(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public static MemberResponseDto MemberResponseDtoMapper(final Member member) {
        return new MemberResponseDto(member.getId(), member.getNickname());
    }
}
