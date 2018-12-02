import java.io.*;
import java.util.StringTokenizer;
import java.util.Hashtable;

public class CalcPOSVecSimil {

	public static void main (String[] args) throws IOException {

		/**
		  reading entire list (de-ud-pos);;;
		 **/
		String fileName = args[0];
		BufferedReader d = new BufferedReader(new InputStreamReader(new FileInputStream(new File (fileName)), "UTF8"));

		String str = new String();
		String[] ar = new String[204800];
		int id = 0;
		str = d.readLine();
		while (str != null) {
			str = str.trim();
			ar[id++] = str;
			str = d.readLine();
		}
		d.close();

		/**
		  making a dev vector;; de-ud-dev.conllu.pos.uniq
		 **/
		fileName = args[1];
		d = new BufferedReader(new InputStreamReader(new FileInputStream(new File (fileName)), "UTF8"));
		str = new String();
		//String dev = new String[2048][2];
		int addr = 0;
		str = d.readLine();
		int total = 0;
		Hashtable dev = new Hashtable(); 
		while (str != null) {
			str = str.trim();
			String num = str.substring(0, str.indexOf(" ")).trim();
			String wd = str.substring(str.indexOf(" ")+1, str.length()).trim();
			total += Integer.parseInt(num);
			dev.put(wd, num);
			str = d.readLine();
		}
		d.close();

		double[] devVector = new double[id];
		//int devAddr = 0;
		for (int i=0; i<id; i++) {
			if(dev.get(ar[i])!=null) {
				devVector[i] = (double) Integer.parseInt((String)dev.get(ar[i]))/total; 
			}
			else {
				devVector[i] = 0; 
			}
		}

		/** 
		  Sentence by sentence in the training data;;;; 
		 **/
		fileName = args[2];
		d = new BufferedReader(new InputStreamReader(new FileInputStream(new File (fileName)), "UTF8"));

		str = new String();
		str = d.readLine();

		String[][] train = new String[2048][2];
		String[] sent = new String[2048];
		addr = 0; 
		int sentAddr = 0; 
		train[addr++][0] = "BOS"; 

		while (str != null) {
			str = str.trim();
			String delim = "\t";

			if (str.startsWith("#")) {
				sent[sentAddr++] = str;}
			else if (str.length()==0) {
				train[addr++][0] = "EOS"; 
				//String[] pos = new String[1024];
				Hashtable pos = new Hashtable();
				String triPOS = new String();
				for (int i=0; i<addr-2; i++) {
					triPOS = train[i][0] + ";" + train[i+1][0] + ";" + train[i+2][0]; 
					if (pos.get(triPOS)!=null) {
						pos.put(triPOS, (Integer) pos.get(triPOS)+1);
					}
					else { pos.put(triPOS, 1); }
				}

				double[] trainVector = new double[id];
				for (int i=0; i<id; i++) {
					if(pos.get(ar[i])!=null) {
						int freq = (Integer) pos.get(ar[i]); 
						trainVector[i] = (double) freq/addr; // normalized with # of words in the sentence.

					}
					else {
						trainVector[i] = 0;
					}
				}


				double similarity = cosineSimilarity(devVector, trainVector); 
				//System.out.println(similarity);
				double seuil = Double.parseDouble(args[3]); 
				if (similarity>=seuil) {
					for (int j=0; j<sentAddr; j++) 
						System.out.println(sent[j]); ;
					System.out.println();
				}


				train = new String[2048][2]; addr = 0; train[addr++][0] = "BOS";
				sent = new String[2048]; sentAddr = 0; 
			}
			else {
				String[] entry;
				entry = str.split(delim);
				if (entry[0].contains("-")) {
					sent[sentAddr++] = str;
				}
				else {
					train[addr][0] = entry[3];
					train[addr][1] = entry[6] + ";" + entry[7];
					sent[sentAddr++] = str; 
					addr++;
				}
			}
			str = d.readLine();
		}
		d.close();
	}

	public static double cosineSimilarity(double[] vectorA, double[] vectorB) {
		double dotProduct = 0.0;
		double normA = 0.0;
		double normB = 0.0;
		for (int i = 0; i < vectorA.length; i++) {
			dotProduct += vectorA[i] * vectorB[i];
			normA += Math.pow(vectorA[i], 2);
			normB += Math.pow(vectorB[i], 2);
		}   
		return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
	}

}


