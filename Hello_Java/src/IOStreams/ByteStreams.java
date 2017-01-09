package IOStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreams {
	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream("/Users/Saurabh/Documents/Eclipse_workspace/Hello_Java/src/IOStreams/foo.txt");
			out = new FileOutputStream("/Users/Saurabh/Documents/Eclipse_workspace/Hello_Java/src/IOStreams/outAgain.txt");
			int c;
			
			while ((c = in.read()) != -1)
				out.write(c);
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

}
