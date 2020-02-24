package com.netty.fuse.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

public class ISOUtil {

	public String pack(ISOMsg isoMsg) throws ISOException {
		// Initialize packager. in this example, I'm using
		// XML packager. We also can use Java Code Packager
		// This code throws ISOException
		GenericPackager packager = new GenericPackager("src/main/resources/iso8583JPosXml.xml");

		// pack the ISO 8583 Message
		byte[] bIsoMsg = isoMsg.pack();

		// output ISO 8583 Message String
		String isoMessage = "";
		for (int i = 0; i < bIsoMsg.length; i++) {
			isoMessage += (char) bIsoMsg[i];
		}
		System.out.println("Packed ISO8385 Message = '" + isoMessage + "'");

		return isoMessage;
	}

	public ISOMsg unpack(String input) throws ISOException {

		System.out.println("Input : " + input);
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
		String isoMessage = input;
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

		return isoMsg;
	}

}
