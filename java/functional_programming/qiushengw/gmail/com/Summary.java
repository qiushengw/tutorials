package qiushengw.gmail.com;

import java.util.List;
import java.util.stream.Stream;

public class Summary<T> {

    public T sum(List<T> collection, MergeOperation<T> merge){
       T result = null;

        for(T i : collection){
            result = merge.add(result,i);
        }

        return result;
    }
}
