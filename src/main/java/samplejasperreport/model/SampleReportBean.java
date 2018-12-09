package samplejasperreport.model;

import java.util.ArrayList;
import java.util.List;

public class SampleReportBean {

	private String firstString;
	
	private String secondString;

	public String getFirstString() {
		return firstString;
	}

	public void setFirstString(String firstString) {
		this.firstString = firstString;
	}

	public String getSecondString() {
		return secondString;
	}

	public void setSecondString(String secondString) {
		this.secondString = secondString;
	}

	public static List<SampleReportBean> generateValues(){
		List <SampleReportBean> list = new ArrayList<SampleReportBean>();
		SampleReportBean bean = new SampleReportBean();
		bean.setFirstString("Hello");
		bean.setSecondString("World");
		list.add(bean);
		return list;
	}

}
