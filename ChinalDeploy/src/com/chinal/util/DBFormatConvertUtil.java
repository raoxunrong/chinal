package com.chinal.util;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

public class DBFormatConvertUtil {

	public static String convertClobToString(Clob clob) throws IOException {
		StringBuffer sb = new StringBuffer(1024);
		Reader instream = null;
		try {
			instream = clob.getCharacterStream();
			char[] buffer = new char[(int) clob.length()];
			while ((instream.read(buffer)) != -1) {
				sb.append(buffer);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (instream != null) {
				instream.close();
			}
		}
		return sb.toString();
	}
	
	public static Clob convertStringToClob(String content) throws SerialException, SQLException{
		return new SerialClob(content.toCharArray());
	}
}
