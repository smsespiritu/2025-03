/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.exchange;

//import com.code.google.gson;
import java.io.*;
import java.net.*;
import java.util.*;
import org.json.*;

/**
*
* @author pakallis
*/
class Recv
{
private String lhs;
private String rhs;
private String error;
private String icc;
public Recv()
{
}
public String getLhs()
{
return lhs;
}
public String getRhs()
{
return rhs;
}
}
public class Convert{
    /**
	* Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	* @param request servlet request
	* @param response servlet response
	* @throws ServletException if a servlet-specific error occurs
	* @throws IOException if an I/O error occurs
	*protected void processRequest(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {*/
        public static void main(String[] args){
    
        /*Open a connection to google and read the result*/
        try {
            query ="https://finance.google.com/finance/converter?a=" + amount + "&from=" + curFrom + "&to=" + curTo;
            URL url = new URL(query);
            InputStreamReader stream = new InputStreamReader(url.openStream());
            BufferedReader in = new BufferedReader(stream);
            String str = "";
            String temp = "";
            while ((temp = in.readLine()) != null) {
                str = str + temp;
            }

            /*Parse the result which is in json format*/
            
           // String str = &quot;{ \&quot;name\&quot;: \&quot;Alice\&quot;, \&quot;age\&quot;: 20 }&quot;;
            //JSONObject obj = new JSONObject(str);
           // JsonParser jp = new JsonParser();
//JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
//JsonObject jsonobj = root.getAsJsonObject();

            //JSONObject res = obj.getJSONObject();
    System.out.println(str);
//JSONObject obj = new JSONObject(str);
//String n = obj.get;
            
            //Gson gson = new Gson();
            //Recv st = gson.fromJson(str, Recv.class);
           // String rhs = st.getRhs();
            //rhs = rhs.replaceAll("ï¿½", "");
            /*we do the check in order to print the additional word(millions,billions etc)*/
           // StringTokenizer strto = new StringTokenizer(rhs);
           // String nextToken;

            //out.write(strto.nextToken());
           // nextToken = strto.nextToken();

           // if( nextToken.equals("million") || nextToken.equals("billion") || nextToken.equals("trillion"))
            //{
            //    out.println(" "+nextToken);
            //}
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
	* Handles the HTTP <code>GET</code> method.
	* @param request servlet request
	* @param response servlet response
	* @throws ServletException if a servlet-specific error occurs
	* @throws IOException if an I/O error occurs
	*/
    
    /**
	* Handles the HTTP <code>POST</code> method.
	* @param request servlet request
	* @param response servlet response
	* @throws ServletException if a servlet-specific error occurs
	* @throws IOException if an I/O error occurs
	*/
    
    /**
	* Returns a short description of the servlet.
	* @return a String containing servlet description
	*/
    
}