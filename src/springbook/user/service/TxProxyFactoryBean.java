package springbook.user.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import java.lang.reflect.Proxy;

/**
 * Created by graham on 2016. 3. 14..
 */
public class TxProxyFactoryBean implements FactoryBean<Object> {
    Object target;
    PlatformTransactionManager txManager;
    String pattern;
    Class<?> serviceInterface;

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setServiceInterface(Class<?> serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public Object getObject() throws Exception {
        TransactionHandler txHandler = new TransactionHandler();
        txHandler.setTarget(target);
        txHandler.setTxManager(txManager);
        txHandler.setPattern(pattern);
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { serviceInterface }, txHandler);
    }

    public Class<?> getObjectType() {
        return serviceInterface;
    }

    public boolean isSingleton() {
        return false;
    }
}
