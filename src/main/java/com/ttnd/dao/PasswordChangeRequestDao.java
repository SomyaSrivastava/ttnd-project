package com.ttnd.dao;

import com.ttnd.Entity.PasswordChangeRequest;

/**
 * Created by Lenovo-1 on 19-07-2017.
 */
public interface PasswordChangeRequestDao {
    public Boolean save(PasswordChangeRequest passwordChangeRequest);
    public PasswordChangeRequest get(String email,String token);
    public void delete(PasswordChangeRequest passwordChangeRequest);
}
