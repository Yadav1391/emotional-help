package com.epam.dataprovider;

import com.epam.ui.utils.ExcelUtil;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class UserExcelData {

    @DataProvider(name = "userData")
    public Object[][] getData() throws IOException {
        String path = "src/test/resources/datafiles/loginData.xlsx";
        ExcelUtil xlutil = new ExcelUtil(path);

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        String loginData[][] = new String[totalrows][totalcols];


        for (int i = 1; i <= totalrows; i++) {
            for (int j = 0; j < totalcols; j++) {
                loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }

        }

        return loginData;
    }

}
