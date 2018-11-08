package servlet;

import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import bean.Option;
import bean.Vote;
import service.VoteService;

public class ChartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vidString = request.getParameter("vid");
		int vid = Integer.parseInt(vidString);
		
		setChartTheme();
		DefaultPieDataset dataset = getDataset(vid);
		JFreeChart chart = ChartFactory.createPieChart3D("投票结果", dataset, true, false, false);
		//设置图表的百分比.
				PiePlot3D plot=(PiePlot3D)chart.getPlot(); 
				// 图片中显示百分比:默认方式 
				//plot.setLabelGenerator(new StandardPieSectionLabelGenerator(StandardPieToolTipGenerator.DEFAULT_TOOLTIP_FORMAT));
				// 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位 
				plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%"))); 
				// 图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例 
				plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})")); 
				
				//将图表输出到浏览器上.
				ChartUtilities.writeChartAsJPEG(response.getOutputStream(),
					1.0f,chart,400,300,null);

	}
	
	private DefaultPieDataset getDataset(int vid) {
		VoteService voteService = new VoteService();
		
		List<Option> list = voteService.getOptions(vid);
		DefaultPieDataset dataset = new DefaultPieDataset();
		//向data集中添加数据（查找vid的所有选项）
		for(Option option:list){
			dataset.setValue(option.getOname(), option.getOnumber());
		}
		return dataset;
	}
	
	private void setChartTheme(){       
        // 创建主题样式       
        StandardChartTheme standardChartTheme = new StandardChartTheme("CN");       
        // 设置标题字体       
        standardChartTheme.setExtraLargeFont(new Font("宋书", Font.BOLD, 20));       
        // 设置图例的字体       
        standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));       
        // 设置轴向的字体       
        standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));       
        // 应用主题样式       
        ChartFactory.setChartTheme(standardChartTheme);       
    } 

}
