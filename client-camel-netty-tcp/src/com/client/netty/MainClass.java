package com.client.netty;

import java.net.*;
import java.io.*;

/**
 * This program is a socket client application that connects to a time server to
 * get the current date time.
 *
 * @author www.codejava.net
 */
public class MainClass {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("localhost");
			Socket socket = new Socket(address, 7000);
			OutputStream os = socket.getOutputStream();

			System.out.println("Message sent.");
			String str = "010032200000000100000200000000000050000221151855123456013|AAA|BBB|CCC|DDD";

			byte[] byteArr = str.getBytes();
			os.write(byteArr, 0, byteArr.length);

			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String msgReceived = br.readLine();

			System.out.println("Message received.");

			System.out.println(msgReceived);
			os.flush();
			os.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}