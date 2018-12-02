import java.io.*;
import java.util.StringTokenizer;
import java.util.Hashtable;
import java.util.zip.GZIPInputStream;


public class Make {

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

		while (str != null) {
			str = str.trim();
//10000227870:30235028:The Lyons Mail (1916 film)
str = str.substring(str.indexOf(":")+1, str.length()).trim(); 
str = str.substring(str.indexOf(":")+1, str.length()).trim(); 
if (str.startsWith("Template:")) {}
else if (str.startsWith("Wikipedia:")) {}
else if (str.startsWith("File:")) {}
else if (str.startsWith("Category:")) {} 
else if (str.startsWith("Draft:")) {} 
else if (str.startsWith("Portal:")) {}
else {
str = str.replaceAll(" ", "_"); 
str = str.replaceAll("\\(", "\\\\("); 
str = str.replaceAll("\\)", "\\\\)");
System.out.println("wget https://en.wikipedia.org/wiki/" + str); 
}
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
