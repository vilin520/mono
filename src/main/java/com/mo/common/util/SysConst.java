package com.mo.common.util;

/**
 * 一些常量
 */
public class SysConst {
	
	public static final Integer OPERATION_TIME = 5;	//一些更新操作动作默认缓存的秒数,用于防止重复提交
	
	/**
	 * 排序方式
	 * @author Administrator
	 *
	 */
	public enum SortBy{
		ASC,DESC;
	}
}
