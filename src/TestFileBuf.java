import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;


public class TestFileBuf {

	//junit
	@Test
	public void testFileBuf() throws IOException{
		File fobj=new File("D:\\succezIDE\\workspace\\Filetobuf\\a.txt.txt");
		byte[] buff = Filetobuf.fileTobuf(fobj);
		String actual = new String(buff, "utf-8");
		Assert.assertEquals("import java.io.File;\r\nimport java.io.FileInputStream;\r\nimport java.util.Arrays;", actual);
	}
}
