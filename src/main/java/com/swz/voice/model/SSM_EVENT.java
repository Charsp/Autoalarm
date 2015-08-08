package com.swz.voice.model;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class SSM_EVENT extends Structure {
	public short wEventCode; // event code
	public int nReference; // reference
	public int dwParam; // event parameter
	public int dwUser; // user
	public int dwSubReason; // event sub-reason
	public int dwXtraInfo; // extra information
	public int pvBuffer; // pointer to buffer
	public int dwBufferLength; // length of buffer pointed by pvBuffer
	public int dwDataLength; // length of data in buffer pointed by pvBuffer
	public int dwEventFlag; // falgs of the following:
	// bit 0, =1 - App created the event
	// =0 - SHP_A3.DLL created the event
	// bit 1, Reserved
	// bit 2, =1 - data has been truncated
	// =0 - data has not been truncated
	public int dwReserved1; // reserved
	public long llReserved2; // reserved

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList(new String[] { "wEventCode", "nReference",
				"dwParam", "dwUser", "dwSubReason", "dwXtraInfo", "pvBuffer",
				"dwBufferLength", "dwDataLength", "dwEventFlag", "dwReserved1",
				"llReserved2" });
	}
}
