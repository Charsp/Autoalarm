package com.swz.system.config.web.controller;

import java.util.Date;

/**
 * 文体上传传输类
 * 
 * @author Charsp
 *
 * @date 2015年1月26日
 */
public class FileTransferController {
	// ////////// 私有变量 ////////////
	// 传输层
	private String transIP;
	// 文件属性
	private String fileName;
	private String filePath; // 服务器端文件路径
	private String currPoint; // 当前文件传输位置
	private Date fileUpdate; // 文件更新位置
	private Long fileSize;

	// ////////// 共有变量 ///////////
	/**
	 * 传输大文件
	 * 
	 * @return
	 */
	public int transferBig(String filePath) {
		return 0;
	}

	/**
	 * 断点续传
	 * 
	 * @param currPoint
	 *            当前位置
	 * @param filePath
	 *            文件名称/位置
	 * @return 当前位置错误返回上一次位置，事务回滚到
	 */
	public int transferFromInterrput(long currPoint, String filePath) {
		return 0;
	}

	public String fileAnalysis(String filePath) {
		return null;
	}

	public String getTransIP() {
		return transIP;
	}

	public void setTransIP(String transIP) {
		this.transIP = transIP;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getCurrPoint() {
		return currPoint;
	}

	public void setCurrPoint(String currPoint) {
		this.currPoint = currPoint;
	}

	public Date getFileUpdate() {
		return fileUpdate;
	}

	public void setFileUpdate(Date fileUpdate) {
		this.fileUpdate = fileUpdate;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

}
