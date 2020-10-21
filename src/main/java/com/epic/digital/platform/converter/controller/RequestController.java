/**
 * 
 */
package com.epic.digital.platform.converter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epic.digital.platform.converter.domain.FundTransferReq;
import com.epic.digital.platform.converter.param.EndPoint;
import com.epic.digital.platform.converter.service.ConverterService;

/**
 * @author duleepa_w
 *
 */

@RestController
@RequestMapping("/")
public class RequestController {
	
	@Autowired
	private ConverterService converterService;
	
	@PostMapping(value = EndPoint.DP_REQUEST_HANDLER, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void requestConvertor(@RequestBody FundTransferReq fundTransfer) {
		
		converterService.convertRestToProtobuff(fundTransfer);
			
	}
}
