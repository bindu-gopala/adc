package amazonTests;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;





public class AutomationScriptRunner extends AutomationScripts{

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Maven project started");
		String[][] recData = AutomationScripts.readExcel("C:\\Users\\vj\\workspace\\amazonTests\\Test Data\\test execution controller.xlsx", "Sheet1");
		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strTimeStamp = dateFormat.format(cur_dt);
		writeExecutionResults(recData[0][1], strTimeStamp, "C:\\Users\\vj\\workspace\\amazonTests\\Test Data\\test execution controller.xlsx", "Sheet1", "");


		for (int i =1; i< recData.length;i++){
			Method test= AutomationScripts.class.getMethod(recData[i][1]);


			String data = (String)test.invoke(test);
			System.out.println(data);
			String[] result= data.split(" ");
			System.out.println(result[0]+":"+result[1]);

			if(result[0].equals("Pass")){
				writeExecutionResults(recData[i][1], "Pass", "C:\\Users\\vj\\workspace\\amazonTests\\Test Data\\test execution controller.xlsx", "Sheet1", result[1]);

			}else if(result[0].equals("Fail")){
				writeExecutionResults(recData[i][1], "Fail", "C:\\Users\\vj\\workspace\\amazonTests\\Test Data\\test execution controller.xlsx", "Sheet1", result[1]);
			}
		}

	}
}


