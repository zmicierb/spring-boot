package pkg.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pkg.config.SelfInject;
import pkg.service.TestService;

/**
 * Created by dima on 10/22/16.
 */
@Service
public class TestServiceImpl implements TestService {

    @SelfInject
    private TestService proxy;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void outerMethod(Long id1, Long id2) throws ClassNotFoundException {
        if (id1 > 0 )
            throw new ClassNotFoundException();

//        innerMethod(id2);
        proxy.innerMethod(id2);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void innerMethod(Long id2) throws ClassNotFoundException {
        if (id2 > 0)
            throw new ClassNotFoundException();
    }
}
