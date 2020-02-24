package com.client.netty;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.jpos.iso.ISOException;
import org.springframework.stereotype.Component;

import com.json.netty.GenerateIso;
import com.json.netty.ParsingIso;

@Component
public class TcpClient {
	public void printParamIn(int id, String name) {
		System.out.println("Param IN :" + id + ";" + name);
	}

	public String call(int id, String name) {
		printParamIn(id, name);
		String msgReceived = "";
		try {
			InetAddress address = InetAddress.getByName("localhost");
			Socket socket = new Socket(address, 7000);
			OutputStream os = socket.getOutputStream();
			GenerateIso genIso = new GenerateIso();
			System.out.println("Message sent.");
			// String str = "010032200000000100000200000000000050000221151855123456013|" +
			// id + "|" + name;
			String str = genIso.generate(String.valueOf(id), name);
			byte[] byteArr = str.getBytes();
			os.write(byteArr, 0, byteArr.length);

			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			msgReceived = br.readLine();

			System.out.println("Message received.");

			System.out.println(msgReceived);
			os.flush();
			os.close();
			is.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		ParsingIso parsingIso = new ParsingIso();
		String returnJson = "";
		try {
			returnJson = parsingIso.parsingIsoMessage(msgReceived);
		} catch (ISOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnJson;
	}
}
