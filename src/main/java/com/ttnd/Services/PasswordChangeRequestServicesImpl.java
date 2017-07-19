package com.ttnd.Services;

import com.ttnd.Entity.PasswordChangeRequest;
import com.ttnd.dao.PasswordChangeRequestDao;
import com.ttnd.dao.PasswordChangeRequestDaoImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo-1 on 19-07-2017.
 */
@Service
public class PasswordChangeRequestServicesImpl implements PasswordChangeRequestServices {


    @Override
    public Boolean save(PasswordChangeRequest passwordChangeRequest) {
        PasswordChangeRequestDao passwordChangeRequestDao=new PasswordChangeRequestDaoImple();
        return passwordChangeRequestDao.save(passwordChangeRequest);
    }

    @Override
    public PasswordChangeRequest get(String email,String token) {
        PasswordChangeRequestDao passwordChangeRequestDao=new PasswordChangeRequestDaoImple();
        return passwordChangeRequestDao.get(email,token);
    }
    @Override
    public void delete(PasswordChangeRequest passwordChangeRequest){

        PasswordChangeRequestDao passwordChangeRequestDao=new PasswordChangeRequestDaoImple();
        passwordChangeRequestDao.delete(passwordChangeRequest);
    }
}
