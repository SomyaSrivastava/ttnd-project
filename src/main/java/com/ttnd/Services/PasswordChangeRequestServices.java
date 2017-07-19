package com.ttnd.Services;

import com.ttnd.Entity.PasswordChangeRequest;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo-1 on 19-07-2017.
 */
@Service
public interface PasswordChangeRequestServices {
    public Boolean save(PasswordChangeRequest passwordChangeRequest);
    public PasswordChangeRequest get(String email,String token);
    public void delete(PasswordChangeRequest passwordChangeRequest);
}
