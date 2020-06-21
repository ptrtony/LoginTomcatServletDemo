package cn.itcast.servlet.download;

import cn.itcast.servlet.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1获取请求参数，文件名称
        String filename = request.getParameter("filename");
        //2 使用字节流加载文件到内存
        //2.1找到文件服务器路径
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("/image/" + filename);
        //2.2用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        //3设置response响应头
        //3.1设置响应头类型，content-type
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type", mimeType);
        //3.2设置响应头打开方式，content-disposition
        //解决中文文件问题
        //1.获取user-agent请求头
        String agent = request.getHeader("user-agent");
        //2.使用工具类方式编码文件即可
        response.setHeader("content-disposition", "attachment;filename=" + DownLoadUtils.getFileName(agent, filename));
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        //关闭输入流
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
