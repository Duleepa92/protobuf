package com.epic.digital.platform.converter.impl;


import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.epic.digital.platform.converter.domain.FundTransferReq;
import com.epic.digital.platform.converter.proto.FundTransfer.Transcation;
import com.epic.digital.platform.converter.service.ConverterService;

@Service
public class ConverterServiceImpl implements ConverterService {

	@Value("${file.path}")
	private String filePath;
	
	@Autowired
	private Producer<String, Transcation> producer;
	
	@Value(value = "${digital.platform.request.topic.name}")
	private String reqTopicName;

	@Override
	public void convertRestToProtobuff(FundTransferReq fundTransferReq) {
		
		Transcation transaction = Transcation.newBuilder().setMode(fundTransferReq.getMode())
				.setFromAccount(fundTransferReq.getFromAccount())
				.setToAccount(fundTransferReq.getToAccount())
				.setTxnAmount(fundTransferReq.getTxnAmount())
				.setDateTime(fundTransferReq.getDateTime())
				.setNarration(fundTransferReq.getNarration())
				.setPayeeId(fundTransferReq.getPayeeId())
				.setPayeeName(fundTransferReq.getPayeeName())
				.setToBank(fundTransferReq.getToBank())
				.setToBranch(fundTransferReq.getToBranch())
				.setRecieverName(fundTransferReq.getRecieverName())
				.setReceiverId(fundTransferReq.getReceiverId())
				.setCurrency(fundTransferReq.getCurrency())
				.setRecieverAddress(fundTransferReq.getRecieverAddress())
				.setPurpose(fundTransferReq.getPurpose())
				.setChgAmt(fundTransferReq.getChgAmt())
				.setBranchName(fundTransferReq.getBranchName())
				.setBankName(fundTransferReq.getBankName())
				.setHolderName(fundTransferReq.getHolderName())
				.setTransactionID(fundTransferReq.getTransactionID())
				.setModeOfOperation(fundTransferReq.getModeOfOperation())
				.setLatitude(fundTransferReq.getLatitude())
				.setLongitude(fundTransferReq.getLongitude())
				.setFromProductType(fundTransferReq.getFromProductType())
				.setToProductType(fundTransferReq.getToProductType())
				.setUserId(fundTransferReq.getUserId()).build();


		ProducerRecord<String, Transcation> record
        = new ProducerRecord<>(reqTopicName, null, transaction);
		
		producer.send(record);
		producer.flush();
		 
	}	

}
