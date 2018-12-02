import java.io.*;
import java.util.StringTokenizer;
import java.util.Hashtable;
import java.util.zip.GZIPInputStream;


public class GetPlot {

	public static void main (String[] args) throws IOException {

		String fileName = args[0];
		String tempo = fileName; 
		String fileNameText = tempo.substring(0, tempo.lastIndexOf(".html")).trim(); 
		//	BufferedReader d = new BufferedReader(new InputStreamReader(new FileInputStream(new File (fileName))));
		OutputStreamWriter out = new OutputStreamWriter (new FileOutputStream(fileNameText+".plot"), "UTF-8");
		BufferedReader d;
		if (fileName.endsWith(".gz")) {
			d = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(new File(fileName)))));
		}
		else {
			d = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
		}
		String str = new String();
		str = d.readLine();

		boolean flag = false; 

		while (str != null) {
			str = str.trim();
			if (str.contains("<h2><span class=\"mw-headline\" id=\"Plot\">" || "<b>Synopsis</b>")) flag = true; 
			if (flag) {// out.write(str + "\n");
				if (str.contains("<h2><span class=\"mw-headline\" id=")) {
					if (!str.contains("<h2><span class=\"mw-headline\" id=\"Plot\">"))  flag = false; 
				}
				if (flag) out.write(str + "\n");

			}
			str = d.readLine();
		}
		d.close();
		out.close(); 
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
