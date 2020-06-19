package com.kt.yoon.controller;

import com.kt.yoon.domain.Member;
import com.kt.yoon.domain.MemberSheet;
import com.kt.yoon.domain.Sheet;
import com.kt.yoon.service.MailService;
import com.kt.yoon.service.MemberService;
import com.kt.yoon.service.MemberSheetService;
import com.kt.yoon.service.SheetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = {"4.Mail"})
@Controller
@RequiredArgsConstructor
@ResponseBody
public class MailController {

    public final MailService mailService;
    private final SheetService sheetService;
    private final MemberService memberService;
    private final MemberSheetService memberSheetService;

    @ApiOperation(value = "시트 유저 모두에게 메일 보내기")
    @GetMapping("/send/{sheetId}")
    public void sendMailAll(@PathVariable String sheetId){
        Sheet sheet = sheetService.getSheetById(Long.parseLong(sheetId));
        List<Member> list = new ArrayList<>();
        List<String> token = new ArrayList<>();
        List<MemberSheet> sheetList = sheetService.getSheetDetail(sheet.getId());
        for(MemberSheet memberSheet:sheetList){
            list.add(memberSheet.getMember());
            token.add(memberSheet.getRandomToken());
        }
        mailService.sendMail(list,sheet,token);
    }

    //todo 한명에게 메일 보내기 ; sheetId,userMail
//    @RequestMapping("/send")
//    public void sendMailUser(String userId, String sheetId){
//
//    }

    //todo 미응답자에게 메일 보내기 ; sheetId

}
