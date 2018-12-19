package com.demo181108.userdemo.service.impl;

import com.demo181108.userdemo.service.TranslatorService;
import com.demo181108.userdemo.webxml.ArrayOfString;
import com.demo181108.userdemo.webxml.TranslatorWebService;
import com.demo181108.userdemo.webxml.TranslatorWebServiceSoap;
import org.springframework.stereotype.Service;

@Service
public class TranslatorServiceImpl implements TranslatorService {

    TranslatorWebService translatorWebService = new TranslatorWebService();
    TranslatorWebServiceSoap soap = translatorWebService.getTranslatorWebServiceSoap();

    @Override
    public ArrayOfString getResult(String s) {
        ArrayOfString arrayOfString = soap.getEnCnTwoWayTranslator(s);
        return arrayOfString;
    }
}
