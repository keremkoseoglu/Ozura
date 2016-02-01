<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.*" %>
<%@ page import="model.*" %>
<%@ page import="search.*" %>
<%@ page import="java.io.BufferedReader" %>
<%@page import="java.io.FileReader"%>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.util.ArrayList" %>

<% 

ArrayList<String> al = new ArrayList<String>();

//InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("contract.xml");  
//BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

BufferedReader in = new BufferedReader(new FileReader(application.getRealPath("/") + "contract.xml"));

String line = null;

while((line = in.readLine()) != null) al.add(line);		

String[] p = new String[al.size()];

for (int n = 0; n < al.size(); n++) p[n] = al.get(n);

DataSource ds = new DataSourceStringArray();
ArrayList<model.Contract> ret = new ArrayList<model.Contract>();
ret = ds.getAllContracts(p);

%>

<table class="u-full-width">
  <thead>
    <tr>
      <th>ID</th>
      <th>Açıklama</th>
      <th>Müşteri</th>
      <th>Versiyon</th>
      <th>Etkin</th>
      <th>Tarih</th>
      <th>Soğutma</th>
      <th>Isıtma</th>
      <th>Tasarruf</th>
      <th>Yeniden kazanım</th>
      <th>Mekan</th>
      <th>Ebat</th>
    </tr>
  </thead>
  <tbody>

<%

String id = "";

try {
	id = request.getParameter("id");
} catch(Exception ex) { id = ""; }

for (int n = 0; n < ret.size(); n++) {
	
	Contract c = ret.get(n);
	
	if (id == null || id.length() <= 0 || c.id.equals(id)) {
	
		out.write("<tr>");
		out.write("<td>" + c.id + "</td>");
		out.write("<td>" + c.description + "</td>");
		out.write("<td>" + c.client + "</td>");
		out.write("<td>" + c.version + "</td>");
		out.write("<td>" + c.getActiveString() + "</td>");
		out.write("<td>" + c.getDateString() + "</td>");
		out.write("<td>" + c.getCoolString() + "</td>");
		out.write("<td>" + c.getWarmString() + "</td>");
		out.write("<td>" + c.getEconomyString() + "</td>");
		out.write("<td>" + c.getRegainString() + "</td>");
		out.write("<td>" + c.space.toString() + "</td>");
		out.write("<td>" + c.getSizeString() + "</td>");
		out.write("</tr>");
	
	}
	
}

%>

  </tbody>
</table>
