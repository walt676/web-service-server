package com.demo181108.userdemo.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public interface VoiceSynthesisService {

    Map<String, Object> getVoice(String text) throws IOException;

}
