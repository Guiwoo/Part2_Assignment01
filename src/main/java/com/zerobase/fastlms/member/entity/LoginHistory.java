package com.zerobase.fastlms.member.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class LoginHistory {
    //email id
    @Id
    private String id;

    private LocalDateTime loginDate;
    private String loginIp;

    private String UserAgent;
}
