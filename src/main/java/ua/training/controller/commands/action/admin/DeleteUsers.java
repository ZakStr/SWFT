package ua.training.controller.commands.action.admin;

import ua.training.constant.Attributes;
import ua.training.constant.Pages;
import ua.training.controller.commands.Command;
import ua.training.controller.commands.utility.CommandsUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Description: This class delete users
 *
 * @author Zakusylo Pavlo
 */
public class DeleteUsers implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        String[] arrUsers = request
                .getParameter(Attributes.REQUEST_ARR_EMAIL_USERS)
                .split(",");

        USER_SERVICE_IMP.deleteArrayUsersByEmail(Arrays.asList(arrUsers));
        CommandsUtil.deleteUsersFromContext(request, arrUsers);

        return Pages.SHOW_USERS_REDIRECT;
    }
}
