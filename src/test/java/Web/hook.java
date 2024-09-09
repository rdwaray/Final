package Web;

import API.baseTestAPI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hook  {

    @Before
    public void setUp(){
        baseTestWeb.getDriver();
        baseTestAPI.setupRestAssured();

    }
    @After
    public void tearDown(){
        baseTestWeb.quitDriver();
        System.out.println("Test selesai");
    }
}



