package orangeHrm.testCase;

import orangeHrm.constants.MenuItems;
import orangeHrm.listeners.TestListener;
import orangeHrm.pages.AddEmployeePage;
import orangeHrm.pages.LeftComponent;
import orangeHrm.pages.PersonalDetailsPage;
import orangeHrm.pages.PimPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class PimTest extends LoginTest {

    protected LeftComponent leftComponent;
    protected PimPage pimPage;
    protected AddEmployeePage addEmployeePage;
    protected PersonalDetailsPage personalDetailsPage;

    @BeforeClass
    public void setupLeftComponent(){
        leftComponent = new LeftComponent(loginPage.getDriver());
    }

    @Test(
            priority = 0,
            description = "Verify that on clicking PIM users moves to PIM page"
    )
    public void selectPimMenu(){
        leftComponent.selectMenuItem(MenuItems.PIM);
        pimPage = new PimPage(leftComponent.getDriver());
        boolean movedToPimPage = pimPage.validatePimUrl();
        Assert.assertTrue(movedToPimPage,"Logged in user didn't moved to PIM page");
    }

    @Test(
            priority = 1,
            description = "Verify that on clicking ADD user moves to Add Employee page"
    )
    public void moveToAddEmployee(){
        boolean movedToAddEmployeePage = pimPage.clickAddEmployee()
                .validateAddEmployeeUrl();

        addEmployeePage = new AddEmployeePage(pimPage.getDriver());
        Assert.assertTrue(movedToAddEmployeePage,"user didn't moved to PIM's Add employee page");
    }

    @Test(
            priority = 2,
            description = "Verify that user is able to create an employee and moves to personal details page"
    )
    public void addEmployee(){
        boolean movedToPersonalDetailsPage = addEmployeePage.createEmployee()
                .validatePersonalDetailsUrl();

        personalDetailsPage = new PersonalDetailsPage(addEmployeePage.getDriver());

        Assert.assertTrue(movedToPersonalDetailsPage,"user didn't moved to personal details page");
    }

}
