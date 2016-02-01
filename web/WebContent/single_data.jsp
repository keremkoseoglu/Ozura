<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="data.*" %>
<%@ page import="model.*" %>
<%@ page import="search.*" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.util.ArrayList" %>

<jsp:include page="top.html" />
			
<h5>Arama sonuçları</h5>

<script language="JavaScript">
      $(document).ready(function(){
    	  $('#main').load('all_data.jsp?id=<%= request.getParameter("id") %>');
      })
</script>

<jsp:include page="bottom.html" />	