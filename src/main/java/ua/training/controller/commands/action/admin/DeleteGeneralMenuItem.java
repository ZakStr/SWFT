package ua.training.controller.commands.action.admin;

import ua.training.constant.Attributes;
import ua.training.constant.Pages;
import ua.training.controller.commands.Command;
import ua.training.controller.commands.utils.CommandsUtil;
import ua.training.model.entity.Dish;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;

/**
 * Description: This class delete general menu item
 *
 * @author Zakusylo Pavlo
 */
public class DeleteGeneralMenuItem implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        String[] arrDish = request
                .getParameter(Attributes.REQUEST_ARR_DISH)
                .split(",");

        Integer[] idDishes = CommandsUtil.stringArrayToInteger(arrDish);

        DISH_SERVICE_IMP.deleteArrayDishesById(idDishes);

        List<Dish> general = DISH_SERVICE_IMP.getGeneralDishes();
        general.sort(Comparator.comparing(Dish::getCalories));
        request.getServletContext().setAttribute(Attributes.REQUEST_GENERAL_DISHES, general);

        return Pages.MENU_GENERAL_EDIT_REDIRECT;
    }
}
