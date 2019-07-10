package configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;

/**
 * 用配置类来替代beans.xml文件
 *
 * Configuration:
 *          作用：用来标志该类是spring的一个注解类，用来代替spring的xml文件
 * ComponentScan：
 *          作用：用来标记spring的ioc容器从哪个包中获取带注解的实例
 *          属性：value  basePackage  指定扫描的包
 * Bean
 *          作用：表明哪些需要注入到spring的IOC容器中
 *          属性：scope  同xml配置文件中的scope属性，表名当前bean是单例还是多例
 */

@Configuration
@ComponentScan(value = {"com.test"})
public class SpringConfiguration {

    @Bean("runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean("dataSource")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/eesy");
            ds.setUser("root");
            ds.setPassword("root");

            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
