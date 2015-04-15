package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08109")
public class BenchmarkTest08109 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		String a1 = "";
		String a2 = "";
		String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
        	a1 = "cmd.exe";
        	a2 = "/c";
        } else {
        	a1 = "sh";
        	a2 = "-c";
        }
        String[] args = {a1, a2, "echo", bar};

		ProcessBuilder pb = new ProcessBuilder(args);
		
		try {
			Process p = pb.start();
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - java.lang.ProcessBuilder(java.lang.String[]) Test Case");
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a83944 = param; //assign
		StringBuilder b83944 = new StringBuilder(a83944);  // stick in stringbuilder
		b83944.append(" SafeStuff"); // append some safe content
		b83944.replace(b83944.length()-"Chars".length(),b83944.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map83944 = new java.util.HashMap<String,Object>();
		map83944.put("key83944", b83944.toString()); // put in a collection
		String c83944 = (String)map83944.get("key83944"); // get it back out
		String d83944 = c83944.substring(0,c83944.length()-1); // extract most of it
		String e83944 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d83944.getBytes() ) )); // B64 encode and decode it
		String f83944 = e83944.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g83944 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g83944); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass