package com.swz.voice.model;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class MESSAGE_INFO extends Structure {
	public short wEvent = 0;
	public int nReference = 0;
	public long dwParam = 0;

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList(new String[] { "wEventCode", "nReference",
				"dwParam" });
	}
}
