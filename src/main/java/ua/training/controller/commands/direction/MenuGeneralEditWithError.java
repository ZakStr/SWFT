package ua.training.controller.commands.direction;

import ua.training.constant.Pages;
import ua.training.controller.commands.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: This class directs 'ADMIN' to general menu edit page with error
 *
 * @author Zakusylo Pavlo
 */
public class MenuGeneralEditWithError implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return Pages.MENU_GENERAL_EDIT;
    }
}
