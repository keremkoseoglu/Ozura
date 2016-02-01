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

<jsp:include page="top.html" />
			
<h5>Arama sonuçları</h5>
			
<% 

// SELECTION SCREEN

String pval = "";

SelectionScreen ss = new SelectionScreen();

pval = request.getParameter("id");
if (pval != null && pval.length() > 0) {
	ss.id = new SelectOptionString();
	ss.id.parseUserInput(pval);
}

pval = request.getParameter("description");
if (pval != null && pval.length() > 0) {
	ss.description = new SelectOptionString();
	ss.description.parseUserInput(pval);
}

pval = request.getParameter("client");
if (pval != null && pval.length() > 0) {
	ss.client = new SelectOptionString();
	ss.client.parseUserInput(pval);
}

pval = request.getParameter("version");
if (pval != null && pval.length() > 0) {
	ss.version = new SelectOptionString();
	ss.version.parseUserInput(pval);
}

pval = request.getParameter("active");
if (pval != null && pval.length() > 0) {
	ss.active = new SelectOptionBool();
	ss.active.parseUserInput(pval);
}

pval = request.getParameter("date");
if (pval != null && pval.length() > 0) {
	ss.date = new SelectOptionDate();
	ss.date.parseUserInput(pval);
}

pval = request.getParameter("cool");
if (pval != null && pval.length() > 0) {
	ss.cool = new SelectOptionBool();
	ss.cool.parseUserInput(pval);
}

pval = request.getParameter("warm");
if (pval != null && pval.length() > 0) {
	ss.warm = new SelectOptionBool();
	ss.warm.parseUserInput(pval);
}

pval = request.getParameter("economy");
if (pval != null && pval.length() > 0) {
	ss.economy = new SelectOptionBool();
	ss.economy.parseUserInput(pval);
}

pval = request.getParameter("regain");
if (pval != null && pval.length() > 0) {
	ss.regain = new SelectOptionBool();
	ss.regain.parseUserInput(pval);
}

pval = request.getParameter("space");
if (pval != null && pval.length() > 0) {
	ss.space = new SelectOptionSpace();
	ss.space.parseUserInput(pval);
}

pval = request.getParameter("width");
if (pval != null && pval.length() > 0) {
	ss.width = new SelectOptionInt();
	ss.width.parseUserInput(pval);
}

pval = request.getParameter("length");
if (pval != null && pval.length() > 0) {
	ss.length = new SelectOptionInt();
	ss.length.parseUserInput(pval);
}

pval = request.getParameter("height");
if (pval != null && pval.length() > 0) {
	ss.height = new SelectOptionInt();
	ss.height.parseUserInput(pval);
}

// DATA

ArrayList<String> al = new ArrayList<String>();

BufferedReader in = new BufferedReader(new FileReader(application.getRealPath("/") + "contract.xml"));

String line = null;

while((line = in.readLine()) != null) al.add(line);		

String[] p = new String[al.size()];

for (int n = 0; n < al.size(); n++) p[n] = al.get(n);

DataSource ds = new DataSourceStringArray();
ArrayList<model.Contract> contracts = new ArrayList<model.Contract>();
contracts = ds.getFilteredContracts(p, ss);

// FILTER

Comparer comp = new Comparer(ss);
ArrayList<CompareResult> res = comp.CompareResults(contracts);


for (int n = 0; n < res.size(); n++) {
	CompareResult cr = res.get(n);
	out.write("<p>");
	out.write("<strong><a href='single_data.jsp?id=" + cr.contract.id + "'>" + cr.contract.description + " | " + cr.contract.client + "</a></strong>");
	out.write("<br>Versiyon " + cr.contract.version);
	out.write("; " + cr.contract.getSizeString());
	out.write("<br>" + String.valueOf(cr.points) + "%");
	out.write(" - ");
	
	for (int m = 0; m < cr.fields.size(); m++) {
		CompareResultLine crl = cr.fields.get(m);
		if (m > 0) out.write(", ");
		out.write(crl.fieldName);
	}
	
	out.write("</p>");
}

%>

		
<jsp:include page="bottom.html" />	
