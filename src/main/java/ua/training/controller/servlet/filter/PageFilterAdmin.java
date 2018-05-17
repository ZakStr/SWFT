package ua.training.controller.servlet.filter;

import ua.training.constant.Attributes;
import ua.training.constant.Pages;
import ua.training.model.entity.User;
import ua.training.model.entity.enums.Roles;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Description: Non permit users with role non 'ADMIN' to admin pages
 *
 * @author Zakusylo Pavlo
 */
@WebFilter(urlPatterns = {"/swft/menuGeneralEdit", "/swft/menuGeneralEditWithError", "/swft/deleteGeneralMenuItem",
        "/swft/updateGeneralDish", "/swft/showUsers", "/swft/deleteUsers", "/swft/listUsersPage", "/swft/updateUsers",
        "/swft/showUsersAfterUpdateOrSearch", "/swft/searchUsersByEmail"})
public class PageFilterAdmin extends AbstractFilter {

    @Override
    protected void filter(HttpServletRequest request,
                          HttpServletResponse response,
                          FilterChain filterChain, Optional<User> user) throws IOException, ServletException {

        if (user.isPresent()) {
            if (user.get().getRole().equals(Roles.ADMIN)) {
                filterChain.doFilter(request, response);
            } else {
                request.getSession().setAttribute(Attributes.PAGE_NAME, Attributes.PAGE_GENERAL);
                request.getRequestDispatcher(Pages.HOME).forward(request, response);
            }
        } else {
            request.getRequestDispatcher(Pages.INDEX).forward(request, response);
        }
    }
}