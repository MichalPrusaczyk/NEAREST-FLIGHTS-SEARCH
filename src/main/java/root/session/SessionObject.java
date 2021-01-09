package root.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import root.model.User;
import root.model.Flight;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class SessionObject {
    private User user = null;
    private String info = null;
    private String filter = null;


    public boolean isLogged() {
        return !(this.user == null);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

}
