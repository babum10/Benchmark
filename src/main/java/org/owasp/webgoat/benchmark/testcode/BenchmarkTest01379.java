package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01379")
public class BenchmarkTest01379 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a46034 = param; //assign
		StringBuilder b46034 = new StringBuilder(a46034);  // stick in stringbuilder
		b46034.append(" SafeStuff"); // append some safe content
		b46034.replace(b46034.length()-"Chars".length(),b46034.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map46034 = new java.util.HashMap<String,Object>();
		map46034.put("key46034", b46034.toString()); // put in a collection
		String c46034 = (String)map46034.get("key46034"); // get it back out
		String d46034 = c46034.substring(0,c46034.length()-1); // extract most of it
		String e46034 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d46034.getBytes() ) )); // B64 encode and decode it
		String f46034 = e46034.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f46034); // reflection
		
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo");
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd + bar);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}
}