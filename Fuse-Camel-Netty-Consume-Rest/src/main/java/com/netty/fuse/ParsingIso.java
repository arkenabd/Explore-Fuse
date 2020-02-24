package com.netty.fuse;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.netty.fuse.util.ISOUtil;
import com.netty.fuse.util.PojoJson;

@Service
public class ParsingIso {
	public String parsingIsoMessage(String inputVal) throws ISOException {
		// 1. Unpack ISO8583 Message
		ISOMsg isoMsg = new ISOMsg();
		ISOUtil isoUtil = new ISOUtil();
		isoMsg = isoUtil.unpack(inputVal);
		// last, print the unpacked ISO8583
		try {
			System.out.println("MTI='" + isoMsg.getMTI());
		} catch (ISOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 1; i <= isoMsg.getMaxField(); i++) {
			if (isoMsg.hasField(i))
				System.out.println(i + "='" + isoMsg.getString(i));

		}

		return "{\"empId\":1,\"name\":\"emp1\",\"designation\":\"manager\",\"salary\":3000.0}";

	}

}