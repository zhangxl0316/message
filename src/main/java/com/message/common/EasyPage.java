package com.message.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.github.pagehelper.Page;

/**
 * @Title: EasyPage.java
 * @Description: 配合easyUI
 * @author zxl
 * @date 2016年12月13日 下午6:31:53
 * @version 1.0
 * @param <T>
 */
public class EasyPage<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //当前页
    private int page;
    //每页的数量
    private int rows;
    //当前页的数量
    private long total;
    //结果集
    private List<T> list;

    /**
     * 包装Page对象
     *
     * @param list          page结果
     * @param navigatePages 页码数量
     */
    public EasyPage(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.page = page.getPageNum();
            this.rows = page.getPageSize();
            this.total = page.getTotal();
           
        } else if (list instanceof Collection) {
            this.page = 1;
            this.rows = list.size();
            this.total = list.size();
        }
        
        this.list = list;
    }

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
