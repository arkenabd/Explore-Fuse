package com.netty.fuse;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.netty.fuse.util.ISOUtil;

import emp.info.ws.main.EmpInfoRequest;
import emp.info.ws.main.EmpInfoResult;
import emp.info.ws.main.EmpInfoWs;
import emp.info.ws.main.EmpInfoWs_Service;

@Service
public class EchoService {
	public String sayHello(String inputVal) throws ISOException {
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
		// 2. Use the unpacked ISO8583 values as input to client services
        EmpInfoWs_Service empInfoWs_Service = new EmpInfoWs_Service();
        EmpInfoWs empInfoWs = empInfoWs_Service.getEmpInfoWsPort();
		EmpInfoRequest request = new EmpInfoRequest();
		request.setId("1");
		EmpInfoResult response = empInfoWs.getEmployeeInfo(request);
		System.out.println(response.getAddress());
		System.out.println(response.getId());
		System.out.println(response.getDivision());
		System.out.println(response.getName());
		// 3.If the response is 'Mail Sent!' then pack ISO8583
		String result = "";
		if (response.getId() != null && response.getId() != "") {
			isoMsg = new ISOMsg();
			// Setting packager
			GenericPackager packager = new GenericPackager("src/main/resources/iso8583JPosXml.xml");

			isoMsg.setPackager(packager);

			// Setting MTI
			isoMsg.set(0, "0100");

			// Setting processing code
			isoMsg.set(3, "020000");

			// Setting transaction amount
			isoMsg.set(4, "5000");

			// Setting transmission date and time
			isoMsg.set(7, new SimpleDateFormat("MMddHHmmss").format(new Date()));

			// Setting system trace audit number
			isoMsg.set(11, "123456");

			// Setting data element #48
			isoMsg.set(48, "Example Return Value :" + response.getAddress() + ";" + response.getId() + ";"
					+ response.getDivision() + ";" + response.getName());
			result = isoUtil.pack(isoMsg);
			
		} else {
			result = "no response";
		}
		
		return result;
	}
}