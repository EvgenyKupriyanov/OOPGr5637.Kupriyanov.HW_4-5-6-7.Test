package Services;

import java.util.List;

public interface iPersonService<T> {
    List<T> getAll();
    void create(T arg);
}
