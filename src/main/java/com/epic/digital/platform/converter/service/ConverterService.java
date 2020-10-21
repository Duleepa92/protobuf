/**
 * 
 */
package com.epic.digital.platform.converter.service;

import org.springframework.stereotype.Service;

import com.epic.digital.platform.converter.domain.FundTransferReq;

/**
 * @author duleepa_w
 *
 */

@Service
public interface ConverterService {
	
	public void convertRestToProtobuff(FundTransferReq fundTransferReq);

}
