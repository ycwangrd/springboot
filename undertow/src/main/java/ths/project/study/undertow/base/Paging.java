package ths.project.study.undertow.base;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author: wangrd
 * @since: 2018年11月18日 00:10:25
 * @Desc:
 */
public class Paging<T> extends PageInfo<T> {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Paging() {
        super();
    }

    public Paging(int pageNum, int pageSize) {
        super();
        super.setPageNum(pageNum);
        super.setPageSize(pageSize);
    }

    public Paging(List<T> list) {
        super(list, 8);
    }

    public Paging(List<T> list, int navigatePages) {
        super(list, navigatePages);
    }

    @Override
    public int getPageNum() {
        if (super.getPageNum() <= 0) {
            super.setPageNum(1);
        }
        return super.getPageNum();
    }

    @Override
    public int getPageSize() {
        if (super.getPageSize() <= 0) {
            super.setPageSize(10);
        }
        return super.getPageSize();
    }

    @Override
    public int getNavigatePages() {
        if (super.getNavigatePages() <= 0) {
            super.setNavigatePages(8);
        }
        return super.getNavigatePages();
    }

    /**
     * @return 当前页第一条
     */
    public int getFirst() {
        return ((super.getPageNum() - 1) * super.getPageSize()) + 1;
    }
}
