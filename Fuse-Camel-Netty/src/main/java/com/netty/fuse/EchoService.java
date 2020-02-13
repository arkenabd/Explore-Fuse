package com.netty.fuse;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EchoService {
	public String sayHello(String inputVal) {
		System.out.println("Input : " + inputVal);
		GenericPackager packager = null;
		try {
			packager = new GenericPackager("src/main/resources/iso8583JPosXml.xml");
		} catch (ISOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Setting packager
		ISOMsg isoMsg = new ISOMsg();
		isoMsg.setPackager(packager);

		// this is ISO8583 Message that we will Unpack
//		String isoMessage = "010032200000000100000200000000000050000221151855123456013Example Value";
		String isoMessage = inputVal;
		// first, we must convert ISO8583 Message String to byte[]
		byte[] bIsoMessage = new byte[isoMessage.length()];
		for (int i = 0; i < bIsoMessage.length; i++) {
			bIsoMessage[i] = (byte) (int) isoMessage.charAt(i);
		}

		// second, we unpack the message
		try {
			isoMsg.unpack(bIsoMessage);
		} catch (ISOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

		//return "Unpack :  " + isoMsg;
		return inputVal;
	}
}