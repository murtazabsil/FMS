
<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.util.List,com.itextpdf.text.pdf.PdfPCell,com.itextpdf.text.pdf.PdfPTable,java.sql.*,com.itextpdf.text.*,com.itextpdf.text.pdf.PdfWriter,java.io.*,java.util.*,java.util.Random,com.eResorts.MemberReviewsVO,com.eResorts.ReportBean,com.eResorts.GeneratePdfFile,com.eResorts.HeaderAndFooter,com.eResorts.PDFServletBean"%>
<%@ page trimDirectiveWhitespaces="true" %>
<HEAD>


	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>


	<LINK href="css/styles.css" type="text/css" rel="stylesheet">

</HEAD>
<BODY class="SC">
<h4 align=center>Member Reviews</h4>
<%	
ReportBean reportBean = (ReportBean)session.getAttribute("reportBean");
	ByteArrayOutputStream baosPDF = null;
	MemberReviewsVO memberReviewsVO =  reportBean.getMemberReviewsVOList().get(0);
	try
	{
		//PDFServlet pdfServlet = new PDFServlet();
		baosPDF = PDFServletBean.generatePDFDocumentBytes(request,config.getServletContext(),memberReviewsVO);
		
		StringBuffer sbFilename = new StringBuffer();
		sbFilename.append("filename_");
		sbFilename.append(System.currentTimeMillis());
		sbFilename.append(".pdf");

		////////////////////////////////////////////////////////
		// Note: 
		//
		// It is important to set the HTTP response headers 
		// before writing data to the servlet's OutputStream 
		//
		////////////////////////////////////////////////////////
		//
		//
		// Read the HTTP 1.1 specification for full details
		// about the Cache-Control header
		//
		response.setHeader("Cache-Control", "max-age=30");
		
		response.setContentType("application/pdf");
		
		//
		//
		// The Content-disposition header is explained
		// in RFC 2183
		//
		//    http://www.ietf.org/rfc/rfc2183.txt
		//
		// The Content-disposition value will be in one of 
		// two forms:
		//
		//   1)  inline; filename=foobar.pdf
		//   2)  attachment; filename=foobar.pdf
		//
		// In this servlet, we use "inline"
		//
		StringBuffer sbContentDispValue = new StringBuffer();
		sbContentDispValue.append("attachment");
		sbContentDispValue.append("; filename=");
		sbContentDispValue.append(sbFilename);
						
		response.setHeader(
			"Content-disposition",
			sbContentDispValue.toString());

		response.setContentLength(baosPDF.size());

		ServletOutputStream sos;

		sos = response.getOutputStream();
		
		baosPDF.writeTo(sos);
		
	//	sos.flush();
		sos.flush();
		sos.close();
		return;
	}
	catch (Exception dex)
	{
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println(
				this.getClass().getName() 
				+ " caught an exception: " 
				+ dex.getClass().getName()
				+ "<br>");
		writer.println("<pre>");
		dex.printStackTrace(writer);
		writer.println("</pre>");
	}
	finally
	{
		if (baosPDF != null)
		{
			baosPDF.reset();
		}
	}
	 
%>
</BODY>
<!-- <iframe src =  width="100%" height="1000px"></iframe> -->
</PRE>