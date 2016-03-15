package springbook.user.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by graham on 2016. 3. 14..
 */
public class TransactionAdvice implements MethodInterceptor {
    private PlatformTransactionManager txManager;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition());
        try {
            Object ret = invocation.proceed();
            txManager.commit(status);
            return ret;
        } catch (RuntimeException e) {
            txManager.rollback(status);
            throw e;
        }
    }
}
