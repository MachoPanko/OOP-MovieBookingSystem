package view;

import model.classes.User;

/**
 * View for the state of the viewing finite state machine
 */
public class ViewState {

    private State currState;
    private User currUser;

    /**
     * The possible state of the screen
     */
    public enum State {
        LoginView,
        StaffLoginView,
        StaffView,
        ReviewView,
        ConfigureSystemSettingView,
        ConfigureCinemaView,
        ConfigureCinemaSubmenu,
        MovieGoerLoginView,
        ViewMoviesView,
        AddMovieView,
        UpdateMovieView,
        UpdateMovieViewSubmenu,
        DeleteMovieView,
        MovieGoerView,
        ExitedView,
        BookingSystemView,
        BookingHistView,

        ListTop5Movie,
        ListTop5Movie2
    }

    /**
     * Constructor for the ViewState class
     * @param currState Current state of the MOBLIMA screen
     * @param currUser Current user that is logged in
     */
    public ViewState(State currState, User currUser) {
        this.currState = currState;
        this.currUser = currUser;
    }

    /**
     * To get the current state of the MOBLIMA screen
     * @return currState Current state
     */
    public State getCurrState() { return currState; }

    /**
     *  To set the current state of the MOBLIMA screen
     * @param currState Current state
     */
    public void setCurrState(State currState) { this.currState = currState; }

    /**
     * To get the current user that is logged in
     * @return currUser Current user
     */
    public User getCurrUser() { return currUser; }

    /**
     * To get the current user that is logged in
     * @param currUser Current user
     */
    public void setCurrUser(User currUser) { this.currUser = currUser; }
}
