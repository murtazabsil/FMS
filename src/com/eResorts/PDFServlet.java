/*
 *
 *  Sean C. Sullivan 
 *  June 2003
 * 
 *  URL:  http://www.seansullivan.com/
 *  
 */

package com.eResorts;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

// import the iText packages
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

/** 
 * 
 *  a servlet that will generate a PDF document
 *  and send the document to the client via the 
 *  ServletOutputStream
 * 
 *  @author Sean C. Sullivan
 * 
 */
public class PDFServlet 
{
	/** 
	* 
	* 
	*/
	public PDFServlet()
	{
		super();
	}

	/**
	 *  
	 * 
	 * we implement doGet so that this servlet will process all 
	 * HTTP GET requests
	 * 
	 * @param req HTTP request object 
	 * @param resp HTTP response object
	 * 
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws javax.servlet.ServletException, java.io.IOException
	{
		DocumentException ex = null;
		
		ByteArrayOutputStream baosPDF = null;
		
		try
		{
			baosPDF = generatePDFDocumentBytes(req, this.getServletContext());
			
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
			resp.setHeader("Cache-Control", "max-age=30");
			
			resp.setContentType("application/pdf");
			
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
			sbContentDispValue.append("inline");
			sbContentDispValue.append("; filename=");
			sbContentDispValue.append(sbFilename);
							
			resp.setHeader(
				"Content-disposition",
				sbContentDispValue.toString());

			resp.setContentLength(baosPDF.size());

			ServletOutputStream sos;

			sos = resp.getOutputStream();
			
			baosPDF.writeTo(sos);
			
			sos.flush();
		}
		catch (DocumentException dex)
		{
			resp.setContentType("text/html");
			PrintWriter writer = resp.getWriter();
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
		 
	}
 */
	/**
	 *  
	 * @param req must be non-null
	 * 
	 * @return a non-null output stream. The output stream contains
	 *         the bytes for the PDF document
	 * 
	 * @throws DocumentException
	 * 
	 */
	public ByteArrayOutputStream generatePDFDocumentBytes(
		final HttpServletRequest req,
		final ServletContext ctx,MemberReviewsVO memberReviewsVO)
		throws DocumentException
		
	{	
		Document doc = new Document();
		
		ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();
		PdfWriter docWriter = null;

		try
		{
			docWriter = PdfWriter.getInstance(doc, baosPDF);
			
			doc.addAuthor(this.getClass().getName());
			doc.addCreationDate();
			doc.addProducer();
			doc.addCreator(this.getClass().getName());
			doc.addTitle("This is a title.");
			doc.addKeywords("pdf, itext, Java, open source, http");
			
			doc.setPageSize(PageSize.LETTER);
			
			HeaderFooter footer = new HeaderFooter(
							new Phrase("This is a footer."),
							false);

			doc.setFooter(footer);
		
			doc.open();
			
			doc.add(new Paragraph(
						"This document was created by a class named: "
						+ this.getClass().getName()));
						
			doc.add(new Paragraph(
						"This document was created on "
						+ new java.util.Date()));

			String strServerInfo = ctx.getServerInfo();
			
			if (strServerInfo != null)
			{
				doc.add(new Paragraph(
						"Servlet engine: " + strServerInfo));
			}
			
			doc.add(new Paragraph(
						"This is a multi-page document."));
			
			doc.add( makeGeneralRequestDetailsElement(req) );
			
			doc.newPage();
			
			doc.add( makeHTTPHeaderInfoElement(req) );
			
			doc.newPage();
			
			doc.add( makeHTTPParameterInfoElement(req) );
			
		}
		catch (DocumentException dex)
		{
			baosPDF.reset();
			throw dex; 
		}
		finally
		{
			if (doc != null)
			{
				doc.close();
			}
			if (docWriter != null)
			{
				docWriter.close();
			}
		}

		if (baosPDF.size() < 1)
		{
			throw new DocumentException(
				"document has "
				+ baosPDF.size()
				+ " bytes");		
		}
		return baosPDF;
	}
	
	/**
	 * 
	 * @param req HTTP request object
	 * @return an iText Element object
	 * 
	 */
	protected Element makeHTTPHeaderInfoElement(final HttpServletRequest req)
	{
		Map mapHeaders = new java.util.TreeMap();
		
		Enumeration enumHeaderNames = req.getHeaderNames();
		while (enumHeaderNames.hasMoreElements())
		{
			String strHeaderName = (String) enumHeaderNames.nextElement();
			String strHeaderValue = req.getHeader(strHeaderName);
			
			if (strHeaderValue == null)
			{
				strHeaderValue = "";
			}
			mapHeaders.put(strHeaderName, strHeaderValue);
		}

		Table tab = makeTableFromMap(
				"HTTP header name",
				"HTTP header value",
				mapHeaders);
		
		return (Element) tab;
	}

	/**
	 *  
	 * @param req HTTP request object 
	 * @return an iText Element object
	 * 
	 */
	protected Element makeGeneralRequestDetailsElement(
						final HttpServletRequest req)
	{
		Map mapRequestDetails = new TreeMap();
		 
		mapRequestDetails.put("Scheme", req.getScheme());
				
		mapRequestDetails.put("HTTP method", req.getMethod());
				
		mapRequestDetails.put("AuthType", req.getAuthType());
				
		mapRequestDetails.put("QueryString", req.getQueryString());
				
		mapRequestDetails.put("ContextPath", req.getContextPath());
				
		mapRequestDetails.put("Request URI", req.getRequestURI());
				
		mapRequestDetails.put("Protocol", req.getProtocol());
				
		mapRequestDetails.put("Remote address", req.getRemoteAddr());
				
		mapRequestDetails.put("Remote host", req.getRemoteHost());
				
		mapRequestDetails.put("Server name", req.getServerName());
				
		mapRequestDetails.put("Server port", "" + req.getServerPort());
				
		mapRequestDetails.put("Preferred locale", req.getLocale().toString());
				
		Table tab = null;
		
		tab = makeTableFromMap(
						"Request info", 
						"Value",
						mapRequestDetails);
		
		return (Element) tab;
	}

	/**
	 * 
	 * 
	 * @param req HTTP request object
	 * @return an iText Element object
	 * 
	 */
	protected Element makeHTTPParameterInfoElement(
					final HttpServletRequest req)
	{
		Map mapParameters = null;
		
		mapParameters = new java.util.TreeMap(req.getParameterMap());

		Table tab = null;

		tab = makeTableFromMap(
				"HTTP parameter name",
				"HTTP parameter value",
				mapParameters);
		
		return (Element) tab;
	}
	
	/**
	 *
	 * @param firstColumnTitle
	 * @param secondColumnTitle
	 * @param m map containing the data for column 1 and column 2
	 * 
	 * @return an iText Table
	 * 
	 */
	private static Table makeTableFromMap(
			final String firstColumnTitle,
			final String secondColumnTitle,
			final java.util.Map m)
	{
		Table tab = null;

		try
		{
			tab = new Table(2 /* columns */);
		}
		catch (BadElementException ex)
		{
			throw new RuntimeException(ex);
		}
		
		tab.setBorderWidth(1.0f);
		tab.setPadding(5);
		tab.setSpacing(5);

		tab.addCell(new Cell(firstColumnTitle));
		tab.addCell(new Cell(secondColumnTitle));
		
		tab.endHeaders();

		if (m.keySet().size() == 0)
		{
			Cell c = new Cell("none");
			c.setColspan(tab.getColumns());
			tab.addCell(c);
		}
		else
		{
			Iterator iter = m.keySet().iterator();
			while (iter.hasNext())
			{
				String strName = (String) iter.next();
				Object value = m.get(strName);
				String strValue = null;
				if (value == null)
				{
					strValue = "";
				}
				else if (value instanceof String[])
				{
					String[] aValues = (String[]) value;   
					strValue = aValues[0];
				}
				else
				{
					strValue = value.toString();
				}
				
				tab.addCell(new Cell(strName));
				tab.addCell(new Cell(strValue));
			}
		}
		
		return tab;
	}
	 
}
