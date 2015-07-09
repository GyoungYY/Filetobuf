import java.io.BufferedInputStream;
//import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Filetobuf {
	public static byte[] fileTobuf(File fobj) throws IOException {
		BufferedInputStream is = null;
		try {
			is = new BufferedInputStream(new FileInputStream(fobj));
			long length = fobj.length();
			byte[] bytes = new byte[(int) length];
			int offset = 0;
			int numread = 0;
			while (offset < bytes.length && (numread = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numread;
			}
			if (offset < bytes.length) {
				throw new IOException("could not read file ");
			}
			
/*			ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);//读取文件的另一种方法
			bos.toByteArray(); */
			return bytes;
		}
		finally {
			if(is != null){
					is.close();
			}
		}
	}

	public static void main(String[] args){
		try{
			File fobj=new File("D:\\succezIDE\\workspace\\Filetobuf\\a.txt");
			if(fobj==null){
				System.out.println("file is null!");
			}
			byte[] bytes=fileTobuf(fobj);
			String str = new String(bytes, "utf-8");
		    System.out.println(str);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("IOException");
		}
	}
}
