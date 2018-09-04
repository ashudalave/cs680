package edu.umb.cs.cs680.hw07;

import java.util.HashMap;

public class FileCache {
	private HashMap<String, String> cache = new HashMap<String, String>();
	private CacheReplacementPolicy cacheReplace;
	private String targetFile;
	private static FileCache instance = null;

	public FileCache FileCache() {
		if (instance == null) {
			instance = new FileCache();
			cacheReplace = new NullReplacement();
		}
		return instance;
	}

	public String fetch(String targetFile) {

		StringBuffer b = new StringBuffer();

		if (cache.containsKey(targetFile)) {
			return cache.get(targetFile);
		} else {
			if (cache.size() < 3) {
				cache.put(targetFile, b.toString());
			} else {
				replace(targetFile);
			}
		}
		return b.toString();
	}

	private void replace(String targetFile) {
		if (cacheReplace != null) {
			cacheReplace.replace(this.cache, targetFile);
		}
	}

	public void changePolicy(CacheReplacementPolicy cacheReplace) {
		this.cacheReplace = cacheReplace;

	}
}
