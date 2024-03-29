package com.inventoryxpert.application.views;

import com.inventoryxpert.application.views.Invoicing.AddInvoice;
import com.inventoryxpert.application.views.Invoicing.Purchase;
import com.inventoryxpert.application.views.about.AboutView;
import com.inventoryxpert.application.views.dashboard.DashboardView;
import com.inventoryxpert.application.views.people.PeopleView;
import com.inventoryxpert.application.views.people.customers.AddCustomer;
import com.inventoryxpert.application.views.people.customers.Customers;
import com.inventoryxpert.application.views.people.employees.AddEmployees;
import com.inventoryxpert.application.views.people.employees.Employees;
import com.inventoryxpert.application.views.products.Inventory;
import com.inventoryxpert.application.views.products.ProductView;
import com.inventoryxpert.application.views.terms.Terms;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
@CssImport("./themes/inventoryxpert/styles.css")
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("InventoyXpert");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Dashboard", DashboardView.class, LineAwesomeIcon.CHART_AREA_SOLID.create()));
        nav.addItem(new SideNavItem("Add invoice", AddInvoice.class, LineAwesomeIcon.RECEIPT_SOLID.create()));
        nav.addItem(new SideNavItem("About", AboutView.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("people", PeopleView.class, LineAwesomeIcon.PEOPLE_CARRY_SOLID.create()));
        nav.addItem(new SideNavItem("Add product", ProductView.class, LineAwesomeIcon.PRODUCT_HUNT.create()));
        nav.addItem(new SideNavItem("Products List", Inventory.class, LineAwesomeIcon.LIST_ALT.create()));
        nav.addItem(new SideNavItem("Add Customer", AddCustomer.class, LineAwesomeIcon.USER_SOLID.create()));
        nav.addItem(new SideNavItem("Customers list", Customers.class, LineAwesomeIcon.LIST_ALT.create()));
        nav.addItem(new SideNavItem("Add Employee", AddEmployees.class, LineAwesomeIcon.USERS_SOLID.create()));
        nav.addItem(new SideNavItem("Employees list", Employees.class, LineAwesomeIcon.LIST_ALT.create()));
        nav.addItem(new SideNavItem("Add terms of payment", Terms.class, LineAwesomeIcon.TIMES_CIRCLE.create()));
        nav.addItem(new SideNavItem("Purchase", Purchase.class, LineAwesomeIcon.FILE.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
