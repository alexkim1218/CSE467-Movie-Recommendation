import java.io.*;
import java.util.StringTokenizer;
import java.util.Hashtable;
import java.util.zip.GZIPInputStream;


public class ConvertHorizontal2Vertical {

	public static void main (String[] args) throws IOException {

		String fileName = args[0];
		//	BufferedReader d = new BufferedReader(new InputStreamReader(new FileInputStream(new File (fileName))));
		//                OutputStreamWriter out = new OutputStreamWriter (new FileOutputStream(fileName+".1"), "UTF-8");
		BufferedReader d;
		if (fileName.endsWith(".gz")) {
			d = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(new File(fileName)))));
		}
		else {
			d = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
		}
		String str = new String();
		str = d.readLine();

int id = 0; 

		while (str != null) {
			str = str.trim();

			String delim = " ";
			String[] entry;
			entry = str.split(delim);

			for (int i=0; i<entry.length; i++) {
				String tok = entry[i];
if (id==0 && i==0) {}
else {
				System.out.println(tok); 
}
			}
			System.out.println(); 

id++; 
			str = d.readLine();
		}
		d.close();
	}
}

/*
   StringTokenizer st = new StringTokenizer(str, delim);
   while (st.hasMoreTokens()) {
   String tok = st.nextToken();
   }
 */
/*
   Enumeration k = hash.keys();
   while(k.hasMoreElements()) {
   String key = (String) k.nextElement();
   System.out.println(key + "\t" + hash.get(key));
   }
 */
