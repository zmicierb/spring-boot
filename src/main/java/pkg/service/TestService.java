package pkg.service;

/**
 * Created by dima on 10/22/16.
 */
public interface TestService {

    void outerMethod(Long id1, Long id2) throws ClassNotFoundException;

    void innerMethod(Long id2) throws ClassNotFoundException;

}
