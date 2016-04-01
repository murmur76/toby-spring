package springbook.user.sqlservice;

import org.springframework.context.annotation.Import;
import springbook.SqlServiceContext;

/**
 * Created by graham on 2016. 3. 31..
 */
@Import(value= SqlServiceContext.class)
public @interface EnableSqlService {
}
