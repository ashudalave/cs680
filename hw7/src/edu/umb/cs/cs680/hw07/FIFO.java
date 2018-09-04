package edu.umb.cs.cs680.hw07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class FIFO implements CacheReplacementPolicy {

	@Override
	public void replace(HashMap<String, String> cache, String targetFile) {

		Iterator<String> it = cache.keySet().iterator();
		String remove = null;
		while (it.hasNext()) {
			remove = it.next();
		}
		cache.remove(remove);
		BufferedReader b = null;
		FileReader f = null;
		try {
			f = new FileReader(targetFile);
			b = new BufferedReader(f);

			String currentLine;
			StringBuffer bf = new StringBuffer();
			while ((currentLine = b.readLine()) != null) {
				bf.append(currentLine);
			}
			cache.put(targetFile, b.toString());
			if (b != null)
				b.close();
			if (f != null)
				f.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
