package PruebaWorkbook.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {

	void copy(InputStream source, File target) throws IOException {

		InputStream in = source;
		OutputStream out = new FileOutputStream(target);
		

		byte[] buf = new byte[1024];
		int len;

		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}

		in.close();
		out.close();
	}

}
