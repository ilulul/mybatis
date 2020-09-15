package com.lll.activity.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 *
 */
@ApiModel("PageUtils")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageUtils<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "总记录数", required = true)
	private int totalCount;

	@ApiModelProperty(value = "每页记录数", required = true)
	private int pageSize;

	@ApiModelProperty(value = "总页数", required = true)
	private int totalPage;

	@ApiModelProperty(value = "当前页数", required = true)
	private int currPage;

	@ApiModelProperty(value = "列表数据", required = true)
	private List<T> list;
	
	/**
	 * 分页
	 * @param list        列表数据
	 * @param totalCount  总记录数
	 * @param pageSize    每页记录数
	 * @param currPage    当前页数
	 */
	public PageUtils(List<T> list, int totalCount, int pageSize, int currPage) {
		this.list = list;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currPage = currPage;
		this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
	}

	/**
	 * 分页
	 */
	public PageUtils(IPage<T> page) {
		this.list = page.getRecords();
		this.totalCount = (int)page.getTotal();
		this.pageSize = (int)page.getSize();
		this.currPage = (int)page.getCurrent();
		this.totalPage = (int)page.getPages();
	}
}
