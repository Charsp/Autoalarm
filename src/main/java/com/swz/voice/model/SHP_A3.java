package com.swz.voice.model;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * 
 */
public interface SHP_A3 extends Library {

	final int ANALOG_CH = 0;
	final int INTER_CH = 1;
	final int USER_CH = 2;
	final int REC_CH = 3;
	final int SS1_CH = 4;
	final int FAX_CH = 5;
	// } As int

	// //pending reason
	// enum{
	final int ANALOGOUT_NO_DIALTONE = 0;
	final int ANALOGOUT_BUSYTONE = 1;
	final int ANALOGOUT_ECHO_NOVOICE = 2;
	final int ANALOGOUT_NOANSWER = 3;
	final int ANALOGOUT_TALKING_REMOTE_HANGUPED = 4;

	final int SS1IN_WAIT_SET_KB = 10;
	final int SS1IN_BWD_KB5 = 11;
	final int SS1IN_TALKING_REMOTE_HANGUPED = 12; // // 鑷姩鍛煎叆鏃舵娴嬪埌涓诲彨鐢ㄦ埛鍏堟寕鏈�?;

	final int SS1OUT_TALKING_REMOTE_HANGUPED = 20; // //
													// 鑷姩鍛煎嚭杩涘叆閫氳瘽鍚庢娴嬪埌琚彨鐢ㄦ埛鍏堟寕鏈�?;
	final int SS1OUT_NOANSWER = 21; // // 绛夊緟琚彨鐢ㄦ埛鎽樻満瓒呮�?;
	final int SS1OUT_NOBWDACK = 22; // // 绛夊緟鍗犵敤搴旂瓟淇″彿瓒呮�?;
	final int SS1OUT_DIALING_BWD_HANGUP = 23; // // �?跺埌鍚庡悜鎷嗙嚎淇�?�彿;
	final int SS1OUT_BWD_A5 = 24; // // �?跺埌A=5锛堢┖鍙凤級淇�?�彿;
	final int SS1OUT_BWD_KB5 = 25; // // �?跺埌KB=5锛堢┖鍙凤級淇�?�彿;
	final int SS1OUT_BWD_KB2 = 26; // // 鐢ㄦ埛鈥滃競蹇欌��;
	final int SS1OUT_BWD_KB3 = 27; // // 鐢ㄦ埛鈥濋暱蹇欌��;
	final int SS1OUT_BWD_A4 = 28; // // 鏈洪敭鎷ュ;
	final int SS1OUT_BWD_KB4 = 29; // // �?跺埌KB=4锛堟�?閿嫢濉烇級淇�?�彿;
	final int SS1OUT_TIMEOUT_BWD_A = 30; // // 绛夊�欐帴鏀跺悗鍚慉缁勪俊鍙疯秴鏃�;
	final int SS1OUT_TIMEOUT_BWD_A_STOP = 31; // // 绛夊�欏悗鍚慉缁勪俊鍙峰仠鍙戣秴鏃�;
	final int SS1OUT_TIMEOUT_BWD_KB = 32; // // 鎺ユ敹鍚庡悜KB淇�?�彿瓒呮�?;
	final int SS1OUT_TIMEOUT_BWD_KB_STOP = 33; // // 绛夊�欒鍙柟鍋滃彂鍚庡悜KB淇�?�彿瓒呮�?;
	final int SS1OUT_TIMEOUT_CALLERID_BWD_A1 = 34; // // �?跺埌鏈畾涔夌殑鍚庡悜A缁勪俊鍙�?;
	final int SS1OUT_TIMEOUT_CALLERID_BWD_A1_STOP = 35; // //
														// 鍙戦�丆ALLERID鏃剁瓑鍊欏悗鍚慉缁勪俊鍙峰仠鍙戣秴鏃�?;
	final int SS1OUT_UNDEFINED_CALLERID_BWD_A = 36; // //
													// 鍙戦�佷富鍙彿鐮佹椂鏀跺埌鏈畾涔夌殑鍚庡悜A缁勪俊鍙�?;
	final int SS1OUT_UNDEFINED_BWD_A = 37; // // �?跺埌鏈畾涔夌殑鍚庡悜A缁勪俊鍙�?;
	final int SS1OUT_UNDEFINED_BWD_KB = 38; // // �?跺埌鏈畾涔夌殑KB淇�?�彿;
	// } As int

	// enum{
	final int S_CALL_STANDBY = 0;
	final int S_CALL_PICKUPED = 1;
	final int S_CALL_RINGING = 2;
	final int S_CALL_TALKING = 3;
	final int S_CALL_ANALOG_WAITDIALTONE = 4;
	final int S_CALL_ANALOG_TXPHONUM = 5;
	final int S_CALL_ANALOG_WAITDIALRESULT = 6;
	final int S_CALL_PENDING = 7;
	final int S_CALL_OFFLINE = 8;

	final int S_CALL_WAIT_REMOTE_PICKUP = 9;
	final int S_CALL_ANALOG_CLEAR = 10;

	final int S_CALL_SS1_BLOCK = 20;
	final int S_CALL_SS1_SAYIDLE = 21;

	final int S_CALL_SS1IN_WAIT_PHONUM = 30;
	final int S_CALL_SS1IN_WAIT_FWDSTOP = 31;
	final int S_CALL_SS1IN_WAIT_CALLERID = 32;
	final int S_CALL_SS1IN_WAIT_KD = 33;
	final int S_CALL_SS1IN_WAIT_KDSTOP = 34;

	final int S_CALL_SS1OUT_WAITBWDACK = 40;
	final int S_CALL_SS1OUT_TXPHONENUM = 41;
	final int S_CALL_SS1OUT_WAIT_PHONUM = 42;
	final int S_CALL_SS1OUT_TXCALLERID = 43;
	final int S_CALL_SS1OUT_WAIT_KB = 44;
	final int DIAL_STANDBY = 0;
	final int DIAL_DIALING = 1;
	final int DIAL_ECHOTONE = 2;
	final int DIAL_NO_DIALTONE = 3;
	final int DIAL_BUSYTONE = 4;
	final int DIAL_ECHO_NOVOICE = 5;
	final int DIAL_NOVOICE = 6;
	final int DIAL_VOICE = 7;
	final int DIAL_VOICEF1 = 8;
	final int DIAL_VOICEF2 = 9;
	final int DIAL_NOANSWER = 10;
	final int DIAL_FAILURE = 11;
	final int DIAL_INVALID_PHONUM = 12;

	// enum{ event process mode
	final int NO_EVENT = 0, // no event mode
			EVENT_POLLING = 1, // event polling mode
			EVENT_CALLBACK = 2, // event callback mode
			EVENT_MESSAGE = 3, // windows message mode
			EVENT_POLLINGA = 4, // extended event polling mode
			EVENT_CALLBACKA = 5; // extended event callback mode
	// } int
	// -----------------------------------------------------------------------
	// definition of event
	// -----------------------------------------------------------------------
	// enum
	final int E_PROC_Recognize = 0x0000, // voice recognition ends
			E_CHG_ISDNStatus = 0x0001, // ISDN: ISDN LAPD layer changes
			E_RCV_Ss7Msu = 0x0002, // SS7: a new message (MSU) is received from
									// the SS7 server
			E_CHG_Mtp3State = 0x0003, // SS7: SS7 MTP3 layer changes, usually to
										// indicate if some DPC route is usable
										// or not
			E_CHG_FaxChState = 0x0004, // FAX channel: channel state changes
			E_CHG_FaxPages = 0x0005, // FAX channel: driver finishes receiving
										// or transmitting a page of fax data
			E_PROC_FaxEnd = 0x0006, // FAX channel: driver finishes receiving or
									// transmitting all fax data
			E_CHG_PcmLinkStatus = 0x0007, // synchronization status of the
											// digital trunk changes
			E_CHG_LineVoltage = 0x0008, // voltage on the analog phone line
										// changes
			E_RCV_CAS = 0x0009, // SS1 channel: ABCD signaling code from the
								// remote PBX changes
			E_RCV_R2 = 0x000a, // SS1 channel: R2 signal from the remote PBX is
								// received
			E_PROC_WaitDTMF = 0x000b, // the task of WaitDTMF is completed and
										// submitted via the function
										// SsmSetWaitDtmf, SsmSetWaitDtmfEx or
										// SsmSetWaitDtmfExA
			E_CHG_RcvDTMF = 0x000c, // DTMF detector: a DTMF digit is received
			E_PROC_SendDTMF = 0x000d, // DTMF generator: the task of
										// transmitting DTMF started by the
										// function SsmTxDtmf is completed
			E_PROC_SendFlash = 0x000e, // the task of sending the flash signal
										// is completed
			E_PROC_PlayEnd = 0x000f, // the task of playing voice ends
			E_PROC_PlayFile = 0x0010, // indicates the file playing progress
			E_PROC_PlayFileList = 0x0011, // indicates driver has finished
											// playing a file in the file queue
			E_PROC_PlayMem = 0x0012, // indicates the voice playing progress in
										// Single Buffer Mode
			E_PROC_RecordEnd = 0x0013, // task of recording voice terminates
			E_PROC_RecordFile = 0x0014, // indicates the file recording progress
			E_PROC_RecordMem = 0x0015, // indicates the memory recording
										// progress
			E_PROC_SendFSK = 0x0016, // FSK transmitter finishes sending all
										// data
			E_PROC_RcvFSK = 0x0017, // task of RcvFSK ends
			E_CHG_ChState = 0x0018, // channel state changes
			E_PROC_AutoDial = 0x0019, // task of AutoDial progresses
			E_CHG_RemoteChBlock = 0x001a, // TUP/ISUP channel: the operation to
											// block the remote channel is
											// completed
			E_CHG_RemotePCMBlock = 0x001b, // TUP/ISUP channel: the operation to
											// block the remote PCM is completed
			E_SYS_ActualPickup = 0x001c, // Analog Trunk channel: pickup command
											// has been executed
			E_CHG_RingFlag = 0x001d, // Analog Trunk channel/Analog Trunk
										// Recording channel: voltage level of
										// the ringing current changes
			E_CHG_RingCount = 0x001e, // Analog Trunk channel: The counter for
										// signal cycles in the ringing current
										// detector changes
			E_CHG_CIDExBuf = 0x001f, // extended buffer area that stores the
										// CallerID information in FSK and DTMF:
										// The size of Extended Caller ID Buffer
										// changes
			E_CHG_RxPhoNumBuf = 0x0020, // DTMF detector: a new called party
										// number is received
			E_CHG_PolarRvrsCount = 0x0021, // Analog Trunk channel: a polarity
											// reversal is detected on the line
			E_SYS_RemotePickup = 0x0022, // Analog Trunk channel: enhanced
											// remote pickup detector detects
											// that the called party picks up
			E_CHG_FlashCount = 0x0023, // Station channel or Recording channel:
										// a flash operation is detected on the
										// phone
			E_CHG_HookState = 0x0024, // Station channel: a pickup or hangup
										// behavior is detected on the phone
			E_CHG_ToneAnalyze = 0x0025, // Tone detector: tone analyzed result
										// changes
			E_OverallEnergy = 0x0026, // Tone detector: overall energy on the
										// line changes
			E_CHG_OvrlEnrgLevel = 0x0027, // Tone detector: indicates the
											// overall energy
			E_CHG_BusyTone = 0x0028, // Tone detector: the call progress tone
										// detector detects the change in number
										// of busy tone cycles
			E_CHG_BusyToneEx = 0x0029, // Tone detector: busy tone is detected
										// by back-to-back busy tone detection
			E_CHG_VocFxFlag = 0x002a, // Tone detector: voltage level of single
										// tones changes, usually for detecting
										// the fax tone
			E_CHG_ToneValue = 0x002b, // Tone detector: tone voltage level
										// changes
			E_CHG_RingEchoToneTime = 0x002c, // Tone detector: count of the
												// ringback tone counter changes
			E_CHG_PeakFrq = 0x002d, // Tone detector: peak frequency changes
			E_SYS_BargeIn = 0x002e, // Barge-in detector: detected result
									// changes
			E_SYS_NoSound = 0x002f, // Tone detector: line keeps silent
			E_SYS_TIMEOUT = 0x0030, // Global Timer: the timer started by the
									// function SsmStartTimer overflows
			E_CHG_SpyState = 0x0031, // DTP series: state of the monitoring
										// circuit changes
			E_CHG_SpyLinkStatus = 0x0032, // not use any more
			E_RCV_DTR_AUDIO = 0x0033, // not use any more
			E_RCV_DTR_HOOK = 0x0034, // not use any more
			E_RCV_DTR_LAMP = 0x0035, // not use any more
			E_RCV_DTR_FKEY = 0x0036, // not use any more
			E_RCV_DTR_DKEY = 0x0037, // not use any more
			E_RCV_DTR_VOX = 0x0038, // not use any more
			E_RCV_DTR_DISPLAY = 0x0039, // not use any more
			E_RCV_DTR_DIRECTION = 0x003a, // not use any more
			E_RCV_DTR_RING = 0x003b, // not use any more
			E_CHG_CICRxPhoNumBuf = 0x003c, // SS7 Virtual Circuit: new called
											// party numbers are received
			E_CHG_CICState = 0x003d, // SS7 Virtual Circuit: circuit state
										// changes
			E_PROC_CICAutoDial = 0x003e, // SS7 Virtual Circuit: the task of
											// ShgAutoDial progresses
			E_RCV_Ss7IsupUtuinf = 0x003f, // SS7: USR message is received
			E_CHG_Mtp2Status = 0x0040, // SS7 signaling link: signaling link
										// state changes
			E_RCV_DSTDChannel = 0x0041, // DST Series: D-channel event
			E_RCV_Ss7SpyMsu = 0X0042, // SS7: new monitoring messages (MSU) are
										// received from the SS7 server
			E_CHG_ToneDetector = 0x0043, // Tone detector: the event to output
											// the detection result in the new
											// mode
			E_CHG_ToneDetectorItem = 0x0044, // Tone detector: the event to
												// count the periods of tones in
												// the new mode
			E_RCV_CALLERID = 0x0045, // receive caller id
			E_PROC_FaxDcnTag = 0x0046, // Fax channel: when the fax reception is
										// successfully completed, judge if the
										// remote fax machine has ever been
										// compelled to stop
			E_CHG_AMD = 0x0047, // Tone detector: used to analyze if it is a
								// human or an answer machine that picks up the
								// phone
			E_RCV_Ss7IsupCpg = 0x0048, // SS7: CPG message is received
			E_CHG_CbChStatus = 0x0049, // Large-capacity Channel Bank: to
										// monitor any change in the connection
										// state of a line between an on-board
										// channel and a channel bank
			E_RCV_SS7Mtp2Msu = 0x004a,
			// Reserved 0x4b-0x4f
			E_REFER_Status = 0x0050, // SsmIpInitiateTransfer: status after call
										// transfer
			E_CHG_SpyHangupInfo = 0x0051, // DTP series: monitoring circuit
											// receives the off-hook event
			E_CHG_CallBackRingCount = 0x0052, // ringback count
			E_CHG_RcvMF = 0x0053,
			E_CHG_Pcm32LineState = 0x0054,
			E_RCV_SPY_CAS = 0x0055,
			E_CHG_RingEchoToneCnt = 0x0056,
			E_Ss7_L2ToL3_IND = 0x0057,
			// Reserved 0x58-0x5f
			E_RCV_IPR_DChannel = 0x0060, // IPR series: D-channel event
			E_RCV_IPR_DONGLE_ADDED = 0x0061, // IPR series: USB-key detected
			E_RCV_IPR_DONGLE_REMOVED = 0x0062, // IPR series: the removal of
												// USB-key detected
			E_RCV_IPR_NIC_LINKED = 0x0063, // IPR series: specified network card
											// detected
			E_RCV_IPR_NIC_UNLINKED = 0x0064, // IPR series: specified network
												// card not detected
			E_RCV_IPR_AUTH_OVERFLOW = 0x0065, // IPR series: authorization
												// overflow
			E_RCV_IPR_MEDIA_SESSION_STARTED = 0x0066, // IPR series: session
														// started
			E_RCV_IPR_MEDIA_SESSION_STOPED = 0x0067, // IPR series: session
														// stopped
			E_RCV_IPR_AUX_MEDIA_SESSION_STARTED = 0x0068, // IPR series:
															// auxiliary session
															// started
			E_RCV_IPR_MEDIA_SESSION_FOWARDING = 0x0069, // IPR series: session
														// being forwarded
														// (reserved. not used
														// at present)
			E_RCV_IPR_MEDIA_SESSION_FOWARD_STOPED = 0x006a, // IPR series:
															// session
															// forwarding
															// stopped
															// (reserved. not
															// used at present)
			E_RCV_IPR_STATION_ADDED = 0x006b, // IPR series: the entrance of
												// terminal detected
			E_RCV_IPR_STATION_REMOVED = 0x006c, // IPR series: the exit of
												// terminal detected
			E_IPR_LINK_REC_SLAVER_CONNECTED = 0x006d, // IPR series: recording
														// slaver connection
														// detected
			E_IPR_LINK_REC_SLAVER_DISCONNECTED = 0x006e, // IPR series:
															// recording slaver
															// disconnection
															// detected
			E_IPR_SLAVER_INIT_CB = 0x006f, // IPR series: feedback on the
											// recording slaver initialization
			E_IPR_ACTIVE_SESSION_CB = 0x0070, // IPR series: feedback on the
												// requirement for the IPRR
												// channel to enable session
												// receiving
			E_IPR_DEACTIVE_SESSION_CB = 0x0071, // IPR series: feedback on the
												// requirement for the IPRR
												// channel to disable session
												// receiving
			E_IPR_START_REC_CB = 0x0072, // IPR series: feedback on the
											// requirement for the IPRR channel
											// to start recording
			E_IPR_STOP_REC_CB = 0x0073, // IPR series: feedback on the
										// requirement for the IPRR channel to
										// stop recording
			E_IPR_PAUSE_REC_CB = 0x0074, // IPR series: feedback on the
											// requirement for the IPRR channel
											// to pause recording
			E_IPR_RESTART_REC_CB = 0x0075, // IPR series: feedback on the
											// requirement for the IPRR channel
											// to restart recording
			E_IPR_START_SLAVER_CB = 0x0076, // IPR series: feedback on the
											// requirement of starting slaver
			E_IPR_CLOSE_SLAVER_CB = 0x0077, // IPR series: feedback on the
											// requirement of closing slaver
			E_IPR_RCV_DTMF = 0x0078, // IPR series: in-band or RFC2833 DTMF
										// detected
			E_IPR_ACTIVE_AND_REC_CB = 0x0079, // IPR series: feedback on the
												// requirement for the IPRR
												// channel to enable Session
												// receiving and start recording
			E_IPR_DEACTIVE_AND_STOPREC_CB = 0x007a, // IPR series: feedback on
													// the requirement for the
													// IPRR channel to disable
													// Session receiving and
													// stop recording
			E_RCV_IPA_DONGLE_ADDED = 0x007b, // IPA series: USB-key detected
			E_RCV_IPA_DONGLE_REMOVED = 0x007c, // IPA series: removal of USB-key
												// detected
			E_RCV_IPA_APPLICATION_PENDING = 0x007d, // IPA series: removal of
													// USB-key
													// detected,application
													// pending
			E_RCV_IPR_AUX_MEDIA_SESSION_STOPED = 0x007e, // IPR series:
															// auxiliary session
															// stoped
			E_BOARD_ICMP_CHANGE = 0x007F, // add by jince problem:OS-2341
			MAX_EVENT_SIZE = 0x0080;
	// } int
	SHP_A3 INSTANCE = (SHP_A3) Native.loadLibrary("SHP_A3", SHP_A3.class);

	// void printf(String format, Object... args);((Platform.isWindows() ?
	// "msvcrt" : "c"),

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@ INITIALIZATION OPERATION  @@@@@@@@@@@@@@@@@@@@@@@@
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public String SsmGetLastErrMsgA();
	
	public int SsmSetEvent(Integer wEvent, Integer nReference, boolean bEnable,
			EVENT_SET_INFO pEventSet);

	public int SsmStartCti(String lpSsmCfgFileName, String lpIndexCfgFileName);

	public int SsmCloseCti();

	public void SsmGetLastErrMsg(byte[] szErrMsgBuf);

	public int SsmGetLastErrCode();

	public int SsmGetMaxUsableBoard();

	public int SsmGetMaxCfgBoard();

	public int SsmGetRxDtmfBufSize();

	public int SsmGetAccreditId(int nBId);

	public int SsmGetMaxCh();

	public int SsmGetChType(int ch);

	public int SsmSetMaxIdxSeg(int wMaxIdxSeg);

	public int SsmLoadIndexData(int nSegNo, String pAlias, int nCodec,
			String pVocFile, int lStartPos, int lLen);

	public int SsmFreeIndexData(int nSegNo);

	public int SsmGetTotalIndexSeg();

	public int SsmPauseCard();

	public int SsmRestartCard();

	public int SsmGetAccreditIdEx(int nBId);

	public int SsmGetBoardModel(int nBId);

	public int SsmGetPciSerialNo(int nBId);

	public int SsmSetChState(int ch, int nState);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ PLAY OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmSetPlayVolume(int ch, int nVolume);

	public int SsmSetDtmfStopPlay(int ch, int bDspf);

	public int SsmGetDtmfStopPlayFlag(int ch);

	public int SsmSetBargeinStopPlay(int ch, int bBispf);

	public int SsmGetBargeinStopPlayFlag(int ch);

	public int SsmStopPlay(int ch);

	public int SsmPlayFile(int ch, String pszFileName, int nFormat,
			int dwStartPos, int dwLen);

	public int SsmStopPlayFile(int ch);

	public int SsmPausePlay(int ch);

	public int SsmRestartPlay(int ch);

	public int SsmFastFwdPlay(int ch);

	public int SsmFastBwdPlay(int ch);

	public int SsmSetPlayTime(int ch, int dwTime);

	public int SsmGetPlayedTimeEx(int ch);

	public int SsmGetPlayingFileInfo(int ch, int pnFormat, int pnTotalTime);

	public int SsmSetPlayPrct(int ch, int dwPercentage);

	public int SsmGetPlayedTime(int ch);

	public int SsmGetPlayedPercentage(int ch);

	public int SsmGetDataBytesToPlay(int ch);

	public int SsmCheckPlay(int ch);

	public int SsmGetPlayType(int ch);

	public int SsmPlayIndexString(int ch, String pszIdxStr);

	public int SsmPlayIndexList(int ch, int wIdxListLen, int pwIdxList);

	public int SsmStopPlayIndex(int ch);

	public int SsmClearFileList(int ch);

	public int SsmAddToFileList(int ch, String pszFileName, int nFormat,
			int dwStartPos, int dwLen);

	public int SsmPlayFileList(int ch);

	public int SsmStopPlayFileList(int ch);

	public int SsmPlayMem(int ch, int nFormat, byte pBuf, int dwBufSize,
			int dwStartOffset, int dwStopOffset);

	public int SsmGetPlayOffset(int ch, int pdwPlayOffset);

	public int SsmSetStopPlayOffset(int ch, int dwStopPlayOffset);

	public int SsmStopPlayMem(int ch);

	public int SsmClearPlayMemList();

	public int SsmAddToPlayMemList(byte pBuf, int dwDataLen, int nFormat);

	public int SsmPlayMemList(int ch, int pMemList, int wMemListLen);

	public int SsmStopPlayMemList(int ch);

	public int SsmSetDTMFStopPlayCharSet(int ch, String lpstrDtmfCharSet);

	public int SsmGetDTMFStopPlayCharSet(int ch, String lpstrDtmfCharSet);

	public int SsmSetHangupStopPlayFlag(int ch, int bHangupStopRecFlag);

	// //
	public int SsmStopPlayMemBlock(int ch);

	public int SsmGetDataBytesPlayed(int ch);

	public int SsmSetPlayGain(int ch, int wGainLevel);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@ RECORD OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmSetRecVolume(int ch, int nVolume);

	public int SsmGetRecType(int ch);

	public int SsmRecToFile(int ch, String pszFileName, int nFormat,
			int dwStartPos, int dwBytes, int dwTime, int nMask);

	public int SsmRecToFileEx(int ch, String pszFileName, int nFormat,
			int dwStartPos, int dwBytes, int dwTime, int nMask,
			int bSaveToFileOnBargin, int dwRollbackTime);

	public int SsmPauseRecToFile(int ch);

	public int SsmRestartRecToFile(int ch);

	public int SsmGetRecTime(int ch);

	public int SsmGetDataBytesToRecord(int ch);

	public int SsmStopRecToFile(int ch);

	public int SsmChkRecToFile(int ch);

	public int SsmRecToMem(int ch, int nFormat, byte pBuf, int dwBufSize,
			int dwStartOffset);

	public int SsmStopRecToMem(int ch);

	public int SsmGetRecOffset(int ch);

	public int SsmGetRecAGCSwitch(int ch);

	public int SsmSetRecAGC(int ch, int bEnable);

	public int SsmQueryOpRecMixer(int ch);

	public int SsmSetRecMixer(int ch, int bEnRecMixer, int nMixerVolume);

	public int SsmGetRecMixerState(int ch, int pnEnRecMixer, int pnMixerVolume);

	public int SsmSetPrerecord(int ch, int bEnable, int nMode, int wInsertTime,
			int nFormat);

	public int SsmSetTruncateTail(int ch, int dwTime);

	public int SsmGetTruncateTailTime(int ch);

	public int SsmGetPrerecordState(int ch, int pnMode, int pwInsertTime,
			int pnFormat);

	public int SsmSetDTMFStopRecCharSet(int ch, String lpstrDtmfCharSet);

	public int SsmGetDTMFStopRecCharSet(int ch, String lpstrDtmfCharSet);

	public int SsmSetHangupStopRecFlag(int ch, int bHangupStopRecFlag);

	public int SsmCheckRecord(int ch);

	// //
	public int SsmStopRecordMemBlock(int ch);

	public int SsmSetNoModuleChBusRec(int ch, int bBusRec);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@ RxDTMF OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmEnableRxDtmf(int ch, int bRun);

	public int SsmClearRxDtmfBuf(int ch);

	public int SsmGetDtmfStr(int ch, String pszDtmf);

	public String SsmGetDtmfStrA(int ch);

	public int SsmGetRxDtmfLen(int ch);

	public int SsmGet1stDtmf(int ch, byte pcDtmf);

	public int SsmGet1stDtmfClr(int ch, byte pcDtmf);

	public int SsmGetLastDtmf(int ch, byte pcDtmf);

	public int SsmSetWaitDtmf(int ch, int wTimeOut, int wMaxLen, byte cEndChar,
			int bWithEndChar);

	public int SsmChkWaitDtmf(int ch, String pszDtmf);

	public int SsmCancelWaitDtmf(int ch);

	public int SsmSetWaitDtmfEx(int ch, int wTimeOut, int wMaxLen,
			byte cEndChar, int bWithEndChar);

	// //

	public int SsmSetWaitDtmfExA(int ch, int wTimeOut, int wMaxLen,
			byte szEndChar, int bWithEndChar);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@ TXDTMF OPERATION @@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmQueryTxDtmf(int ch, String pszDtmf);

	public int SsmQueryTxFlash(int ch, String pszDtmf);

	public int SsmSetTxDtmfPara(int ch, int wOnTime, int wOffTime);

	public int SsmGetTxDtmfPara(int ch, int pwOnTime, int pwOffTime);

	public int SsmTxDtmf(int ch, String pszDtmf);

	public int SsmStopTxDtmf(int ch);

	public int SsmChkTxDtmf(int ch);

	public int SsmTxFlash(int ch, int Time);

	public int SsmChkTxFlash(int ch);

	public int SsmSetTxFlashCharTime(int ch, int Time);

	public int SsmGetTxFlashCharTime(int ch);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@ INTER-CH OPERATION @@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmSetLocalFlashTime(int nFlashTime);

	public int SsmSetASDT(int ch, int bEnAutoSendDialTone);

	public int SsmGetASDT(int ch);

	public int SsmGetFlashCount(int ch);

	public int SsmClearFlashCount(int ch);

	public int SsmGetHookState(int ch);

	public int SsmStartRing(int ch);

	public int SsmStopRing(int ch);

	public int SsmStartRingWithFskCID(int ch, String pBuf, int dwMaxBit,
			int dw1stRingOffDelay);

	public int SsmStartRingWithCIDStr(int ch, String pBuf, int dwLen,
			int dw1stRingOffDelay);

	public int SsmCheckSendRing(int ch, int pnCnt);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@ SEND TONE OPERATION @@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmQueryOpSendTone(int ch);

	public int SsmSendTone(int ch, int nToneType);

	public int SsmStopSendTone(int ch);

	public int SsmSendToneEx(int ch, int dwOnTime, int dwOffTime);

	public int SsmSetTxTonePara(int ch, int nReq1, int nVolume1, int nFreq2,
			int nVolume2);

	public int SsmGetTxTonePara(int ch, int nReq1, int nVolume1, int nFreq2,
			int nVolume2);

	public int SsmChkSendTone(int ch, int pnToneType);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@ TONE ANALYZE OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	public int SsmQueryOpToneAnalyze(int ch);

	public int SsmClearToneAnalyzeResult(int ch);

	public int SsmStartToneAnalyze(int ch);

	public int SsmCloseToneAnalyze(int ch);

	public int SsmGetOverallEnergy(int ch);

	public int SsmGetVocFxFlag(int ch, int nSelFx, int bClear);

	public int SsmGetToneAnalyzeResult(int ch);

	public int SsmGetBusyToneLen(int ch);

	public int SsmGetBusyToneCount(int ch);

	public int SsmGetRingEchoToneTime(int ch);

	public int SsmGetBusyToneEx(int ch);

	public int SsmSetTonePara(int ch, int wToneFreq1, int wToneBW1,
			int wToneFreq2, int wToneBW2, int dwIsToneRatio);

	public int SsmSetIsDialToneDtrTime(int ch, int wIsDialToneDtrTime);

	public int SsmSetBusyTonePeriod(int ch, int wBusyTonePeriod);

	public int SsmSetIsBusyToneDtrCnt(int ch, int wIsBusyToneDtrCnt);

	public int SsmSetRingEchoTonePara(int ch, int wRingEchoOnTime,
			int wRingEchoOffTime);

	public int SsmSetVoiceFxPara(int ch, int wSelFx, int wFx, int wFxBW,
			int dwIsVocFxRatio, int wIsVocFxDtrTime);

	public int SsmSetVoiceOnDetermineTime(int ch, int wIsVocDtrTime);

	public int SsmSetMinVocDtrEnergy(int ch, int dwMinVocDtrEnergy);

	public int SsmGetTonePara(int ch, int pwToneFreq1, int pwToneBW1,
			int pwToneFreq2, int pwToneBW2, int pdwIsToneRatio);

	public int SsmGetIsDialToneDtrTime(int ch, int pwIsDialToneDtrTime);

	public int SsmGetBusyTonePeriod(int ch, int pwBusyTonePeriod);

	public int SsmGetIsBusyToneDtrCnt(int ch, int pwIsBusyToneDtrCnt);

	public int SsmGetRingEchoTonePara(int ch, int pwRingEchoOnTime,
			int pwRingEchoOffTime);

	public int SsmGetIsNoVocDtrmTime(int ch, int pwIsNoVocDtrmTime);

	public int SsmGetVoiceFxPara(int ch, int wSelFx, int pwFx, int pwFxBW,
			int pdwIsVocFxRatio, int pwIsVocFxDtrTime);

	public int SsmGetVoiceOnDetermineTime(int ch, int pwIsVocDtrTime);

	public int SsmGetMinVocDtrEnergy(int ch, int pdwMinVocDtrEnergy);

	public int SsmQueryOpPeakFrqDetect(int ch);

	public int SsmSetPeakFrqDetectBW(int ch, int nPeakBW);

	public int SsmGetPeakFrqDetectBW(int ch);

	public int SsmGetPeakFrqEnergy(int ch);

	public int SsmGetPeakFrq(int ch);

	public int SsmGetRecPlayEnergy(int ch, int dwMask);

	public int SsmStart2ndToneAnalyzer(int ch, int bEn);

	public int SsmGet2ndToneAnalyzerState(int ch);

	public int SsmSet2ndTonePara(int ch, int wToneFreq1, int wToneBW1,
			int wToneFreq2, int wToneBW2, int dwIsToneRatio);

	public int SsmGet2ndTonePara(int ch, int pwToneFreq1, int pwToneBW1,
			int pwToneFreq2, int pwToneBW2, int pdwIsToneRatio);

	public int SsmGet2ndToneAnalyzeResult(int ch);

	public int SsmClear2ndToneAnalyzeResult(int ch);

	public int SsmGet2ndBusyToneLen(int ch);

	public int SsmGet2ndBusyToneCount(int ch);

	public int SsmSet2ndBusyTonePeriod(int ch, int wBusyTonePeriod);

	public int SsmGet2ndBusyTonePeriod(int ch, int pwBusyTonePeriod);

	public int SsmSet2ndIsBusyToneDtrCnt(int ch, int wIsBusyToneDtrCnt);

	public int SsmGet2ndIsBusyToneDtrCnt(int ch, int pwIsBusyToneDtrCnt);

	public int SsmSet2ndIsDialToneDtrTime(int ch, int wIsDialToneDtrTime);

	public int SsmGet2ndIsDialToneDtrTime(int ch, int pwIsDialToneDtrTime);

	public int SsmSet2ndRingEchoTonePara(int ch, int wRingEchoOnTime,
			int wRingEchoOffTime);

	public int SsmGet2ndRingEchoTonePara(int ch, int pwRingEchoOnTime,
			int pwRingEchoOffTime);

	public int SsmSetBusyTonePeriodEx(int ch, int nType, int wMax, int pwPeriod);

	public int SsmGetBusyTonePeriodEx(int ch, int nType, int pwPeriod);

	public int SsmGetToneValue(int ch);

	public int SsmSetToneValue(int ch, int value);

	public int SsmGetOverallEnergyAllCh(int nBeginCh, int nChNum,
			int pdwEnergyTable);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@ BARGEIN OPERATION @@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmSetNoSoundDtrmTime(int ch, int dwIsNoSoundDtrTime);

	public int SsmSetIsBargeInDtrmTime(int ch, int wIsBargeInDtrmTime);

	public int SsmSetBargeInSens(int ch, int nBargeInSens);

	public int SsmGetNoSoundTime(int ch);

	public int SsmGetNoSoundDtrmTime(int ch);

	public int SsmGetIsBargeInDtrmTime(int ch);

	public int SsmGetBargeInSens(int ch);

	public int SsmDetectBargeIn(int ch);

	public int SsmDetectNoSound(int ch);

	public int SsmSetCalleeHookDetectP(int ch, int wMulti, int wValidTime);

	public int SsmGetCalleeHookDetectP(int ch, int wMulti, int wValidTime);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@ RING DETECT OPERATION @@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmQueryOpRingDetect(int ch);

	public int SsmGetRingFlag(int ch);

	public int SsmGetRingCount(int ch);

	public int SsmClearRingCount(int ch);

	public int SsmChkOpCallerId(int ch);

	public int SsmGetCallerId(int ch, String szCallerId);

	public int SsmGetCallerIdEx(int ch, String szCallerIdEx);

	public int SsmClearCallerId(int ch);

	public int SsmClearCallerIdEx(int ch);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@ CALL OPERATION @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmPickup(int ch);

	public int SsmCheckActualPickup(int ch);

	public int SsmSetPickupNow(int ch, int bFlag);

	public int SsmHangup(int ch);

	public int SsmAutoDial(int ch, String szPhoNum);

	public int SsmChkAutoDial(int ch);

	public int SsmGetAutoDialFailureReason(int ch);

	public int SsmGetBlockReason(int ch);

	public int SsmGetChState(int ch);

	public int SsmSetPlayDest(int ch, int nSelDest);

	public int SsmSetRecBack(int ch, int nRecBack);

	public int SsmSearchIdleCallOutCh(int wSearchMode, int dwPrecedence);

	public int SsmSetAutoCallDirection(int ch, int bEnAutoCall, int nDirection);

	public int SsmGetAutoCallDirection(int ch, int pnDirection);

	public int SsmAppendPhoNum(int ch, String szPhoNum);

	public int SsmGetPendingReason(int ch);

	public int SsmGetChStateKeepTime(int ch);

	public int SsmGetPhoNumStr(int ch, byte[] pszPhoNum);

	public int SsmGetPhoNumLen(int ch);

	public int SsmGet1stPhoNumStr(int ch, byte[] pszPhoNum);

	public int SsmGet1stPhoNumLen(int ch);

	public int SsmEnableAutoSendKB(int ch, int bEnable);

	public int SsmGetAutoSendKBFlag(int ch);

	public int SsmSetKB(int ch, byte btSigKB);

	public int SsmSetKD(int ch, byte btSigKD);

	public int SsmSetKA(int ch, byte btSigKA);

	public int SsmSetTxCallerId(int ch, String pszTxCallerId);

	public int SsmGetTxCallerId(int ch, String pszTxCallerId);

	public int SsmGetKA(int ch);

	public int SsmGetKB(int ch);

	public int SsmGetKD(int ch);

	public int SsmAutoDialEx(int ch, String szPhoNum, int wParam);

	// //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// // Following functions are newly appended by cxg for applications using
	// SS7
	// //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public int SsmBlockLocalCh(int ch);

	public int SsmUnblockLocalCh(int ch);

	public int SsmQueryLocalChBlockState(int ch, int pdwBlockState);

	public int SsmBlockLocalPCM(int nLocalPcmNo);

	public int SsmUnblockLocalPCM(int nLocalPcmNo);

	public int SsmQueryLocalPCMBlockState(int nLocalPcmNo, int pdwBlockState);

	public int SsmQueryOpBlockRemoteCh(int ch);

	public int SsmBlockRemoteCh(int ch);

	public int SsmUnblockRemoteCh(int ch);

	public int SsmGetRemoteChBlockStatus(int ch);

	public int SsmBlockRemotePCM(int nLocalPcmNo, int dwBlockMode);

	public int SsmUnblockRemotePCM(int nLocalPcmNo, int dwUnblockMode);

	public int SsmGetRemotePCMBlockStatus(int nLocalPcmNo, int dwBlockMode);

	public int SsmGetWaitAutoDialAnswerTime(int pwSeconds);

	public int SsmSetWaitAutoDialAnswerTime(int wSeconds);

	// //Ver3.5.26.
	// //+++BEGIN+++ Added by xxb for
	// 妯℃嫙鐢佃瘽绾跨浉�?�硅兘閲忕畻娉曟娴嬭鍙憳鏈轰笉閫傜敤浜庤皟鐢⊿smTxDtmf();澶栨嫧鍙婁簩娆℃嫧鍙�?,2003.3.7
	public int SsmStartPickupAnalyze(int ch);

	public int SsmGetPickup(int ch);

	// //+++END+++ Added by xxb for
	// 妯℃嫙鐢佃瘽绾跨浉�?�硅兘閲忕畻娉曟娴嬭鍙憳鏈轰笉閫傜敤浜庤皟鐢⊿smTxDtmf();澶栨嫧鍙婁簩娆℃嫧鍙�?,2003.3.7
	public int SsmGetReleaseReason(int ch);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@ ADAPTIVE FILTER OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmQueryOpEchoCanceller(int ch);

	public int SsmSetEchoCanceller(int ch, int bRun);

	public int SsmGetEchoCancellerState(int ch);

	public int SsmSetEchoCancellerStudy(int ch, int bRun);

	public int SsmGetEchoCancellerStudyState(int ch);

	public int SsmGetEchoCancellerRatio(int ch);

	public int SsmSaveEchoCancellerPara(int ch);

	// ++
	public int SsmSetEchoCancelDelaySize(int ch, int wSize);

	public int SsmGetEchoCancelDelaySize(int ch);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@ CT-BUS OPERATION @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmListenTo(int ch1, int ch2);

	public int SsmListenToEx(int ch1, int nVolume1, int ch2);

	public int SsmStopListenTo(int ch1, int ch2);

	public int SsmTalkWith(int ch1, int ch2);

	public int SsmTalkWithEx(int ch1, int nVlm1, int ch2, int nVlm2);

	public int SsmStopTalkWith(int ch1, int ch2);

	public int PlayListen(int dwBId, int ch);

	public int PlayListenNew(int dwSpeakerCh, int dwMonitorCh);

	public int StopListen(int dwBId);

	public int StopListenNew(int dwSpeakerCh);

	public int SsmLinkFrom(int ch1, int ch2);

	public int SsmStopLinkFrom(int ch1, int ch2);

	public int SsmLinkFromEx(int ch1, int nVolume1, int ch2);

	public int SsmLinkFromAllCh(int ch, int nListenerTable, int nListenerNum);

	public int SsmUnLinkFromAllCh(int ch, int nListenerTable, int nListenerNum);

	public int SsmLinkToBus(int ch, int ts);

	public int SsmUnLinkToBus(int ch, int ts);

	public int SsmLinkFromBus(int ts, int ch);

	public int SsmLinkFromBusEx(int ts, int ch, int vlm);

	public int SsmUnLinkFromBus(int ts, int ch);

	public int SsmListenToPlay(int ch1, int vlm1, int ch2);

	public int SsmUnListenToPlay(int ch1, int ch2);

	public int SsmClearChBusLink(int nCh);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@ CONFERENCE OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmCreateConfGroup(int nMaxMember, int nMaxSpeaker,
			int nMaxSpeaking, int nMaxSilenceTime);

	public int SsmFreeConfGroup(int nGrpId);

	public int SsmJoinConfGroup(int nGrpId, int ch, int wJoinMode,
			int nMixerVolume, int bCreateAlways, int bExitGrpAlways);

	public int SsmExitConfGroup(int ch, int bFreeGrpAlways);

	public int SsmGetConfCfgInfo(int pwMaxMember, int pwMaxSpeaker,
			int pwMaxSpeaking, int pwMaxSilenceTime);

	public int SsmGetTotalConfGroup();

	public int SsmGetConfGrpId(int pnGrpId);

	public int SsmGetConfGrpCfgInfo(int nGrpId, int pwMaxMember,
			int pwMaxSpeaker, int pwMaxSpeaking, int pwMaxSilenceTime);

	public int SsmGetConfGrpInfo(int nGrpId, int pwTotalMember,
			int pwTotalSpeaker, int pwTotalSpeaking);

	public int SsmGetConfGrpMmbrId(int nGrpId, int pnMmbrId);

	public int SsmGetConfGrpMmbrInfo(int nGrpId, int nMmbrId, int pnAppCh,
			int pwJoinMode, int pwIsSpeaking, int pdwSilenceTime);

	public int SsmGetConfChInfo(int ch, int pnGrpId, int pnMmbrId,
			int pwJoinMode, int pwIsSpeaking, int pdwSilenceTime);

	public int SsmValidateGrpId(int nGrpId);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@ DRIVER Ver. 1.x COMPATIBLE FUNCTIONS @@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int InitCard(int add1, int add2, int add3, int add4, int add5,
			int add6, int add7, int add8, int intno);

	public void ShutCard();

	public int StartRecordFile(int ch, String fliename);

	public int StopRecordFile(int ch);

	public int PauseRecord(int ch);

	public int RestartRecord(int ch);

	public int GetRecordTime(int ch);

	public int StartPlayFile(int ch, String fliename);

	public int StopPlayFile(int ch);

	public int CheckPlayingEnd(int ch);

	public int PausePlay(int ch);

	public int RestartPlay(int ch);

	public int FastPlay(int ch);

	public int BackPlay(int ch);

	public int GetPlayTime(int ch);

	public int GetPlayPercent(int ch);

	public int SetPlayTime(int ch, int Time);

	public int SetPlayPercent(int ch, int percent);

	public int LoadIndexFile(int segNo, String filename, int StartAdr,
			int Length);

	public int FreeIndexMem(int segNo);

	public int PlayIndex(String ch, int segstring);

	public int StopIndex(int ch);

	public int DTMFStop(int ch, int ifstop);

	public int GetDTMF(int ch);

	public int ClearDTMFBuf(int ch);

	public int DetectRing(int ch);

	public int ClearRing(int ch);

	public int HangUp(int ch);

	public int PickUp(int ch);

	public int DetectInter(int ch);

	public int GetFlash(int ch);

	public int SetFlashTime(int Time);

	public int ToneCheck(int ch);

	public int GetBusyLen(int ch);

	public int DTMFDial(String ch, int dialstring);

	public int DTMFDialEnd(int ch);

	public int Flash(int ch, int Time);

	public int SetPlayVolume(int ch, int volume);

	public int SetRecVolume(int ch, int volume);

	public int GetCallerId(int ch, String buf);

	public int SetPickSens(int piont);

	public int GetPickUp(int ch);

	public int GetNum(int ch, String buf, int Time, int dtmflen, int endchar);

	public int SetWorkMode(int mode);

	public int SetUserCard(int addr1, int addr2, int addr3, int addr4,
			int addr5, int addr6, int addr7, int addr8);

	public int SendBusyTone(int ch);

	public int SendRingEchoTone(int ch);

	public int SendDialTone(int ch);

	public int StopSendTone(int ch);

	public int StartSendRing(int ch);

	public int StopSendRing(int ch);

	public int Link2Ch(int ch1, int ch2);

	public int UnLink2Ch(int ch1, int ch2);

	public int Link3Ch(int ch1, int ch2, int Ch3);

	public int UnLink3Ch(int ch1, int ch2, int Ch3);

	public int ListenFromCh(int ch1, int ch2);

	public int StopListenFromCh(int ch1, int ch2);

	public int SetDelay(int ch, int delay);

	public int SetLevel(int ch, int level);

	public int DetectSound(int ch);

	public int GetFax11(int ch);

	public int GetFax21(int ch);

	public int GetRing(int ch);

	public int SetDialSpeed(int Point);

	public void GetErrorMsg(byte buf);

	public int SetMaxSeg(int inmaxsegment);

	public int ApplyTimeSlot();

	public int LinkFromBus(int tsHandle, int ch);

	public int StopLinkFromBus(int tsHandle, int ch);

	public int LinkToBus(int ch, int tsHandle);

	public int StopLinkToBus(int ch, int tsHandle);

	public int FreeTimeSlot(int tsHandle);

	public void PauseCard();

	public void RestartCard();

	public int SetIRQPriority(int nPriorityClass);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@ RECORD MODULE OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int GetLevel(int ch);

	public int SetJudge(int ch, int Judge);

	public int SsmQueryOpADC(int ch);

	public int SsmGetLineVoltage(int ch);

	public int SsmSetDtrmLineVoltage(int ch, int wDtrmValtage);

	public int SsmGetDtrmLineVoltage(int ch);

	public int DetectPickUp(int ch);

	public int DetectEmpty(int ch);

	public int SetSoundJudgeLevel(int ch, int level);

	public int GetSoundJudgeLevel(int ch);

	public int SsmQueryOpMicGain(int ch);

	public int SsmSetMicGain(int ch, int nGain);

	public int SsmGetMicGain(int ch);

	public int SsmSetIgnoreLineVoltage(int ch, int bEnable);

	public int SsmGetIgnoreLineVoltage(int ch);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@ POWER-AMPLIFIER OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SetVolume(int dwBoardId, int dwVolume);

	public int SsmQueryOpPowerAmp(int ch);

	public int SsmSetPowerAmpVlm(int ch, int nVolume);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@ POLAR REVERSE OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int GetFZCount(int ch);

	public int SsmQueryOpPolarRvrs(int ch);

	public int SsmGetPolarRvrsCount(int ch);

	public int SsmGetPolarState(int ch);

	public int SsmSetPolarState(int ch, int nPolar);

	public int SsmSetUnimoduleState(int ch, int nLink);

	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ SS1 OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmQueryOpSS1(int ch);

	public int SsmSendCAS(int ch, byte btCas);

	public int SsmGetCAS(int ch);

	public int SsmSetRxR2Mode(int ch, int nMode, int bEnable);

	public int SsmGetR2(int ch);

	public int SsmSendR2(int ch, int nMode, byte btR2);

	public int SsmStopSendR2(int ch);

	public int SsmGetSendingCAS(int ch);

	public int SsmGetSendingR2(int ch, int pnMode, byte pbtR2);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ PCM LINK OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmGetMaxPcm();

	public int SsmGetPcmInfo(int nPcmNo, int pnSSxMode, int pnBoardId,
			int pnBoardPcmNo, int pnUsePcmTS16, int pdwRcvrMode,
			int pdwEnableAutoCall, byte pdwAutoCallDirection);

	public int SsmSetPcmClockMode(int nPcmNo, int nClockMode);

	public int SsmGetPcmLinkStatus(int nPcmNo, int pwPcmLinkStatus);

	public int SsmPcmTsToCh(int nLocalPcmNo, int nTs);

	public int SsmChToPcmTs(int ch, int pnLocalPcmNo, int pnTs);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ SEND FSK OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmSetFskPara(int nFreqBit0, int nFreqBit1, int nBaudrate,
			int nMdlAmp);

	public int SsmGetFskPara(int nFreqBit0, int nFreqBit1, int nBaudrate,
			int nMdlAmp);

	public int SsmTransFskData(byte pS, int nSrcLen, int nSyncLen, byte pD);

	public int SsmStartSendFSK(int ch, String pBuf, int dwMaxBit);

	public int SsmCheckSendFsk(int ch);

	public int SsmStopSendFsk(int ch);

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ RECEIVE FSK OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmStartRcvFSKII(int ch, int wTimeOut, int wMaxLen,
			byte pucMarkCodeBuf, byte ucMarkCodeCount);

	public int SsmStartRcvFSK(int ch, int wTimeOut, int wMaxLen,
			byte ucEndCode, int wEndCodeCount);

	public int SsmClearRcvFSKBuf(int ch);

	public int SsmCheckRcvFSK(int ch);

	public int SsmGetRcvFSK(int ch, byte pucBuf);

	public int SsmStopRcvFSK(int ch);

	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ SS7 OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmSendSs7Msu(int wMsuLength, byte pucMsuBuf);

	public int SsmGetSs7Msu(byte pucMsuBuf);

	public int SsmGetSs7Mtp2Msu(byte pucPara, byte ppucMsuBuf);

	public int SsmGetMtp3State();

	public int SsmGetMtp3StateEx(int nDpcNo);

	public int SsmGetMtp2Status(int nLinkNum);

	// //added by mengjin for 鍔ㄦ�佽缃富鍙敤鎴风被鍒�?2004.11.22
	public int SsmSetISUPCAT(int nCh, byte ucCallerCAT);

	// //---Start--- added by cxq for ISUP鐢ㄦ埛閮ㄥ垎鍙傛暟璁剧疆,05.06.09
	public int SsmGetIsupUPPara(int nBCh, int wEventType, int pwLength,
			byte pucContent);

	public int SsmSetIsupUPPara(int nBCh, int wEventType, int pwLength,
			byte pucContent);

	// //---End--- added by cxq for ISUP鐢ㄦ埛閮ㄥ垎鍙傛暟璁剧疆,05.06.09
	public int SsmSendIsupMsg(int nBCh, int wEventType);

	// //---Start--- added by cxq for 鍛煎叆閫氶亾鎵�瀵瑰簲鐨刲ink缁�,05.10.25

	public int SsmGetInboundLinkSet(int nBCh, int pwLinkSetNo, String pszOpc,
			String pszDpc);

	// //---Start--- added by cxq for 鍛煎叆閫氶亾鎵�瀵瑰簲鐨刲ink缁�,05.10.25

	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@ FAX OPERATION API @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmFaxGetChStateMsg(int ch, String buf);

	public int SsmFaxGetPages(int ch);

	public int SsmFaxStartReceive(int ch, String filename);

	public int SsmFaxStartSend(int ch, String filename);

	public int SsmFaxStop(int ch);

	public int SsmFaxSetMaxSpeed(int speed);

	public int SsmFaxCheckEnd(int ch);

	public int SsmFaxSetID(int ch, String myid);

	public int SsmFaxGetID(int ch, String myid);

	public int SsmFaxSetSendMode(int ch, int mode);

	public int SsmFaxGetRcvBytes(int ch);

	public int SsmFaxGetSendBytes(int ch);

	public int SsmFaxAppendSend(int ch, String filename);

	public int SsmFaxSetHangup(int ch, int flag);

	public int SsmFaxStartSendEx(int ch, String filename, int nStartPage,
			int nEndPage);

	public int SsmFaxSendMultiFile(int ch, String szFilePath, String szFileName);

	// //
	public int SsmFaxGetAllBytes(int ch);

	public int SsmFaxGetSpeed(int ch);

	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@ MODEM OPERATION API
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmEnableCh(int ch);

	public int SsmDisableCh(int ch);

	public int SsmResetCh(int ch);

	public int SsmCheckResetCh(int ch);

	public int SsmGetLSR(int ch, byte retu);

	public int SsmGetMSR(int ch, byte retu);

	public int SsmGetRTS(int ch);

	public int SsmGetCTS(int ch);

	public int SsmGetOH(int ch);

	public int SsmDetectCarry(int ch);

	// //soft-fax 2002.07.03
	public int SsmFaxGetChState(int ch, int buf);

	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@ SERIAL PORT IO OPERATION API
	// @@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmReadRxBuf(int ch, String nLen, int lpcRxBuf);

	public int SsmGetRxBufLen(int ch);

	public int SsmClearRxBuf(int ch);

	public int SsmWriteTxBuf(int ch, int nLen, String lpcTxBuf);

	public int SsmWriteTxBufS(int ch, String s);

	public int SsmWriteTxBufC(int ch, byte buf);

	public int SsmGetTxBufRemain(int ch);

	public int SsmGetTxBufLen(int ch);

	public int SsmClearTxBuf(int ch);

	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@ ISDN API
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmISDNSetDialSubAddr(int ch, String lpSubAddress);

	public int SsmISDNSetTxSubAddr(int ch, String lpSubAddress);

	public int SsmISDNGetTxCallerSubAddr(int ch, String lpSubAddress);

	public int SsmISDNGetSubAddr(int ch, String lpSubAddress);

	public int SsmISDNGetCallerSubAddr(int ch, String lpSubAddress);

	public int SsmISDNGetDisplayMsg(int ch, String lpDispMsg);

	public int SsmISDNSetHangupRzn(int ch, int nReason);

	public int SsmISDNGetStatus(int nPcmNo, int pL3Start, int pL2DStatus,
			int pL2DL3Atom, int pL3L2DAtom, int pRefind);

	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@ ViaVoice recognize OPERATION API
	// @@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmStartRecognize(int ch, int grammarid, int maxtime);

	public int SsmGetResultCount(int ch);

	public int SsmGetCurSens(int ch);

	public int SsmGetResult(String buf, String index, String score, int ch);

	public int SsmGetNResult(int id, String buf, String index, String score,
			int ch);

	public int SsmSetSil(int nValue);

	public int SsmSetRecoSound(int nBeginLen, int nEndLen, int nSoundLen);

	public int SsmSetRecoTime(int nRecoTime, int nMaxWait);

	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@ Set Hardware Flags OPERATION API
	// @@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SsmSetFlag(int ch, int nType, int lValue);

	public int SsmGetFlag(int ch, int nType, int plValue);

	public int SsmSetOvrlEnrgLevel(int ch, int wOvrlEnrgLevel);

	public int SsmGetOvrlEnrgLevel(int ch);

	public int SsmSetOvrlEnrgDtrmTime(int ch, int wMinTime, int wMaxTime);

	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@ SPY API @@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int SpyGetState(int nCic);

	public int SpyGetCallerId(int nCic, String pcCid);

	public int SpyGetCalleeId(int nCic, String pcCid);

	public int SpyGetMaxCic();

	public int SpyStopRecToFile(int nCic);

	public int SpyRecToFile(int nCic, int wDirection, String pszFileName,
			int nCodecFormat, int dwStartPos, int dwBytes, int dwTime, int nMask);

	public int SpyGetLinkStatus(int nSpyPcmNo, byte ucFlag);

	// //add by JK Shi for 璁剧疆鍘熶富鍙彿鐮�?, begin
	public int SsmSetTxOriginalCallerID(int ch, byte pszTxCallerId);

	// //add by JK Shi for 璁剧疆鍘熶富鍙彿鐮�?, end
	public int SpyChToCic(int ch);

	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@ EVENT API @@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	// //
	public int SsmStartTimer(int wDelay, int fuEvent);

	public int SsmStopTimer(int nTimer);

	public int SsmSetEvent(int wEvent, int nReference, int bEnable,
			EVENT_SET_INFO pEventSet);

	public int SsmGetEventMode(int wEvent, int nReference, int pwEnable,
			EVENT_SET_INFO pEventSet);

	public int SsmWaitForEvent(int dwTimeOut, MESSAGE_INFO pEvent);

	public int SsmWaitForEventA(int dwTimeOut, SSM_EVENT pEvent);

	public int SsmGetEvent(MESSAGE_INFO pEvent);

	public int SsmGetEventA(SSM_EVENT pEvent);

	public int SsmPutUserEventA(SSM_EVENT pEvent);

	public int SsmGetInterEventType();

	public int SsmSetInterEventType(int nType);

	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@ DTR OPERATION
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //+++START+++ added by yxh for 2B+D, 2004.12.23
	public int DTRGetLCDStr(int ch, String pszLCDStr);

	public int DTRSetMixerVolume(int ch, int nGroup, int nDownVolume,
			int nUpVolume);

	public int DTRGetMixerVolume(int ch, int nGroup, int nDownVolume,
			int nUpVolume);

	// //+++ END +++ added by yxh for 2B+D, 2004.12.23
	// //+++START+++ added by yxh for GetDKeyStr, 2005.09.02
	public int DTRGetDKeyStr(int ch, String pszDKeyStr);

	// //+++ END +++ added by yxh for GetDKeyStr, 2005.09.02
	// //+++START+++ added by yxh for SimulantScene, 2005.09.27
	public int DTRSendRawData2A3(int ch, byte ucCmd, int wLen, byte pucData);

	// //+++ END +++ added by yxh for SimulantScene, 2005.09.27

	// //add by JK Shi for Isdn娑堟伅杈撳嚭,begin
	public int SsmGetIsdnMsu(int nPcmId, byte pucMsuBuf);

	public int SsmSendIsdnMsu(int nPcmId, int nMsgLen, byte pucMsuBuf);

	public int SsmCheckIsdnMsu(int nPcmId);

	// //add by JK Shi for Isdn娑堟伅杈撳嚭,end
	public int SsmPutUserEvent(int wEventCode, int nReference, int dwParam);

	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@ Tcap and Sccp API @@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //++Start++added by cxq for Tcap 2005.04.28
	public int SccpSaveReceivedMessage(int nLen, byte pucMsg);

	public int SccpGetReceivedMessage(byte pnLen, int pucMsg);

	public int MtpGetSccpMessage(byte pnLen, int pucMsg);

	public int SccpInit();

	public int SccpConfig();

	// //瀵瑰鍏�?竷鍑芥暟 Begin
	public int SsmUserSendMessageToTcap(int nLen, byte pucMsg);

	public int SsmUserGetTcapDlgMessage(byte pLen, int pucDlgInd);

	public int SsmUserGetTcapCmpMessage(int pLen, int nCurDlgID, int nMsgStyle,
			byte pucCmpInd);

	public int SsmUserGetLocalMessage(byte pnLen, int pucMsgInd);

	public int SsmUserGetISMState(int nID, byte pucState);

	public int SsmStartTcap();

	// //++End++added by cxq for Tcap 2005.04.28

	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@ Query Format 鏌ヨ閫氶亾鏄惁鏀寔鎸囧畾鐨勫綍�?鹃煶鏍煎紡@@@@@@@
	// //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// //---start--- added by cxq for query format,2005.05.17
	// int WINAPI SsmQueryPlayFormat(int ch,int nFormat);;
	public int SsmQueryPlayFormat(int ch, int nFormat);

	// int WINAPI SsmQueryRecFormat(int ch, int nFormat);;
	public int SsmQueryRecFormat(int ch, int nFormat);
}
