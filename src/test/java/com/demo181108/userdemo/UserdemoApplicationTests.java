package com.demo181108.userdemo;

import com.demo181108.userdemo.domain.MessageBoard;
import com.demo181108.userdemo.domain.TranslateRecord;
import com.demo181108.userdemo.domain.User;
import com.demo181108.userdemo.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserdemoApplicationTests {

	@Autowired
	UserService userService;
	@Autowired
	MessageBoardService messageBoardService;
	@Autowired
	VoiceSynthesisService voiceSynthesisService;

	@Test
	public void contextLoads() throws IOException {


	    voiceSynthesisService.getVoice("一段新的语音,好爽！");
		//		userService.registerAccount(user);
//		System.out.println(userService.findByPage(1));
	}

}
