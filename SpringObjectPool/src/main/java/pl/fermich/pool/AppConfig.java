package pl.fermich.pool;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.target.CommonsPoolTargetSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    public PoolableObject poolableObjectTarget() {
        return new PoolableObject();
    }

    @Bean
    public CommonsPoolTargetSource poolTargetSource() {
        CommonsPoolTargetSource targetSource = new CommonsPoolTargetSource();
        targetSource.setTargetBeanName("poolableObjectTarget");
        targetSource.setMaxSize(3);
        return targetSource;
    }

    @Bean
    public ProxyFactoryBean poolableObject() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTargetSource(poolTargetSource());

        return proxyFactoryBean;
    }

}
