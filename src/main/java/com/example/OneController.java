/*
 * Copyright (c) 2016 Citrix Online LLC
 * All Rights Reserved Worldwide.
 *
 * THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO CITRIX ONLINE
 * AND CONSTITUTES A VALUABLE TRADE SECRET.  Any unauthorized use,
 * reproduction, modification, or disclosure of this program is
 * strictly prohibited.  Any use of this program by an authorized
 * licensee is strictly subject to the terms and conditions,
 * including confidentiality obligations, set forth in the applicable
 * License and Co-Branding Agreement between Citrix Online LLC and
 * the licensee.
 */
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneController{

    @Autowired
    private OneRepository or;
    
    @RequestMapping(value = "/api/one", method = RequestMethod.GET)
    public void getSessions1(@RequestParam("oneKey") Long oneKey) {
	    System.out.println(or.findQuery1(oneKey, 1L));
        One one1 = or.findQuery2(oneKey);
        for(Many many : one1.getMany()){
            System.out.println(many);
        }
    }

}
