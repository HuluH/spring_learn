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
 * Import
 *          作用：用于引入其他的注解配置类
 *          属性：value 用于指定其他配置类的字节码
 *                当我们使用Import注解之后，有Import注解的就是父配置类，而导入的就是子配置类
 * PropertySource
 *          作用：用于指定properties文件的位置
 *          属性：value 用于指定文件的路径和名称
 *                关键字 classpath，表示类路径下
 */

@Configuration
@ComponentScan(value = {"com.test"})
@Import(JDBCConfiguration.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {

}
