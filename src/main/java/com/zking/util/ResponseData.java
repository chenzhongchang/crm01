package com.zking.util;

import java.io.Serializable;

//通用JSON数据集对象
public class ResponseData implements Serializable {

	private static final long serialVersionUID = -308499030984494877L;

	private Object rows;// 返回数据
	private int total;// 总记录数

	public ResponseData() {
		super();
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
