package org.example.utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BaseClass {

    public ChromiumDriver driver = null;
    public static Properties properties = new Properties();
    public Map<String, String> rowDataToUse;
    public  static WebDriverWait wait = null;
    public Map<String, String> readTestDataForMyTest(String testCase) throws IOException {
        List<Map<String, String>> testDataList = ExcelReader.readTestData("src/test/resources/testData/IrctcTestData.xlsx","Sheet1");
        for (Map<String, String> rowData : testDataList) {
            System.out.println("Row Data: " + rowData);
            if (rowData.get("testcase").equals(testCase)){
                rowDataToUse = rowData;
                break;
            }
        }
        return rowDataToUse;
    }

    public void launchApp(){

        if(properties.getProperty("browser").equals("chrome")) {
            driver = new ChromeDriver();
        } else if (properties.getProperty("browser").equals("edge")) {
            driver = new EdgeDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(properties.getProperty("devurl"));
    }

    public void loadProperties()
    {
        FileInputStream fileInputStream = null;
        try {
            // Load the properties file
            fileInputStream = new FileInputStream("src/main/resources/config/EnvConfig.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the FileInputStream
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
