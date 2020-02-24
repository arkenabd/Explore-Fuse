package com.fl.parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FLOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String line = "#food was testy. #drink lots of. #night was fab. #three
		// #four";
		String line = "00000673020200120hnbnid-dSWDK000000658100192.168.87.32                          AABBCCDDEEFFTHOSHOS00000QA20200120151650480                                 HOS_0024EAS00050                                R10EN                                                                                 _HLIHDLST_SWDKWSCONS9999                              2020012015165500658100000000658100PDFMAIL|didik.haryadi@kebhana.co.id                       |5473010100|460221******9999    |123456|DIDIK HARYADI                                                                                       |Kartu Debit VISA IDR                              | VISA IDR Debit Card                               |@@";
		// line = line.replace(" ", "");
//		line= line.trim();
		Pattern pattern = Pattern.compile("\\|[^s]*");

		Matcher matcher = pattern.matcher(line);
		int i = 1;
		String found1 = "";
		while (matcher.find()) {
			System.out.println(i++);
			System.out.println(matcher.group().toString());
			found1 = matcher.group().toString();
		}

		String[] found2 = found1.split("|");
		for (int z = 0; z < found2.length; z++) {
			System.out.println(found2[z].toString());
		}
	}

}
