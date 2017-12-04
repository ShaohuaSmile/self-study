package shaohua.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/8/14
 */
@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageDao messageDao;
    public void printMessage() {
        System.out.println(messageDao.getHello());
    }
}
