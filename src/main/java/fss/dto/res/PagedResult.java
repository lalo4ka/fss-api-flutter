package fss.dto.res;

import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class PagedResult<T> {

    public static final long DEFAULT_OFFSET = 0;
    public static final int DEFAULT_MAX_NO_OF_ROWS = 50;
    private final long total;
    private final int currentPage;
    private final int lastPage;
    private final int perPage;
    private final List<T> data;
    private final boolean hasNextPage;

    public PagedResult(Map<String, Object> params, List<T> data) {
        this.data = data;
        this.total = (long) params.get("total");
        this.hasNextPage = (boolean) params.get("hasNextPage");
        this.perPage = (int) params.get("perPage");
        this.currentPage = (int) params.get("currentPage");
        this.lastPage = (int) Math.ceil((double) this.total / (double) this.perPage);
    }

}
