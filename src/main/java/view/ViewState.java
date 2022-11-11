package view;

import model.classes.User;

public class ViewState {

    private State currState;
    private User currUser;

    public enum State {
        LoginView,
        StaffLoginView,
        StaffView,
        ConfigureSystemSettingView,
        MovieGoerLoginView,
        ExitedView
    }

    public ViewState(State currState, User currUser) {
        this.currState = currState;
        this.currUser = currUser;
    }

    public State getCurrState() { return currState; }
    public void setCurrState(State currState) { this.currState = currState; }
    public User getCurrUser() { return currUser; }
    public void setCurrUser(User currUser) { this.currUser = currUser; }
}
