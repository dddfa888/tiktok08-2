 

package com.auto.mall.utils;

import com.auto.mall.page.PageDomain;
import com.auto.mall.page.TableSupport;
import com.auto.mall.utils.sql.SqlUtil;
import com.github.pagehelper.PageHelper;

public class PageUtils extends PageHelper {
  public PageUtils() {
  }

  public static void startPage() {
    PageDomain pageDomain = TableSupport.buildPageRequest();
    Integer pageNum = pageDomain.getPageNum();
    Integer pageSize = pageDomain.getPageSize();
    if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
      String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
      Boolean reasonable = pageDomain.getReasonable();
      PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }

  }

  public static void startPage(Integer pageNum, Integer pageSize) {
    if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
      String orderBy = SqlUtil.escapeOrderBySql("");
      PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(true);
    }

  }
}
