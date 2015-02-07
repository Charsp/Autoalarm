package com.swz.voice.model;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

public class SSM_EVENT extends Structure {
	short wEventCode; // event code
	int nReference; // reference
	int dwParam; // event parameter
	int dwUser; // user
	int dwSubReason; // event sub-reason
	int dwXtraInfo; // extra information
	int pvBuffer; // pointer to buffer
	int dwBufferLength; // length of buffer pointed by pvBuffer
	int dwDataLength; // length of data in buffer pointed by pvBuffer
	int dwEventFlag; // falgs of the following:
	// bit 0, =1 - App created the event
	// =0 - SHP_A3.DLL created the event
	// bit 1, Reserved
	// bit 2, =1 - data has been truncated
	// =0 - data has not been truncated
	int dwReserved1; // reserved
	long llReserved2; // reserved

	@Override
	protected List<String> getFieldOrder() {
		return Arrays.asList(new String[] { "wEventCode", "nReference",
				"dwParam", "dwUser", "dwSubReason", "dwXtraInfo", "pvBuffer",
				"dwBufferLength", "dwDataLength", "dwEventFlag", "dwReserved1",
				"llReserved2" });
	}
}
