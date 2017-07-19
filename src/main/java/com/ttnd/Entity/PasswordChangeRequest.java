package com.ttnd.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

/**
 * Created by Lenovo-1 on 19-07-2017.
 */
@Entity
public class PasswordChangeRequest {

    @Id
    String email;
    String id;
    Instant time;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }
}
