package com.swz.system.admin;

/**
 * 
 * @author Charsp
 *
 * @date 2015年1月15日
 */
public enum Permission {
	other("游客", 1), user("游客", 1), admin("游客", 1), system("游客", 1);
	// 成员变量
	private String name;
	private int index;

	/**
	 * 构造方法
	 * 
	 * @param name
	 *            用户昵称
	 * @param index
	 *            id号(游客个数)
	 */
	private Permission(String name, int index) {
		this.setName(name);
		this.setIndex(index);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
