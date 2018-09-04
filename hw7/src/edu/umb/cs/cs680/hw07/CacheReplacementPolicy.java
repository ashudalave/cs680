package edu.umb.cs.cs680.hw07;

import java.util.HashMap;

public interface CacheReplacementPolicy {
	public void replace(HashMap<String, String> cache, String targetFile);
}
