package samplejasperreport.ctrl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import samplejasperreport.model.SampleReportBean;

@WebServlet("/generateReport")
public class JasperReportsExample extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1043415364230203465L;
	final String deviceJasper = "SampleReport.jasper";
	String deviceAvailReportFileName="";
	String reportFolderPath;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
	response.setContentType("application/pdf");
	response.setCharacterEncoding("UTF-8");
	//final String subDeviceJasper = "JASPER_REPORTS/";
	try{
	List<SampleReportBean> sampleReportBeanList = new ArrayList<SampleReportBean>();
	SampleReportBean bean = new SampleReportBean();
	bean.setFirstString("Hello");
	bean.setSecondString("World");
	sampleReportBeanList.add(bean);
	InputStream is = this.getClass().getClassLoader().getResourceAsStream(deviceJasper);
	JasperReport jasperReport = (JasperReport) JRLoader.loadObject(is);
	JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(sampleReportBeanList);
	Map<String, Object> parameters = new HashMap<String, Object>();
	// parameters.put("SUBREPORT_DIR",subDeviceJasper);
	System.out.println("@#e#@ deviceJasper ="+deviceJasper);
	System.out.println(" jasperReport = "+jasperReport);
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanCollectionDataSource);
	JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}catch(Exception e)	{
		System.out.println("Error:while creating jasper report....");
		e.printStackTrace();
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		
	}
		
}