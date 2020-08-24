package com.team.collabo.team.payload;

import com.team.collabo.team.model.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class TeamResponseDto {
    private Long id;
    private String name;
    private String description;
    List<MemberResponseDto> members = new ArrayList<>();

    @Builder
    public TeamResponseDto(Long id, String name, String description, List<MemberResponseDto> members) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.members = members;
    }

    public static TeamResponseDto TeamResponseDtoMapper(final Team team) {
        return TeamResponseDto.builder()
                .id(team.getId())
                .name(team.getName())
                .description(team.getDescription())
                .members(team.getMembers().stream()
                        .map(MemberResponseDto::MemberResponseDtoMapper)
                        .collect(Collectors.toList()))
                .build();
    }
}
