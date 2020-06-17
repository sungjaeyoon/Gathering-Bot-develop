package com.kt.yoon.domain;

import com.kt.yoon.domain.type.RequestStatus;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class MemberSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_sheet_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sheet_id")
    private Sheet sheet;

    private String response;

    private LocalDateTime responseDate;

    private LocalDateTime modifiedDate;

    @Enumerated(value = EnumType.STRING)
    private RequestStatus requestStatus;

    //==생성 메소드==//
    public MemberSheet() {
    }

    public MemberSheet(Member member, Sheet sheet){
        this.member=member;
        this.sheet=sheet;
        this.requestStatus=RequestStatus.NO;
    }
}
