package gss.testcase;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> initParamsMap = new HashMap<String, String>();

	public void init() throws ServletException {

		Enumeration<String> initParams = getServletConfig().getInitParameterNames();
		System.out.println(initParams + " initParams");

		while (initParams.hasMoreElements()) {

			String initParamName = initParams.nextElement();
			System.out.println("The initparam name: " + initParamName);
			String initParamValue = getServletConfig().getInitParameter(initParamName);
			System.out.println("The value is : " + initParamValue);
			initParamsMap.put(initParamName, initParamValue);

		}

	}
    /**
     * Default constructor. 
     */
    public MyServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		Iterator<Map.Entry<String, String>> iter = initParamsMap.entrySet().iterator();

		while (iter.hasNext()) {

			Map.Entry<String, String> entry = iter.next();
			String key = entry.getKey();
			String value = entry.getValue();

			out.write(key);
			out.write(" = ");
			out.write(value);
			out.write("\n");

		}

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
