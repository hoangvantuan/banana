package banana.util.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author hoang_van_tuan
 *
 */
public class SystemUtil {

	public static void setSystemProperties(File file) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(file));
		System.setProperties(properties);
	}
}
