package ua.training.constant;

/**
 * Description: This is list of pages
 *
 * @author Zakusylo Pavlo
 */
public interface Pages {
    String REDIRECT = "redirect:/";
    String INDEX = "/index.jsp";

    String HOME = "/WEB-INF/user/homePage.jsp";
    String HOME_REDIRECT = "redirect:/homePage";

    String SIGN_OR_REGISTER = "/WEB-INF/user/signInOrRegister.jsp";
    String SIGN_OR_REGISTER_REDIRECT = "redirect:/signInOrRegister";
    String SIGN_OR_REGISTER_WITH_ERROR = "redirect:/signInOrRegisterWithError";

    String USER_SETTINGS = "/WEB-INF/user/userSettings.jsp";
    String USER_SETTINGS_REDIRECT = "redirect:/userSettings";
    String USER_SETTINGS_REDIRECT_WITH_ERROR = "redirect:/userSettingsWithError";

    String MENU = "/WEB-INF/user/menu.jsp";
    String MENU_GENERAL_EDIT = "/WEB-INF/admin/menuGeneralEdit.jsp";
    String MENU_GENERAL_EDIT_REDIRECT = "redirect:/menuGeneralEdit";
    String MENU_GENERAL_EDIT_WITH_ERROR_REDIRECT = "redirect:/menuGeneralEditWithError";
    String MENU_USERS_EDIT = "/WEB-INF/user/menuUsersEdit.jsp";
    String MENU_USERS_EDIT_REDIRECT = "redirect:/menuUsersEdit";
    String MENU_USERS_EDIT_REDIRECT_WITH_ERROR = "redirect:/menuUsersEditWithError";
    String MENU_USERS_EDIT_AFTER_UPDATE_REDIRECT = "redirect:/menuUsersEditAfterUpdate";

    String SHOW_USERS = "/WEB-INF/admin/showUsers.jsp";
    String SHOW_USERS_REDIRECT = "redirect:/showUsers";
    String SHOW_USERS_AFTER_UPDATE_OR_SEARCH_REDIRECT = "redirect:/showUsersAfterUpdateOrSearch";

    String DAY_RATION = "/WEB-INF/user/dayRation.jsp";
    String DAY_RATION_REDIRECT = "redirect:/dayRation";
    String DAY_RATION_LIST_REDIRECT = "redirect:/listUserDayRation";
}
