<%@ page import="org.apache.commons.dbutils.QueryRunner" %>
<%@ page import="com.library.pojo.DateTime" %>
<%@ page import="org.apache.commons.dbutils.handlers.ScalarHandler" %>
<%@ page import="org.apache.commons.dbutils.handlers.BeanListHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.library.utils.DruidUtil" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/29
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="../js/echarts.min.js"></script>
<html>
<head>
    <title>折线图</title>
</head>
<body>
<div id="main" style="height: 600px;width: 1200px;"></div>

    <%
          QueryRunner queryRunner =new QueryRunner(DruidUtil.getDataSource());

            ArrayList arrayData = new ArrayList();
            ArrayList<String> arrayDay= new ArrayList<String>();
            int i=30;
             while(i!=0) {
                i--;
                String date = DateTime.showDate(-i); // 设置日期
				String md = DateTime.showMD(-i);
//				out.println(date + "**" );
				String sql="select count(*) as count from borrow_books where date_format(borrow_date,'%Y-%m-%d')=? order by id desc";
                Long countsList = (Long) queryRunner.query(sql,new ScalarHandler(),date);
                arrayData.add(countsList);
                arrayDay.add(md);

          }
        out.print(arrayDay);
    %>
<script>
    var myChart = echarts.init(document.getElementById('main'))

    var xdata =["11-30", "12-01", "12-02"," 12-03", "12-04", "12-05", "12-06", "12-07"," 12-08", "12-09", "12-10", "12-11", "12-12","12-13", "12-14", "12-15", "12-16", "12-17","12-18", "12-19", "12-20", "12-21", "12-22", "12-23", "12-24", "12-25", "12-26", "12-27"," 12-28", "12-29"]
    <%--var xdata= <%=arrayDay%>--%>
    var ydata = <%=arrayData%>
    <%--console.log(<%=arrayDay%>)--%>

    var option = {
        xAxis: {
            data: xdata
        },
        yAxis: {
            type: "value",
            scale: true,
        }, legend: {
            text: "借书量"
        },
        series: [
            {
                name: '借书量',
                type: 'line',
                data: ydata,
                smooth: true, //平滑曲线
                stack: 'Total',//折线堆叠

                // emphasis: {     //堆叠面积图
                //     focus: 'series'
                // },
                // areaStyle: {} //基础面积图
                markPoint: {
                    data: [
                        {
                            type: 'max'
                        },
                        {
                            type: 'min'
                        }
                    ]
                }
            },

        ]
    };
    myChart.setOption(option);
</script>
</body>
</html>
