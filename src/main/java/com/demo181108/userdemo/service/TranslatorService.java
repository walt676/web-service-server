package com.demo181108.userdemo.service;

import com.demo181108.userdemo.webxml.ArrayOfString;
import org.springframework.stereotype.Service;

@Service
public interface TranslatorService {

    ArrayOfString getResult(String s);
}
